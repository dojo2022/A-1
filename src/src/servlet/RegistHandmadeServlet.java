package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class RegistHandmadeServlet
 */
@MultipartConfig(location = "C://dojo6//src//WebContent//images") // アップロードファイルの一時的な保存先
@WebServlet("/RegistHandmadeServlet")
public class RegistHandmadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//手作り記録登録画面ににフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_diary.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);

		 // リクエストパラメータを取得する
		 request.setCharacterEncoding("UTF-8");
		 String foodName = request.getParameter("foodName");
		 Part foodPhoto = request.getPart("foodPhoto");
		 String cookTime = request.getParameter("cookTime");
		 String date = request.getParameter("date");
		 String cost = request.getParameter("cost");
		 String star = request.getParameter("star");
		 String feeling = request.getParameter("feeling");
	}
}


	/*	String image = this.getFileName(foodPhoto);

		HttpSession session = request.getSession();
		request.setAttribute("image", image);
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある


		//	DAOを呼び出す
		HandmadeDiaryDAO hDao = new HandmadeDiaryDAO();

		//登録処理を行う
		if(hDao.insert(foodName,foodPhoto,cookTime,date,cost,star,feeling)) {
			request.setAttribute("result","手作り日記をを登録しました。");
		}else {												// 登録失敗
			request.setAttribute("result","登録できませんでした");
		}
		//タイムラインに遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
	}

		//ファイルの名前を取得してくる
			private String getFileName(Part part) {
			    String name = null;
			    for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			        if (dispotion.trim().startsWith("filename")) {
			            name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
			            name = name.substring(name.lastIndexOf("\\") + 1);
			            break;
			        }
			    }		// TODO 自動生成されたメソッド・スタブ
				return name;
			}
			*/

