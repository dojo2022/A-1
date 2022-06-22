package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.LunchReactionBeans;

public class LdReactionDAO {

		Connection conn = null;
		ArrayList<LunchReactionBeans> ldReaction = new 		ArrayList<LunchReactionBeans>();

	//ランチ日記のスタンプの件数とユーザーの検索を行うメソッド
	public ArrayList<LunchReactionBeans> selectLdReaction(int ldReactionId, int lunchId, String emailAddress, int ldToGo, int ldToTell, int ldToUse) {

		return null;

	}

	//ランチ日記のスタンプを登録するメソッド
	public boolean insertLdReaction(int lunchId, String emailAddress, int ldToGo, int ldToTell, int ldToUse) {

		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "insert into lunch_reaction (lunch_id, email_address,ld_to_go,ld_to_tell,ld_to_use) values (? ,? ,? ,? ,? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, lunchId);
			pStmt.setString(2, emailAddress);
			pStmt.setInt(3, ldToGo);
			pStmt.setInt(4, ldToTell);
			pStmt.setInt(5, ldToUse);

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

		return result;

	}

	//ランチ日記のスタンプを削除するメソッド
	public boolean deleteLdReaction(int ldReactionId) {
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "delete from lunch_reaction where lunch_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, ldReactionId);

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

		return result;
	}

}
