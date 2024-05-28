package javabasic.jdbc.board;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javabasic.jdbc.ConnectionUtil;

public class BoardMain {

	Connection conn;
	CallableStatement cstmt;

	BoardMain() {
		conn = ConnectionUtil.getConnection();
	}

	public static void main(String[] args) throws SQLException {

		BoardMain bm = new BoardMain();
		// String sql = " INSERT INTO BOARD VALUES(SEQ_BOARD.NEXTVAL, ?, ?, SYSDATE) ";
		// 자바에서 프로시저 호출 : call (프로시저명)
		String sql = " { call PROC_INSERT(?, ?) } ";
		bm.cstmt = bm.conn.prepareCall(sql);
		bm.cstmt.setString(1, "제목1");
		bm.cstmt.setString(2, "내용1");
		int result = bm.cstmt.executeUpdate();
		if (result > 0) {
			System.out.println("한 행 입력 완료!");
		}

		// OUT파라미터 프로시저 호출
		sql = " { call PROC_INSERT2(?, ?, ?) } ";
		bm.cstmt = bm.conn.prepareCall(sql);
		bm.cstmt.setString(1, "제목2");
		bm.cstmt.setString(2, "내용2");
		bm.cstmt.registerOutParameter(3, Types.NUMERIC);
		int result2 = bm.cstmt.executeUpdate();
		if (result2 > 0) {
			System.out.println("한 행 입력 완료!");
			System.out.println("전체 행의 수 : " + bm.cstmt.getInt(3));
		}

		// INPUT파라미터 프로시저 호출
		sql = " { call PROC_INOUT(?) } ";
		bm.cstmt = bm.conn.prepareCall(sql);
		bm.cstmt.setInt(1, 3);
		bm.cstmt.registerOutParameter(1, Types.NUMERIC);
		bm.cstmt.executeUpdate();
		System.out.println(bm.cstmt.getInt(1));

		// 자바에서 Function 호출
		sql = " { ? = call FUNC_COUNT } ";
		bm.cstmt = bm.conn.prepareCall(sql);
		bm.cstmt.registerOutParameter(1, Types.NUMERIC);
		bm.cstmt.executeUpdate();
		System.out.println("함수 호출 후 리턴값 : " + bm.cstmt.getInt(1));

		sql = " SELECT FUNC_COUNT() CNT FROM DUAL ";
		bm.cstmt = bm.conn.prepareCall(sql);
		ResultSet rs = bm.cstmt.executeQuery();
		if (rs.next()) {
			System.out.println(rs.getInt("CNT"));
		}
	}

}
