package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LdJoin2DAO;
import dao.MyPageDAO;
import model.AllColumnBeans;
import model.UserMasterBeans;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		//マイページ画面を表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//sessionからメールアドレスの情報を取ってくる
		 HttpSession session = request.getSession();
		 UserMasterBeans user = (UserMasterBeans) session.getAttribute("user");
		 String emailAddress = user.getEmailAddress();

		//メールアドレスを引数にしてランチ日記の情報を取ってくる-------------------------------------
	     MyPageDAO mDao = new MyPageDAO();
	     ArrayList<AllColumnBeans> myLunch = mDao.selectLd(emailAddress);
	     if(myLunch.size()==0) {
				request.setAttribute("myLunch", null);
			}
			else {
		// 検索結果をリクエストスコープに格納する
				request.setAttribute("myLunch", myLunch);
			}
    	//ランチ日記コメント情報をゲットしてくる
			LdJoin2DAO LdCDao = new LdJoin2DAO();
			ArrayList<AllColumnBeans> LdComment = LdCDao.selectComment();
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("LdComment", LdComment);

	    //メールアドレスを引数にしてランチ日記のリアクション情報を取ってくる-------------------------------------

	     ArrayList<AllColumnBeans>myLdReaction = mDao.countMyLdReaction(emailAddress);

	    // 検索結果をリクエストスコープに格納する
		        request.setAttribute("myLdReaction",myLdReaction);




		//メールアドレスを引数にして手作り日記の情報を取ってくる-------------------------------------

	     ArrayList<AllColumnBeans> myHandmade = mDao.selectMyHd(emailAddress);
		 if(myHandmade.size()==0) {
   			   request.setAttribute("myHandmade", null);
		   }
	     else {
	    // 検索結果をリクエストスコープに格納する
		       request.setAttribute("myHandmade", myHandmade);
		   }

//		//手作り日記のコメント情報をゲットしてくる
//		LdJoin2DAO HdCDao = new LdJoin2DAO();
//		ArrayList<AllColumnBeans> LdComment = LdCDao.selectComment();
//		// 検索結果をリクエストスコープに格納する
//				request.setAttribute("LdComment", LdComment);
//


		 //JSP表示
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		   dispatcher.forward(request, response);
	 }





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 	*/

//	ArrayList<AllColumnBeans> lList =ldDao.selectUser();
//	request.setAttribute("lList", lList);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
		}
	}


//		Part part = request.getPart("icon"); // getPartで取得

//		String image = this.getFileName(part);
//		request.setAttribute("image", image);
//		part.write(image);
//		String accountName = request.getParameter("accountName");
//		String depName = request.getParameter("depName");
//		String emailAddress = request.getParameter("emailAddress");
		//新規会員登録で入力された情報を表示するだけだから、
		//リクエストゲットパラメータでJSPからデータをサーブレットに取ってこなくてよい？


		//ログインしている人を区別(主キーのメールアドレスで）して表示する
		//メールアドレスをタップするとメールを送れるようになる仕組みを作る

//		３つのタブ(手作り記録・ランチ日記・行きたい場所リスト）ごとにログインしている人のデータを持ってくる
//		手作り日記・ランチ日記・行きたい場所リストで登録された情報を持ってくる？？
//		下記の４つのDAOを使い分ける！？！？
//		もっと見るボタンを押すとしまわれている部分が見えるようになる仕組み

		//ユーザー情報のdao
//		UsersDAO uDao = new UsersDAO();
//		//ユーザーのデータを取得するメソッドを使用する(仮）
//		ArrayList<AllColumnBeans> uList =uDao.selectUser();
//		request.setAttribute("uList", uList);
//
//		//ランチ日記のDAO(仮）
//		LunchDiaryDAO ldDao = new LunchDiaryDAO();
//		ArrayList<AllColumnBeans> lList =ldDao.selectUser();
//		request.setAttribute("lList", lList);
//
//		//行きたい場所リストのDAO(仮）
//		ListDAO liDao =  new ListDAO();
//		ArrayList<AllColumnBeans> liList =liDao.selectUser();
//		request.setAttribute("liList", liList);
//
//		//手作り日記のDAO(仮）
//		HandmadeDiaryDAO HdDao =  new HandmadeDiaryDAO();
//		ArrayList<AllColumnBeans> hList =HdDao.selectUser();
//		//HandmadeDiaryDAOをHdDaoと言い換えて、HdDaoのデータベースのbeansがhListという箱の中に入っている。
//		//箱の名前を同じhListにしただけ
//		request.setAttribute("hList", hList);
//
//
//
//			//ファイルの名前を取得してくる
//			private String getFileName(Part part) {
//		        String name = null;
//		        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
//		            if (dispotion.trim().startsWith("filename")) {
//		                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
//		                name = name.substring(name.lastIndexOf("\\") + 1);
//		                break;}
//		           }


