package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllColumnBeans;

public class HdJoinDAO {
	Connection conn = null;
	ArrayList<AllColumnBeans> allLunch = new ArrayList<AllColumnBeans>();
	ArrayList<AllColumnBeans> hdReactionList = new ArrayList<AllColumnBeans>();
	ArrayList<AllColumnBeans> hdCommentList = new ArrayList<AllColumnBeans>();

	//すべての手作り日記の検索を行うメソッド
	public ArrayList<AllColumnBeans>select(){
		try {
			//ドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文
			String sql = "SELECT handmade_id, user_master.email_address, food_name, food_photo, cooktime, date, cost, star, feeling, account_name FROM handmade_diary left join user_master on handmade_diary.email_address = user_master.email_address WHERE lunch_flag = 1 ORDER BY ld_regist_time DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			//検索結果をコピーする
				while(rs.next()) {

					AllColumnBeans hd = new AllColumnBeans();
					hd.setHandmadeId(rs.getInt("handmade_id"));
					hd.setEmailAddress(rs.getString("user_master.email_address"));
					hd.setLdResName(rs.getString("food_name"));
					hd.setLdFoodPhoto(rs.getString("food_photo"));
					hd.setLdCategory(rs.getString("cooktime"));
					hd.setStyle(rs.getString("date"));
					hd.setLdDate(rs.getString("cost"));
					hd.setLdFoodName(rs.getString("food_name"));
					hd.setLdCost(rs.getString("cost"));
					hd.setLdStar(rs.getInt("star"));
					hd.setLdFeeling(rs.getString("feeling"));
					hd.setAccountName(rs.getString("account_name"));

					allLunch.add(hd);
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
			String sql = "SELECT handmade_diary.handmade_id, SUM(hd_to_go), SUM(hd_to_tell), SUM(hd_to_use) FROM handmade_diary LEFT JOIN user_master ON handmade_diary.email_address = user_master.email_address LEFT JOIN handamade_reaction ON handmade_diary.handmade_id = handamade_reaction.handmade_id WHERE lunch_diary.handamade_flag = 1 group by handmade_diary.handmade_id ORDER BY handmade_diary.ld_regist_time DESC ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				AllColumnBeans reacLd = new AllColumnBeans();
				reacLd.setLunchId(rs.getInt("handmade_id"));
				reacLd.setCountLdToGo(rs.getInt("SUM(hd_to_go)"));
				reacLd.setCountLdToTell(rs.getInt("SUM(hd_to_tell)"));
				reacLd.setCountLdToUse(rs.getInt("SUM(hd_to_use)"));

				hdReactionList.add(reacLd);
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

	//誰がどのランチ日記にコメントしたかとその内容を検索するメソッド
	public ArrayList<AllColumnBeans> selectComment(){
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造を施す>>
			String sql = "SELECT hd_comment_id, handmade_comment.email_address, handmade_comment.handmade_id, hd_comment, user_master.account_name FROM handmade_comment LEFT JOIN handmade_diary ON handmade_diary.handmade_id = handmade_comment.handmade_id LEFT JOIN user_master ON user_master.email_address = handmade_comment.email_address ORDER BY handmade_comment_id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				AllColumnBeans comLd = new AllColumnBeans();
				comLd.setLdCommentId(rs.getInt("hd_comment_id"));
				comLd.setEmailAddress("handmade_comment.email_address");
				comLd.setLunchId(rs.getInt("handmade_comment.handmade_id"));
				comLd.setLdComment(rs.getString("hd_comment"));
				comLd.setAccountName(rs.getString("user_master.account_name"));

				hdCommentList.add(comLd);
			}


		}
		catch(SQLException e) {
			e.printStackTrace();
			hdCommentList = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			hdCommentList = null;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					hdCommentList = null;
				}
			}

		}
		return hdCommentList;
		}


}


