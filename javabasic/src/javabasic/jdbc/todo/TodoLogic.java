package javabasic.jdbc.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabasic.jdbc.ConnectionUtil;

public class TodoLogic {

	Connection conn;
	PreparedStatement pstmt;

	TodoLogic() {
		conn = ConnectionUtil.getConnection();
	}

	// 리스트
	public List<Todo> listTodo() throws Exception {
		String sql = " select * from todo ";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Todo> todoList = new ArrayList<Todo>();
		while (rs.next()) {
			Todo todo = new Todo();
			todo.setTdid(rs.getInt("tdid"));
			todo.setTdcontent(rs.getString("tdcontent"));
			todo.setTdcomplete(rs.getString("tdcomplete"));
			todo.setTdregdate(rs.getTimestamp("tdregdate"));
			todoList.add(todo);
		}
		return todoList;
	}

	// 등록
	public int writeTodo(Todo todo) throws Exception {
		String sql = " insert into todo values(todo_seq.nextval, ?, 'N', sysdate) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, todo.getTdcontent());
		return pstmt.executeUpdate();
	}

	// 삭제
	public int deleteTodo(Todo todo) throws Exception {
		String sql = " delete todo where tdid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, todo.getTdid());
		return pstmt.executeUpdate();
	}

}
