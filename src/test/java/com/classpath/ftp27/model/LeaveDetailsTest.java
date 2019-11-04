package com.classpath.ftp27.model;
import com.classpath.ftp27.persistence.EmployeeDAO;
import com.classpath.ftp27.persistence.LeaveDetailsDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import java.util.Date;
import mockit.Mocked;
import mockit.MockUp;
import mockit.Mock;
import mockit.Verifications;
import mockit.Expectations;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Test class for Leave Details.
 */
//@RunWith(JMockit.class)
public class LeaveDetailsTest {
   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testLeaveDetails() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    LeaveDetails ld1 = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
            "sick", "22-03-18 10:25:25", 2000, "Granted");
    int leaveId = ld1.getLeaveId();
    assertEquals(leaveId, 12);
    long leaveNoOfDays = ld1.getLeaveNoOfDays();
    assertEquals(leaveNoOfDays, 2);
    assertEquals(d1.toString(), ld1.getLeaveStartDate().toString());
    assertEquals(d2.toString(), ld1.getLeaveEndDate().toString());
    assertEquals(LeaveType.MATERNITY_LEAVE, ld1.getLeaveType());
    assertEquals(LeaveStatus.PENDING, ld1.getLeaveStatus());
    String s5 = ld1.getLeaveReason();
    assertEquals(s5, "sick");
    String s6 = ld1.getLeaveAppliedOn();
    assertEquals(s6, "22-03-18 10:25:25");
    int empId = ld1.getEmpId();
    assertEquals(empId, 2000);
    String s4 = ld1.getLeaveMgrComment();
    assertEquals(s4, "Granted");
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testLeaveDetails1() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveDetails ld1 = new LeaveDetails(2, d1, d2, leaveType,
            "sick", "22-03-18 10:25:25", 2000);
    long leaveNoOfDays = ld1.getLeaveNoOfDays();
    assertEquals(leaveNoOfDays, 2);
    assertEquals(d1.toString(), ld1.getLeaveStartDate().toString());
    assertEquals(d2.toString(), ld1.getLeaveEndDate().toString());
    assertEquals(LeaveType.MATERNITY_LEAVE, ld1.getLeaveType());
    String s5 = ld1.getLeaveReason();
    assertEquals(s5, "sick");
    String s6 = ld1.getLeaveAppliedOn();
    assertEquals(s6, "22-03-18 10:25:25");
    int empId = ld1.getEmpId();
    assertEquals(empId, 2000);
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveId() {
    LeaveDetails ld2 = new LeaveDetails();
    ld2.setLeaveId(13);
    int b = ld2.getLeaveId();
    assertEquals(b, 13);
  }
  /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveNoOfDays() {
    LeaveDetails ld3 = new LeaveDetails();
    ld3.setLeaveNoOfDays(4);
    long b = ld3.getLeaveNoOfDays();
    assertEquals(b, 4);
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveMgrComment() {
    LeaveDetails ld4 = new LeaveDetails();
    ld4.setLeaveMgrComment("granted");
    String s2 = ld4.getLeaveMgrComment();
    assertEquals(s2, "granted");
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveReason() {
    LeaveDetails ld5 = new LeaveDetails();
    ld5.setLeaveReason("sick");
    String s2 = ld5.getLeaveReason();
    assertEquals(s2, "sick");
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveType() {
    LeaveDetails ld6 = new LeaveDetails();
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    ld6.setLeaveType(leaveType);
    assertEquals(LeaveType.MATERNITY_LEAVE, ld6.getLeaveType());
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveStatus() {
    LeaveDetails ld7 = new LeaveDetails();
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    ld7.setLeaveStatus(leaveStatus);
    assertEquals(LeaveStatus.PENDING, ld7.getLeaveStatus());
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveStartDate() {
    LeaveDetails ld8 = new LeaveDetails();
    Date d1 = new Date(24, 03, 18);
    ld8.setLeaveStartDate(d1);
    Date d2 = ld8.getLeaveStartDate();
    assertEquals(d2, d1);
  }

     /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveEndDate() {
    LeaveDetails ld9 = new LeaveDetails();
    Date d1 = new Date(26, 03, 18);
    ld9.setLeaveEndDate(d1);
    Date d2 = ld9.getLeaveEndDate();
    assertEquals(d2, d1);
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetLeaveAppliedOn() {
    LeaveDetails ld10 = new LeaveDetails();
    ld10.setLeaveAppliedOn("23-03-18");
    String s1 = ld10.getLeaveAppliedOn();
    assertEquals(s1, "23-03-18");
  }

     /**
   * Test class for Leave Details.
   */
  @Test
  public final void testSetEmpId() {
    LeaveDetails ld2 = new LeaveDetails();
    ld2.setEmpId(13);
    int b = ld2.getEmpId();
    assertEquals(b, 13);
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testEquals() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    LeaveDetails ld11 = new LeaveDetails(15, 3, d1, d2, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    LeaveDetails ld12 = new LeaveDetails(15, 3, d1, d2, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    assertEquals(ld12, ld11);
  }

     /**
   * Test class for Leave Details.
   */
  @Test
  public final void testEquals1() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    LeaveDetails ld13 = new LeaveDetails(15, 3, d1, d2, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    Date d3 = new Date(23, 03, 18);
    LeaveDetails ld14 = new LeaveDetails(15, 3, d1, d3, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    assertNotEquals(ld13, ld14);
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testHashCode() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    LeaveDetails ld15 = new LeaveDetails(15, 3, d1, d2, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    int a = ld15.hashCode();
    assertNotEquals(a, 183);
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testHashCode1() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    LeaveDetails ld16 = new LeaveDetails(15, 3, d1, d2, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    LeaveDetails ld19 = new LeaveDetails(15, 3, d1, d2, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    int a = ld16.hashCode();
    int b = ld19.hashCode();
    assertEquals(a, b);
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testToString1() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    LeaveDetails ld17 = new LeaveDetails(15, 3, d1, d2, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    assertEquals("LeaveDetails:153Fri Apr 18 00:00:00 IST 1924Sun Apr 18 00:00:00 IST 1926"
        + "MATERNITY_LEAVEPENDINGsick23-03-182000Granted", ld17.toString());
  }

   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testToString2() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    LeaveDetails ld18 = new LeaveDetails(15, 3, d1, d2, leaveType, leaveStatus, "sick", "23-03-18", 2000, "Granted");
    assertNotEquals("LeaveDetails:163Fri Apr 18 00:00:00 IST 1924Sun Apr 18 00:00:00 IST 1926"
        + "MATERNITY_LEAVEPENDINGsick23-03-182000Granted", ld18.toString());
  }

  /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
  @Test
  public final void testInvalidEmpIdForListPendingLeaves(@Mocked final LeaveDetailsDAO dao) {
    new MockUp<Employee>() {
      @Mock
      Employee listEmployeeDetailsById(final int a) {
        return null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(45);
    assertNull(list);

    new Verifications() {
      {
        dao.fetchLeaveDetailsByEmployee(45); times = 0;
      }
    };
  }

  /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
 // @Test
  public final void testvalidEmpIdForListPendingLeaves(@Mocked final LeaveDetailsDAO dao) {

    new Expectations() {
        {
          dao.fetchLeaveDetailsByEmployee(34); result = null;
        }
      };

    new MockUp<Employee>() {
        @Mock
        Employee listEmployeeDetailsById(final int a) {
        return new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(), "Sales", 65, 3001);
      }
    };
    new MockUp<LeaveDetails>() {
        @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(34);
    assertNull(list);

    new Verifications() {
      {
        dao.fetchLeaveDetailsByEmployee(anyInt); times = 1;
      }
    };
  }

  /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
 // @Test
  public final void testvalidEmpIdForEmptyListPendingLeaves(@Mocked final LeaveDetailsDAO dao) {

    new Expectations() {
        {
          dao.fetchLeaveDetailsByEmployee(34); result = new ArrayList<LeaveDetails>();
        }
      };

    new MockUp<Employee>() {
      @Mock
        Employee listEmployeeDetailsById(final int a) {
        return new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(), "Sales", 65, 3001);
        }
    };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
        return dao;
        }
    };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(34);
    assertNotNull(list);
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());

    new Verifications() {
      {
        dao.fetchLeaveDetailsByEmployee(anyInt); times = 1;
      }
    };
  }

  /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
  //@Test
  public final void testvalidEmpIdForValidListPendingLeaves(@Mocked final LeaveDetailsDAO dao) {

    new Expectations() {
        {
          List<LeaveDetails> list = new ArrayList<LeaveDetails>();
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          dao.fetchLeaveDetailsByEmployee(34); result = list;
        }
      };

    new MockUp<Employee>() {
      @Mock
    Employee listEmployeeDetailsById(final int a) {
        return new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(), "Sales", 65, 3001);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
        return dao;
        }
      };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(34);
    assertNotNull(list);
    assertEquals(5, list.size());
    assertTrue(!list.isEmpty());

    new Verifications() {
      {
        dao.fetchLeaveDetailsByEmployee(anyInt); times = 1;
      }
    };
  }
  /**
   * Test class for Leave Details.
   * @param emp for employee details.
   * @param dao for getting leave details.
   */
  @Test
  public final void testInvalidEmpIdForLeaveHistory(@Mocked final Employee emp, @Mocked final LeaveDetailsDAO dao) {
    new MockUp<Employee>() {
      @Mock
      Employee listEmployeeDetailsById(final int a) {
        return null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(45);
    assertNull(list);
    new Verifications() {
      {
        dao.fetchLeaveDetailsByEmployee(anyInt); times = 0;
      }
    };
  }
   /**
   * Test class for Leave Details.
   * @param emp for employee details.
   * @param dao for getting leave details.
   */
  @Test
  public final void testValidEmpIdForNoLeaveHistory(@Mocked final Employee emp, @Mocked final LeaveDetailsDAO dao) {
    Date d1 = new Date(18, 02, 18);
    Employee employee = new Employee(200, "Sabitha", "sabitha44@gmail.com",
        "9855078309", d1, "Electrical", 50, 1000);
    new Expectations() {
          {
            dao.fetchLeaveDetailsByEmployee(anyInt);
            result = null;
        }
    };

    new MockUp<Employee>() {
          @Mock
          Employee listEmployeeDetailsById(final int id) {
            return emp;
          }
        };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(1);
    assertNull(list);
    new Verifications() { {
        dao.fetchLeaveDetailsByEmployee(anyInt); times = 1;
      }
      };
  }

  /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
  @Test
  public final void testvalidEmpIdForEmptyLeaveHistory(@Mocked final LeaveDetailsDAO dao) {

    new Expectations() {
        {
          dao.fetchLeaveDetailsByEmployee(34); result = new ArrayList<LeaveDetails>();
        }
      };

    new MockUp<Employee>() {
      @Mock
        Employee listEmployeeDetailsById(final int a) {
        return new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(), "Sales", 65, 3001);
        }
    };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
        return dao;
        }
    };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(34);
    assertNotNull(list);
    assertTrue(list.isEmpty());

    new Verifications() {
      {
        dao.fetchLeaveDetailsByEmployee(anyInt); times = 1;
      }
    };
  }

  /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
  @Test
  public final void testvalidEmpIdForLeaveHistory(@Mocked final LeaveDetailsDAO dao) {

    new Expectations() {
        {
          List<LeaveDetails> list = new ArrayList<LeaveDetails>();
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          dao.fetchLeaveDetailsByEmployee(34); result = list;
        }
      };

    new MockUp<Employee>() {
      @Mock
    Employee listEmployeeDetailsById(final int a) {
        return new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(), "Sales", 65, 3001);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
        return dao;
        }
      };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmployee(34);
    assertNotNull(list);
    assertEquals(5, list.size());
    assertTrue(!list.isEmpty());

    new Verifications() {
      {
        dao.fetchLeaveDetailsByEmployee(anyInt); times = 1;
      }
    };
  }
  /**
   * Test class for Leave Details.
   * @param emp for getting leave details.
   */
  //@Test
  public final void testInvalidApplyforleave(@Mocked final Employee emp) {

    new Expectations() {
      {
        emp.getEmpLeaveAvail(); result = 5;
      }
    };
    new MockUp<Employee>() {
        @Mock
      Employee listEmployeeDetailsById(final int a) {
        return new Employee();
      }
    };
    try {
      List<String> errorsList = LeaveDetails.validateLeaveDetails(34, "20-04-18mmm",
           "24-04-18mm", "lopo", "marriage", 100);
      assertNotNull(errorsList);
      assertEquals(4, errorsList.size());
      assertTrue(!errorsList.isEmpty());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  /**
   * Test class for Leave Details.
   * @param emp for getting leave details.
   */
  @Test
  public final void testInvalidDate(@Mocked final Employee emp) {

    new Expectations() {
      {
        emp.getEmpLeaveAvail(); result = 3;
      }
    };
    new MockUp<Employee>() {
      @Mock
    Employee listEmployeeDetailsById(final int a) {
        return new Employee();
      }
    };
    try {
      List<String> errorsList = LeaveDetails.validateLeaveDetails(3, "26-03-18",
          "23-03-18", "lop", "marriage", 100);
      assertNotNull(errorsList);
      assertEquals(4, errorsList.size());
      assertTrue(!errorsList.isEmpty());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  /**
   * Test class for Leave Details.
   * @param emp for getting leave details.
   */
  //@Test
  public final void testInvalidDate1(@Mocked final Employee emp) {

    new Expectations() {
      {
        emp.getEmpLeaveAvail(); result = 3;
      }
    };
    new MockUp<Employee>() {
      @Mock
    Employee listEmployeeDetailsById(final int a) {
        return new Employee();
      }
    };
    try {
      List<String> errorsList = LeaveDetails.validateLeaveDetails(3, "31-03-18",
          "31-04-18", "lop", "marriage", 100);
      assertNotNull(errorsList);
      assertEquals(4, errorsList.size());
      assertTrue(!errorsList.isEmpty());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  /**
   * Test class for Leave Details.
   * @param emp for getting leave details.
   */
  @Test
  public final void testInvalidDate2(@Mocked final Employee emp) {

    new MockUp<Employee>() {
      @Mock
    Employee listEmployeeDetailsById(final int a) {
        return new Employee(2000, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(), "Sales", 65, 1000);
      }
    };
    try {
      List<String> errorsList = LeaveDetails.validateLeaveDetails(3, "sghshgs",
          "agsggh", "lop", "marriage", 100);
      assertNotNull(errorsList);
      assertEquals(3, errorsList.size());
      assertTrue(!errorsList.isEmpty());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Test class for Leave Details.
   * @param emp for getting leave details.
   */
  //@Test
  public final void testValidApplyforleave(@Mocked final Employee emp) {
    new Expectations() {
      {
        emp.getEmpLeaveAvail(); result = 8;
      }
    };
    new MockUp<Employee>() {
      @Mock
    Employee listEmployeeDetailsById(final int a) {
        return emp;
      }
    };
    List<String> errorsList = LeaveDetails.validateLeaveDetails(8, "20-04-18",
          "27-04-18", "lop", "marriage", 100);
    assertNotNull(errorsList);
    assertEquals(0, errorsList.size());
    assertTrue(errorsList.isEmpty());
  }
  /**
   * Test class for Leave Details.
   * @param emp for employee
   */
  @Test
  public final void testNoEmpLeaveAvail(@Mocked final Employee emp) {
    new MockUp<Employee>() {
      @Mock
    Employee listEmployeeDetailsById(final int a) {
        return null;
      }
    };
    List<String> errorsList = LeaveDetails.validateLeaveDetails(8, "20-04-18",
          "27-04-18", "lop", "marriage", 1000);
    assertNull(errorsList);
  }
  /**
   * Test class for Leave Details.
   */
  @Test
  public final void testInvalidMgrIdForApproveDeny() {
    new MockUp<Employee>() {
      @Mock
        boolean isManager(final int a) {
        return false;
        }
    };

    List<String> list = LeaveDetails.approveDenyLeave(5, 5, "GWS", "APPROVED");
    assertEquals(1, list.size());
    assertTrue(!list.isEmpty());
  }
   /**
   * Test class for Leave Details.
   */
  @Test
  public final void testValidMgrIdInvalidLeaveIdForApproveDeny() {

    new MockUp<Employee>() {
      @Mock
        boolean isManager(final int a) {
        return true;
        }
    };
    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetails findLeaveDetails1(final int a, final int b) {
        return null;
        }
    };
    List<String> list = LeaveDetails.approveDenyLeave(5, 5, "GWS", "APPROVED");
    assertEquals(1, list.size());
    assertTrue(!list.isEmpty());
  }

   /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   * @param dao1 for getting leave details
   */
  @Test
  public final void testApproveValidLeaveIdForListApproveDeny1(@Mocked final LeaveDetailsDAO dao,
        @Mocked final EmployeeDAO dao1) {

    new MockUp<Employee>() {
      @Mock
        boolean isManager(final int a) {
          return true;
        }
    };

    new MockUp<Employee>() {
      @Mock
        Employee listEmployeeDetailsById(final int a) {
          Employee employee1 = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(),
              "Sales", 65, 3001);
          return employee1;
        }
    };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
          return dao;
      }
    };

    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao1;
      }
    };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetails findLeaveDetails1(final int a, final int b) {
          Date d1 = new Date(24, 03, 18);
          Date d2 = new Date(26, 03, 18);
          LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
          LeaveStatus leaveStatus = LeaveStatus.DENIED;
          LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
              "sick", "22-03-18 10:25:25", 2000, null);
          return leave;
        }
    };

    List<String> list = LeaveDetails.approveDenyLeave(2000, 12, "GWS", "APPROVED");
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
    new Verifications() {
      {
        dao.approveStatusByLeaveId(12, "GWS", "APPROVED"); times = 1;
      }
    };
  }

   /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   * @param dao1 for employee details.
   */
  @Test
  public final void testApproveValidLeaveIdForApproveDeny(@Mocked final LeaveDetailsDAO dao,
      @Mocked final EmployeeDAO dao1) {

    new MockUp<Employee>() {
      @Mock
        boolean isManager(final int a) {
          return true;
        }
    };

    new MockUp<Employee>() {
      @Mock
        Employee listEmployeeDetailsById(final int a) {
          Employee employee1 = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(),
                "Sales", 65, 3001);
          return employee1;
        }
    };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
          return dao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao1;
      }
    };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetails findLeaveDetails1(final int a, final int b) {
          Date d1 = new Date(24, 03, 18);
          Date d2 = new Date(26, 03, 18);
          LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
          LeaveStatus leaveStatus = LeaveStatus.PENDING;
          LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
              "sick", "22-03-18 10:25:25", 2000, null);
          return leave;
        }
    };

    List<String> list = LeaveDetails.approveDenyLeave(2000, 12, "GWS", "APPROVED");
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
    new Verifications() {
      {
        dao.approveStatusByLeaveId(12, "GWS", "APPROVED"); times = 1;
      }
    };
  }


   /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   * @param dao1 for employee details.
   */
  @Test
  public final void testDenyValidLeaveIdForApproveDeny(@Mocked final LeaveDetailsDAO dao,
      @Mocked final EmployeeDAO dao1) {

    new MockUp<Employee>() {
      @Mock
        boolean isManager(final int a) {
          return true;
        }
    };

    new MockUp<Employee>() {
      @Mock
        Employee listEmployeeDetailsById(final int a) {
          Employee employee1 = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(),
                "Sales", 65, 3001);
          return employee1;
        }
    };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
          return dao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetails findLeaveDetails1(final int a, final int b) {
          Date d1 = new Date(24, 03, 18);
          Date d2 = new Date(26, 03, 18);
          LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
          LeaveStatus leaveStatus = LeaveStatus.APPROVED;
          LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
              "sick", "22-03-18 10:25:25", 2000, null);
          return leave;
        }
    };

    List<String> list = LeaveDetails.approveDenyLeave(2000, 12, "GWS", "DENIED");
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
    new Verifications() {
      {
        dao.approveStatusByLeaveId(12, "GWS", "DENIED"); times = 1;
      }
    };
  }

  /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   * @param dao1 for employee details.
   */
  @Test
  public final void testDenyValidLeaveIdForApproveDeny1(@Mocked final LeaveDetailsDAO dao,
      @Mocked final EmployeeDAO dao1) {

    new MockUp<Employee>() {
      @Mock
        boolean isManager(final int a) {
          return true;
        }
    };

    new MockUp<Employee>() {
      @Mock
        Employee listEmployeeDetailsById(final int a) {
          Employee employee1 = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(),
              "Sales", 65, 3001);
          return employee1;
        }
    };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
          return dao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetails findLeaveDetails1(final int a, final int b) {
          Date d1 = new Date(24, 03, 18);
          Date d2 = new Date(26, 03, 18);
          LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
          LeaveStatus leaveStatus = LeaveStatus.PENDING;
          LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
              "sick", "22-03-18 10:25:25", 2000, null);
          return leave;
        }
    };

    List<String> list = LeaveDetails.approveDenyLeave(2000, 12, "GWS", "DENIED");
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
    new Verifications() {
      {
        dao.approveStatusByLeaveId(12, "GWS", "DENIED"); times = 1;
      }
    };
  }


  /**
   * Test class for Leave Details.
   */
  @Test
  public final void testInvalidLeavestatusForApproveDeny() {

    new MockUp<Employee>() {
      @Mock
        boolean isManager(final int a) {
          return true;
        }
    };

    new MockUp<Employee>() {
      @Mock
        Employee listEmployeeDetailsById(final int a) {
          Employee employee1 = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(),
                "Sales", 65, 3001);
          return employee1;
        }
    };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetails findLeaveDetails1(final int a, final int b) {
          Date d1 = new Date(24, 03, 18);
          Date d2 = new Date(26, 03, 18);
          LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
          LeaveStatus leaveStatus = LeaveStatus.PENDING;
          LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
              "sick", "22-03-18 10:25:25", 2000, null);
          return leave;
        }
    };

    List<String> list = LeaveDetails.approveDenyLeave(2000, 12, "GWS", "INVALID");
    assertEquals(1, list.size());
    assertTrue(!list.isEmpty());
  }

    /**
   * Test class for Leave Details.
   */
  @Test
  public final void testLeaveAvailableForApproveDeny() {

    new MockUp<Employee>() {
      @Mock
        boolean isManager(final int a) {
          return true;
        }
    };

    new MockUp<Employee>() {
      @Mock
        Employee listEmployeeDetailsById(final int a) {
          Employee employee1 = new Employee(300, "nikita", "nikitamgs@gmail.com", "8318831967", new Date(),
                "Sales", 1, 3001);
          return employee1;
        }
    };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetails findLeaveDetails1(final int a, final int b) {
          Date d1 = new Date(24, 03, 18);
          Date d2 = new Date(26, 03, 18);
          LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
          LeaveStatus leaveStatus = LeaveStatus.PENDING;
          LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
              "sick", "22-03-18 10:25:25", 2000, null);
          return leave;
        }
    };

    List<String> list = LeaveDetails.approveDenyLeave(2000, 12, "GWS", "INVALID");
    assertEquals(1, list.size());
    assertTrue(!list.isEmpty());
  }
  /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
  @Test
  public final void testLeaveDetailsByEmpId(@Mocked final LeaveDetailsDAO dao) {

    new Expectations() {
        {
          List<LeaveDetails> list = new ArrayList<LeaveDetails>();
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          list.add(new LeaveDetails());
          dao.fetchPendingLeavesByMgrId(30); result = list;
        }
      };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
        return dao;
        }
      };
    List<LeaveDetails> list = LeaveDetails.fetchLeaveDetailsByEmpId(30);
    assertNotNull(list);
    assertEquals(5, list.size());
    assertTrue(!list.isEmpty());

    new Verifications() {
      {
        dao.fetchPendingLeavesByMgrId(anyInt); times = 1;
      }
    };
  }

    /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
  @Test
  public final void testfindLeaveDetails(@Mocked final LeaveDetailsDAO dao) {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.PENDING;
    final LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
        "sick", "22-03-18 10:25:25", 2000, "GWS");
    new Expectations() {
        {
          dao.fetchPendingLeaveByLeaveIdAndMgrId(30, 10);
          result = leave;
        }
      };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
        return dao;
        }
      };
    LeaveDetails details = LeaveDetails.findLeaveDetails(30, 10);
    assertEquals(leave, details);

    new Verifications() {
      {
        dao.fetchPendingLeaveByLeaveIdAndMgrId(anyInt, anyInt); times = 1;
      }
    };
  }
   /**
   * Test class for Leave Details.
   * @param dao for getting leave details.
   */
  @Test
  public final void testFindLeaveDetails1(@Mocked final LeaveDetailsDAO dao) {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.APPROVED;
    final LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
        "sick", "22-03-18 10:25:25", 2000, "GWS");
    new Expectations() {
        {
          dao.fetchPendingLeaveByLeaveIdAndMgrId1(30, 10);
          result = leave;
        }
      };

    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
        return dao;
        }
      };
    LeaveDetails details = LeaveDetails.findLeaveDetails1(30, 10);
    assertEquals(leave, details);

    new Verifications() {
      {
        dao.fetchPendingLeaveByLeaveIdAndMgrId1(anyInt, anyInt); times = 1;
      }
    };
  }
   /**
   * Test class for Employee Details.
   * @param dao for getting all employee details.
   */
  @Test
  public final void testListAll(@Mocked final LeaveDetailsDAO dao) {

    final List<LeaveDetails> list = new ArrayList<LeaveDetails>();
    list.add(new LeaveDetails());
    list.add(new LeaveDetails());
    list.add(new LeaveDetails());
    list.add(new LeaveDetails());
    list.add(new LeaveDetails());
    new Expectations() {
      {
        dao.list(); result = list;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
        LeaveDetailsDAO dao() {
        return dao;
        }
      };
    LeaveDetails[] arrayOfLeave = LeaveDetails.listAll();
    assertNotNull(arrayOfLeave);
    assertEquals(arrayOfLeave.length, list.size());
    new Verifications() {
      {
        dao.list(); times = 1;
      }
    };
  }
   /**
   * Test class for Leave Details.
   *
   */
  @Test
  public final void testLeaveEqualNull() {
    LeaveDetails leave1 = new LeaveDetails();
    LeaveDetails leave2 = null;
    assertNotEquals(leave1, leave2);
  }
   /**
   * Test class for Leave Details.
   *
   */
  @Test
  public final void testNotEqual() {
    Date d1 = new Date(24, 03, 18);
    Date d2 = new Date(26, 03, 18);
    LeaveType leaveType = LeaveType.MATERNITY_LEAVE;
    LeaveStatus leaveStatus = LeaveStatus.APPROVED;
    LeaveDetails leave = new LeaveDetails(12, 2, d1, d2, leaveType, leaveStatus,
        "sick", "22-03-18 10:25:25", 2000, "GWS");
    LeaveDetails leaveDetails = new LeaveDetails(188, 23, d1, d2, leaveType, leaveStatus,
        "exam", "22-03-18 10:25:25", 2000, "rty");
    assertFalse(leave.equals(leaveDetails));
  }
  /**
   * Test class for Employee Details.
   *
   */
  @Test
  public final void testEqualClass() {
    Employee emp1 = new Employee();
    LeaveDetails leaveDetails = new LeaveDetails();
    assertFalse(leaveDetails.equals(emp1));
  }
}

