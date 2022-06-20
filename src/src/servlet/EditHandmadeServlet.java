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

import dao.HandmadeDiaryDAO;

/**
 * Servlet implementation class EditHandmadeServlet
 */
@MultipartConfig(location = "C:\\pleiades\\workspace\\lunchBox\\WebContent\\images") // アップロードファイルの一時的な保存先
@WebServlet("/EditHandmadeServlet")
public class EditHandmadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//手作り日記編集画面ににフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String foodName = request.getParameter("foodName");
		Part foodPhoto = request.getPart("foodPhoto");
		String cookTime = request.getParameter("cookTime");
		String date = request.getParameter("date");
		String cost = request.getParameter("cost");
		String star = request.getParameter("star");
		String feeling = request.getParameter("feeling");
/*
		String image = this.getFileName(foodPhoto);
		request.setAttribute("image", image);
		*/
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある


		//DAOを呼び出す
		HandmadeDiaryDAO hDao = new HandmadeDiaryDAO();
/*
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (hDao.update(foodName,foodPhoto, cookTime,date,cost,star,feeling)) {	// 更新成功
				request.setAttribute("result",("手作り日記を更新しました。"));
		}
		else {												// 更新失敗
			request.setAttribute("result",("手作り日記を更新できませんでした。"));
		}
			}
		else {
			if (hDao.delete(number)) {	// 削除成功
				request.setAttribute("result",
				new Result("手作り日記を削除しました。"));
		}
		else {						// 削除失敗
			request.setAttribute("result",
			new Result("手作り日記を削除できませんでした。"));
					}
				}
*/
		//タイムラインに遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
		}
}
