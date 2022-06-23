package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.LdJoin2DAO;
import dao.LunchDiaryDAO;
import model.AllColumnBeans;
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
		int star =0;
		//nullのときにparseIntするせいでエラー？
		if(request.getParameter("star") != null) {
			 star = Integer.parseInt(request.getParameter("star"));
		}
//		int star = Integer.parseInt(request.getParameter("star"));
		String feeling = request.getParameter("feeling");

		//画像の保存
		String foodPhoto = this.getFileName(image);
		request.setAttribute("foodPhoto", foodPhoto);

		//LunchDiaryDAOを呼び出す
		LunchDiaryDAO ldDao = new LunchDiaryDAO();
		boolean ans = ldDao.insertLd(emailAddress, resName, foodPhoto, category, style, date, foodName, cost, time, distance, star, feeling);

		if(ans == true) {
			System.out.println("登録成功");
			request.setAttribute("ldresult", "ランチ日記を登録しました。");
		}else {
			System.out.println("登録失敗");
		}
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
