package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.LunchDiaryDAO;
import model.UserMasterBeans;

/**
 * Servlet implementation class RegistLunchServlet
 */
@MultipartConfig(location = "C://dojo6//src//WebContent//images")
@WebServlet("/RegistLunchServlet")
public class RegistLunchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistLunchServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//jsp表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_lunchdiary.jsp");
		dispatcher.forward(request, response);

	}

	//ランチ日記の新規登録をするメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insertに必要なメールアドレスを取ってくる
		HttpSession session = request.getSession();
		UserMasterBeans user = (UserMasterBeans) session.getAttribute("user");
		String emailAddress = user.getEmailAddress();


		//登録フォームに入力された内容を取ってくる
		request.setCharacterEncoding("UTF-8");
		String resName = request.getParameter("resName");
		Part image = request.getPart("foodPhoto");
		String category = request.getParameter("category");
		String style = request.getParameter("style");
		String date = request.getParameter("date");
		String foodName = request.getParameter("foodName");
		String cost = request.getParameter("cost");
		String time = request.getParameter("time");
		String distance = request.getParameter("distance");
		int star = Integer.parseInt(request.getParameter("star"));
		String feeling = request.getParameter("feeling");

		//画像の保存
		String foodPhoto = this.getFileName(image);

		//LunchDiaryDAOを呼び出す
		LunchDiaryDAO ldDao = new LunchDiaryDAO();
		boolean ans = ldDao.insertLd(emailAddress, resName, foodPhoto, category, style, date, foodName, cost, time, distance, star, feeling);

		if(ans == true) {
			System.out.println("登録成功");
			request.setAttribute("ldresult", "ランチ日記を登録しました。");
		}else {
			System.out.println("登録失敗");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
		return;

	}

	//ファイル名の取得
	private String getFileName(Part image) {
	    String name = null;
	    for (String dispotion : image.getHeader("Content-Disposition").split(";")) {
	        if (dispotion.trim().startsWith("filename")) {
	            name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	            name = name.substring(name.lastIndexOf("\\") + 1);
	            break;
	        }
	    }
		return name;
	}
}
