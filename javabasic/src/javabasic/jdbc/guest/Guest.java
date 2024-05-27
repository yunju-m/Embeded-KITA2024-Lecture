package javabasic.jdbc.guest;

import java.sql.Date;

public class Guest {

	private int gNo;
	private String gName;
	private int gAge;
	private String gGender;
	private String gSid;
	private Date gConndt;

	public Guest() {
	}

	public Guest(int gNo, String gName, int gAge, String gGender, String gSid, Date gConndt) {
		super();
		this.gNo = gNo;
		this.gName = gName;
		this.gAge = gAge;
		this.gGender = gGender;
		this.gSid = gSid;
		this.gConndt = gConndt;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgAge() {
		return gAge;
	}

	public void setgAge(int gAge) {
		this.gAge = gAge;
	}

	public String getgGender() {
		return gGender;
	}

	public void setgGender(String gGender) {
		this.gGender = gGender;
	}

	public String getgSid() {
		return gSid;
	}

	public void setgSid(String gSid) {
		this.gSid = gSid;
	}

	public Date getgConndt() {
		return gConndt;
	}

	public void setgConndt(Date gConndt) {
		this.gConndt = gConndt;
	}

	@Override
	public String toString() {
		String gGenderPrn = gGender.equals("M") ? "남자" : "여자";
		return gNo + "번, " + gName + "님 반갑습니다.\n나이: " + gAge + "\n성별: " + gGenderPrn + "\n주민등록번호: " + gSid + "\n접속일시: "
				+ gConndt + "\n";
	}

}