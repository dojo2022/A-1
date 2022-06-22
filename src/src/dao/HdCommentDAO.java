package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllColumnBeans;
import model.HandmadeCommentBeans;

public class HdCommentDAO {
	Connection conn = null;
	ArrayList<HandmadeCommentBeans> lcb = new ArrayList<HandmadeCommentBeans>();
	ArrayList<AllColumnBeans> hdReactionList = new ArrayList<AllColumnBeans>();
	ArrayList<AllColumnBeans> hdCommentList = new ArrayList<AllColumnBeans>();


	//手作り日記のコメントを検索するメソッド---------------------------------------------------------------
	public ArrayList<AllColumnBeans> selectHdComment() {
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造を施す>>
			String sql = "SELECT hd_comment_id, handmade_comment.email_address, handmade_comment.handmade_id, hd_comment, user_master.account_name FROM handmade_comment LEFT JOIN handmade_diary ON handmade_diary.handmade_id = handmade_comment.handmade_id LEFT JOIN user_master ON user_master.email_address = handmade_comment.email_address ORDER BY hd_comment_id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				AllColumnBeans comHd = new AllColumnBeans();
				comHd.setHdCommentId(rs.getInt("hd_comment_id"));
				comHd.setEmailAddress("handmade_comment.email_address");
				comHd.setHandmadeId(rs.getInt("handmade_comment.handmade_id"));
				comHd.setHdComment(rs.getString("hd_comment"));
				comHd.setAccountName(rs.getString("user_master.account_name"));

				hdCommentList.add(comHd);
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

	//手作り日記のコメントを登録するメソッド--------------------------------------------------------
	public boolean insertHdComment(int hdCommentId, int handmadeId, String emailAddress, String hdComment) {
		boolean result = false;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "insert into handmade_comment ( email_address, handmade_id, hd_comment) values (?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
//				pStmt.setInt(1, ldCommentId);
				pStmt.setString(1, emailAddress);
				pStmt.setInt(2, handmadeId);
				pStmt.setString(3, hdComment);

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

}
