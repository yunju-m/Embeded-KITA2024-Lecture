package javabasic.jdbc.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabasic.jdbc.ConnectionUtil;

public class InsertData {

	Connection conn;
	PreparedStatement pstmt;

	InsertData() {
		conn = ConnectionUtil.getConnection();
	}

	List<Subject> subjectList; // 과목 리스트
	List<Student> studentList; // 학생 리스트

	public void startInsertData() {

		// 과목 데이터를 배열로 저장
		String[] subjectArr = { "국어", "영어", "수학", "과학", "역사" };
		int subjectArrLen = subjectArr.length;

		// 학생 데이터 배열로 저장
		String[][] studentArr = { { "홍길동", "20", "M" }, { "김길순", "30", "F" }, { "최길동", "40", "M" },
				{ "박길순", "50", "F" }, { "유길동", "60", "M" } };
		int studentArrLen = studentArr.length;

		// 학생별 수강과목 데이터 배열로 저장
		int[][] studentSubArr = { { 1, 2, 3 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 2, 3, 4 } };

		try {
			// 과목 데이터 저장
			for (int i = 0; i < subjectArrLen; i++) {
				Subject subject = new Subject(0, subjectArr[i]);
				insertSubject(subject);
			}

			// 학생리스트, 과목리스트 생성
			studentList = new ArrayList<Student>();
			subjectList = new ArrayList<Subject>();

			for (int i = 0; i < studentArrLen; i++) {
				int studentSubArrLen = studentSubArr[i].length;
				subjectList = new ArrayList<Subject>();
				for (int j = 0; j < studentSubArrLen; j++) {
					// 과목리스트에 학생별 수강과목들 추가
					subjectList.add(new Subject(studentSubArr[i][j], subjectArr[studentSubArr[i][j] - 1]));
				}
				// 학생 객체 생성
				Student student = new Student(i + 1, studentArr[i][0], Integer.parseInt(studentArr[i][1]),
						studentArr[i][2], subjectList);
				// 학생 데이터 저장
				insertStudent(student);
				// 학생별 과목 데이터 저장
				insertStudentSubject(student);
				// 학생리스트에 학생 객체를 추가
				studentList.add(student);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(conn);
		}
	}

	// 과목 등록 메소드
	private int insertSubject(Subject subject) throws SQLException {
		String sql = " insert into subject values(subject_seq.nextval, ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, subject.getSubName());
		return pstmt.executeUpdate();
	}

	// 학생 등록 메소드
	private void insertStudent(Student student) throws SQLException {
		String sql = " insert into student values(student_seq.nextval, ?, ?, ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, student.getSname());
		pstmt.setInt(2, student.getSage());
		pstmt.setString(3, student.getSgender());
		pstmt.executeUpdate();
	}

	// 학생별 과목 등록 메소드
	private void insertStudentSubject(Student student) throws SQLException {
		for (Subject subject : student.getSubjectList()) {
			String sql = " insert into studentsubject values(?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getSno());
			pstmt.setInt(2, subject.getSubNo());
			pstmt.executeUpdate();
		}
	}

	// 학생리스트 반환 메소드
	public List<Student> getStudentList() {
		return studentList;
	}

}
