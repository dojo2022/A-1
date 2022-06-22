package servlet;

import java.io.FileNotFoundException;
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

import dao.UsersDAO;
import model.UserMasterBeans;

/**
 * Servlet implementation class RegistListServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\images")
// アップロードファイルの一時的な保存先
@WebServlet("/SettingsServlet")
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// pageで指定した場所へ遷移させる（引数のpathでどこに遷移するか判断する）
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settings.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			/*HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/simpleBC/LoginServlet");
					return;}
			*/


		//写真を射影！？
		request.setCharacterEncoding("UTF-8");

//		String icon = request.getParameter("icon");
		Part part = request.getPart("icon"); // getPartで取得

		String icon = this.getFileName(part);

		HttpSession session = request.getSession();
		request.setAttribute("image", icon);
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある


		//アイコンを変更しなかった場合の挙動
		UserMasterBeans user =(UserMasterBeans) session.getAttribute("user");
		try {
			part.write(icon);
		}catch(FileNotFoundException e) {
			icon = (String)user.getIcon();
		}catch(IOException e) {
			icon = (String)user.getIcon();
		}
		//getParameterはそのサーブレットのjsp（setting.jsp）でJSPでフォームに入力した情報を取得する
		String accountName = request.getParameter("accountName");
		String pw = request.getParameter("pw");
		String depName = request.getParameter("depName");
		String emailAddress = request.getParameter("emailAddress");
		//int range = request.getParameter("range");
		int range = Integer.parseInt(request.getParameter("range"));
		String pwCheck = request.getParameter("pwCheck");

		//DAOから得た情報をJSPにセットする
		//getAttributeはセッションにセットされている情報を取得する構文（このアプリでいうとユーザ情報など(arrayList））
		//setAttributeはJSPでフォームに入力した情報をセッションにセットする(新規登録画面で入力された情報）
		//JSP内で何らかの値をセッション（session）に保持（session.setArribute）し、
		//それをボタン押下等で起動するServletで取得（session.getArribute）する
		request.setAttribute("image", icon);
		request.setAttribute("accountName", accountName);
		request.setAttribute("depName", depName);
		request.setAttribute("emailAddress", emailAddress);
		request.setAttribute("range", range);

		//パスワード確認はプログラムに入っているもの(データベース等）ではないため、Attributeは必要ない？
		/*request.setAttribute("pwCheck", pwCheck);*/

		//ここで確認する
		//System.out.println(image+","+accountName+","+pw+","+depName+","+emailAddress+","+range);

		//パスワードの入力チェック
		if(pw.length()<8 || pw.length()>=20) {
			request.setAttribute("msg","パスワードを８文字以上２０文字以下で入力してください!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settings.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//パスワードとパスワード確認の内容が正しくなければ更新失敗になる
		//文字列と文字列を比較するときはequals
		if(!pw. equals (pwCheck)) {
			request.setAttribute("msg","パスワードとパスワード確認用の内容が異なります！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settings.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//DAOを呼んでくる
		UsersDAO uDao = new UsersDAO();
		//DAOに変更してねって依頼をする
		boolean ans = uDao.updateUser(emailAddress, pw, accountName, depName,icon, range);

		//アップデートが成功したら
		if(ans == true) {
			request.setAttribute("msg","変更が完了しました");
			UsersDAO dao = new UsersDAO();
			session.setAttribute("user",dao.selectUser(emailAddress).get(0));
			System.out.println("成功");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);

		//アップデートが失敗したら
		}else {
			request.setAttribute("msg","パスワードとパスワード確認用の内容が異なります！");
			System.out.println("失敗");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settings.jsp");
			dispatcher.forward(request, response);
		}

	}

//セットアトリビュート：結果をリクエストスコープに格納するカードりリストに格納してデータを取ってこれるようにする
//リクエストスコープ：JSPとサーブレットの間にあるデータを格納する場所


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

}