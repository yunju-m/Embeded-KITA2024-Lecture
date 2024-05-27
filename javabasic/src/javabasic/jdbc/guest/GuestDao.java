package javabasic.jdbc.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GuestDao {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	public GuestDao() {
		conn = ConnectionUtil.getConnection();
	}

	// 전체 게스트 리스트 메소드
	public List<Guest> getGuestList() throws SQLException {
		String sql = " SELECT * FROM GUEST ORDER BY GNO";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);

		List<Guest> guestList = new ArrayList<Guest>();
		while (rs.next()) {
			Guest guest = new Guest(rs.getInt("GNO"),
					rs.getString("GNAME"),
					rs.getInt("GAGE"),
					rs.getString("GGENDER"),
					rs.getString("GSID"),
					rs.getDate("GCONNDT")
					);
			guestList.add(guest);
		}
		return guestList;
	}

	// 하나의 게스트 반환 메소드
	public Guest getGuest(int gno) throws SQLException {
		String sql = " SELECT * FROM GUEST WHERE GNO = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gno);
		rs = pstmt.executeQuery();
		
		Guest guest = null;
		if (rs.next()) {
			guest = new Guest(rs.getInt("GNO"),
					rs.getString("GNAME"),
					rs.getInt("GAGE"),
					rs.getString("GGENDER"),
					rs.getString("GSID"),
					rs.getDate("GCONNDT")
					);
		}
		return guest;
	}

	// 게스트 등록 메소드
	public void insertGuestSql(Guest guest) throws SQLException {
		String sql = " INSERT INTO GUEST VALUES(SEQ_GUEST.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, guest.getgName());
		pstmt.setInt(2, guest.getgAge());
		pstmt.setString(3, guest.getgGender());
		pstmt.setString(4, guest.getgSid());
		pstmt.executeQuery();
	}

	// 게스트 업데이트 메소드
	public void updateGuestAgeSql(Guest guest) throws SQLException {
		String sql = " UPDATE GUEST SET GNAME = ?, GAGE = ?, GGENDER = ? WHERE GNO = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, guest.getgName());
		pstmt.setInt(2, guest.getgAge());
		pstmt.setString(3, guest.getgGender());
		pstmt.setInt(4, guest.getgNo());
		pstmt.executeUpdate();
	}

	// 게스트 삭제 메소드
	public void deleteGuestSql(int guestGno) throws SQLException {
		String sql = " DELETE FROM GUEST WHERE GNO = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, guestGno);
		pstmt.executeUpdate();
	}

}
