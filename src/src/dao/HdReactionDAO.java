package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllColumnBeans;

public class HdReactionDAO {

		Connection conn = null;
//		ArrayList<HandmadeReactionBeans> hdReaction = new;
		ArrayList<AllColumnBeans> hdReactionList = new ArrayList<AllColumnBeans>();

	//ランチ日記のスタンプの件数とユーザーの検索を行うメソッド
//	public ArrayList<HandmadeReactionBeans> selectHdReaction(int hdReactionId, int handmadeId, String emailAddress, int hdToEat, int hdToTell, int hdToUse) {
//
//		return null;
//
//	}

	//リアクションボタンの人数を数えるメソッド
	public ArrayList<AllColumnBeans> countReactionUser(){
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造を施す>>
			String sql = "SELECT handmade_diary.handmade_id, SUM(hd_to_eat), SUM(hd_to_tell), SUM(hd_to_use) FROM HANDMADE_DIARY LEFT JOIN user_master ON handmade_diary.email_address = user_master.email_address LEFT JOIN handmade_reaction ON handmade_diary.handmade_id = handmade_reaction.handmade_id WHERE handmade_diary.handmade_flag = 1 group by handmade_diary.handmade_id ORDER BY handmade_diary.ld_regist_time DESC ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				AllColumnBeans reacHd = new AllColumnBeans();
				reacHd.setHandmadeId(rs.getInt("handmade_id"));
				reacHd.setCountHdToEat(rs.getInt("SUM(hd_to_eat)"));
				reacHd.setCountHdToTell(rs.getInt("SUM(hd_to_tell)"));
				reacHd.setCountHdToUse(rs.getInt("SUM(hd_to_use)"));

				hdReactionList.add(reacHd);
			}


		}
		catch(SQLException e) {
			e.printStackTrace();
			hdReactionList = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			hdReactionList = null;
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					hdReactionList = null;
				}
			}
		}

		return hdReactionList;
	}
	//ランチ日記のスタンプを登録するメソッド
	public boolean insertHdReaction(int handmadeId, String emailAddress, int hdToEat, int hdToTell, int hdToUse) {

		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "insert into handmade_reaction (handmade_id, email_address,hd_to_eat,hd_to_tell,hd_to_use) values (? ,? ,? ,? ,? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, handmadeId);
			pStmt.setString(2, emailAddress);
			pStmt.setInt(3, hdToEat);
			pStmt.setInt(4, hdToTell);
			pStmt.setInt(5, hdToUse);

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
	public boolean deleteHdReaction(int hdReactionId) {
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "delete from handmade_reaction where handmade_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, hdReactionId);

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
