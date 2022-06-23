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

import dao.MyPageDAO;
import model.AllColumnBeans;
import model.UserMasterBeans;

/**
 * Servlet implementation class EditLunchServlet
 */
@WebServlet("/EditLunchServlet")
public class EditLunchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditLunchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub




		//sessionからメールアドレスの情報を取ってくる
		 HttpSession session = request.getSession();
		 UserMasterBeans user = (UserMasterBeans) session.getAttribute("user");
		 String emailAddress = user.getEmailAddress();

		//メールアドレスを引数にしてランチ日記の情報を取ってくる-------------------------------------
	     MyPageDAO mDao = new MyPageDAO();
	     ArrayList<AllColumnBeans> myLunch = mDao.selectLd(emailAddress);
	  // 検索結果をリクエストスコープに格納する
	     request.setAttribute("myLunch", myLunch);

	   //メールアドレスで誰のランチ日記かは識別できたのではないか。
	   //ランチ日記はいくつも１個１個の日記があるため、どの日記の情報を持ってくるかを検索する必要がある



	     /* if(myLunch.size()==0) {
					request.setAttribute("myLunch", null);
				}
				else {
			// 検索結果をリクエストスコープに格納する
					request.setAttribute("myLunch", myLunch);
				}*/



		//「飛ばしたいページ」にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_diary.jsp");
		dispatcher.forward(request, response);
	}

	
	
	
	
	
	
	String restName = request.getParameter("resName");
	String foodPhoto = request.getParameter("foodPhoto");
	String depName = request.getParameter("depName");
	String emailAddress = request.getParameter("emailAddress");
	//int range = request.getParameter("range");
	int range = Integer.parseInt(request.getParameter("range"));
	String pwCheck = request.getParameter("pwCheck");
	
	
	
	request.setAttribute("image", icon);
	request.setAttribute("accountName", accountName);
	request.setAttribute("depName", depName);
	request.setAttribute("emailAddress", emailAddress);
	request.setAttribute("range", range);
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
