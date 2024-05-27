package javabasic.jdbc.guest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GuestMain {

	Connection conn;

	public GuestMain() {
		conn = ConnectionUtil.getConnection();
	}

	public static void main(String[] args) {

		GuestDao gdao = new GuestDao();

		String[][] newGuestArr = { { "신길동", "장길순" }, { "35", "25" }, { "M", "F" },
				{ "123456-1234567", "987654-9876543" } };

		String[][] updateGuestArr = { { "1", "3" }, { "홍길동", "박길순" }, { "20", "55" }, { "M", "F" } };
		Integer[] deleteGuestArr = { 2, 4 };
		Integer[] specialGuestArr = { 1, 5 };

		int newGuestArrLen = newGuestArr[0].length;
		int updateGuestArrLen = updateGuestArr[0].length;

		try {
			// 새로운 게스트 추가
			for (int i = 0; i < newGuestArrLen; i++) {
				Guest guest = new Guest(0, newGuestArr[0][i], Integer.parseInt(newGuestArr[1][i]), newGuestArr[2][i],
						newGuestArr[3][i], null);
				gdao.insertGuestSql(guest);
			}

			// 게스트 정보 변경
			for (int i = 0; i < updateGuestArrLen; i++) {
				Guest guest = new Guest(Integer.parseInt(updateGuestArr[0][i]), updateGuestArr[1][i],
						Integer.parseInt(updateGuestArr[2][i]), updateGuestArr[3][i], null, null);
				gdao.updateGuestAgeSql(guest);
			}

			// 게스트 삭제
			for (int deleteNum : deleteGuestArr) {
				gdao.deleteGuestSql(deleteNum);
			}

			// 전체 게스트 출력
			List<Guest> guestList = gdao.getGuestList();
			System.out.println("바뀐 후 게스트 정보");
			for (Guest guest : guestList) {
				System.out.println(guest);
			}

			// 특정 게스트 출력
			System.out.println("======== 스폐셜 게스트 =========");
			for (int specialNum : specialGuestArr) {
				Guest specialGuest = gdao.getGuest(specialNum);
				System.out.println(specialGuest);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
