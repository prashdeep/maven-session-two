package com.classpath.ftp27.util;
//import java.util.Iterator;
//import LeaveType;
//import LeaveStatus;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
//import javax.ws.rs.NotFoundException;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.classpath.ftp27.model.Employee;
import com.classpath.ftp27.model.LeaveDetails;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * This class provides a REST interface for the leavedetails entity.
 */
@Path("/leavedetails")
public class LeaveDetailsRest {
  private static final Logger LOGGER = LogManager.getLogger(LeaveDetailsRest.class);
  /**
   * Returns pending leaves under a manager.
   * @param id the id of the manager.
   * @return the pending leaves.
   */
  @GET
  @Path("/{id}/pending")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response pendingLeaveDetails(@PathParam("id") final int id) {
    final Employee employee = Employee.listEmployeeDetailsById(id);
    if (employee == null) {
      return Response.status(Response.Status.NOT_FOUND).entity("{\"error\":\"Sorry, No such person found\"}").build();
    } else {
      final List<LeaveDetails> leave = LeaveDetails.fetchLeaveDetailsByEmpId(id);
      return Response.ok().entity(leave).build();
    }
  }
  /**
   * Returns leave history of the employee.
   * @param id the id of the manager.
   * @return the leave history.
   */
  @GET
  @Path("/{id}/history")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response viewLeaveHistory(@PathParam("id") final int id) {
    final Employee employee = Employee.listEmployeeDetailsById(id);
    if (employee == null) {
      return Response.status(Response.Status.NOT_FOUND).entity("{\"error\":\"Sorry, No such person found\"}").build();
    } else {
      final List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(id);
      return Response.ok().entity(list).build();
    }
  }

  /**
   * Returns leave history of the employee.
   * @param leaveId id the id of the manager.
   * @return the leave history.
   */
  @GET
  @Path("/{leaveId}/details")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response viewEmpDetailsById(@PathParam("leaveId") final int leaveId) {
    final LeaveDetails list = LeaveDetails.findDetails(leaveId);
    return Response.ok().entity(list).build();
  }

  /**
   * Returns leave history of the employee.
   * @param id the id of the manager.
   * @param leave the id of the manager.
   * @return object.
   */
  @POST
  @Path("/{id}/applyLeave")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final Object applyForLeave(@PathParam("id") final int id, final LeaveDetails leave) {
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy");
    long userLeaveNoOfdays = leave.getLeaveNoOfDays();
    String strLeaveStartDate = date.format(leave.getLeaveStartDate());
    String strLeaveEndDate = date.format(leave.getLeaveEndDate());
    String leaveType = leave.getLeaveType().toString();
    String leaveReason = leave.getLeaveReason();
    List result = LeaveDetails.validateLeaveDetails(userLeaveNoOfdays, strLeaveStartDate, strLeaveEndDate, leaveType,
        leaveReason, id);
    leave.setEmpId(id);
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
    String leaveAppliedOn = dateFormat.format(currentDate);
    leave.setLeaveAppliedOn(leaveAppliedOn);
    if (result.isEmpty()) {
      LOGGER.info("entering into apply for leave method ");
      int dbValue = LeaveDetails.applyForLeave(leave, id);
      if (dbValue != 0 && id != 1000) {
        LOGGER.info("entering into mail alert method ");
        Employee emp2 = Employee.listEmployeeDetailsById(id);
        String empName = emp2.getEmpName();
        int mgrId = emp2.getEmpMgrId();
        Employee emp1 = Employee.listEmployeeDetailsById(mgrId);
        String mgrEmail = emp1.getEmpEmail();
        LeaveDetails.simpleEmailForApply(leave, mgrEmail, empName);
        return Response.status(Response.Status.CREATED).entity("{\"Leave applied"
        + "successfully \": \"Mail alert has been sent to your Manager.\"}").build();
      } else {
        return Response.status(Response.Status.CREATED).entity("{\"Success\" : \""
        + "Leave applied successfully .\"}").build();
      }
    } else {
      return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    }
  }
  /**
   * Returns a specific employee's details.
   * @param mgrId the id of the employee.
   * @param leaves the id of the employee.
   * @return Object of approve and deny.
   */
  @PUT
  @Path("/{mgrId}/approvedeny")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response approvedeny(@PathParam("mgrId") final int mgrId, final LeaveDetails leaves) {
    LOGGER.debug("getting leave status ");
    System.out.println("getting leave status");
    int leaveId = leaves.getLeaveId();
    LeaveDetails leave = LeaveDetails.findLeaveDetails1(mgrId, leaveId);
    String mgrComment = leaves.getLeaveMgrComment();
    String status = leaves.getLeaveStatus().toString();
    if (leave == null) {
      LOGGER.info("getting leave NULL");
      return Response.status(Response.Status.NOT_FOUND)
      .entity("{\"error\" : \"Sorry No such leave\"}").build();
    } else if (leave.getLeaveStatus().toString().equalsIgnoreCase("APPROVED") && status.equalsIgnoreCase("APPROVED")) {
      return Response.status(Response.Status.NOT_MODIFIED)
      .entity("{\"error\" : \"Sorry Leave is Already Approved\"}").build();
    } else if (leave.getLeaveStatus().toString().equalsIgnoreCase("DENIED") && status.equalsIgnoreCase("DENIED")) {
      return Response.status(Response.Status.NOT_MODIFIED)
      .entity("{\"error\" : \"Sorry Leave is Already Denied\"}").build();
    } else {
      List errorList = LeaveDetails.approveDenyLeave(mgrId, leaveId, mgrComment, status);
      if (errorList.isEmpty()) {
        return Response.ok().build();
      } else {
        return Response.status(Response.Status.BAD_REQUEST).entity(errorList).build();
      }
    }
  }
}


