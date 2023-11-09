package model;

public class Account {

	//余裕があればIDも設定する
	//private String userId;
	private String userName;
	private String pass;

	public Account(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}
	//IDがあれば
//	public Account(String userId, String userName, String pass) {
//		this.userId = userId;
//		this.userName = userName;
//		this.pass = pass;
//	}

	public String getUserName() {
		return userName;
	}

	public String getPass() {
		return pass;
	}
}
