package com.classpath.ftp27.persistence;

import com.classpath.ftp27.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for leave details.
 */
public interface LeaveDetailsDAO  {
  /**
   * return all the leave details of all the employees.
   * @return the leave details array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the leave details of the selected employee.
   * @param empId to get the leave details of the employee.
   * @return the leave details object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> fetchLeaveDetailsByEmpId(@Bind("empId") int empId);

  /**
   * return all the leave details of the subordinate employee.
   * @param empMgrId to get the leave details of the subordinate employee.
   * @return the leave details object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS INNER JOIN EMPLOYEE ON "
      + " LEAVE_DETAILS.EMP_ID = EMPLOYEE.EMP_ID WHERE EMP_MGR_ID= :empMgrId "
      + " HAVING (LEAVE_STATUS ='PENDING' OR LEAVE_STATUS ='DENIED' OR "
      + "LEAVE_STATUS ='APPROVED') ORDER BY LEAVE_ID DESC ")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> fetchPendingLeavesByMgrId(@Bind("empMgrId") int empMgrId);


   /**
   * return all the leave details of the selected employee.
   * @param empId to get the leave details of the employee.
   * @return the leave details object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empId ORDER BY LEAVE_APPLIED_ON DESC")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> fetchLeaveDetailsByEmployee(@Bind("empId") int empId);

/**
   * return all the leave details of the selected employee.
   * @param argLeaveDetails to insert the details of the leave.
   * @return argLeaveDetails to insert the details of the leave.
   */
  @SqlUpdate(" INSERT INTO LEAVE_DETAILS(LEAVE_NO_DAYS, LEAVE_START_DATE, LEAVE_END_DATE, "
      + " LEAVE_TYPE, LEAVE_REASON, LEAVE_APPLIED_ON, EMP_ID) "
      + " VALUES (:leaveDetails.leaveNoOfDays, :leaveDetails.leaveStartDate, "
      + " :leaveDetails.leaveEndDate, :leaveDetails.leaveType, :leaveDetails.leaveReason, "
      + " :leaveDetails.leaveAppliedOn, :leaveDetails.empId)")
  int insertLeaveDetails(@BindBean("leaveDetails") LeaveDetails argLeaveDetails);


  /**
   * return all the leave details of the selected employee.
   * @param empMgrId to get the leave details of the subordinate employee.
   * @param leaveId to get the details of the specific leave.
   * @return the leave details object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS INNER JOIN EMPLOYEE ON "
      + " LEAVE_DETAILS.EMP_ID = EMPLOYEE.EMP_ID WHERE EMP_MGR_ID= :empMgrId "
      + " HAVING LEAVE_STATUS ='PENDING' AND LEAVE_ID = :leaveId ")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails fetchPendingLeaveByLeaveIdAndMgrId(@Bind("empMgrId") int empMgrId, @Bind("leaveId") int leaveId);

  /**
   * return all the leave details of the selected employee.
   * @param leaveId to get the details of the specific leave.
   * @return the leave details object
   */
  @SqlQuery("SELECT LEAVE_STATUS FROM LEAVE_DETAILS WHERE LEAVE_ID = :leaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails fetchStatusByLeaveId(@Bind("leaveId") int leaveId);

  /**
   * return all the leave details of the selected employee.
   * @param leaveId to get the details of a specific leave.
   * @param mgrComment to get the comment made by the manager.
   * @param status to get the details of a specific leave.*/
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS = :status, "
      + "LEAVE_MGR_COMMENT = :mgrComment WHERE LEAVE_ID = :leaveId")
  void approveStatusByLeaveId(@Bind("leaveId") int leaveId, @Bind("mgrComment") String mgrComment,
            @Bind("status") String status);

/**
   * return all the leave details of the selected employee.
   * @param empId to get the details of a specific leave.
   * @param status to get the details of a specific leave.
   * @param mgrComment to get the details of a specific leave.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS = :status, LEAVE_MGR_COMMENT = :mgrComment WHERE EMP_ID = :empId")
  void approveCeoLeave(@Bind("empId") int empId, @Bind("status") String status, @Bind("mgrComment") String mgrComment);

  /**
   * return all the leave details of the selected employee.
   * @param empMgrId to get the leave details of the subordinate employee.
   * @param leaveId to get the details of the specific leave.
   * @return the leave details object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS INNER JOIN EMPLOYEE ON "
      + " LEAVE_DETAILS.EMP_ID = EMPLOYEE.EMP_ID WHERE EMP_MGR_ID= :empMgrId "
      + " HAVING (LEAVE_STATUS ='PENDING' OR LEAVE_STATUS ='DENIED' OR "
      + "LEAVE_STATUS ='APPROVED')  AND LEAVE_ID = :leaveId ")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails fetchPendingLeaveByLeaveIdAndMgrId1(@Bind("empMgrId") int empMgrId, @Bind("leaveId") int leaveId);
/**
   * return all the leave details of the selected employee.
   * @param leaveId to get the details of the specific leave.
   * @return the leave details object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID= :leaveId ")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails findEmployeeDetailsByLeaveId(@Bind("leaveId") int leaveId);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
