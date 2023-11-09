package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostDAO {

	private final String JDBC_URL =
			"jdbc:mysql://localhost/microblog";
	private final String USER = "root";
	private final String PASS = null;
	Connection conn = null;

	/**
	 * DB接続
	 */
//	public void connect() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * 全取得
	 * @return
	 */
	public List<Post> selectAll() {
		List<Post> postList = new ArrayList<>();
		String sql =
				"SELECT ID, NAME, TEXT FROM POST ORDER BY ID DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);

			//SELECT文の実行
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			//SELECTの結果を格納
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Post post = new Post(id, userName, text);
				postList.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return postList;
	}

	/**
	 * 投稿
	 * @param post
	 * @return
	 */
	public boolean create(Post post) {
		String sql =
				"INSERT INTO POST(NAME, TEXT) VALUES(?, ?)";
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			//SQL文の"?"に設定する値を指定
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getUserName());
			pstmt.setString(2, post.getText());

			//INSERT文の実行
			//修正予定 closeさせたい
			int result = pstmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
