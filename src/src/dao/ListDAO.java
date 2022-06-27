package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TogoListBeans;

public class ListDAO {

	Connection conn = null;
	ArrayList<TogoListBeans> lunchDiary = new ArrayList<TogoListBeans>();
	//行きたい場所リストに必要なデータを取得するメソッド

	//行きたい場所リストの登録を行うメソッド
	public boolean insertList(String emailAddress, String listResName, String listCategory, String togoMemo) {

		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を用意
			String sql = "insert into togo_list (email_address,res_name,category,togo_memo) values (? ,? ,? ,? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, emailAddress);
			pStmt.setString(2, listResName);
			pStmt.setString(3, listCategory);
			pStmt.setString(4, togoMemo);

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

	//行きたい場所リストの更新を行うメソッド
	public boolean updateList(String listResName, String listCategory, String togoMemo, int listId) {

		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update togo_list set res_name=?, category=?, togo_memo=? where list_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, listResName);
			pStmt.setString(2, listCategory);
			pStmt.setString(3, togoMemo);
			pStmt.setInt(4, listId);


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (NullPointerException e) {
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

	//行きたい場所リストの論理削除を行うメソッド
	public boolean updateListFlag(int listId) {
		boolean result = false;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する
			String sql = "UPDATE togo_list SET list_flag = 0 WHERE list_Id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文の？部分に変数を入れる
			pStmt.setInt(1,listId);
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
		catch (NullPointerException e) {
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
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
/*
	//行きたい場所リストの公開範囲を変更するメソッド
	public boolean updateRange(int listId) {
		boolean result = false;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する

			//非公開にする場合
			//if () {
				String sql = "UPDATE togo_list SET range = 0 WHERE listId = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文の？部分に変数を入れる
				pStmt.setInt(0,listId);
				if(pStmt.executeUpdate() == 1) {
					result = true;
				}
			//}

			// 公開する場合
			if () {
				String sql = "UPDATE togo_list SET range = 1 WHERE listId = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文の？部分に変数を入れる
				pStmt.setInt(0,listId);
				if(pStmt.executeUpdate() == 1) {
					result = true;
				}
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
	*/

}
