package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllColumnBeans;

public class LdReactionDAO {

		Connection conn = null;
//		ArrayList<LunchReactionBeans> ldReaction = new ArrayList<LunchReactionBeans>();
		ArrayList<AllColumnBeans> ldReaction = new ArrayList<AllColumnBeans>();
//		int ldReactionId, int lunchId, String emailAddress, int ldToGo, int ldToTell, int ldToUse
	//ランチ日記のスタンプの件数とユーザーの検索を行うメソッド
	public ArrayList<AllColumnBeans> selectLdReaction(String email_address) {
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する、リアクションの全件検索
//			String sql = "select ld_reaction_id ,lunch_reaction.email_address, lunch_reaction.lunch_id, ld_to_go,ld_to_tell,ld_to_use from lunch_reaction left join lunch_diary on lunch_diary.lunch_id = lunch_reaction.lunch_id left join user_master on user_master.email_address = lunch_reaction.email_address where lunch_diary.lunch_flag = 1 ORDER BY lunch_reaction.ld_reaction_id DESC";
			String sql = "select ld_reaction_id ,lunch_reaction.email_address, lunch_reaction.lunch_id, ld_to_go,ld_to_tell,ld_to_use from lunch_reaction left join lunch_diary on lunch_diary.lunch_id = lunch_reaction.lunch_id left join user_master on user_master.email_address = lunch_reaction.email_address where lunch_diary.lunch_flag = 1 and lunch_reaction.email_address = ? ORDER BY lunch_reaction.ld_reaction_id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, email_address);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				AllColumnBeans acbeans = new AllColumnBeans();
				acbeans.setLdReactionId(rs.getInt("ld_reaction_id"));
				acbeans.setLunchId(rs.getInt("lunch_id"));
				acbeans.setEmailAddress(rs.getString("email_address"));
				acbeans.setLdToGo(rs.getInt("ld_to_go"));
				acbeans.setLdToTell(rs.getInt("ld_to_tell"));
				acbeans.setLdToUse(rs.getInt("ld_to_use"));


				ldReaction.add(acbeans);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			ldReaction = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			ldReaction = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					ldReaction = null;
				}
			}
		}
	// 結果を返す
	return ldReaction;

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
	public boolean deleteLdToGoReaction(int lunchId,String emailAdress) {
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "delete from lunch_reaction  where lunch_id = ? and email_address = ? and ld_to_go = 1;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, lunchId);
			pStmt.setString(2, emailAdress);

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
	public boolean deleteLdToTellReaction(int lunchId,String emailAdress) {
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "delete from lunch_reaction  where lunch_id = ? and email_address = ? and ld_to_tell = 1;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, lunchId);
			pStmt.setString(2, emailAdress);

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
	public boolean deleteLdToUseReaction(int lunchId,String emailAdress) {
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "delete from lunch_reaction  where lunch_id = ? and email_address = ? and ld_to_use = 1;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, lunchId);
			pStmt.setString(2, emailAdress);

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
