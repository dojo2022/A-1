package servlet;

import java.io.FileNotFoundException;
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

import dao.HdCommentDAO;
import dao.HdReactionDAO;
import dao.LdJoin2DAO;
import dao.LunchDiaryDAO;
import dao.MyPageDAO;
import model.AllColumnBeans;
import model.LunchDiaryBeans;
import model.UserMasterBeans;

/**
 * Servlet implementation class EditLunchServlet
 */
@MultipartConfig(location = "C://dojo6//src//WebContent//images") // アップロードファイルの一時的な保存先
@WebServlet("/EditLunchServlet")
public class EditLunchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	/*    public EditLunchServlet() {
	    super();
	    // TODO Auto-generated constructor stub
	}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ランチ日記更新削除画面にフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
			dispatcher.forward(request, response);
	}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			System.out.println("入ったよ");
	 request.setCharacterEncoding("UTF-8");
	if(request.getParameter("SUBMIT")!=null) {
		if(request.getParameter("SUBMIT").equals("編集")) {



	    int lunchId = Integer.parseInt(request.getParameter("lunch_id"));
	    String ldFoodType = request.getParameter("ldFoodType");
	 	String resName = request.getParameter("resName");
		//String foodPhoto = request.getParameter("foodPhoto");



				//String part = request.getParameter("foodPhoto"); // getPartで取得

				Part part = request.getPart("foodPhoto"); // getPartで取得

				String ldFoodPhoto = this.getFileName(part);

				HttpSession session = request.getSession();
				request.setAttribute("image", ldFoodPhoto);
				// サーバの指定のファイルパスへファイルを保存
		        //場所はクラス名↑の上に指定してある

				//☆☆☆大事：アイコンを変更しなかった場合の挙動------------------------------------------------------------
				//sessionからユーザーの情報を取得してくる
				LunchDiaryBeans user =(LunchDiaryBeans) session.getAttribute("user");
				//選択されてなければ、FileNotFoundExceptionとIOException例外が出るので下記のように書く
				try {
					part.write(ldFoodPhoto);
				}catch(FileNotFoundException e) {
					//icon（ファイルの名前）に元々DBに格納されている名前を入れる
					ldFoodPhoto = (String)user.getLdFoodPhoto();
				}catch(IOException e) {
					//こっちも同様
					ldFoodPhoto = (String)user.getLdFoodPhoto();
				}


				//String foodPhoto = this.getFileName(part);

				/*HttpSession session = request.getSession();
				request.setAttribute("images", foodPhoto);
				// サーバの指定のファイルパスへファイルを保存
				//場所はクラス名↑の上に指定してある


				//アイコンを変更しなかった場合の挙動
				LunchDiaryBeans result =(LunchDiaryBeans) session.getAttribute("result");
				try {
					part.write(foodPhoto);
				}catch(FileNotFoundException e) {
					foodPhoto = (String)result.getLdFoodPhoto();
				}catch(IOException e) {
					foodPhoto = (String)result.getLdFoodPhoto();
				}*/



















		String category = request.getParameter("category");
		String style = request.getParameter("style");
		String date = request.getParameter("date");
		String foodName = request.getParameter("foodName");
		String cost = request.getParameter("cost");
		String time = request.getParameter("time");
		String distance = request.getParameter("distance");
		int star =0;
		//nullのときにparseIntするせいでエラー？
		if(request.getParameter("Star") != null) {
			 star = Integer.parseInt(request.getParameter("Star"));
			 }
		String feeling = request.getParameter("feeling");


		//上記データをリクエストスコープにセット
		request.setAttribute("lunchId", lunchId);
		request.setAttribute("ldFoodType", ldFoodType);
		request.setAttribute("ldResName", resName);
		request.setAttribute("ldFoodPhoto", ldFoodPhoto);
		request.setAttribute("ldCategory", category);
		request.setAttribute("style", style);
		request.setAttribute("ldDate", date);
		request.setAttribute("ldFoodName", foodName);
		request.setAttribute("ldCost", cost);
		request.setAttribute("time", time);
		request.setAttribute("distance", distance);
		request.setAttribute("ldStar", star);
		request.setAttribute("ldFeeling", feeling);




		//ランチ日記更新削除画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
		dispatcher.forward(request, response);
		return;

		}

	}
