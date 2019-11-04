package com.classpath.ftp27.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.classpath.ftp27.model.LeaveDetails;
import com.classpath.ftp27.model.LeaveStatus;
import com.classpath.ftp27.model.LeaveType;

/**
 * Mapper class to map from result set to leavedetails object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped leavedetails object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs,
      final      StatementContext ctx) throws SQLException {
    /**
     * @return LeaveDetails
     */
    return new LeaveDetails(rs.getInt("Leave_Id"), rs.getInt("Leave_No_Days"),
        rs.getDate("Leave_Start_Date"), rs.getDate("Leave_End_Date"),
        LeaveType.valueOf(rs.getString("LEAVE_TYPE")),
        LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")), rs.getString("Leave_Reason"),
        rs.getString("Leave_Applied_On"), rs.getInt("Emp_ID"), rs.getString("Leave_Mgr_Comment"));
  }
}
