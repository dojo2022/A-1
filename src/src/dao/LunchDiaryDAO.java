package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllColumnBeans;
import model.LunchDiaryBeans;

public class LunchDiaryDAO {
	Connection conn = null;
	ArrayList<LunchDiaryBeans> lunchDiary = new ArrayList<LunchDiaryBeans>();
	ArrayList<AllColumnBeans> allLunch = new ArrayList<AllColumnBeans>();
	//ランチ日記表示に必要なデータを取得するメソッド

	// タイムラインから検索ボックスで指定された引数を元に該当するランチ日記を検索するメソッド
	public ArrayList<LunchDiaryBeans> selectLunch(
		String ldResName,
		String ldCategory,
		String ldCost,
		String time,
		String distance
		){

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造を施す>>
			String sql = "SELECT lunch_id, email_address, food_type, res_name, food_photo, category, style, date, food_name, cost, time, distance, star, feeling FROM lunch_diary WHERE distance LIKE ? AND time LIKE ? AND category LIKE ? AND cost LIKE ? AND res_name LIKE ? AND lunch_flag = 1 ORDER BY ld_regist_time DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setString(1, "%" + distance + "%"); //%はワイルドカード
				pStmt.setString(2, "%" + time + "%");
				pStmt.setString(3, "%" + ldCategory + "%");
				pStmt.setString(4, "%" + ldCost + "%");
				pStmt.setString(5, "%" + ldResName + "%");

			// SQL文を実行し、結果表を取得する
			//右にexecuteQuery()がある場合はなんでも入るボックスResultSet rs を入れる
			//DAOの中じゃないとつかっちゃダメ
			//beanに格納したうえでアレイリストに格納しなきゃダメ
			//
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				LunchDiaryBeans ld = new LunchDiaryBeans();
				ld.setLunchId(rs.getInt("lunchId"));
				ld.setLunchId(rs.getInt("lunch_id"));
				ld.setEmailAddress(rs.getString("email_address"));
				ld.setLdFoodType(rs.getString("food_type"));
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

				lunchDiary.add(ld);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			lunchDiary = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			lunchDiary = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					lunchDiary = null;
				}
			}
		}

		// 結果を返す
			return lunchDiary;
}

	// すべてのランチ日記の検索を行うメソッド-----------------------------------------------
	//名前取得のためにjoinが必要説
	public ArrayList<AllColumnBeans> select(){
		try {
			//ドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文
//			String sql = "SELECT lunch_id, email_address, food_type, res_name, food_photo, category, style, date, food_name, cost, time, distance, star, feeling FROM lunch_diary WHERE lunch_flag = 1 ORDER BY ld_regist_time DESC";
			String sql = "SELECT lunch_id, email_address, food_type, res_name, food_photo, category, style, date, food_name, cost, time, distance, star, feeling, account_name FROM lunch_diary left join user_master on lunch_diary.email_address = user_master.email_address WHERE lunch_flag = 1 ORDER BY ld_regist_time DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			//検索結果をコピーする
				while(rs.next()) {

					AllColumnBeans ld = new AllColumnBeans();
					ld.setLunchId(rs.getInt("lunch_id"));
					ld.setEmailAddress(rs.getString("email_address"));
					ld.setLdFoodType(rs.getString("food_type"));
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


	//ランチ日記の更新を行うメソッド-----------------------------------------------
	public boolean updateLd(
		int lunchId,
		String ldFoodType,
		String ldResName,
		String ldFoodPhoto,
		String ldCategory,
		String style,
		String ldDate,
		String ldFoodName,
		String ldCost,
		String time,
		String distance,
		int ldStar,
		String ldFeeling) {
		boolean result = false;
			try {
				//JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				//SQL文を準備する
				String sql = "UPDATE lunch_diary SET foodtype = ?, res_name = ?, food_photo = ?, category = ?, style = ?, date = ?, food_name = ?, cost = ?, time = ?,distance = ?, star = ?, feeling = ? WHERE lunch_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文の？部分に変数を入れる
				pStmt.setString(1, ldFoodType);
				pStmt.setString(2, ldResName);
				pStmt.setString(3, ldFoodPhoto);
				pStmt.setString(4, ldCategory);
				pStmt.setString(5, style);
				pStmt.setString(6, ldDate);
				pStmt.setString(7, ldFoodName);
				pStmt.setString(8, ldCost);
				pStmt.setString(9, time);
				pStmt.setString(10, distance);
				pStmt.setInt(11, ldStar);
				pStmt.setString(12, ldFeeling);
				pStmt.setInt(13, lunchId);

					if(pStmt.executeUpdate() == 1) {
						result = true;
					}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		//結果を返す
		return result;
	}

	public boolean updateLdFlag(int lunchId) {
		//そのランチIDに結び付くテーブルのフラグを０にするだけ
		//where lunch_id = ?を忘れずに！！！！！！
		boolean result = false;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する
			String sql = "UPDATE lunch_diary SET lunch_flag = 0 WHERE lunchId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文の？部分に変数を入れる
			pStmt.setInt(0,lunchId);
			if(pStmt.executeUpdate() == 1) {
				result = true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
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


