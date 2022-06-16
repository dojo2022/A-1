package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.LunchDiaryBeans;

public class LunchDiaryDAO {
	// 引数で検索項目を指定し、検索結果のリストを返す
	public ArrayList<LunchDiaryBeans> selectLunch(
			String res_name,
			String category,
			String cost,
			String time,
			String distance
			){
				Connection conn = null;
				ArrayList<LunchDiaryBeans> lunchDiary = new ArrayList<LunchDiaryBeans>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/meishiApp", "sa", "");

					// SQL文を準備する<<ここに改造を施す>>
					String sql = "SELECT * from lunch_diary WHERE distance LIKE ? AND time LIKE ? AND category LIKE ? AND cost LIKE ? AND res_name LIKE ? ORDER BY lunch_id";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる

						pStmt.setString(1, "%" + distance + "%"); //%はワイルドカード
						pStmt.setString(2, "%" + time + "%");
						pStmt.setString(3, "%" + category + "%");
						pStmt.setString(4, "%" + cost + "%");
						pStmt.setString(5, "%" + res_name + "%");

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
						ld.setEmailAddress(rs.getString("emailAddress"));
						ld.setLdFoodType(rs.getString("ldFoodType"));
						ld.setLdResName(rs.getString("ldResName"));
						ld.setLdFoodPhoto(rs.getString("ldFoodPhoto"));
						ld.setLdCategory(rs.getString("ldCategory"));
						ld.setStyle(rs.getString("style"));
						ld.setLdDate(rs.getString("ldDate"));
						ld.setLdFoodName(rs.getString("ldFoodName"));
						ld.setLdCost(rs.getString("ldCost"));
						ld.setTime(rs.getString("time"));
						ld.setDistance(rs.getString("distance"));
						ld.setLdStar(rs.getInt("ldStar"));
						ld.setLdFeeling(rs.getString("ldFeeling"));
						ld.setLunchFlag(rs.getInt("lunchFlag"));
						ld.setLdRegistTime(rs.getString("ldRegistTime"));

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
	// 引数で検索項目を指定し、検索結果のリストを返す
	public ArrayList<LunchDiaryBeans> select(
			String emailAddress,
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
			String ldFeeling,
			int lunchFlag,
			String ldRegistTime){
		return null;
	}
	public boolean updateLd(LunchDiaryBeans ld) {
		return false;
	}

	public boolean updateLdFlag(LunchDiaryBeans ld) {
		return false;
	}
}


