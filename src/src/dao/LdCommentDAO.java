package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.LunchCommentBeans;

public class LdCommentDAO {
	Connection conn = null;
	ArrayList<LunchCommentBeans> lcb = new ArrayList<LunchCommentBeans>();
//	ランチ日記のコメントを検索するメソッド
	public ArrayList<LunchCommentBeans> selectHdComment(int ldCommentId, int lunchId, String emailAddress, String ldComment) {
		return null;
	}

	//手作り日記のコメントを登録するメソッド
	public boolean insertLdComment(int ldCommentId, int lunchId, String emailAddress, String ldComment) {
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into lunch_comment ( email_address, lunch_id, ld_comment) values (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
//			pStmt.setInt(1, ldCommentId);
			pStmt.setString(1, emailAddress);
			pStmt.setInt(2, lunchId);
			pStmt.setString(3, ldComment);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	// 結果を返す
	return result;
	}


}
