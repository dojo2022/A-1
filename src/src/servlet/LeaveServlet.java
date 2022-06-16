package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;

/**
 * Servlet implementation class LeaveServlet
 */
@WebServlet("/LeaveServlet")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 退会ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/leave.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String reason = request.getParameter("reason").trim();
		String buttonName = request.getParameter("leaveButton");//ボタンのvalue

		if(reason.length()==0) {
			request.setAttribute("errMsg", "退会理由を入力してください！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/leave.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if(buttonName.equals("退会する")) {

			//退会理由の登録とフラグの変更処理を行う
			UsersDAO uDao = new UsersDAO();
			boolean ans =uDao.updateUserFlag(reason);

			if(ans == true) {
				HttpSession session = request.getSession();
				//sessionの中身のデータを全て削除する
				//sessinにある全ての要素名を取得する
				Enumeration values = session.getAttributeNames();

				//取得した要素名をループ処理で全て削除する
				while(values.hasMoreElements()) {
					String nm = (String)values.nextElement();
					session.removeAttribute(nm);
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/leave_result.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("errMsg", "退会出来ませんでした。管理者へ問い合わせてください。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/leave.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			//前の画面に遷移する
			response.sendRedirect("/lunchBox/SettingsServlet");
		}
	}

}
