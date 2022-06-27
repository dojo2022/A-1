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

import dao.HandmadeDiaryDAO;
import dao.HdCommentDAO;
import dao.HdReactionDAO;
import dao.LdCommentDAO;
import dao.LdJoin2DAO;
import dao.LdReactionDAO;
import dao.LunchDiaryDAO;
import dao.MyPageDAO;
import model.AllColumnBeans;
import model.UserMasterBeans;

/**
 * Servlet implementation class MyPageServlet
 */

@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\images")
//アップロードファイルの一時的な保存先
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
		 request.setAttribute("LdComment", LdComment);

		//メールアドレスを引数にしてランチ日記リアクション情報をゲットしてくる------------------------------------
			LdJoin2DAO LdRDao = new LdJoin2DAO();
			ArrayList<AllColumnBeans> ldReactionList = LdRDao.countReactionUser();
		// 検索結果をリクエストスコープに格納する
			request.setAttribute("ldReactionList", ldReactionList);


		//メールアドレスを引数にして手作り日記の情報を取ってくる-------------------------------------

	     ArrayList<AllColumnBeans> myHandmade = mDao.selectMyHd(emailAddress);
	     if(myHandmade.size()==0) {
   			   request.setAttribute("myHandmade", null);
		   }
	     else {
	    // 検索結果をリクエストスコープに格納する
		       request.setAttribute("myHandmade", myHandmade);
		   }
	    //手作り日記コメント情報をゲットしてくる
	 	HdCommentDAO HCDao = new HdCommentDAO();
	 	 ArrayList<AllColumnBeans> HdComment = HCDao.selectHdComment();
	 	// 検索結果をリクエストスコープに格納する
	 			request.setAttribute("HdComment", HdComment);
//	 	手作り日記リアクション情報をゲットしてくる
	 	 HdReactionDAO HdRDao = new HdReactionDAO();
	 	 ArrayList<AllColumnBeans> hdReactionList = HdRDao.countReactionUser();
	 	// 検索結果をリクエストスコープに格納する
	 			request.setAttribute("hdReactionList", hdReactionList);

	 			//メールアドレスを引数にして行きたい場所リストの情報を取ってくる-------------------------------------

	 	ArrayList<AllColumnBeans> myList = mDao.selectMyList(emailAddress);
	 	if(myList.size()==0) {
	 	   	   request.setAttribute("myList", null);
	 			   }
	    else {
	   // 検索結果をリクエストスコープに格納する
	 		  request.setAttribute("myList", myList);
	 			   }
					/* 	//行きたい場所リストのリアクション情報をゲットしてくる
					 	 ListReactionDAO ListDao = new ListReactionDAO();
					 	 ArrayList<AllColumnBeans> hdReactionList = ListDao.countReactionUser();
					 	// 検索結果をリクエストスコープに格納する
					 			request.setAttribute("hdReactionList", hdReactionList);
					*/



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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UserMasterBeans user = (UserMasterBeans)session.getAttribute("user");
		String email_address = user.getEmailAddress();
		Integer lunch_id =0;
		if(request.getParameter("lunch_id") != null) {
			lunch_id = Integer.parseInt(request.getParameter("lunch_id"));
		}
		String ld_comment =request.getParameter("ld_comment");
		Integer	handmade_id=0;
		if(request.getParameter("handmade_id") != null) {
			handmade_id = Integer.parseInt(request.getParameter("handmade_id"));
		}
		String hd_comment =request.getParameter("hd_comment");

		//ランチ日記コメントの「送信する」ボタンを押した後の処理-------------------------------
		LdCommentDAO ldcDao = new LdCommentDAO();
		ldcDao.insertLdComment(0, lunch_id, email_address, ld_comment);

		//ランチ日記情報をゲットしてくる
		MyPageDAO mDao = new MyPageDAO();
		 ArrayList<AllColumnBeans> myLunch = mDao.selectLd(email_address);
		// 検索結果をリクエストスコープに格納する
		 if(myLunch.size()==0) {
				request.setAttribute("myLunch", null);
		}
		else {
				request.setAttribute("myLunch", myLunch);
			}
		//ランチ日記コメント情報をゲットしてくる
		LdJoin2DAO LdCDao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> LdComment = LdCDao.selectComment();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("LdComment", LdComment);

		//手作り日記コメントの「送信する」ボタンを押した後の処理-------------------------------
		//コメントをデータベースに登録する
		HdCommentDAO hcDao = new HdCommentDAO();
		hcDao.insertHdComment(0, handmade_id, email_address, hd_comment);

		//手作り日記情報をゲットしてくる
		 ArrayList<AllColumnBeans> myHandmade = mDao.selectMyHd(email_address);
		// 検索結果をリクエストスコープに格納する
		 if(myHandmade.size()==0) {
				request.setAttribute("myHandmade", null);
		}
		else {
				request.setAttribute("myHandmade", myHandmade);
			}
		//手作り日記コメント情報をゲットしてくる
		 HdCommentDAO HCDao = new HdCommentDAO();
		ArrayList<AllColumnBeans> HdComment = HCDao.selectHdComment();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("HdComment", HdComment);


		//ランチ日記リアクションボタンを押した後の処理-------------------------------
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("to") != null) {
			request.setCharacterEncoding("UTF-8");
			Integer ldr_lunch_id = Integer.parseInt(request.getParameter("lunch_id"));
			String ldr_email_address = user.getEmailAddress();
			Integer to_go = 0;
			Integer to_tell = 0;
			Integer to_use = 0;
//			ボタン押したか押していないかを取得
			String button =request.getParameter("to");
			if(button.equals("行きたい")) {
				to_go = 1;
			}else if (button.equals("教えて")) {
				to_tell= 1;
			}else if(button.equals("参考にします")){
				to_use = 1;
			}else {
				System.out.println("失敗");
			}
			LdReactionDAO ldrDao = new LdReactionDAO();
			ldrDao.insertLdReaction(ldr_lunch_id, ldr_email_address, to_go, to_tell, to_use);
			}else if(request.getParameter("hdbtn") != null) {
		//-----------------------リアクションの登録（インサート）を行うやつ手作り記録------------------------------
			request.setCharacterEncoding("UTF-8");
			Integer hdr_handmade_id = Integer.parseInt(request.getParameter("handmade_id"));
			String hdr_email_address = user.getEmailAddress();
			Integer to_eat = 0;
			Integer hdr_to_tell = 0;
			Integer hdr_to_use = 0;
//			ボタン押したか押していないかを取得
			String hd_button =request.getParameter("hdbtn");
			if(hd_button.equals("食べたい")) {
				to_eat = 1;
			}else if (hd_button.equals("教えて")) {
				hdr_to_tell= 1;
			}else if(hd_button.equals("参考にします")){
				hdr_to_use = 1;
			}else {
				System.out.println("失敗");
			}
			HdReactionDAO hdrDao = new HdReactionDAO();
			hdrDao.insertHdReaction(hdr_handmade_id, hdr_email_address, to_eat, hdr_to_tell, hdr_to_use);
		}

				request.setCharacterEncoding("UTF-8");
				String ldc_email_address = user.getEmailAddress();
				Integer ldc_lunch_id = Integer.parseInt(request.getParameter("lunch_id"));
				ldcDao.insertLdComment(0, ldc_lunch_id, ldc_email_address, ld_comment);

