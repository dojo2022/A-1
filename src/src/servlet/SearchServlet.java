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
import dao.LdCommentDAO;
import dao.LunchDiaryDAO;
import model.AllColumnBeans;
import model.HandmadeDiaryBeans;
import model.UserMasterBeans;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*		HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/meishiApp/LoginServlet");
					return;
				}*/
		//リクエストパラメータ（ラジオボックスがどっちに押されているかで分岐する）
		request.setCharacterEncoding("UTF-8");
		String lunch = request.getParameter("lunch");


		if (lunch.equals("lunch_diary")) {
			//リクエストパラメータ（検索ボックスに入力された文字列の情報）を取得する
			request.setCharacterEncoding("UTF-8");
			String distance = request.getParameter("distance");
			String time = request.getParameter("time");
			String category = request.getParameter("category");
			String cost = request.getParameter("cost");
			String res_name = request.getParameter("res_name");
			//検索処理を行う
			LunchDiaryDAO LdDao = new LunchDiaryDAO();
			ArrayList<AllColumnBeans> searchLunch =LdDao.selectLunch(distance,time,category,cost,res_name);

			request.setAttribute("searchLunch", searchLunch);
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
			dispatcher.forward(request, response);

		}else {
			//リクエストパラメータ（検索ボックスに入力された文字列の情報）を取得する
			request.setCharacterEncoding("UTF-8");
			String time = request.getParameter("time");
			String food_name = request.getParameter("food_name");
			//検索処理を行う
			HandmadeDiaryDAO HdDao = new HandmadeDiaryDAO();
			ArrayList<HandmadeDiaryBeans> handmadeDiary =HdDao.selectHandmade(time,food_name);

			request.setAttribute("handmadeDiary", handmadeDiary);
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
			dispatcher.forward(request, response);
		}


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


	}

}
