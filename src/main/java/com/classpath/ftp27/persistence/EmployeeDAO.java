package com.classpath.ftp27.persistence;

import com.classpath.ftp27.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> findEmployeeDetails();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee findEmployeeDetailsByEnteredId(@Bind("empID") int empID);

  /**
   * return employees with pending leaves.
   * @param empMgrId the id of the manager
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_MGR_ID = :empMgrId")
  @Mapper(EmployeeMapper.class)
  Employee findPendingLeavesForEnteredMgrId(@Bind("empMgrId") int empMgrId);

  /**
   * no. of subordinates for entered mgrId.
   * @param empId the id Employee.
   * @return no. of subordinates
   */
  @SqlQuery("SELECT COUNT(*) FROM EMPLOYEE WHERE EMPLOYEE.EMP_MGR_ID  = :empID")
  int findNumberOfEmployeesForManager(@Bind("empID") int empId);

  /**
   * list employee details by id.
   * @param empId the id Employee.
   * @param avail the id Employee.
   */
  @SqlUpdate(" UPDATE EMPLOYEE SET EMP_LEAVE_AVAIL = :avail WHERE EMP_ID = :empID")
  void updateLeaves(@Bind("empID") int empId, @Bind("avail") long avail);

  /**
  * close with no args is used to close the connection.
  */
  void close();
}

