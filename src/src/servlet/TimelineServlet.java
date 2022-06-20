package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LunchDiaryDAO;
import model.AllColumnBeans;

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
		/*		HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/lunchBox/LoginServlet");
					return;
		}
		*/

		//日記情報をゲットしてくる
		LunchDiaryDAO LdDao = new LunchDiaryDAO();
		ArrayList<AllColumnBeans> allLunch = LdDao.select();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("allLunch", allLunch);

		/*		//ランチ日記リアクション情報をゲットしてくる
				LdReactionDAO LdRDao = new LdReactionDAO();
				ArrayList<LunchReactionBeans> LdReaction = LdRDao.selectLdReaction();
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("LdReaction", LdReaction);

				//ランチ日記コメント情報をゲットしてくる
				LdCommentDAO LdCDao = new LdCommentDAO();
				ArrayList<LunchCommentBeans> LdComment = LdCDao.select(new LunchCommentBeans());
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("LdComment", LdComment);

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
		// TODO Auto-generated method stub
		doGet(request, response);

		//検索ボタンが押されたら検索結果ページにフォワードする
	}

}
