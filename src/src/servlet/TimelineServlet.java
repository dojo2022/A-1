package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HandmadeDiaryDAO;
import dao.HdCommentDAO;
import dao.HdReactionDAO;
import dao.LdCommentDAO;
import dao.LdJoin2DAO;
import dao.LdReactionDAO;
import dao.LunchDiaryDAO;
import model.AllColumnBeans;
import model.UserMasterBeans;

/**
 * Servlet implementation class TimelineServlet
 */
@WebServlet("/TimelineServlet")
public class TimelineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしてなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("emailAddress") == null) {
//			response.sendRedirect("/lunchBox/LoginServlet");
//			return;
//	}

//----------------------------ランチ日記の情報-------------------------------------
		//日記情報をゲットしてくる
		LunchDiaryDAO LdDao = new LunchDiaryDAO();
		ArrayList<AllColumnBeans> allLunch = LdDao.select();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("allLunch", allLunch);

	//ランチ日記リアクション情報をゲットしてくる
		LdJoin2DAO LdRDao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> ldReactionList = LdRDao.countReactionUser();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("ldReactionList", ldReactionList);

		//ランチ日記コメント情報をゲットしてくる
		LdJoin2DAO LdCDao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> LdComment = LdCDao.selectComment();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("LdComment", LdComment);

//----------------------------手作り日記の情報-------------------------------------
//		手作り日記の情報を貰ってくる
		HandmadeDiaryDAO hdDao = new HandmadeDiaryDAO();
	    ArrayList<AllColumnBeans> myHandmade = hdDao.select();
	    // 検索結果をリクエストスコープに格納する
	    request.setAttribute("myHandmade", myHandmade);
//		手作り日記リアクション情報をゲットしてくる
	    HdReactionDAO HdRDao = new HdReactionDAO();
		ArrayList<AllColumnBeans> hdReactionList = HdRDao.countReactionUser();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("hdReactionList", hdReactionList);
	    //手作り日記コメント情報をゲットしてくる
	 	HdCommentDAO HCDao = new HdCommentDAO();
	 	ArrayList<AllColumnBeans> HdComment = HCDao.selectHdComment();
//		検索結果をリクエストスコープに格納する
	 	request.setAttribute("HdComment", HdComment);

		//タイムラインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしてなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if (session.getAttribute("emailAddress") == null) {
//			response.sendRedirect("/lunchBox/LoginServlet");
//			return;
//	}

//		if() {
//
//		}
//		セッションにあるuserの情報を取得
		UserMasterBeans user = (UserMasterBeans)session.getAttribute("user");
//-----------------------リアクションの登録（インサート）を行うやつ----------------------------------
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("to") != null) {
			request.setCharacterEncoding("UTF-8");
			Integer ldr_lunch_id = Integer.parseInt(request.getParameter("lunch_id"));
			String ldr_email_address = user.getEmailAddress();
			Integer to_go = 0;
			Integer to_tell = 0;
			Integer to_use = 0;
//			ボタン押したか押していないかを取得
			String button =request.getParameter("to");
			if(button.equals("行きたい")) {
				to_go = 1;
			}else if (button.equals("教えて")) {
				to_tell= 1;
			}else if(button.equals("参考にします")){
				to_use = 1;
			}else {
				System.out.println("失敗");
			}
			LdReactionDAO ldrDao = new LdReactionDAO();
			ldrDao.insertLdReaction(ldr_lunch_id, ldr_email_address, to_go, to_tell, to_use);
		}else if(request.getParameter("hdbtn") != null) {
			request.setCharacterEncoding("UTF-8");
			Integer hdr_handmade_id = Integer.parseInt(request.getParameter("handmade_id"));
			String hdr_email_address = user.getEmailAddress();
			Integer to_eat = 0;
			Integer hdr_to_tell = 0;
			Integer hdr_to_use = 0;
//			ボタン押したか押していないかを取得
			String hd_button =request.getParameter("hdbtn");
			if(hd_button.equals("食べたい")) {
				to_eat = 1;
			}else if (hd_button.equals("教えて")) {
				hdr_to_tell= 1;
			}else if(hd_button.equals("参考にします")){
				hdr_to_use = 1;
			}else {
				System.out.println("失敗");
			}
			HdReactionDAO hdrDao = new HdReactionDAO();
			hdrDao.insertHdReaction(hdr_handmade_id, hdr_email_address, to_eat, hdr_to_tell, hdr_to_use);
		}


//		コメントの入力をゲットしてインサートする処理
		request.setCharacterEncoding("UTF-8");
		String send_comment = request.getParameter("send_comment");
		if(request.getParameter("send_comment") != null && send_comment.equals("ランチ日記コメントを送信する")) {
			request.setCharacterEncoding("UTF-8");
			String ldc_email_address = user.getEmailAddress();
			Integer ldc_lunch_id = Integer.parseInt(request.getParameter("lunch_id"));
			String ld_comment =request.getParameter("ld_comment");

			LdCommentDAO ldcDao = new LdCommentDAO();
			ldcDao.insertLdComment(0, ldc_lunch_id, ldc_email_address, ld_comment);

		}else if(request.getParameter("send_comment") != null && send_comment.equals("手作り記録コメントを送信する")) {
			request.setCharacterEncoding("UTF-8");
			String hdc_email_address = user.getEmailAddress();
			Integer hdc_lunch_id = Integer.parseInt(request.getParameter("handmade_id"));
			String hd_comment =request.getParameter("hd_comment");

			HdCommentDAO hdcDao = new HdCommentDAO();
			hdcDao.insertHdComment(0, hdc_lunch_id, hdc_email_address, hd_comment);
		}
//		コメント、リアクションのインサート（登録）が行われたら、その情報をフォワードした際に表示できるようにする-------------
		//日記情報をゲットしてくる
		LunchDiaryDAO LdDao = new LunchDiaryDAO();
		ArrayList<AllColumnBeans> allLunch = LdDao.select();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("allLunch", allLunch);

		//ランチ日記リアクション情報をゲットしてくる
		LdJoin2DAO LdRDao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> ldReactionList = LdRDao.countReactionUser();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("ldReactionList", ldReactionList);

		//ランチ日記コメント情報をゲットしてくる
		LdJoin2DAO LdCDao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> LdComment = LdCDao.selectComment();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("LdComment", LdComment);
//----------------------------手作り日記の情報-------------------------------------
//		手作り日記の情報を貰ってくる
		HandmadeDiaryDAO hdDao = new HandmadeDiaryDAO();
	    ArrayList<AllColumnBeans> myHandmade = hdDao.select();
	    // 検索結果をリクエストスコープに格納する
	    request.setAttribute("myHandmade", myHandmade);
//		手作り日記リアクション情報をゲットしてくる
	    HdReactionDAO HdRDao = new HdReactionDAO();
		ArrayList<AllColumnBeans> hdReactionList = HdRDao.countReactionUser();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("hdReactionList", hdReactionList);
	    //手作り日記コメント情報をゲットしてくる
	 	HdCommentDAO HCDao = new HdCommentDAO();
	 	ArrayList<AllColumnBeans> HdComment = HCDao.selectHdComment();
//		検索結果をリクエストスコープに格納する
	 	request.setAttribute("HdComment", HdComment);

		//タイムラインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
	}

}
