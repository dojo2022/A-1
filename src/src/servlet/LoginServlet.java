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

import dao.UsersDAO;
import model.UserMasterBeans;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String emailAddress = request.getParameter("emailAddress");
		String pw = request.getParameter("pw");

		// ログイン処理を行う
		UsersDAO uDao = new UsersDAO();

		//uDaoにユーザーの情報を取ってきてもらう
		ArrayList<UserMasterBeans> user = uDao.selectUser(emailAddress, pw);

		if(user.size() != 0) {
			//ちゃんとidとpwが合っていて、データを取得できた場合
			 //sessionを使うための準備をする
			HttpSession session = request.getSession();
			//sessionにもらってきたuserの情報を格納する
			session.setAttribute("user", user.get(0));

			//リダイレクト
			response.sendRedirect("/lunchBox/TimelineServlet");

		}else {
			//idとpwが間違っていた場合
			request.setAttribute("errMsg", "メールアドレス、もしくはパスワードが異なります");

			//ログイン画面に遷移させる
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
