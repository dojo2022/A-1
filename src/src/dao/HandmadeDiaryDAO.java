package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllColumnBeans;
import model.HandmadeDiaryBeans;

public class HandmadeDiaryDAO {

	Connection conn = null;
	ArrayList<HandmadeDiaryBeans> Handmade = new ArrayList<HandmadeDiaryBeans>();
	ArrayList<AllColumnBeans> Allhandmade = new ArrayList<AllColumnBeans>();

	//手作り日記の検索を行うメソッド（タイムラインの検索ボックス用）
	public ArrayList<HandmadeDiaryBeans> selectHandmade(
			String hdFoodName,
			String cooktime
			) {

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data","sa","");

			//SQL文を準備する
			String sql = "SELECT handmade_id, email_address, food_type, food_name, food_photo, cook_time, date,  cost, star, feeling FROM handmade_diary WHERE food_name LIKE ? AND cook_time LIKE ? AND  cost LIKE ? AND lunch_flag = 1 ORDER BY hd_regist_time DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる。
			pStmt.setString(1, "%" + hdFoodName +"%");
			pStmt.setString(2, "%" + cooktime + "%");


			//SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
				HandmadeDiaryBeans hdd = new HandmadeDiaryBeans();
					hdd.setHandmadeId(rs.getInt("handmade_id"));
					hdd.setEmailAddress(rs.getString("email_address"));
					hdd.setHdFoodType(rs.getString("food_type"));
					hdd.setHdFoodName(rs.getString("food_name"));
					hdd.setHdFoodPhoto(rs.getString("food_photo"));
					hdd.setCooktime(rs.getString("cook_time"));
					hdd.setHdDate(rs.getString("date"));
					hdd.setHdCost(rs.getString("cost"));
					hdd.setHdStar(rs.getInt("star"));
					hdd.setHdFeeling(rs.getString("feeling"));

						Handmade.add(hdd);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
				Handmade = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Handmade = null;
			}

		finally {
			// データベースを切断する
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Handmade = null;
				}
			}
	    }
		// 結果を返す
				return Handmade;
			}


	//手作り日記の全件検索を行うメソッド(タイムライン表示用)
	public ArrayList<AllColumnBeans> select() {


		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data","sa","");

			//SQL文を準備する ここ変える
			String sql = "SELECT handmade_id, user_master.email_address, food_name, food_photo, cooktime, hd_date, hd_cost, hd_star, hd_feeling, account_name FROM handmade_diary left join user_master on handmade_diary.email_address = user_master.email_address WHERE handmade_flag = 1 ORDER BY ld_regist_time DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

/*
			//SQL文を完成させる
			pStmt.setInt(1, "handmadeId");
			pStmt.setString(2, "emailAddress");
			pStmt.setString(3, "hdFoodType");
			pStmt.setString(4, "%" + "foodName" + "%");
			pStmt.setString(5, "foodPhoto");
			pStmt.setString(6, "cooktime");
			pStmt.setString(7, "Cost");
			pStmt.setString(8, "Date");
			pStmt.setInt(9, "Star");
			pStmt.setString(10, "%" + "hdFeeling" + "%");
			pStmt.setString(11, "handmadeFlog");
			pStmt.setString(12, "%" + "hdRegistTime" + "%");
*/

			//SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
				AllColumnBeans hdd = new AllColumnBeans();

				hdd.setHandmadeId(rs.getInt("handmade_id"));
				hdd.setEmailAddress(rs.getString("user_master.emailAddress"));
				hdd.setHdFoodName(rs.getString("food_name"));
				hdd.setHdFoodPhoto(rs.getString("food_photo"));
				hdd.setCooktime(rs.getString("cooktime"));
				hdd.setHdDate(rs.getString("date"));
				hdd.setHdCost(rs.getString("cost"));
				hdd.setHdStar(rs.getInt("star"));
				hdd.setHdFeeling(rs.getString("feeling"));
				hdd.setAccountName(rs.getString("account_name"));;


				Allhandmade.add(hdd);
			}
	}

			catch (SQLException e) {
				e.printStackTrace();
				Allhandmade = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Allhandmade = null;
			}

			finally {
				// データベースを切断する
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Allhandmade = null;
					}
				}
			}
				// 結果を返す
						return Allhandmade;
					}

	//手作り日記の登録を行うメソッド
	public boolean insertHd(
				String emailAddress,
				String hdFoodName,
				String image,
				String cookTime,
				String hdDate,
				String hdCost,
				int hdStar,
				String hdFeeling) {

			boolean result = false;

			try {
				//JDBCドライバを読み込む
				Class.forName("org.h2.Driver");


				//データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data","sa","");

				//SQL文を準備する
				String sql = "INSERT INTO handmade_diary (email_address, food_name, food_photo, cookTime, hd_date, hd_cost, hd_star, hd_feeling) VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる
				pStmt.setString(1, emailAddress);
				pStmt.setString(2, hdFoodName);
				pStmt.setString(3, image);
				pStmt.setString(4, cookTime);
				pStmt.setString(5, hdDate);
				pStmt.setString(6, hdCost);
				pStmt.setInt(7, hdStar);
				pStmt.setString(8, hdFeeling);


				if(pStmt.executeUpdate() == 1) {
					result = true;
				}
			}

				catch (SQLException e) {
					e.printStackTrace();
					Allhandmade = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					Allhandmade = null;
				}

				finally {
					// データベースを切断する
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							Allhandmade = null;
						}
					}
				}
					// 結果を返す
					return result;
				}


	//手作り日記の更新を行うメソッド
	public boolean updateHd(
			int handmadeId,
			String hdFoodName,
			String image,
			String cooktime,
			String hdDate,
			String hdCost,
			int hdStar,
			String hdFeeling){

		boolean result = false;

		try {
		//JDBCドライバを読み込む
		Class.forName("org.h2.Driver");


		//データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data","sa","");


		//SQL文を準備する
		String sql = "UPDATE handmade_diary SET food_name=?, food_photo=?, cookTime=?, hd_date=?, hd_cost=?, hd_star=?, hd_feeling=? WHERE handmade_id=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);


		//SQL文を完成させる。
		pStmt.setString(1, hdFoodName);
		pStmt.setString(2, image);
		pStmt.setString(3, cooktime);
		pStmt.setString(4, hdDate);
		pStmt.setString(5, hdDate);
		pStmt.setString(6, hdCost);
		pStmt.setInt(7, hdStar);
		pStmt.setString(8, hdFeeling);


		//SQL文を実行させる。
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

		//データベースを切断。
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

		//結果を返す。
		return result;
		}


	//手作り日記の論理削除を行うメソッド
	public boolean updateHdFlag(int handmadeId) {
		boolean result = false;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");


			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data","sa","");

			//SQL文を準備する
			String sql = "UPDATE handmade_diary SET handmade_flag = 0 WHERE handmade_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);



			//SQL文を実行する。
			pStmt.setInt(0,handmadeId);
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

			//データベースを切断。
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

			//結果を返す。
			return result;
		}
	}