//マイページJSPの<input type="hidden" name="lunch_id" value="${e.lunchId}">のname＝””中の文字がリクエストパラメータ取得の青い文字↓

	request.setCharacterEncoding("UTF-8");

			 int lunchId = Integer.parseInt(request.getParameter("lunchId"));
			    String ldFoodType = request.getParameter("ldFoodType");
			 	String resName = request.getParameter("resName");
				String foodPhoto = request.getParameter("foodPhoto");
				String category = request.getParameter("category");
				String style = request.getParameter("style");
				String date = request.getParameter("date");
				String foodName = request.getParameter("foodName");
				String cost = request.getParameter("cost");
				String time = request.getParameter("time");
				String distance = request.getParameter("distance");
				int star =0;
				//nullのときにparseIntするせいでエラー？
				if(request.getParameter("ldStar") != null) {
					 star = Integer.parseInt(request.getParameter("ldStar"));
					 }
				String feeling = request.getParameter("feeling");

				request.setAttribute("lunchId", lunchId);
				request.setAttribute("ldFoodType", ldFoodType);
				request.setAttribute("ldResName", resName);
				request.setAttribute("ldFoodPhoto", foodPhoto);
				request.setAttribute("ldCategory", category);
				request.setAttribute("style", style);
				request.setAttribute("ldDate", date);
				request.setAttribute("ldFoodName", foodName);
				request.setAttribute("ldCost", cost);
				request.setAttribute("time", time);
				request.setAttribute("distance", distance);
				request.setAttribute("ldStar", star);
				request.setAttribute("ldFeeling", feeling);




		 LunchDiaryDAO ldDao = new LunchDiaryDAO();


		if (request.getParameter("updateButton") != null) {
			boolean ans = ldDao.updateLd(lunchId,ldFoodType,resName, foodPhoto, category, style, date,foodName, cost,time,distance, star, feeling);

		//更新成功したら
		if(ans == true) {
			request.setAttribute("msg","更新が完了しました");


		//更新が失敗したら
		}else {
			request.setAttribute("ngmsg","更新失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
			dispatcher.forward(request, response);
			return;
			}
		}



		else if (request.getParameter("deleteButton") != null){
			//DAOに削除してねって依頼をする
			boolean ans = ldDao.updateLdFlag(lunchId);

			//論理削除成功時
			if(ans == true) {
				request.setAttribute("msg","削除が完了しました");


			//論理削除失敗時
			}else {
				request.setAttribute("msg","削除に失敗しました");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
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
				private String getFileName(Part part) {
			        String name = null;
			        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			            if (dispotion.trim().startsWith("filename")) {
			                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
			                name = name.substring(name.lastIndexOf("\\") + 1);
			                break;
			            }
			        }
			return name;
			}
		}















		//タイムラインに遷移
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
			return;
		}

*//*
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

*/




		/*//sessionからメールアドレスの情報を取ってくる
		 HttpSession session = request.getSession();
		 UserMasterBeans user = (UserMasterBeans) session.getAttribute("user");
		 String emailAddress = user.getEmailAddress();
*/


		/*//sessionからランチIDのを持ってくる
		 HttpSession session = request.getSession();
		 LunchDiaryBeans ldbeans = (LunchDiaryBeans) session.getAttribute("ldbeans");
		 String lunchId = ldbeans.get lunchId();*/

	     //メールアドレスで誰のランチ日記かは識別できたのではないか。
	   //ランチ日記はいくつも１個１個の日記があるため、どの日記の情報を持ってくるかを検索する必要がある

//らんちID で識別できる

	     /* if(myLunch.size()==0) {
					request.setAttribute("myLunch", null);
				}
				else {
			// 検索結果をリクエストスコープに格納する
					request.setAttribute("myLunch", myLunch);
				}*/

