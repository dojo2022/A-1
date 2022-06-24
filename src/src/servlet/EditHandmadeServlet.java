package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.HandmadeDiaryDAO;
import dao.HdCommentDAO;
import dao.HdReactionDAO;
import dao.LdJoin2DAO;
import dao.MyPageDAO;
import model.AllColumnBeans;
import model.UserMasterBeans;

/**
 * Servlet implementation class EditHandmadeServlet
 */
@MultipartConfig(location = "C://dojo6//src//WebContent//images") // アップロードファイルの一時的な保存先
@WebServlet("/EditHandmadeServlet")
public class EditHandmadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;
	private ServletResponse response;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//手作り日記編集画面ににフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_handmade_diary.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
/*
		//insertに必要なメールアドレスを取得
		HttpSession session = request.getSession();
		UserMasterBeans user = (UserMasterBeans) session.getAttribute("user");
		String emailAddress = user.getEmailAddress();

*/
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("SUBMIT")+"←ぼたんの名前");
		//編集ボタンが押されたときの処理
		if(request.getParameter("SUBMIT")!=null) {
			if(request.getParameter("SUBMIT").equals("編集")) {
				//値の取得

				int handmadeId = Integer.parseInt(request.getParameter("handmadeId"));
				String foodName = request.getParameter("foodName");
				String foodPhoto = request.getParameter("foodPhoto");
				String cookTime = request.getParameter("cookTime");
				String date = request.getParameter("date");
				String cost = request.getParameter("cost");
				String feeling = request.getParameter("feeling");
				int star =0;
				//nullのときにparseIntするせいでエラー？
				if(request.getParameter("star") != null) {
					 star = Integer.parseInt(request.getParameter("star"));
				}

				//上記データをリクエストスコープへセット
				request.setAttribute("handmadeId", handmadeId);
				request.setAttribute("foodName",foodName );
				request.setAttribute("foodPhoto",foodPhoto );
				request.setAttribute("cookTime",cookTime );
				request.setAttribute("date", date);
				request.setAttribute("cost", cost);
				request.setAttribute("feeling", feeling);
				request.setAttribute("star",star );

				//編集画面へ画面遷移
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_handmade_diary.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}


				//リクエストパラメーターを取得
				request.setCharacterEncoding("UTF-8");
				int handmadeId = Integer.parseInt(request.getParameter("handmadeId"));
				String foodName = request.getParameter("foodName");
				Part foodPhoto = request.getPart("foodPhoto");
				String cookTime = request.getParameter("cookTime");
				String date = request.getParameter("date");
				String cost = request.getParameter("cost");
				String feeling = request.getParameter("feeling");
				int star =0;
				//nullのときにparseIntするせいでエラー？
				if(request.getParameter("star") != null) {
					 star = Integer.parseInt(request.getParameter("star"));
				}

				String image = this.getFileName(foodPhoto);
				request.setAttribute("image", image);
				// サーバの指定のファイルパスへファイルを保存
		        //場所はクラス名↑の上に指定してある

				//上記データをリクエストスコープへセット
				request.setAttribute("handmadeId", handmadeId);
				request.setAttribute("foodName",foodName );
				request.setAttribute("foodPhoto",foodPhoto );
				request.setAttribute("cookTime",cookTime );
				request.setAttribute("date", date);
				request.setAttribute("cost", cost);
				request.setAttribute("feeling", feeling);
				request.setAttribute("star",star );


		//DAOを呼び出す
		HandmadeDiaryDAO hDao = new HandmadeDiaryDAO();


		if (request.getParameter("updateButton") != null) {
			boolean ans = hDao.updateHd(handmadeId, foodName, image, cookTime, date, cost, star, feeling);

			//更新成功したら
			if(ans == true) {
				request.setAttribute("msg","更新が完了しました");

			//更新が失敗したら
			}else {
				request.setAttribute("ngmsg","更新失敗しました");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_handmade_diary.jsp");
				dispatcher.forward(request, response);
				return;
				}
			}

		else if (request.getParameter("deleteButton") != null){
				//DAOに削除してねって依頼をする
				boolean ans = hDao.updateHdFlag(handmadeId);

				//論理削除成功時
				if(ans == true) {
					request.setAttribute("msg","削除が完了しました");

				//論理削除失敗時
				}else {
					request.setAttribute("ngmsg","削除に失敗しました");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_handmade_diary.jsp");
					dispatcher.forward(request, response);
					return;
					}
				}

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


			/*		ArrayList<AllColumnBeans>myLdReaction = mDao.countMyLdReaction(emailAddress);

			// 検索結果をリクエストスコープに格納する
				        request.setAttribute("myLdReaction",myLdReaction);
			*/



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
					/*  //行きたい場所リストのリアクション情報をゲットしてくる
					  HdCommentDAO HCDao = new HdCommentDAO();
					  ArrayList<AllColumnBeans> HdComment = HCDao.selectHdComment();
					   // 検索結果をリクエストスコープに格納する
					 		  request.setAttribute("HdComment", HdComment);
					*/

		//タイムラインに遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
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



