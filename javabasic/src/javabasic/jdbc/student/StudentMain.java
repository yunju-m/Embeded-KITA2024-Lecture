package javabasic.jdbc.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabasic.jdbc.ConnectionUtil;

public class StudentMain {

	Connection conn;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;

	public StudentMain() {
		conn = ConnectionUtil.getConnection();
	}

	public static void main(String[] args) {

		// 객체 생성
		StudentMain sm = new StudentMain();
		CreateDDL createDDL = new CreateDDL();
		InsertData insertData = new InsertData();

		try {
			createDDL.startCreateDDL();
			insertData.startInsertData();
			// 조인 수행 결과 행들의 커서(ResultSet)
			ResultSet rs = sm.getJoinedResultSet();

			// 학생리스트
			List<Student> studentList = insertData.getStudentList();

			// 학생 수만큼 반복
			for (Student st : studentList) {
				// 과목리스트 생성(초기화)
				List<Subject> subList = new ArrayList<Subject>();
				// 학생별 과목의 수
				int subjectListSize = st.getSubjectList().size();

				for (int j = 0; j < subjectListSize; j++) {
					rs.next();
					subList.add(new Subject(rs.getInt("subno"), rs.getString("subname")));
				}
				// Student 객체 생성
				Student student = new Student(rs.getInt("sno"), rs.getString("sname"), rs.getInt("sage"),
						rs.getString("sgender"), subList);
				System.out.println(student); // => student.toString()
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// 조인 쿼리 결과를 ResultSet으로 반환
	private ResultSet getJoinedResultSet() throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.sno sno, s.sname sname, s.sage sage, s.sgender sgender,");
		sb.append(" sub.subno subno, sub.subname subname");
		sb.append(" from student s, subject sub");
		sb.append(" where s.subno = sub.subno");
		String joinSql = sb.toString();
		stmt = conn.createStatement();
		return stmt.executeQuery(joinSql);
	}

}
