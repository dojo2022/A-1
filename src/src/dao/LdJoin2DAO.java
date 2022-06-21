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
	ArrayList<AllColumnBeans> allLunch = new ArrayList<AllColumnBeans>();
	ArrayList<AllColumnBeans> ldReactionList = new ArrayList<AllColumnBeans>();
	ArrayList<AllColumnBeans> ldCommentList = new ArrayList<AllColumnBeans>();

	// すべてのランチ日記の検索を行うメソッド-----------------------------------------------
	public ArrayList<AllColumnBeans> select(){
		try {
			//ドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文
			String sql = "SELECT lunch_id, user_master.email_address, res_name, food_photo, category, style, date, food_name, cost, time, distance, star, feeling, account_name FROM lunch_diary left join user_master on lunch_diary.email_address = user_master.email_address WHERE lunch_flag = 1 ORDER BY ld_regist_time DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			//検索結果をコピーする
				while(rs.next()) {

					AllColumnBeans ld = new AllColumnBeans();
					ld.setLunchId(rs.getInt("lunch_id"));
					ld.setEmailAddress(rs.getString("user_master.email_address"));
					ld.setLdResName(rs.getString("res_name"));
					ld.setLdFoodPhoto(rs.getString("food_photo"));
					ld.setLdCategory(rs.getString("category"));
					ld.setStyle(rs.getString("style"));
					ld.setLdDate(rs.getString("date"));
					ld.setLdFoodName(rs.getString("food_name"));
					ld.setLdCost(rs.getString("cost"));
					ld.setTime(rs.getString("time"));
					ld.setDistance(rs.getString("distance"));
					ld.setLdStar(rs.getInt("star"));
					ld.setLdFeeling(rs.getString("feeling"));
					ld.setAccountName(rs.getString("account_name"));

					allLunch.add(ld);
				}

		}
		//例外処理
		catch (SQLException e){
			e.printStackTrace();
			allLunch = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			allLunch = null;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					allLunch = null;
				}
			}
		}
		return allLunch;
	}

	//リアクションボタンの人数を数えるメソッド
	public ArrayList<AllColumnBeans> countReactionUser(){
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造を施す>>
			String sql = "SELECT lunch_diary.lunch_id, SUM(ld_to_go), SUM(ld_to_tell), SUM(ld_to_use) FROM lunch_diary LEFT JOIN user_master ON lunch_diary.email_address = user_master.email_address LEFT JOIN lunch_reaction ON lunch_diary.lunch_id = lunch_reaction.lunch_id WHERE lunch_diary.lunch_flag = 1 ORDER BY lunch_diary.ld_regist_time DESC ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				AllColumnBeans reacLd = new AllColumnBeans();
				reacLd.setLunchId(rs.getInt("lunch_id"));
				reacLd.setCountLdToGo(rs.getInt("SUM(ld_to_go)"));
				reacLd.setCountLdToTell(rs.getInt("SUM(ld_to_tell)"));
				reacLd.setCountLdToUse(rs.getInt("SUM(ld_to_use)"));

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
			String sql = "SELECT ld_comment_id, lunch_comment.email_address, lunch_comment.lunch_id, ld_comment user_master.account_name LEFT JOIN lunch_diary ON lunch_diary.lunch_id = lunch_comment.lunch_id LEFT JOIN user_master ON user_master.email_address = lunch_comment.email_address ORDER BY comment_id DESC";
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
