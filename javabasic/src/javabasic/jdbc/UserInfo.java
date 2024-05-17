package javabasic.jdbc;

public class UserInfo {

	private String username;
	private int identifier;
	private String firstname;
	private String lastname;

	public UserInfo() {
	}

	public UserInfo(String username, int identifier, String firstname, String lastname) {
		super();
		this.username = username;
		this.identifier = identifier;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", identifier=" + identifier + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}

}
