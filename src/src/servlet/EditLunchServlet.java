package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LunchDiaryDAO;

/**
 * Servlet implementation class EditLunchServlet
 */
@WebServlet("/EditLunchServlet")
public class EditLunchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;
	private ServletResponse response;



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

			 request.setCharacterEncoding("UTF-8");
			if(request.getParameter("SUBMIT")!=null) {
				if(request.getParameter("SUBMIT").equals("編集")) {



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
		if(request.getParameter("star") != null) {
			 star = Integer.parseInt(request.getParameter("star"));
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




		//ランチ日記更新削除画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
		dispatcher.forward(request, response);
		return;
			}

		}

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
				if(request.getParameter("star") != null) {
					 star = Integer.parseInt(request.getParameter("star"));
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


		if (request.getParameter("updateButton").equals("更新する")) {
			boolean ans = ldDao.updateLd(lunchId,ldFoodType,resName, foodPhoto, category, style, date,foodName, cost,time,distance, star, feeling);

		//更新成功したら
		if(ans == true) {
			request.setAttribute("msg","更新が完了しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
		//更新が失敗したら
		}else {
			request.setAttribute("msg","更新失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
			dispatcher.forward(request, response);
			return;
			}
		}

		else {
			//DAOに削除してねって依頼をする
			boolean ans = ldDao.updateLdFlag(lunchId);

			//論理削除成功時
			if(ans == true) {
				request.setAttribute("msg","削除が完了しました");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
				dispatcher.forward(request, response);

			//論理削除失敗時
			}else {
				request.setAttribute("msg","削除に失敗しました");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
				dispatcher.forward(request, response);
				return;
				}
			}


		//タイムラインに遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
			return;
			}





		}






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

