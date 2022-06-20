package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllColumnBeans;


public class LdJoin2DAO {
	Connection conn = null;
	ArrayList<AllColumnBeans> ldReactionList = new ArrayList<AllColumnBeans>();
	ArrayList<AllColumnBeans> ldCommentList = new ArrayList<AllColumnBeans>();

	//リアクションボタンの人数を数えるメソッド
	public ArrayList<AllColumnBeans> countReactionUser(){
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造を施す>>
			String sql = "SELECT lunch_diary.lunch_id, SUM(ld_to_go), SUM(ld_to_tell), SUM(ld_to_use) FROM lunch_diary LEFT JOIN user_master ON lunch_diary.email_address = usermaster.email_address LEFT JOIN lunch_reaction ON lunch_diary.lunch_id = lunch_reaction.lunch_id WHERE lunch_diary.lunch_flag = 1 ORDER BY lunch_diary.ld_regist_time DESC ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				AllColumnBeans reacLd = new AllColumnBeans();
				reacLd.setLunchId(rs.getInt("lunch_id"));
				reacLd.setCountLdToGo(rs.getInt("ld_to_go"));
				reacLd.setCountLdToTell(rs.getInt("ld_to_tell"));
				reacLd.setCountLdToUse(rs.getInt("ld_to_use"));

				ldReactionList.add(reacLd);
			}


		}
		catch(SQLException e) {
			e.printStackTrace();
			ldReactionList = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			ldReactionList = null;
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					ldReactionList = null;
				}
			}
		}

		return ldReactionList;
	}

	//誰がどのランチ日記にコメントしたかとその内容を検索するメソッド
	public ArrayList<AllColumnBeans> selectComment(){
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造を施す>>
			String sql = "SELECT ld_comment_id, lunch_comment.email_address, lunch_comment.lunch_id, ld_comment user_master.account_name LEFT JOIN lunch_diary ON lunch_diary.lunch_id = lunch_comment.lunch_id LEFT JOIN user_master ON user_master.email_address = lunch_comment.email_address";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				AllColumnBeans comLd = new AllColumnBeans();
				comLd.setLdCommentId(rs.getInt("ld_comment_id"));
				comLd.setEmailAddress("lunch_comment.email_address");
				comLd.setLunchId(rs.getInt("lunch_comment.lunch_id"));
				comLd.setLdComment(rs.getString("ld_comment"));

				ldCommentList.add(comLd);
			}


		}
		catch(SQLException e) {
			e.printStackTrace();
			ldCommentList = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			ldCommentList = null;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					ldCommentList = null;
				}
			}

		}
		return ldCommentList;
	}




}
