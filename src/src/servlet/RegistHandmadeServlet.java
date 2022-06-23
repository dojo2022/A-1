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

import dao.HandmadeDiaryDAO;
import model.UserMasterBeans;


/**
 * Servlet implementation class RegistHandmadeServlet
 */
@MultipartConfig(location = "C://dojo6//src//WebContent//images") // アップロードファイルの一時的な保存先
@WebServlet("/RegistHandmadeServlet")
public class RegistHandmadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//手作り記録登録画面ににフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_handmade_diary.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);

		//insertに必要なメールアドレスを取得
		HttpSession session = request.getSession();
		UserMasterBeans user = (UserMasterBeans) session.getAttribute("user");
		String emailAddress = user.getEmailAddress();

		 // リクエストパラメータを取得する
		 request.setCharacterEncoding("UTF-8");
		 String foodName = request.getParameter("foodName");
		 Part foodPhoto = request.getPart("foodPhoto");
		 String cookTime = request.getParameter("cookTime");
		 String date = request.getParameter("date");
		 String cost = request.getParameter("cost");
		 int star = 0;
		 if(request.getParameter("star") != null) {
			 star = Integer.parseInt(request.getParameter("star"));
		 }
		 String feeling = request.getParameter("feeling");


		 String image = this.getFileName(foodPhoto);

		 request.setAttribute("image", image);
		//  サーバの指定のファイルパスへファイルを保存
		//場所はクラス名↑の上に指定してある


		//	DAOを呼び出す
		HandmadeDiaryDAO hDao = new HandmadeDiaryDAO();
		boolean ans = hDao.insertHd(emailAddress, foodName,image,cookTime,date,cost,star,feeling);

		// 登録処理
		// 成功した時
		if(ans == true) {
			request.setAttribute("hdresult","手作り日記を登録しました。");
		// 失敗した時
		}else {
			request.setAttribute("hdresult","登録できませんでした");
		}

		//日記情報をゲットしてくる
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
		return;
	}


		//ファイルの名前を取得してくる
			private String getFileName(Part foodPhoto) {
			    String name = null;
			    for (String dispotion : foodPhoto.getHeader("Content-Disposition").split(";")) {
			        if (dispotion.trim().startsWith("filename")) {
			            name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
			            name = name.substring(name.lastIndexOf("\\") + 1);
			            break;
			        }
			    }
				return name;
			}

		}



