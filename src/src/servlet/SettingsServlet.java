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

import dao.UsersDAO;

/**
 * Servlet implementation class RegistListServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\images")
// アップロードファイルの一時的な保存先
@WebServlet("/SettingsServlet")
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public SettingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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



		request.setCharacterEncoding("UTF-8");

//		String icon = request.getParameter("icon");
		Part part = request.getPart("icon"); // getPartで取得

		String image = this.getFileName(part);
		request.setAttribute("image", image);
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある

		part.write(image);
		String accountName = request.getParameter("accountName");
		String pw = request.getParameter("pw");
		String depName = request.getParameter("depName");
		String emailAddress = request.getParameter("emailAddress");
		String range = request.getParameter("range");

		request.setAttribute("image", image);
		request.setAttribute("accountName", accountName);
		request.setAttribute("depName", depName);
		request.setAttribute("emailAddress", emailAddress);
		request.setAttribute("range", range);


		//ここで確認する
		//System.out.println(image+","+accountName+","+pw+","+depName+","+emailAddress+","+range);

		//パスワードの入力チェック
		if(pw.length()<8 || pw.length()>=20) {
			request.setAttribute("msg","パスワードを８文字以上２０文字以下で入力してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settings.jsp");
			dispatcher.forward(request, response);
			return;
		}


		//DAOを呼んでくる
		UsersDAO uDao = new UsersDAO();
		//DAOに変更してねって依頼をする
		boolean ans = uDao.updateUser(emailAddress, pw, accountName, depName, 1, image, range);

		//アップデートが成功したら
		if(ans == true) {
			request.setAttribute("msg","変更が完了しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myPage.jsp");
			dispatcher.forward(request, response);

		//アップデートが失敗したら
		}/*else {
			request.setAttribute("msg","更新失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settings.jsp");
			dispatcher.forward(request, response);
		}*/


		//↓押されたボタンの値を取得(更新を押されたら、request.getParameter("SUBMIT")が更新という文字列に代わる。

						//登録されているユーザの情報を持ってくる
			             //更新に成功したらマイページ画面に移動する
	}			//編集をした際にパスワードの基準8文字以上20文字以内、メールには＠マークつけるなどを満たしているかをチェック
						//更新に失敗したらエラーメッセージを表示し、非同期処理にて設定画面の入力された状態に戻る


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