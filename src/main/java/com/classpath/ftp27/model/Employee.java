package com.classpath.ftp27.model;

import com.classpath.ftp27.persistence.EmployeeDAO;
import com.classpath.ftp27.persistence.DbConnection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlRootElement;


import java.util.Objects;
import java.util.List;
import java.util.Date;
/**
 * Employee class to store employee personal details.
 * @author hexware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Employee {

  /**
   * empId to store employee id.
   * empName to store employee name.
   * empEmail to store employee email.
   * empPhoneNo to store employee phoneno.
   * empDOJ to store employee doj.
   * empDept to store employee dept.
   * empLeaveAvail to store employee leaveavail.
   * empMgrId to store employee mgrid.
   */
  private int empId;
  private String empName;
  private String empEmail;
  private String empPhoneNo;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
  private Date empDOJ;
  private String empDept;
  private long empLeaveAvail;
  private int empMgrId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName)
        && Objects.equals(empEmail, emp.empEmail) && Objects.equals(empPhoneNo, emp.empPhoneNo)
        && Objects.equals(empDOJ, emp.empDOJ) && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empLeaveAvail, emp.empLeaveAvail)
        && Objects.equals(empMgrId, emp.empMgrId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empEmail, empPhoneNo, empDOJ, empDept, empLeaveAvail, empMgrId);
  }
  @Override
  public final String toString() {
    return "Employee:" + this.empId + this.empName + this.empEmail + this.empPhoneNo
      + this.empDOJ + this.empDept + this.empLeaveAvail
      + this.empMgrId;
  }
  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpName to initialize employee name.
   * @param argEmpEmail to initialize employee email.
   * @param argEmpPhoneNo to initialize employee phoneno.
   * @param argEmpDOJ to initialize employee date of joining.
   * @param argEmpDept to initialize employee dept.
   * @param argEmpLeaveAvail to initialize employee available leave days.
   * @param argEmpMgrId to initialize employee mgrid.
   */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpEmail,
      final String argEmpPhoneNo, final Date argEmpDOJ, final String argEmpDept,
      final int argEmpLeaveAvail, final int argEmpMgrId) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empEmail = argEmpEmail;
    this.empPhoneNo = argEmpPhoneNo;
    this.empDOJ = new Date(argEmpDOJ.getTime());
    this.empDept = argEmpDept;
    this.empLeaveAvail = argEmpLeaveAvail;
    this.empMgrId = argEmpMgrId;
  }
  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId =  argEmpId;
  }
  /**
   * No argument constructor.
   */
  public Employee() {
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }
  /**
   *
   * @return argEmpId to get employee Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }
  /**
   *
   * @return argEmpId to get employee phone no.
   */
  public final String getEmpPhoneNo() {
    return empPhoneNo;
  }

  /**
   *
   * @return argEmpId to get employee date of joining.
   */
  public final Date getEmpDOJ() {
    return new Date(this.empDOJ.getTime());
  }

  /**
   *
   * @return argEmpId to get employee working dept.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   *
   * @return argEmpId to get employee available leave days.
   */
  public final long getEmpLeaveAvail() {
    return empLeaveAvail;
  }

  /**
   *
   * @return argEmpId to get manager if.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   *
   * @param argEmpEmail to set employee email.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   *
   * @param argEmpPhoneNo to set employee phoneno.
   */
  public final void setEmpPhoneNo(final String argEmpPhoneNo) {
    this.empPhoneNo = argEmpPhoneNo;
  }

  /**
   *
   * @param argEmpDOJ to set employee date of joining.
   */
  public final void setEmpDOJ(final Date argEmpDOJ) {
    this.empDOJ = new Date(argEmpDOJ.getTime());
  }

  /**
   *
   * @param argEmpDept to set employee working dept.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }

  /**
   *
   * @param argEmpLeaveAvail to set employee leave available days.
   */
  public final void setEmpLeaveAvail(final long argEmpLeaveAvail) {
    this.empLeaveAvail = argEmpLeaveAvail;
  }

  /**
   *
   * @param argEmpMgrId to set manager ID.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAllEmployeeDetails() {

    List<Employee> es = dao().findEmployeeDetails();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return entered(id) Employee's details
   */
  public static Employee listEmployeeDetailsById(final int empID) {
    return dao().findEmployeeDetailsByEnteredId(empID);
  }

  /**
   * list manager's subordinates Pending Leaves.
   * @param empMgrId to get subordinates leave details.
   * @return Employee
   */
  public static Employee listPendingLeavesForEnteredMgrId(final int empMgrId) {
    return dao().findPendingLeavesForEnteredMgrId(empMgrId);
  }

  /**
   * check for Manager.
   * @param empId id to get manager.
   * @return Manager.
   */
  public static boolean isManager(final int empId) {
    int numberOfEmployees =  dao().findNumberOfEmployeesForManager(empId);
    if (numberOfEmployees > 0) {
      return true;
    }
    return false;
  }

  /**
   * check for Manager.
   * @param empId id to get manager.
   * @param avail id to get manager.
   */
  public static void updateEmpLeaveAvail(final int empId, final long avail) {
    dao().updateLeaves(empId, avail);
  }
}