package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BcDAO;
import model.Bc;
import model.Result;

/**
 * Servlet implementation class RegistUserServlet
 */
@WebServlet("/RegistUserServlet")
public class RegistUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新規登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_user.jsp");
		dispatcher.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String  icon = request.getParameter("icon");
		String  accountName = request.getParameter("accountName");
		String  depName = request.getParameter("depName");
		String  emailAddress = request.getParameter("emailAddress");
		String  emailCheck = request.getParameter("emailCheck");
		String  pw = request.getParameter("pw");
		String  pwCheck = request.getParameter("pwcheck");


	//	登録を行う
		UsersDAO uDao = new UsersDAO();

	//
		if (uDao.insert(new Users(icon, accountName, depName, emailAddress, pw))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/lunchBox/loginServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。"));
		}

		//ログイン画面に遷移
				RequestDispatcher dispatcher = request.getRequestDispatcher("/lunchBox/jsp/login.jsp");
				dispatcher.forward(request, response);

	}



