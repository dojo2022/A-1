package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllColumnBeans;

public class MyPageDAO {
	Connection conn = null;
	ArrayList<AllColumnBeans> myLunch = new ArrayList<AllColumnBeans>();
	ArrayList<AllColumnBeans> myHandmade = new ArrayList<AllColumnBeans>();
	ArrayList<AllColumnBeans> myToGo = new ArrayList<AllColumnBeans>();

	//自分のランチ日記を全件検索するメソッド
	public ArrayList<AllColumnBeans> selectLd(String emailAddress){
		try {
			//ドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文
			String sql = "SELECT lunch_id, lunch_diary.email_address, res_name, food_photo, category, style, date, food_name, cost, time, distance, star, feeling, account_name FROM lunch_diary left join user_master on lunch_diary.email_address = user_master.email_address WHERE lunch_flag = 1 AND lunch_diary.email_address = ? ORDER BY ld_regist_time DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//sqlの？部分を埋める
			pStmt.setString(1, "%" + emailAddress + "%");
			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			//検索結果をコピーする
				while(rs.next()) {

					AllColumnBeans myld = new AllColumnBeans();
					myld.setLunchId(rs.getInt("lunch_id"));
					myld.setEmailAddress(rs.getString("lunch_diary.email_address"));
					myld.setLdResName(rs.getString("res_name"));
					myld.setLdFoodPhoto(rs.getString("food_photo"));
					myld.setLdCategory(rs.getString("category"));
					myld.setStyle(rs.getString("style"));
					myld.setLdDate(rs.getString("date"));
					myld.setLdFoodName(rs.getString("food_name"));
					myld.setLdCost(rs.getString("cost"));
					myld.setTime(rs.getString("time"));
					myld.setDistance(rs.getString("distance"));
					myld.setLdStar(rs.getInt("star"));
					myld.setLdFeeling(rs.getString("feeling"));
					myld.setAccountName(rs.getString("account_name"));

					myLunch.add(myld);
				}

		}
		//例外処理
		catch (SQLException e){
			e.printStackTrace();
			myLunch = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			myLunch = null;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					myLunch = null;
				}
			}
		}
		return myLunch;
	}

	//自分の手作り日記を全件検索するメソッド
	public ArrayList<AllColumnBeans> selectMyHd(String emailAddress){
		try {
			//ドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文
			String sql = "SELECT handmade_id, handmade_diary.email_address, food_photo, hd_date, food_name, hd_cost, hd_star, hd_feeling, cooktime, account_name FROM handmade_diary left join user_master on handmade_diary.email_address = user_master.email_address WHERE handmade_flag = 1 AND handmade_diary.email_address = ? ORDER BY hd_regist_time DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//sqlの？部分を埋める
			pStmt.setString(1, "%" + emailAddress + "%");
			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			//検索結果をコピーする
				while(rs.next()) {

					AllColumnBeans myhd = new AllColumnBeans();
					myhd.setHandmadeId(rs.getInt("handmade_id"));
					myhd.setEmailAddress(rs.getString("handmade_diary.email_address"));
					myhd.setHdFoodPhoto(rs.getString("food_photo"));
					myhd.setHdDate(rs.getString("date"));
					myhd.setHdFoodName(rs.getString("food_name"));
					myhd.setHdCost(rs.getString("cost"));
					myhd.setHdStar(rs.getInt("star"));
					myhd.setHdFeeling(rs.getString("feeling"));
					myhd.setCooktime(rs.getString("cooktime"));
					myhd.setAccountName(rs.getString("account_name"));

					myHandmade.add(myhd);
				}

		}
		//例外処理
		catch (SQLException e){
			e.printStackTrace();
			myHandmade = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			myHandmade = null;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					myHandmade = null;
				}
			}
		}
		return myHandmade;
	}
	//自分の行きたい場所リストを全件検索するメソッド
	public ArrayList<AllColumnBeans> selectMyList(String emailAddress){
		try {
			//ドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文
			String sql = "SELECT list_id, res_name, category, togo_memo FROM togo_list left join user_master on togo_list.email_address = user_master.email_address WHERE list_flag = 1 AND togo_list.email_address = ? AND user_master.range = 1 ORDER BY list_id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//sqlの？部分を埋める
			pStmt.setString(1, "%" + emailAddress + "%");
			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			//検索結果をコピーする
				while(rs.next()) {

					AllColumnBeans myList = new AllColumnBeans();
					myList.setListId(rs.getInt("list_id"));
					myList.setListResName(rs.getString("res_name"));
					myList.setListCategory(rs.getString("category"));
					myList.setTogoMemo(rs.getString("togo_memo"));

					myToGo.add(myList);
				}

		}
		//例外処理
		catch (SQLException e){
			e.printStackTrace();
			myToGo = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			myToGo = null;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					myToGo = null;
				}
			}
		}
		return myToGo;
	}




}


