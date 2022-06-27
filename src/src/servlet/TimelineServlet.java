package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import dao.LdJoin2DAO;
import dao.LdReactionDAO;
import dao.LunchDiaryDAO;
import model.AllColumnBeans;
import model.UserMasterBeans;

/**
 * Servlet implementation class TimelineServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\images")
//アップロードファイルの一時的な保存先
@WebServlet("/TimelineServlet")
public class TimelineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしてなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if (session.getAttribute("emailAddress") == null) {
//			response.sendRedirect("/lunchBox/LoginServlet");
//			return;
//	}

		request.setCharacterEncoding("UTF-8");

//		String icon = request.getParameter("icon");
//		Part part = request.getPart("food_photo"); // getPartで取得
//		String food_photo = this.getFileName(part);
//		HttpSession session = request.getSession();
//		request.setAttribute("food_photo", food_photo);
//----------------------------ランチ日記の情報-------------------------------------
		//日記情報をゲットしてくる
		LunchDiaryDAO LdDao = new LunchDiaryDAO();
		ArrayList<AllColumnBeans> allLunch = LdDao.select();
//		request.setAttribute("food_photo", food_photo);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("allLunch", allLunch);

	//ランチ日記リアクション情報をゲットしてくる
		LdJoin2DAO LdRDao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> ldReactionList = LdRDao.countReactionUser();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("ldReactionList", ldReactionList);

//		Integer lunch_id = Integer.parseInt(request.getParameter("data1"));
////		Integer reaction = Integer.parseInt(request.getParameter("data2"));
		UserMasterBeans user = (UserMasterBeans)session.getAttribute("user");
		String email_address=user.getEmailAddress();
		System.out.println(email_address+"aaaaaaaaaaaaaaaaaaaaaaaaaa");

		LdReactionDAO ldrDao = new LdReactionDAO();
		ArrayList<AllColumnBeans> ldr = ldrDao.selectLdReaction(email_address);
		System.out.println(ldr.size()+"サイズだよｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘｘ");
		request.setAttribute("ldr", ldr);

		//ランチ日記コメント情報をゲットしてくる
		LdJoin2DAO LdCDao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> LdComment = LdCDao.selectComment();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("LdComment", LdComment);

//----------------------------手作り日記の情報-------------------------------------
//		手作り日記の情報を貰ってくる
		HandmadeDiaryDAO hdDao = new HandmadeDiaryDAO();
	    ArrayList<AllColumnBeans> myHandmade = hdDao.select();
	    // 検索結果をリクエストスコープに格納する
	    request.setAttribute("myHandmade", myHandmade);
//		手作り日記リアクション情報をゲットしてくる
	    HdReactionDAO HdRDao = new HdReactionDAO();
		ArrayList<AllColumnBeans> hdReactionList = HdRDao.countReactionUser();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("hdReactionList", hdReactionList);
	    //手作り日記コメント情報をゲットしてくる
	 	HdCommentDAO HCDao = new HdCommentDAO();
	 	ArrayList<AllColumnBeans> HdComment = HCDao.selectHdComment();
//		検索結果をリクエストスコープに格納する
	 	request.setAttribute("HdComment", HdComment);

		//タイムラインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost入ったよ");
		//		data4で取ってきたボタンの種類がto_go(行きたい)だったらこの処理をする
		if(request.getParameter("data4").equals("to_go")) {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json");
			response.setHeader("Cache-Control", "nocache");
			response.setCharacterEncoding("utf-8");

	//		セッションにあるuserの情報を取得
			UserMasterBeans user = (UserMasterBeans)session.getAttribute("user");
	//-----------------------リアクションの登録、削除を行うやつ----------------------------------
			request.setCharacterEncoding("UTF-8");
	//		ランチ日記のリアクションボタンが押されたら(変えた方がいいかも？)(nullなのか""なのか）)
			if(request.getParameter("data2") != null) {
				request.setCharacterEncoding("UTF-8");
		//		ajaxの方からデータ持ってくるやつ。誰がどのランチIDに対してどのリアクションボタンを押したかを取得する
				Integer lunch_id = Integer.parseInt(request.getParameter("data1"));
				String iki = request.getParameter("data2");
				System.out.println(iki+"←いきだよ");
				String email_address = request.getParameter("data3");
		//		LdReactionDAOのselectLdReactionメソッドを呼び出す
		//		今まで誰がどのランチIDに対してどんなリアクションをしたかが分かる（？）
				LdReactionDAO ldrDao = new LdReactionDAO();
				ArrayList<AllColumnBeans> ldr = ldrDao.selectLdReaction(email_address);
				request.setAttribute("ldr", ldr);

//				Integer reaction_id = Integer.parseInt(request.getParameter("ldReactionId"));

		//		ここまできたら、そのランチIDに対してボタンを押したユーザーはどんな情報を持っているか分かるんじゃないか！！
		//		もし既に持っていたto_goが0ならinsertしなさい！1ならdelteしろ！の条件分岐
				if(iki.length()==0) {
					boolean ans = ldrDao.insertLdReaction(lunch_id, email_address, 1, 0, 0);
					System.out.println(ans);
				}else {

					ldrDao.deleteLdToGoReaction(lunch_id, email_address);
				}
				PrintWriter out = response.getWriter();
				out.print("戻り値");}
		}

		//		data4で取ってきたボタンの種類がto_tell(教えて)だったらこの処理をする
		if(request.getParameter("data4").equals("to_tell")) {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json");
			response.setHeader("Cache-Control", "nocache");
			response.setCharacterEncoding("utf-8");

	//		セッションにあるuserの情報を取得
			UserMasterBeans user = (UserMasterBeans)session.getAttribute("user");
	//-----------------------リアクションの登録、削除を行うやつ----------------------------------
			request.setCharacterEncoding("UTF-8");
	//		ランチ日記のリアクションボタンが押されたら(変えた方がいいかも？)(nullなのか""なのか）)
			if(request.getParameter("data2") != null) {
				request.setCharacterEncoding("UTF-8");
		//		ajaxの方からデータ持ってくるやつ。誰がどのランチIDに対してどのリアクションボタンを押したかを取得する
				Integer lunch_id = Integer.parseInt(request.getParameter("data1"));
				String oshi = request.getParameter("data2");
				System.out.println(oshi+"←おしだよ");
				String email_address = request.getParameter("data3");
		//		LdReactionDAOのselectLdReactionメソッドを呼び出す
		//		今まで誰がどのランチIDに対してどんなリアクションをしたかが分かる（？）
				LdReactionDAO ldrDao = new LdReactionDAO();
				ArrayList<AllColumnBeans> ldr = ldrDao.selectLdReaction(email_address);
				request.setAttribute("ldr", ldr);

//				Integer reaction_id = Integer.parseInt(request.getParameter("ldReactionId"));

		//		ここまできたら、そのランチIDに対してボタンを押したユーザーはどんな情報を持っているか分かるんじゃないか！！
		//		もし既に持っていたto_goが0ならinsertしなさい！1ならdelteしろ！の条件分岐
				if(oshi.length()==0) {
					boolean ans = ldrDao.insertLdReaction(lunch_id, email_address, 0, 1, 0);
					System.out.println(ans);
				}else {

					ldrDao.deleteLdToTellReaction(lunch_id, email_address);
				}
				PrintWriter out = response.getWriter();
				out.print("戻り値");}
		}

		//		data4で取ってきたボタンの種類がto_use(参考にします)だったらこの処理をする
		if(request.getParameter("data4").equals("to_use")) {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json");
			response.setHeader("Cache-Control", "nocache");
			response.setCharacterEncoding("utf-8");

	//		セッションにあるuserの情報を取得
			UserMasterBeans user = (UserMasterBeans)session.getAttribute("user");
	//-----------------------リアクションの登録、削除を行うやつ----------------------------------
			request.setCharacterEncoding("UTF-8");
	//		ランチ日記のリアクションボタンが押されたら(変えた方がいいかも？)(nullなのか""なのか）)
			if(request.getParameter("data2") != null) {
				request.setCharacterEncoding("UTF-8");
		//		ajaxの方からデータ持ってくるやつ。誰がどのランチIDに対してどのリアクションボタンを押したかを取得する
				Integer lunch_id = Integer.parseInt(request.getParameter("data1"));
				String san = request.getParameter("data2");
				System.out.println(san+"←いきだよ");
				String email_address = request.getParameter("data3");
		//		LdReactionDAOのselectLdReactionメソッドを呼び出す
		//		今まで誰がどのランチIDに対してどんなリアクションをしたかが分かる（？）
				LdReactionDAO ldrDao = new LdReactionDAO();
				ArrayList<AllColumnBeans> ldr = ldrDao.selectLdReaction(email_address);
				request.setAttribute("ldr", ldr);

//				Integer reaction_id = Integer.parseInt(request.getParameter("ldReactionId"));

		//		ここまできたら、そのランチIDに対してボタンを押したユーザーはどんな情報を持っているか分かるんじゃないか！！
		//		もし既に持っていたto_goが0ならinsertしなさい！1ならdelteしろ！の条件分岐
				if(san.length()==0) {
					boolean ans = ldrDao.insertLdReaction(lunch_id, email_address, 0, 0, 1);
					System.out.println(ans);
				}else {

					ldrDao.deleteLdToUseReaction(lunch_id, email_address);
				}
				PrintWriter out = response.getWriter();
				out.print("戻り値");}
		}

////		コメントの入力をゲットしてインサートする処理
//		request.setCharacterEncoding("UTF-8");
//		String send_comment = request.getParameter("send_comment");
//		if(request.getParameter("send_comment") != null && send_comment.equals("ランチ日記コメントを送信する")) {
//			request.setCharacterEncoding("UTF-8");
//			String ldc_email_address = user.getEmailAddress();
//			Integer ldc_lunch_id = Integer.parseInt(request.getParameter("lunch_id"));
//			String ld_comment =request.getParameter("ld_comment");
//
//			LdCommentDAO ldcDao = new LdCommentDAO();
//			ldcDao.insertLdComment(0, ldc_lunch_id, ldc_email_address, ld_comment);
//
//		}else if(request.getParameter("send_comment") != null && send_comment.equals("手作り記録コメントを送信する")) {
//			request.setCharacterEncoding("UTF-8");
//			String hdc_email_address = user.getEmailAddress();
//			Integer hdc_lunch_id = Integer.parseInt(request.getParameter("handmade_id"));
//			String hd_comment =request.getParameter("hd_comment");
//
//			HdCommentDAO hdcDao = new HdCommentDAO();
//			hdcDao.insertHdComment(0, hdc_lunch_id, hdc_email_address, hd_comment);
//		}
//		コメント、リアクションのインサート（登録）が行われたら、その情報をフォワードした際に表示できるようにする-------------
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
//----------------------------手作り日記の情報-------------------------------------
//		手作り日記の情報を貰ってくる
		HandmadeDiaryDAO hdDao = new HandmadeDiaryDAO();
	    ArrayList<AllColumnBeans> myHandmade = hdDao.select();
	    // 検索結果をリクエストスコープに格納する
	    request.setAttribute("myHandmade", myHandmade);
//		手作り日記リアクション情報をゲットしてくる
	    HdReactionDAO HdRDao = new HdReactionDAO();
		ArrayList<AllColumnBeans> hdReactionList = HdRDao.countReactionUser();
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("hdReactionList", hdReactionList);
	    //手作り日記コメント情報をゲットしてくる
	 	HdCommentDAO HCDao = new HdCommentDAO();
	 	ArrayList<AllColumnBeans> HdComment = HCDao.selectHdComment();
//		検索結果をリクエストスコープに格納する
	 	request.setAttribute("HdComment", HdComment);

		//タイムラインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeline.jsp");
		dispatcher.forward(request, response);
	}

	//ファイルの名前を取得してくる
//	private String getFileName(Part part) {
//        String name = null;
//        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
//            if (dispotion.trim().startsWith("filename")) {
//                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
//                name = name.substring(name.lastIndexOf("\\") + 1);
//                break;
//            }
//        }		// TODO 自動生成されたメソッド・スタブ
//		return name;
//
//	}
}
