package javabasic.jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC 개인 실습) 
 * 1. https://support.staffbase.com/hc/en-us/article_attachments
 * /360009197031/username.csv 파일을 가져온다.
 * 2. userinfo라는 테이블을 생성
 * create table userinfo ( 
 * 	username varchar2(20), 
 * 	identifier Number primary key,
 * 	firstname varchar2(20), 
 * 	lastname varchar2(20) 
 * ); 
 * 3. userinfo 테이블에 csv 파일의 내용을 insert 
 * 4. userinfo 테이블의 데이터를 출력
 */
public class JDBCExer {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	JDBCExer() {
		conn = ConnectionUtil.getConnection();
	}

	public static void main(String[] args) {
		JDBCExer exer = new JDBCExer();

		try {
			// 1. 네트워크 데이터 가져오기
			String dataStr = exer
					.getData("https://support.staffbase.com/hc/en-us/article_attachments/360009197031/username.csv");

			// 2. 테이블에 데이터 입력
			String[] dataArr = dataStr.split("\n");
			int dataArrLen = dataArr.length;
			List<UserInfo> uiList = new ArrayList<UserInfo>();

			for (int i = 1; i < dataArrLen; i++) {
				String[] lineArr = dataArr[i].split(";");
				UserInfo userInfo = new UserInfo(lineArr[0], Integer.parseInt(lineArr[1]), lineArr[2], lineArr[3]);
				uiList.add(userInfo);
			}

			int insertResult = exer.insertData(uiList);
			if (insertResult > 0) {
				System.out.println(insertResult + "개의 행 입력 성공!");
			}

			// 3. 테이블 데이터 출력
			exer.listData();

			// 4. 데이터를 파일에 저장 (asset/userinfo.txt)
			exer.saveAsFile(dataStr);

		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

	// 데이터 가져오기
	private String getData(String uri) throws Exception {
		URLConnection urlc = new URI(uri).toURL().openConnection();
		InputStream is = urlc.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String readLine = "";
		String dataStr = "";

		while ((readLine = br.readLine()) != null) {
			dataStr += readLine + "\n";
		}
		return dataStr;
	}

	// 데이터 입력
	private int insertData(List<UserInfo> uiList) throws SQLException {
		String sql = " insert into userinfo values(?, ?, ?, ?) ";
		psmt = conn.prepareStatement(sql);
		int returnValue = 0;

		for (UserInfo userinfo : uiList) {
			psmt.setString(1, userinfo.getUsername());
			psmt.setInt(2, userinfo.getIdentifier());
			psmt.setString(3, userinfo.getFirstname());
			psmt.setString(4, userinfo.getLastname());
			returnValue += psmt.executeUpdate();
		}
		return returnValue;
	}

	// 데이터 출력
	private void listData() throws SQLException {
		String sql = " select * from userinfo ";
		StringBuilder sb = new StringBuilder();
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery(sql);

		while(rs.next()) {
			sb.append(rs.getString("username") + ":"
					+ rs.getInt("identifier") + ":"
					+ rs.getString("firstname") + ":"
					+ rs.getString("lastname") + "\n");
		}
		System.out.println(sb);
	}

	// 데이터를 파일에 저장
	private void saveAsFile(String dataStr) throws Exception {
		File file = new File("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\userinfo.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(dataStr);
		bw.flush();
		bw.close();
	}

}
