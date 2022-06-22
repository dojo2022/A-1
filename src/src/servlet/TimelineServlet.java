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

import dao.LdCommentDAO;
import dao.LdJoin2DAO;
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
				/*
		//		手作り日記の情報
		//		手作り日記の情報を貰ってくる
				HandmadeDiaryDAO HdDao = new HandmadeDiaryDAO();
				ArrayList<HandmadeDiaryBeans> handmadeDiary = HdDao.select(new HandmadeDiaryBeans());
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("handmadeDiary", handmadeDiary);

				//手作り日記リアクション情報をゲットしてくる
				HdReactionDAO HdRDao = new HdReactionDAO();
				ArrayList<HandmadeReactionBeans> HdReaction = HdRDao.select(new HandmadeReactionBeans());
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("HdReaction", HdReaction);

				//手作り日記コメント情報をゲットしてくる
				HdCommentDAO HdCDao = new HdCommentDAO();
				ArrayList<HandmadeCommentBeans> HdComment = HdCDao.select(new HandmadeCommentBeans());
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("HdComment", HdComment);*/

		//タイムラインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
	}

//	ランチリアクション、ランチコメント、



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしてなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("emailAddress") == null) {
//			response.sendRedirect("/lunchBox/LoginServlet");
//			return;
//	}

		//リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		Integer to_go = Integer.parseInt(request.getParameter("to_go"));
//		Integer to_tell_me = Integer.parseInt(request.getParameter("to_tell_me"));
//		Integer to_use = Integer.parseInt(request.getParameter("to_use"));
//
////		LdReactionDAO ldRDao = new LdReactionDAO();
////		if(LdRDao.insert(new LunchReactionBeans(to_go, to_tell_me, to_use))) {
////			request.setAttribute("ldRDao", ldRDao);
////		}else {
////			request.setAttribute("ldRDao", "失敗！");
////		}

		request.setCharacterEncoding("UTF-8");
//		Integer ld_comment_id = Integer.parseInt(request.getParameter("ld_comment_id"));
		HttpSession session = request.getSession();
		UserMasterBeans user = (UserMasterBeans)session.getAttribute("user");
		String email_address = user.getEmailAddress();
		Integer lunch_id = Integer.parseInt(request.getParameter("lunch_id"));
		String ld_comment =request.getParameter("ld_comment");


		LdCommentDAO ldcDao = new LdCommentDAO();
//		ArrayList<AllColumnBeans> ldCommentList = ldcDao.selectComment(new AllColumnBeans(ld_comment_id,email_address,lunch_id,ld_comment));
		ldcDao.insertLdComment(0, lunch_id, email_address, ld_comment);

		//日記情報をゲットしてくる
		LunchDiaryDAO LdDao = new LunchDiaryDAO();
		ArrayList<AllColumnBeans> allLunch = LdDao.select();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("allLunch", allLunch);

	//ランチ日記リアクション情報をゲットしてくる
//		LdReactionDAO LdRDao = new LdReactionDAO();
//		ArrayList<LunchReactionBeans> LdReaction = LdRDao.selectLdReaction();
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("LdReaction", LdReaction);

		//ランチ日記コメント情報をゲットしてくる
		LdJoin2DAO LdCDao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> LdComment = LdCDao.selectComment();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("LdComment", LdComment);

		//タイムラインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
//		AllColumnBeans acb = new AllColumnBeans();
////		acb.setLdCommentId(ld_comment_id);
//		acb.setEmailAddress(email_address);
//		acb.setLunchId(lunch_id);
//		acb.setLdComment(ld_comment);
//		LdJoin2DAO ldCommentList = ldcDao;

//		request.setAttribute("ldCommentList", ldCommentList);
	}

}
