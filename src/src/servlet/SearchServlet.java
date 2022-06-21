package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HandmadeDiaryDAO;
import dao.LunchDiaryDAO;
import model.AllColumnBeans;
import model.HandmadeDiaryBeans;
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
			ArrayList<AllColumnBeans> lunchDiary =LdDao.selectLunch(distance,time,category,cost,res_name);

			request.setAttribute("lunchDiary", lunchDiary);
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
	}

}
