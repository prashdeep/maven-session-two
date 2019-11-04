package com.classpath.ftp27.model;
import com.classpath.ftp27.util.EmailUtil;
import com.classpath.ftp27.persistence.DbConnection;
import com.classpath.ftp27.persistence.LeaveDetailsDAO;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.text.ParseException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * LeaveDetails class to store leave details.
 * @author hexware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class LeaveDetails {
  /**
   * logger to display information.
   * leaveId to store leave id.
   * leaveNoOfDays to store leave number of days.
   * leaveStartDate to store leave start date.
   * leaveEndDate to store leave end date.
   * leaveType to store leave type.
   * leaveStatus to store leave status.
   * leaveReason to store leave reason.
   * leaveAppliedOn to store leave applied on.
   * leaveMgrComment to store leave manager comments.
   * empId to store employee ID.
   */
  private static final Logger LOGGER = LogManager.getLogger(LeaveDetails.class);
  private int leaveId;
  private long leaveNoOfDays;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
  private Date leaveStartDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
  private Date leaveEndDate;
  private LeaveType leaveType;
  private LeaveStatus leaveStatus;
  private String leaveReason;
  private String leaveAppliedOn;
  private String leaveMgrComment;
  private int empId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails leave = (LeaveDetails) obj;
    if (Objects.equals(leaveId, leave.leaveId) && Objects.equals(leaveNoOfDays, leave.leaveNoOfDays)
        && Objects.equals(leaveStartDate, leave.leaveStartDate) && Objects.equals(leaveEndDate, leave.leaveEndDate)
        && Objects.equals(leaveType, leave.leaveType) && Objects.equals(leaveStatus, leave.leaveStatus)
        && Objects.equals(leaveReason, leave.leaveReason)
        && Objects.equals(leaveAppliedOn, leave.leaveAppliedOn)
        && Objects.equals(empId, leave.empId) && Objects.equals(leaveMgrComment, leave.leaveMgrComment)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, leaveNoOfDays, leaveStartDate, leaveEndDate,
    leaveType, leaveStatus, leaveReason, leaveAppliedOn, empId, leaveMgrComment);
  }
  @Override
  public final String toString() {
    return "LeaveDetails:" + this.leaveId + this.leaveNoOfDays
        + this.leaveStartDate + this.leaveEndDate + this.leaveType + this.leaveStatus + this.leaveReason
        + this.leaveAppliedOn + this.empId + this.leaveMgrComment;
  }
  /**
   * @param argleaveId to initialize leave id.
   * @param argleaveNoOfDays to initialize leave number of days.
   * @param argleaveStartDate to initialize leave start date.
   * @param argleaveEndDate to initialize leave end date.
   * @param argleaveType to initialize leave type.
   * @param argleaveStatus to initialize leave Status.
   * @param argleaveReason to initialize leave reason.
   * @param argleaveAppliedOn to initialize leave Applied on.
   * @param argEmpId to initialize employee id.
   * @param argleaveMgrComment to initialize leave manager comments.
   */
  public LeaveDetails(final int argleaveId, final long argleaveNoOfDays, final Date argleaveStartDate,
      final Date argleaveEndDate, final LeaveType argleaveType, final LeaveStatus argleaveStatus,
      final String argleaveReason, final String argleaveAppliedOn, final int argEmpId,
      final String argleaveMgrComment) {
    this.leaveId = argleaveId;
    this.leaveNoOfDays = argleaveNoOfDays;
    this.leaveStartDate = new Date(argleaveStartDate.getTime());
    this.leaveEndDate = new Date(argleaveEndDate.getTime());
    this.leaveType = argleaveType;
    this.leaveStatus = argleaveStatus;
    this.leaveReason = argleaveReason;
    this.leaveAppliedOn = argleaveAppliedOn;
    this.empId = argEmpId;
    this.leaveMgrComment = argleaveMgrComment;
  }
  /**
   * apply for leave Constructor.
   * @param argLeaveNoOfDays to initialize leave number of days.
   * @param argLeaveStartDate to initialize leave start date.
   * @param argLeaveEndDate to initialize leave end date.
   * @param argLeaveType to initialize leave type.
   * @param argLeaveReason to initialize leave reason.
   * @param argLeaveAppliedOn to initialize leave Applied on.
   * @param argEmpId to initialize employee id.
   */
  public LeaveDetails(final long argLeaveNoOfDays, final Date argLeaveStartDate, final Date argLeaveEndDate,
      final LeaveType argLeaveType, final String argLeaveReason, final String argLeaveAppliedOn, final int argEmpId) {
    this.leaveNoOfDays = argLeaveNoOfDays;
    this.leaveStartDate = new Date(argLeaveStartDate.getTime());
    this.leaveEndDate = new Date(argLeaveEndDate.getTime());
    this.leaveType = argLeaveType;
    this.leaveReason = argLeaveReason;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.empId = argEmpId;
  }
  /**
   * Default No argument Constructor.
   */
  public LeaveDetails() {
  }

  /**
   * Gets the leave Id.
   * @return this leave ID.
   */
  public final int getLeaveId() {
    return leaveId;
  }

  /**
   * Gets the leave number of days.
   * @return this leave no of days.
   */
  public final long getLeaveNoOfDays() {
    return leaveNoOfDays;
  }

  /**
   *
   * @return argLeaveStartDate to get leave start date.
   */
  public final Date getLeaveStartDate() {
    return new Date(this.leaveStartDate.getTime());
  }

  /**
   *
   * @return argLeaveEndDate to get leave end date.
   */
  public final Date getLeaveEndDate() {
    return new Date(this.leaveEndDate.getTime());
  }

  /**
   *
   * @return argLeaveType to get leave type.
   */
  public final LeaveType getLeaveType() {
    return leaveType;
  }

  /**
   *
   * @return argleaveStatus to get leave status.
   */
  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }

  /**
   *
   * @return argLeaveReason to get leave reason.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }

  /**
   *
   * @return argLeaveAppliedOn to get leave applied on.
   */
  public final String getLeaveAppliedOn() {
    return leaveAppliedOn;
  }

  /**
   *
   * @return argLeaveMgrComment to get leave manager comments.
   */
  public final String getLeaveMgrComment() {
    return leaveMgrComment;
  }

  /**
   *
   * @return argEmpId to get Employee Id.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argLeaveId to set leave id.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

  /**
   *
   * @param argLeaveNoOfDays to set leave number of days.
   */
  public final void setLeaveNoOfDays(final long argLeaveNoOfDays) {
    this.leaveNoOfDays = argLeaveNoOfDays;
  }

  /**
   *
   * @param argLeaveStartDate to set leave start date.
   */
  public final void setLeaveStartDate(final Date argLeaveStartDate) {
    this.leaveStartDate =  new Date(argLeaveStartDate.getTime());
  }

  /**
   *
   * @param argLeaveEndDate to set leave end date.
   */
  public final void setLeaveEndDate(final Date argLeaveEndDate) {
    this.leaveEndDate = new Date(argLeaveEndDate.getTime());
  }

  /**
   *
   * @param argLeaveType to set leave type.
   */
  public final void setLeaveType(final LeaveType argLeaveType) {
    this.leaveType = argLeaveType;
  }

  /**
   *
   * @param argLeaveStatus to set leave status.
   */
  public final void setLeaveStatus(final LeaveStatus argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }

  /**
   *
   * @param argLeaveReason to set leave reason.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }

  /**
   *
   * @param argLeaveAppliedOn to set leave applied on.
   */
  public final void setLeaveAppliedOn(final String argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }

  /**
   *
   * @param argLeaveMgrComment to set leave manager comments.
   */
  public final void setLeaveMgrComment(final String argLeaveMgrComment) {
    this.leaveMgrComment = argLeaveMgrComment;
  }

  /**
   *
   * @param argEmpId to set Employee Id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * The dao for leave details.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

  /**
   * list all leave details.
   * @return all leave details.
   */
  public static LeaveDetails[] listAll() {

    List<LeaveDetails> ls = dao().list();
    return ls.toArray(new LeaveDetails[ls.size()]);
  }

  /**
   * list all PENDING leave details.
   * @param empId id to get leave details.
   * @return all leave details.
   */
  public static List<LeaveDetails> fetchLeaveDetailsByEmpId(final int empId) {
    return dao().fetchPendingLeavesByMgrId(empId);
  }

  /**
   * list all PENDING leave details.
   * @param empId id to get leave details.
   * @param leaveId id to get leave details.
   * @return all leave details.
   */
  public static LeaveDetails findLeaveDetails(final int empId, final int leaveId) {
    return dao().fetchPendingLeaveByLeaveIdAndMgrId(empId, leaveId);
  }

