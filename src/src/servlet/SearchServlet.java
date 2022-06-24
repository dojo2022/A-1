package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LunchDiaryDAO;
import model.AllColumnBeans;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*		HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/meishiApp/LoginServlet");
					return;
				}*/
		//リクエストパラメータ（ラジオボックスがどっちに押されているかで分岐する）
		request.setCharacterEncoding("UTF-8");


			//リクエストパラメータ（検索ボックスに入力された文字列の情報）を取得する
			request.setCharacterEncoding("UTF-8");
			String resName = request.getParameter("resName");
			String category = request.getParameter("category");
			String cost = request.getParameter("cost");
			String time = request.getParameter("time");
			String distance = request.getParameter("distance");


			//検索処理を行う
			LunchDiaryDAO LdDao = new LunchDiaryDAO();
			ArrayList<AllColumnBeans> searchLunch =LdDao.selectLunch(resName, category, cost, time, distance);
			System.out.println(searchLunch.size());
			request.setAttribute("searchLunch", searchLunch);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
			dispatcher.forward(request, response);
//			検索が行われたら、その情報をフォワードした際に表示できるようにする-------------
//			//日記情報をゲットしてくる
////			LunchDiaryDAO LdDao = new LunchDiaryDAO();
//			ArrayList<AllColumnBeans> allLunch = LdDao.select();
//			// 検索結果をリクエストスコープに格納する
//			request.setAttribute("allLunch", allLunch);
//
//			//ランチ日記リアクション情報をゲットしてくる
//			LdJoin2DAO LdRDao = new LdJoin2DAO();
//			ArrayList<AllColumnBeans> ldReactionList = LdRDao.countReactionUser();
//			// 検索結果をリクエストスコープに格納する
//			request.setAttribute("ldReactionList", ldReactionList);
//
//			//ランチ日記コメント情報をゲットしてくる
//			LdJoin2DAO LdCDao = new LdJoin2DAO();
//			ArrayList<AllColumnBeans> LdComment = LdCDao.selectComment();
//			// 検索結果をリクエストスコープに格納する
//			request.setAttribute("LdComment", LdComment);
//	//----------------------------手作り日記の情報-------------------------------------
////			手作り日記の情報を貰ってくる
//			HandmadeDiaryDAO hdDao = new HandmadeDiaryDAO();
//		    ArrayList<AllColumnBeans> myHandmade = hdDao.select();
//		    // 検索結果をリクエストスコープに格納する
//		    request.setAttribute("myHandmade", myHandmade);
////			手作り日記リアクション情報をゲットしてくる
////			LdJoin2DAO LdRDao = new LdJoin2DAO();
//			ArrayList<AllColumnBeans> hdReactionList = LdRDao.countReactionUser();
//			// 検索結果をリクエストスコープに格納する
//			request.setAttribute("hdReactionList", hdReactionList);
//		    //手作り日記コメント情報をゲットしてくる
//		 	HdCommentDAO HCDao = new HdCommentDAO();
//		 	ArrayList<AllColumnBeans> HdComment = HCDao.selectHdComment();
////			検索結果をリクエストスコープに格納する
//		 	request.setAttribute("HdComment", HdComment);
//
//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
//			dispatcher.forward(request, response);
//
//		}else {
//			//リクエストパラメータ（検索ボックスに入力された文字列の情報）を取得する
//			request.setCharacterEncoding("UTF-8");
//			String time = request.getParameter("time");
//			String food_name = request.getParameter("food_name");
//			//検索処理を行う
//			HandmadeDiaryDAO HdDao = new HandmadeDiaryDAO();
//			ArrayList<HandmadeDiaryBeans> handmadeDiary =HdDao.selectHandmade(time,food_name);
//
//			request.setAttribute("handmadeDiary", handmadeDiary);
//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
//			dispatcher.forward(request, response);
		}




//		request.setCharacterEncoding("UTF-8");
////		Integer ld_comment_id = Integer.parseInt(request.getParameter("ld_comment_id"));
//		HttpSession session = request.getSession();
//		UserMasterBeans user = (UserMasterBeans)session.getAttribute("user");
//		String email_address = user.getEmailAddress();
//		Integer lunch_id = Integer.parseInt(request.getParameter("lunch_id"));
//		String ld_comment =request.getParameter("ld_comment");
//
//
//		LdCommentDAO ldcDao = new LdCommentDAO();
////		ArrayList<AllColumnBeans> ldCommentList = ldcDao.selectComment(new AllColumnBeans(ld_comment_id,email_address,lunch_id,ld_comment));
//		ldcDao.insertLdComment(0, lunch_id, email_address, ld_comment);


	}


