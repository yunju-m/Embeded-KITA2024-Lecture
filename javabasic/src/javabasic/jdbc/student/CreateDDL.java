package javabasic.jdbc.student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javabasic.jdbc.ConnectionUtil;

public class CreateDDL {

	Connection conn;

	CreateDDL() {
		conn = ConnectionUtil.getConnection();
	}

	public void startCreateDDL() {
		// 객체 생성
		String subjectSql = createSubjectSql();
		String studentSql = createStudentSql();
		String subjectSequenceSql = createSubjectSequenceSql();
		String studentSequenceSql = createStudentSequenceSql();

		Statement stmt = null;
		try {
			// Statement 생성 후 쿼리 실행
			stmt = conn.createStatement();
			stmt.execute(subjectSql);
			stmt.execute(studentSql);
			stmt.execute(subjectSequenceSql);
			stmt.execute(studentSequenceSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.close();
				ConnectionUtil.closeConnection(conn);
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	// Subject테이블 생성 쿼리
	private String createSubjectSql() {
		StringBuilder sb = new StringBuilder();
		sb.append(" create table subject(");
		sb.append(" subno number primary key,");
		sb.append(" subname varchar2(20)");
		sb.append(")");
		return sb.toString();
	}

	// Student테이블 생성 쿼리
	private String createStudentSql() {
		StringBuilder sb = new StringBuilder();
		sb.append(" create table student( ");
		sb.append(" sno number primary key, ");
		sb.append(" sname varchar2(20), ");
		sb.append(" sage number, ");
		sb.append(" sgender char(1), ");
		sb.append(" subno number, ");
		sb.append(" foreign key (subno) references subject(subno) ");
		sb.append(")");
		return sb.toString();
	}

	// Subject 시퀀스 쿼리
	private String createSubjectSequenceSql() {
		return " create sequence subject_seq";
	}

	// Student 시퀀스 쿼리
	private String createStudentSequenceSql() {
		return " create sequence student_seq";
	}

}