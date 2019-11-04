package com.classpath.ftp27.util;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.classpath.ftp27.model.Employee;
import com.classpath.ftp27.model.LeaveDetails;
import com.classpath.ftp27.model.LeaveType;
import com.classpath.ftp27.model.LeaveStatus;
import java.util.Iterator;
import java.util.List;
import java.util.InputMismatchException;


/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply for Leave(s)");
    System.out.println("4. View Pending Leaves");
    System.out.println("5. View Leave History");
    System.out.println("6. Manager Approve/Deny");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyForLeave();
        break;
      case 4:
        viewPendingLeaves();
        break;
      case 5:
        viewLeaveHistory();
        break;
      case 6:
        managerApproveOrDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose valid options");
        mainMenu();
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listEmployeeDetailsById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println("Employee Details : ");
      System.out.println(" ID      Name              Email ID               Mobile No.        DOJ    "
          + "     Dept.           Available Leave Days   Manager ID");
      System.out.format("%-5d %-15s %-25s %-15s %-12tF %-26s %-17d %-10d %n", employee.getEmpId(),
          employee.getEmpName(), employee.getEmpEmail(), employee.getEmpPhoneNo(), employee.getEmpDOJ(),
          employee.getEmpDept(), employee.getEmpLeaveAvail(), employee.getEmpMgrId());
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAllEmployeeDetails();
    System.out.println("Employee Details : ");
    System.out.println(" ID      Name              Email ID               Mobile No.        DOJ    "
          + "     Dept.         Available Leave Days   Manager ID");
    for (Employee employees : employee) {
      System.out.format("%-5d %-15s %-25s %-15s %-12tF %-26s %-15d %-10d %n", employees.getEmpId(),
          employees.getEmpName(), employees.getEmpEmail(), employees.getEmpPhoneNo(), employees.getEmpDOJ(),
          employees.getEmpDept(), employees.getEmpLeaveAvail(), employees.getEmpMgrId());
    }
  }
  private void applyForLeave() {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();

    Employee employee = Employee.listEmployeeDetailsById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
      mainMenu();
    }
    System.out.println("Enter leave start date in dd-mm-yy format");
    String strLeaveStartDate = option.next();
    System.out.println("Enter leave end date in dd-mm-yy format");
    String strLeaveEndDate = option.next();
    System.out.println("Enter the number of days leave availed for : ");
    long userLeaveNoOfdays = option.nextLong();
    System.out.println("Select the leave type--'PL','ML','EL','LOP','OL'");
    String leaveType = option.next();
    option.nextLine();
    System.out.println("Enter the reason for leave");
    String leaveReason = option.nextLine();
    List result = LeaveDetails.validateLeaveDetails(userLeaveNoOfdays, strLeaveStartDate, strLeaveEndDate, leaveType,
        leaveReason, empId);
    if (!result.isEmpty()) {
      for (Iterator i = result.iterator(); i.hasNext();) {
        System.out.println(i.next());
      }
      mainMenu();
    }
    Date leaveStartDate = null;
    Date leaveEndDate = null;
    try {
      leaveStartDate = dateFormat.parse(strLeaveStartDate);
      leaveEndDate = dateFormat.parse(strLeaveEndDate);
    } catch (ParseException e) {
      System.out.println("Entered wrong format of date..");
    }
    if (leaveStartDate != null && leaveEndDate != null) {
      String lveType = "EARNED_LEAVE";
      if (leaveType.equalsIgnoreCase("EL")) {
        lveType = "EARNED_LEAVE";
      } else if (leaveType.equalsIgnoreCase("SL")) {
        lveType = "SICK_LEAVE";
      } else if (leaveType.equalsIgnoreCase("ML")) {
        lveType = "MATERNITY_LEAVE";
      } else if (leaveType.equalsIgnoreCase("PL")) {
        lveType = "PATERNITY_LEAVE";
      } else if (leaveType.equalsIgnoreCase("LOP")) {
        lveType = "LOSS_OF_PAY";
      } else if (leaveType.equalsIgnoreCase("OL")) {
        lveType = "OPTIONAL_LEAVE";
      }
      Date currentDate = new Date();
      SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
      String leaveAppliedOn = date.format(currentDate);

      LeaveDetails leaveDetails = new LeaveDetails(userLeaveNoOfdays, leaveStartDate, leaveEndDate,
          LeaveType.valueOf(lveType), leaveReason, leaveAppliedOn, empId);
      int leaveno = LeaveDetails.applyForLeave(leaveDetails, empId);
      System.out.println("Leave applied successfully");
      if (leaveno != 0 && empId != 1000) {
        Employee emp2 = Employee.listEmployeeDetailsById(empId);
        String empName = emp2.getEmpName();
        int mgrId = emp2.getEmpMgrId();
        Employee emp1 = Employee.listEmployeeDetailsById(mgrId);
        String mgrEmail = emp1.getEmpEmail();
        LeaveDetails.simpleEmailForApply(leaveDetails, mgrEmail, empName);
      } else {
        mainMenu();
      }
    } else {
      mainMenu();
    }
  }

  private void viewPendingLeaves() {
    System.out.println("Enter Manager Id");
    int empMgrId = option.nextInt();
    Employee employee = Employee.listPendingLeavesForEnteredMgrId(empMgrId);
    if (employee == null) {
      System.out.println("Sorry, No such Manager Exists");
    } else {
      List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmpId(empMgrId);
      System.out.println("Employee Leave History : ");
      System.out.println("Leave ID Applied Days  Start Date  End Date    Leave Type      Leave Status "
          + "   Leave Reason       Leave Applied On     Manager Comment  Employee ID");
      for (LeaveDetails leaves : list) {
        System.out.format("%-12d %-9d %-10tF %-12tF %-16s %-13s %-19s %-21s %-15s %-12d%n", leaves.getLeaveId(),
            leaves.getLeaveNoOfDays(), leaves.getLeaveStartDate(), leaves.getLeaveEndDate(), leaves.getLeaveType(),
            leaves.getLeaveStatus(), leaves.getLeaveReason(), leaves.getLeaveAppliedOn(),
            leaves.getLeaveMgrComment(), leaves.getEmpId());
      }
    }
  }
  private void viewLeaveHistory() {
    System.out.println("Enter Employee Id");
    int emp2Id = option.nextInt();
    Employee employee = Employee.listEmployeeDetailsById(emp2Id);
    if (employee == null) {
      System.out.println("Sorry, No such Employee Exists");
    } else {
      List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(emp2Id);
      System.out.println("Employee Leave History : ");
      System.out.println("Leave ID Applied Days  Start Date  End Date    Leave Type      Leave Status "
          + "   Leave Reason       Leave Applied On     Manager Comment");
      for (LeaveDetails leaves : list) {
        System.out.format("%-12d %-9d %-10tF %-12tF %-16s %-13s %-19s %-21s %-15s%n", leaves.getLeaveId(),
            leaves.getLeaveNoOfDays(), leaves.getLeaveStartDate(), leaves.getLeaveEndDate(), leaves.getLeaveType(),
            leaves.getLeaveStatus(), leaves.getLeaveReason(), leaves.getLeaveAppliedOn(), leaves.getLeaveMgrComment());
      }
    }
  }
  private void managerApproveOrDeny() {
    String value = null;
    System.out.println("Enter Manager Id");
    int empId = option.nextInt();
    System.out.println("Enter leave Id");
    int leaveId = option.nextInt();
    LeaveDetails leave = LeaveDetails.findLeaveDetails1(empId, leaveId);
    if (leave == null) {
      System.out.println("Leave Id does not exists Or Doesn't report to this manager");
      mainMenu();
      return;
    }
    System.out.println("Enter the value Approved or Denied");
    option.nextLine();
    value = option.nextLine();
    LeaveStatus leaveStatusDb = leave.getLeaveStatus();
    String leaveStatusValue = leaveStatusDb.toString();
    if (leaveStatusValue.equalsIgnoreCase("APPROVED") && value.equalsIgnoreCase("APPROVED")) {
      System.out.println("Leave already APPROVED");
      mainMenu();
    } else if (leaveStatusValue.equalsIgnoreCase("DENIED") && value.equalsIgnoreCase("DENIED")) {
      System.out.println("Leave already DENIED");
      mainMenu();
    }
    System.out.println("Enter manager comments");
    String mgrComment = option.nextLine();
    List errorList = LeaveDetails.approveDenyLeave(empId, leaveId, mgrComment, value);
    if (!errorList.isEmpty()) {
      for (Iterator i = errorList.iterator(); i.hasNext();) {
        System.out.println(i.next());
      }
      mainMenu();
    }
  }
  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    try {
      mainObj.mainMenu();
    } catch (InputMismatchException e) {
      System.out.println("Enter valid input");
      //mainMenu();
    }
  }
}
