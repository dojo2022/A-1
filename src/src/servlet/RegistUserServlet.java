package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.UsersDAO;


/**
 * Servlet implementation class RegistUserServlet
 */
@MultipartConfig(location = "C://dojo6//src//WebContent//images") // アップロードファイルの一時的な保存先
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
		Part icon = request.getPart("icon");   //getPartで取得
		String  accountName = request.getParameter("accountName");
		String  depName = request.getParameter("depName");
		String  emailAddress = request.getParameter("emailAddress");
		String  pw = request.getParameter("pw");

		String image = this.getFileName(icon);

		HttpSession session = request.getSession();
		request.setAttribute("image", image);
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある



		// 未完成 パスワードチェック※飛ぶところ見直し
		if(pw.length()<8 || pw.length()>=20) {
			request.setAttribute("pwMsg","パスワードを８文字以上２０文字以下で入力してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

	//	UsersDAOを呼び出す
		UsersDAO uDao = new UsersDAO();

		boolean ans = uDao.insertUser(emailAddress, pw, accountName, depName, image);

		//メールアドレスが重複してないか確かめる処理
		//成功の時
		if(ans ==true) {
			request.setAttribute("emailAddress",emailAddress);
			System.out.println("成功したよ");
			request.setAttribute("result","アカウントを登録しました。");
		//失敗の時
		}else {
			System.out.println("成功したよ");
			request.setAttribute("errMsg", "メールアドレスがすでに使われています。");
		}


		//ログイン画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
		return;

	}

		//ファイルの名前を取得してくる
		private String getFileName(Part icon) {
		    String name = null;
		    for (String dispotion : icon.getHeader("Content-Disposition").split(";")) {
		        if (dispotion.trim().startsWith("filename")) {
		            name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
		            name = name.substring(name.lastIndexOf("\\") + 1);
		            break;
		        }
		    }		// TODO 自動生成されたメソッド・スタブ
			return name;
		}
}


