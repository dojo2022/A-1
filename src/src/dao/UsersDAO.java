package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.UserMasterBeans;

public class UsersDAO {
	Connection conn = null;
	ArrayList<UserMasterBeans> user = new ArrayList<UserMasterBeans>();

	//引数として送られてきたメアドとパスワードに該当するデータがあるか検索するメソッド---------------------------
	public ArrayList<UserMasterBeans> selectUser(
			String emailAddress,
			String pw) {

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "select * from user_master WHERE  email_address= ? AND pw= ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					pStmt.setString(1, emailAddress);
					pStmt.setString(2, pw);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					UserMasterBeans us = new UserMasterBeans();
					us.setEmailAddress(rs.getString("email_address"));
					us.setPw(rs.getString("pw"));
					us.setAccountName(rs.getString("account_name"));
					us.setDepName(rs.getString("dep_name"));
					us.setUserFlag(rs.getInt("user_flag"));
					us.setIcon(rs.getString("icon"));
					us.setReason(rs.getString("reason"));
					us.setRange(rs.getInt("range"));

					user.add(us);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				user = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				user = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						user = null;
					}
				}
			}
		// 結果を返す
		return user;
	}





	//ユーザー情報の登録をするメソッド----------------------------------------------
	public boolean insertUser(
			String emailAddress,
			String pw,
			String accountName,
			String depName,
			String image) {

			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "insert into user_master (email_address, pw, account_name, dep_name, icon) values ( ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, emailAddress);
				pStmt.setString(2, pw);
				pStmt.setString(3, accountName);
				pStmt.setString(4, depName);
				pStmt.setString(5, image);

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

		// 結果を返す
		return result;
	}



	//ユーザー情報の更新をするメソッド------------------------------------------
	public boolean updateUser(
			String emailAddress,
			String pw,
			String accountName,
			String depName,
			String icon,
			int range) {

			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "update user_master set pw=?, account_name=?, dep_name=?, icon=?, range=? where email_address=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, pw);
				pStmt.setString(2, accountName);
				pStmt.setString(3, depName);
				pStmt.setString(4, icon);
				pStmt.setInt(5, range);
				pStmt.setString(6, emailAddress);


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

		// 結果を返す
		return result;
	}






	//フラグを更新するメソッド------------------------------------------------------
	//引数で主キーのemailaddressを持ってい来るようにした
	public boolean updateUserFlag(String emailAddress, String reason) {
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql ="UPDATE user_master SET user_flag = 0, reason =? WHERE email_address = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// ?に変数を入れてSQL文を完成させる
			pStmt.setString(1, reason);
			pStmt.setString(2, emailAddress);

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

		// 結果を返す
		return result;
	}





	//引数として送られてきたメアドに該当するユーザーを検索するメソッド------------------------------------
	public ArrayList<UserMasterBeans> selectUser(String emailAddress){

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "select * from user_master WHERE  email_address= ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					pStmt.setString(1, emailAddress);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					UserMasterBeans us = new UserMasterBeans();
					us.setEmailAddress(rs.getString("email_address"));
					us.setPw(rs.getString("pw"));
					us.setAccountName(rs.getString("account_name"));
					us.setDepName(rs.getString("dep_name"));
					us.setUserFlag(rs.getInt("user_flag"));
					us.setIcon(rs.getString("icon"));
					us.setRange(rs.getInt("range"));
				//us.setReason(rs.getString("reason"));

					user.add(us);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				user = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				user = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						user = null;
					}
				}
			}
		// 結果を返す
		return user;
	}



	//登録しているユーザーの全件検索を行うメソッド------------------------------------------

	public ArrayList<UserMasterBeans> selectUser(){
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select * from user_master ";
			PreparedStatement pStmt = conn.prepareStatement(sql);



			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				UserMasterBeans us = new UserMasterBeans();
				us.setEmailAddress(rs.getString("email_address"));
				us.setPw(rs.getString("pw"));
				us.setAccountName(rs.getString("account_name"));
				us.setDepName(rs.getString("dep_name"));
				us.setUserFlag(rs.getInt("user_flag"));
				us.setIcon(rs.getString("icon"));
			//us.setReason(rs.getString("reason"));

				user.add(us);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			user = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					user = null;
				}
			}
		}
	// 結果を返す
	return user;
	}



}
