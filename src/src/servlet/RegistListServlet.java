package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListDAO;

/**
 * Servlet implementation class RegistListServlet
 */
@WebServlet("/RegistListServlet")
public class RegistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/* HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect("/lunchBox/LoginServlet");
			return;
		} */

		// 行きたい場所リスト登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_list.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}  */


		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String emailAddress = request.getParameter("EMAIL_ADDRESS");
		String listResName = request.getParameter("RES_NAME");
		String listCategory = request.getParameter("CATEGORY");
		String togoMemo = request.getParameter("TOGO_MEMO");

		if(togoMemo.length() > 200) {
			request.setAttribute("msg","メモは200字以内で入力してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_list.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//DAOを呼んでくる
		ListDAO lDao = new ListDAO();

		//DAOに変更してねって依頼をする
		boolean ans = lDao.insertList(emailAddress,listResName,listCategory,togoMemo);

		System.out.println(emailAddress);
		System.out.println(listResName);
		System.out.println(listCategory);
		System.out.println(togoMemo);
		//登録成功時
		if(ans == true) {
			request.setAttribute("msg","登録が完了しました");
			System.out.println("成功");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
		}
		//登録失敗時
		else {
			request.setAttribute("msg","登録に失敗しました");
			System.out.println("失敗");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
}

