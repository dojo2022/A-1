package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.LunchReactionBeans;

public class ListReactionDAO {

		Connection conn = null;
		ArrayList<LunchReactionBeans> listReaction = new 		ArrayList<LunchReactionBeans>();

	//ランチ日記のスタンプの件数とユーザーの検索を行うメソッド
	public ArrayList<LunchReactionBeans> selectListReaction(int listReactionId, int listId, String emailAddress, int listToGo, int listToTell, int listToUse) {

		return null;

	}

	//ランチ日記のスタンプを登録するメソッド
	public boolean insertListReaction(int listId, String emailAddress, int listToGo, int listToTell, int listToUse) {

		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "insert into list_reaction (list_id, email_address,list_to_go,list_to_tell,list_to_use) values (? ,? ,? ,? ,? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, listId);
			pStmt.setString(2, emailAddress);
			pStmt.setInt(3, listToGo);
			pStmt.setInt(4, listToTell);
			pStmt.setInt(5, listToUse);

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
	public boolean deleteListReaction(int listReactionId) {
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "delete from list_reaction where list_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, listReactionId);

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