//				コメント、リアクションのインサート（登録）が行われたら、その情報をフォワードした際に表示できるようにする-------------
				//日記情報をゲットしてくる
				LunchDiaryDAO LdDao = new LunchDiaryDAO();
				ArrayList<AllColumnBeans> allLunch = LdDao.select();
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("allLunch", allLunch);

				//ランチ日記コメント・リアクション情報をゲットしてくる
				LdJoin2DAO LdRDao = new LdJoin2DAO();
				ArrayList<AllColumnBeans> ldReactionList = LdRDao.countReactionUser();
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("ldReactionList", ldReactionList);

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("LdComment", LdComment);
		//----------------------------手作り日記の情報-------------------------------------
//				手作り日記の情報を貰ってくる
				HandmadeDiaryDAO hdDao = new HandmadeDiaryDAO();
				ArrayList<AllColumnBeans> Allhandmade = hdDao.select();
				  // 検索結果をリクエストスコープに格納する
			    request.setAttribute("Allhandmade", Allhandmade);
			    // 検索結果をリクエストスコープに格納する
			    request.setAttribute("myHandmade", myHandmade);
//				手作り日記リアクション情報をゲットしてくる
				ArrayList<AllColumnBeans> hdReactionList = LdRDao.countReactionUser();
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("hdReactionList", hdReactionList);
			    //手作り日記コメント情報をゲットしてくる
//				検索結果をリクエストスコープに格納する
			 	request.setAttribute("HdComment", HdComment);
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
		}

	}

//-----------------------リアクションの登録（インサート）を行うやつ手作り記録------------------------------
/*			request.setCharacterEncoding("UTF-8");
			Integer hdr_lunch_id = Integer.parseInt(request.getParameter("handmade_id"));
			String hdr_email_address = user.getEmailAddress();
			Integer to_eat = 0;
			Integer hdr_to_tell = 0;
			Integer hdr_to_use = 0;
//				ボタン押したか押していないかを取得
			String hd_button =request.getParameter("hdbtn");
			if(hd_button.equals("食べたい")) {
				to_eat = 1;
			}else if (hd_button.equals("教えて")) {
				hdr_to_tell= 1;
			}else if(hd_button.equals("参考にします")){
				hdr_to_use = 1;
			}else {
				System.out.println("失敗");
			}
			HdReactionDAO hdrDao = new HdReactionDAO();
			hdrDao.insertHdReaction(hdr_lunch_id, hdr_email_address, to_eat, hdr_to_tell, hdr_to_use);
*/
//		入力されたコメントを取得して登録するやつ





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