/**
   * list all MgrDetails leave details.
   * @param leaveId id to get leave details.
   * @return all leave details.
   */
  public static LeaveDetails findDetails(final int leaveId) {
    return dao().findEmployeeDetailsByLeaveId(leaveId);
  }


  /**
   * list all NOT PENDING leave details.
   * @param empId id to get leave details.
   * @param leaveId id to get leave details.
   * @return all leave details.
   */
  public static LeaveDetails findLeaveDetails1(final int empId, final int leaveId) {
    return dao().fetchPendingLeaveByLeaveIdAndMgrId1(empId, leaveId);
  }


  /**
   * list all PENDING leave details.
   * @param leaveId id to get leave details.
   * @param mgrComment the id of the leave details.
   * @param status id to get leave details.
   * @param empId id to get leave details.
   * @return error id to get leave details.
   */
  public static List approveDenyLeave(final int empId, final int leaveId, final String mgrComment,
      final String status) {
    LOGGER.debug("entering into approveDeny method with params: empId : " + empId + " leaveId : " + leaveId
            + " mgrComment : " + mgrComment + " status : " + status);
    List<String> errorsList = new ArrayList<String>();
    long avail = 0;

    long leaveNoOfDays = 0;
    boolean flag = Employee.isManager(empId);
    LOGGER.info("getting whether employee is manager or not");
    String leaveStatusValue = null;
    if (!flag) {
      errorsList.add("Sorry, No such employee exists or you are not a Manager");
    } else {
      LeaveDetails leave = LeaveDetails.findLeaveDetails1(empId, leaveId);
      LOGGER.info("finding leave details");
      if (leave == null) {
        errorsList.add("Leave Id does not exists Or Doesn't report to this manager");
      } else {
        int empId2 = leave.getEmpId();
        Employee employee1 = Employee.listEmployeeDetailsById(empId2);
        String email = employee1.getEmpEmail();
        LOGGER.info("getting employee details by employee Id");
        avail = employee1.getEmpLeaveAvail();
        LOGGER.info("getting available leave");
        leaveNoOfDays = leave.getLeaveNoOfDays();
        LOGGER.info("getting no of leave days");
        if (avail > leaveNoOfDays) {
          if (status.equalsIgnoreCase("APPROVED")) {
            LeaveStatus leaveStatusDb = leave.getLeaveStatus();
            LOGGER.info("getting leave status APPROVED");
            leaveStatusValue = leaveStatusDb.toString();
            if (leaveStatusValue.equalsIgnoreCase("PENDING") || leaveStatusValue.equalsIgnoreCase("DENIED")) {
              avail = avail - leaveNoOfDays;
              Employee.updateEmpLeaveAvail(empId2, avail);
              LOGGER.info("updating employee leave days available");
              dao().approveStatusByLeaveId(leaveId, mgrComment, status);
              EmailUtil.sendEmailForApprove(leaveId, mgrComment, status, email);
              LOGGER.info("updating employee leave days available");
            }
          } else if (status.equalsIgnoreCase("DENIED")) {
            LeaveStatus leaveStatusDb = leave.getLeaveStatus();
            LOGGER.info("getting leave status DENIED");
            leaveStatusValue = leaveStatusDb.toString();
            if (leaveStatusValue.equalsIgnoreCase("APPROVED")) {
              avail = avail + leaveNoOfDays;
              Employee.updateEmpLeaveAvail(empId2, avail);
              LOGGER.info("updating employee leave available");
              dao().approveStatusByLeaveId(leaveId, mgrComment, status);
              EmailUtil.sendEmailForApprove(leaveId, mgrComment, status, email);
            } else if (leaveStatusValue.equalsIgnoreCase("PENDING")) {
              dao().approveStatusByLeaveId(leaveId, mgrComment, status);
              EmailUtil.sendEmailForApprove(leaveId, mgrComment, status, email);
            }
          } else {
            errorsList.add("Enter correct Leave Status");
          }
        } else {
          errorsList.add("Leaves already exhausted");
        }
      }
    }
    LOGGER.debug("exit from approveDeny method");
    return errorsList;
  }

  /**
   * list all leave details.
   * @param emp2Id id to get leave details.
   * @return all leave details.
   */
  public static List<LeaveDetails> fetchLeaveDetailsByEmployee(final int emp2Id) {
    Employee emp = Employee.listEmployeeDetailsById(emp2Id);
    if (emp == null) {
      return null;
    }
    return dao().fetchLeaveDetailsByEmployee(emp2Id);
  }
  /**
   * list all PENDING leave details.
   * @param argLeaveDetails to save leave details.
   * @param empId to save leave details.
   * @return to save leave details.
   */
  public static int applyForLeave(final LeaveDetails argLeaveDetails, final int empId) {
    int value = dao().insertLeaveDetails(argLeaveDetails);
    if (empId == 1000) {
      String status = "APPROVED";
      String mgrComment = "AUTO_APPROVED";
      dao().approveCeoLeave(empId, status, mgrComment);
      Employee employee1 = Employee.listEmployeeDetailsById(1000);
      long avail = employee1.getEmpLeaveAvail();
      long avail1 = argLeaveDetails.getLeaveNoOfDays();
      Employee.updateEmpLeaveAvail(1000, (avail - avail1));
    }
    LOGGER.debug("exit from leavedetails");
    return value;
  }

  /**
   * list all PENDING leave details.
   * @param empId to save leave details.
   * @param userLeaveNoOfdays to save leave details.
   * @param strLeaveStartDate to save leave details.
   * @param strLeaveEndDate to save leave details.
   * @param leaveType to save leave details.
   * @param leaveReason to save leave details.
   * @return error details.
   */
  public static List validateLeaveDetails(final long userLeaveNoOfdays, final String strLeaveStartDate,
      final String strLeaveEndDate, final String leaveType, final String leaveReason,
      final int empId) {
    LOGGER.debug("entering into validateLeaveDetails method with params: userLeaveNoOfdays : " + userLeaveNoOfdays
        + "strLeaveStartDate : " + strLeaveStartDate + " strLeaveEndDate : " + strLeaveEndDate + " leaveType : "
        + leaveType + "leaveReason : " + leaveReason + " empId : " + empId);
    ArrayList<String> errors = new ArrayList<String>();
    Employee employee = Employee.listEmployeeDetailsById(empId);
    LOGGER.info("getting employee details by empId");
    if (employee == null) {
      errors.add("Sorry no such employee");
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    Date leaveStartDate = null;
    Date leaveEndDate = null;
    Date leaveAppliedOn = new Date();
    try {
      leaveStartDate = dateFormat.parse(strLeaveStartDate);
      if (!strLeaveStartDate.equals(dateFormat.format(leaveStartDate))) {
        errors.add("Enter a valid Date");
      }
    } catch (ParseException e) {
      LOGGER.error("Invalid start date");
      errors.add("Enter start date in correct format");
    }
    if (leaveStartDate != null && leaveStartDate.before(leaveAppliedOn)) {
      errors.add("Leave start date cannot be before current date");
    }
    try {
      leaveEndDate = dateFormat.parse(strLeaveEndDate);
      if (!strLeaveEndDate.equals(dateFormat.format(leaveEndDate))) {
        errors.add("Enter a valid Date");
      }
    } catch (ParseException e) {
      LOGGER.error("Invalid end date");
      errors.add("Enter end date in correct format");
    }
    if (leaveEndDate != null && leaveEndDate.before(leaveStartDate)) {
      errors.add("Leave end date cannot be before leave start date. ");
    }
    if (leaveEndDate != null && leaveEndDate.before(leaveAppliedOn)) {
      errors.add("Leave end date cannot be before current date");
    }
    if (leaveStartDate != null && leaveEndDate != null) {
      long difference = leaveEndDate.getTime() - leaveStartDate.getTime();
      LOGGER.info("Getting no of days for which leave is applied");
      long availed = difference / (1000 * 60 * 60 * 24) + 1;
      long avail = employee.getEmpLeaveAvail();
      LOGGER.info("Getting no of leave available");
      long avails = userLeaveNoOfdays;
      LOGGER.info("Getting user leave no of days");
      if (avails != availed) {
        errors.add("Enter correct Leave No Of days");
      }
      if (availed > avail) {
        errors.add("The number of days leave applied for is more than the Available leave balance");
      }
    } else {
      errors.add("Number of Days Leave availed for cannot be calculated for the dates entered ");
    }
    if (!(leaveType.equalsIgnoreCase("EL") || leaveType.equalsIgnoreCase("SL")
        || leaveType.equalsIgnoreCase("PL") || leaveType.equalsIgnoreCase("ML")
        || leaveType.equalsIgnoreCase("LOP") || leaveType.equalsIgnoreCase("OL")
        || leaveType.equalsIgnoreCase("EARNED_LEAVE") || leaveType.equalsIgnoreCase("SICK_LEAVE")
        || leaveType.equalsIgnoreCase("PATERNITY_LEAVE") || leaveType.equalsIgnoreCase("MATERNITY_LEAVE")
        || leaveType.equalsIgnoreCase("LOSS_OF_PAY") || leaveType.equalsIgnoreCase("OPTIONAL_LEAVE"))) {
      errors.add("Invalid Leave Type");
    }
    LOGGER.info("exiting from validateLeaveDetails method");
    return errors;
  }
  /**
  * @param leaveDetails leave.
  * @param argMgrEmail leave.
  * @param argEmpName leave.
  */
  public static void simpleEmailForApply(final LeaveDetails leaveDetails, final String argMgrEmail,
      final String argEmpName) {
    Date strDate = leaveDetails.getLeaveStartDate();
    Date endDate = leaveDetails.getLeaveEndDate();
    int eId = leaveDetails.getEmpId();
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy");
    String sDate = date.format(strDate);
    String eDate = date.format(endDate);
    String subject = "Leave Applied by " + argEmpName;
    String body = "The leave Details are :" + "\n" + "Employee Name :" + argEmpName + "\n" + "Leave No of Days :"
          + leaveDetails.getLeaveNoOfDays() + "\n" + "Leave Start Date :" + sDate
          + "\n" + "Leave End Date :" + eDate + "\n" + "Leave Type :" + leaveDetails.getLeaveType() + "\n"
          + "Leave Reason :" + leaveDetails.getLeaveReason() + "\n"
          + "Leave Applied On :" + leaveDetails.getLeaveAppliedOn();
    EmailUtil.sendEmailForApply(argMgrEmail, subject + "[" + "EmpId: " + eId + "]", body);
  }
}