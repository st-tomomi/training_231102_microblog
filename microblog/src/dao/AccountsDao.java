package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;


public class AccountsDao {
	private final String JDBC_URL =
			"jdbc:mysql://localhost/microblog";
	private final String USER = "root";
	private final String PASS = null;
	Connection conn = null;

//	public Account searchAccount(Login login) {
	public Account searchAccount(User user) {
//		String sql =
//				"SELECT ID, NAME, TEXT FROM POST ORDER BY ID DESC";
		String sql =
				"SELECT NAME, PASS FROM USERS WHERE NAME = ? AND PASS = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
				("JDBCドライバを読み込めませんでした");
		}

		//DBに接続
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPass());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String userName = rs.getString("NAME");
				String pass = rs.getString("PASS");
				account = new Account(userName, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return account;
	}

}
