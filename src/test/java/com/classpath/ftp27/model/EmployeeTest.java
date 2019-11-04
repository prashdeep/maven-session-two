package com.classpath.ftp27.model;

import com.classpath.ftp27.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Verifications;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {
/**
   * constructor method.
   */
  @Test
  public final void testEmployee() {
    Date d1 = new Date(18, 02, 18);
    Employee employee = new Employee(200, "Sabitha", "sabitha44@gmail.com", "9855078309", d1, "Electrical", 50, 1000);
    int empId = employee.getEmpId();
    assertEquals(empId, 200);
    String empName = employee.getEmpName();
    assertEquals(empName, "Sabitha");
    String empEmail = employee.getEmpEmail();
    assertEquals(empEmail, "sabitha44@gmail.com");
    String empPhoneNo = employee.getEmpPhoneNo();
    assertEquals(empPhoneNo, "9855078309");

    assertEquals(d1.toString(), employee.getEmpDOJ().toString());
    String empDept = employee.getEmpDept();
    assertEquals(empDept, "Electrical");
    long empLeaveAvail = employee.getEmpLeaveAvail();
    assertEquals(empLeaveAvail, 50);
    int empMgrId = employee.getEmpMgrId();
    assertEquals(empMgrId, 1000);
  }
  /**
   * Employee getempId.
   */
  @Test
  public final void testEmployeee() {
    Employee employee = new Employee(200);
    int empId = employee.getEmpId();
    assertEquals(empId, 200);
  }
  /**
   * set and get method.
   */
  @Test
  public final void testSetEmpId() {
    Employee emp = new Employee();
    emp.setEmpId(200);
    int empId = emp.getEmpId();
    assertEquals(empId, 200);
  }
  /**
   * set and get method.
   */
  @Test
  public final void testSetEmpName() {
    Employee emp = new Employee();
    emp.setEmpName("Surbhi");
    String empName = emp.getEmpName();
    assertEquals(empName, "Surbhi");
  }
  /**
   * set and get method.
   */
  @Test
  public final void testSetEmpEmail() {
    Employee emp = new Employee();
    emp.setEmpEmail("Surbhi43@gmail.com");
    String empEmail = emp.getEmpEmail();
    assertEquals(empEmail, "Surbhi43@gmail.com");
  }
  /**
   * set and get method.
   */
  @Test
  public final void testSetEmpPhoneNo() {
    Employee emp = new Employee();
    emp.setEmpPhoneNo("8675488645");
    String empPhoneNo = emp.getEmpPhoneNo();
    assertEquals(empPhoneNo, "8675488645");
  }
  /**
   * set and get method.
   */
  @Test
  public final void testSetEmpDOJ() {
    Employee emp = new Employee();
    Date d1 = new Date(20, 02, 18);
    emp.setEmpDOJ(d1);
    Date empDOJ = emp.getEmpDOJ();
    assertEquals(empDOJ, d1);
  }
  /**
   * set and get method.
   */
  @Test
  public final void testSetEmpDept() {
    Employee emp = new Employee();
    emp.setEmpDept("computer science");
    String empDept = emp.getEmpDept();
    assertEquals(empDept, "computer science");
  }
  /**
   * set and get method.
   */
  @Test
  public final void testSetEmpLeaveAvail() {
    Employee emp = new Employee();
    emp.setEmpLeaveAvail(50);
    long empLeaveAvail = emp.getEmpLeaveAvail();
    assertEquals(empLeaveAvail, 50);
  }
  /**
   * set and get method.
   */
  @Test
  public final void testSetEmpMgrId() {
    Employee emp = new Employee();
    emp.setEmpMgrId(1002);
    int empMgrId = emp.getEmpMgrId();
    assertEquals(empMgrId, 1002);
  }
  /**
   * equals method.
   */
  @Test
  public final void testEquals() {
    Date d1 = new Date(18, 02, 18);
    Employee emp = new Employee(200, "namrata", "namrataraj77@gmail.com", "7656364467", d1, "Electrical", 48, 2001);
    Employee emp1 = new Employee(200, "namrata", "namrataraj77@gmail.com", "7656364467", d1, "Electrical", 48, 2001);
    assertEquals(emp, emp1);
  }
  /**
   * notequals method.
   */
  @Test
  public final void testNotEquals() {
    Date d1 = new Date(18, 02, 18);
    Employee emp = new Employee(200, "namrata", "namrataraj77@gmail.com", "7656364467", d1, "Electrical", 48, 2001);
    Date d2 = new Date(18, 07, 18);
    Employee emp1 = new Employee(200, "ridhima", "ridhimasharma77@gmail.com", "9876453258", d2, "Marketing", 45, 2007);
    assertNotEquals(emp, emp1);
  }
  /**
   * hashcode method.
   */
  /*@Test
  public final void testHashCode() {
    Date d1 = new Date(18, 02, 18);
    Employee emp = new Employee(200, "namrata", "namrataraj77@gmail.com", "7656364467", d1, "Electrical", 48, 2001);
    int emp1 = emp.hashCode();
    assertEquals(emp1, 1364148867);
  }*/
   /**
   * hashcodeNotEquals method.
   */
  /*@Test
  public final void testHashCodeNotequals() {
    Date d1 = new Date(18, 02, 18);
    Employee emp = new Employee(40, "ridhima", "namrataraj77@gmail.com", "7656364467", d1, "Electrical", 48, 2001);
    int emp1 = emp.hashCode();
    assertNotEquals(emp1, 1553641467);
  }*/

  /**
   * toString method.
   */
  @Test
  public final void testToString() {
    Date d1 = new Date(18, 02, 18);
    Employee employee = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", d1, "Sales", 65, 3001);
    assertEquals("Employee:300nikitanikitamgs@gmail.com8318831967Mon Mar 18 00:00:00 IST 1918Sales653001",
        employee.toString());
  }
  /**
   * Test class for Employee Details.
   * @param dao for getting all employee details.
   */
  @Test
  public final void testListAllEmployeeDetails(@Mocked final EmployeeDAO dao) {
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    final List<Employee> list = new ArrayList<Employee>();
    list.add(new Employee());
    list.add(new Employee());
    list.add(new Employee());
    list.add(new Employee());
    list.add(new Employee());
    new Expectations() {
      {
        dao.findEmployeeDetails(); result = list;
      }
    };
    Employee[] arrayOfEmployees = Employee.listAllEmployeeDetails();
    assertNotNull(arrayOfEmployees);
    assertEquals(arrayOfEmployees.length, list.size());
    new Verifications() {
      {
        dao.findEmployeeDetails(); times = 1;
      }
    };
  }
  /**
   * Test class for Employee Details.
   * @param dao for getting all employee details.
   */
  @Test
  public final void testListEmployeeDetailsById(@Mocked final EmployeeDAO dao) {
    Date d1 = new Date(18, 02, 18);
    final Employee employee = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", d1, "Sales", 65, 3001);
    new Expectations() {
      {
        dao.findEmployeeDetailsByEnteredId(300); result = employee;
      }
    };

    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };

    Employee emp = Employee.listEmployeeDetailsById(300);
    assertNotNull(emp);
    assertEquals(emp, employee);
    new Verifications() {
      {
        dao.findEmployeeDetailsByEnteredId(300); times = 1;
      }
    };
  }

  /**
   * Test class for Employee Details.
   * @param dao for getting all employee details.
   */
  @Test
  public final void testListPendingLeavesForEnteredMgrId(@Mocked final EmployeeDAO dao) {
    final Employee manager = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967",
        new Date(15, 03, 18), "Sales", 65, 3001);
    new Expectations() {
      {
        dao.findPendingLeavesForEnteredMgrId(300); result = manager;
      }
    };

    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };

    Employee empMgr = Employee.listPendingLeavesForEnteredMgrId(300);
    assertNotNull(empMgr);
    assertEquals(empMgr, manager);
    new Verifications() {
      {
        dao.findPendingLeavesForEnteredMgrId(300); times = 1;
      }
    };
  }

  /**
   * Test class for Employee Details.
   * @param dao for getting all employee details.
   */
  @Test
  public final void testIsManager(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.findNumberOfEmployeesForManager(5000); result = 5;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    boolean flag = Employee.isManager(5000);
    assertTrue(flag);
    new Verifications() {
      {
        dao.findNumberOfEmployeesForManager(5000); times = 1;
      }
    };
  }
  /**
   * Test class for Employee Details.
   * @param dao for getting all employee details.
   */
  @Test
  public final void testNotManager(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.findNumberOfEmployeesForManager(4000); result = 0;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    boolean flag = Employee.isManager(4000);
    assertFalse(flag);
    new Verifications() {
      {
        dao.findNumberOfEmployeesForManager(4000); times = 1;
      }
    };
  }
  /**
   * Test class for Employee Details.
   */
  @Test
  public final void testEqualNull() {
    Employee emp1 = new Employee(45);
    Employee emp2 = null;
    assertNotEquals(emp1, emp2);
  }
  /**
   * Test class for Employee Details.
   *
   */
  @Test
  public final void testEqualClass() {
    Employee emp1 = new Employee(45);
    LeaveDetails leaveDetails = new LeaveDetails();
    assertNotEquals(emp1, leaveDetails);
  }
}
