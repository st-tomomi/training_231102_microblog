package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetPostListLogic;
import model.Post;
import model.PostTextLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {

		//記事リストを取得
		GetPostListLogic getPostListLogic =
				new GetPostListLogic();
		List<Post> postList = getPostListLogic.execute();
		request.setAttribute("postList", postList);
//		ServletContext application = this.getServletContext();
//
//		List<Post> postList =
//				(List<Post>) application.getAttribute("postList");
//
//		//記事リストなければ生成
//		if (postList == null) {
//			postList = new ArrayList<>();
//			application.setAttribute("postList", postList);
//		}

		//ユーザ情報取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			//未ログイン
			response.sendRedirect("/microblog/");
		} else {
			//ログイン済み メイン画面へ
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {

		//リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//テキストがnullでもなく長さ0でもないとき
		if(text != null && text.length() != 0) {
			//投稿リストを取得
//			ServletContext application = this.getServletContext();
//			List<Post> postList =
//					(List<Post>) application.getAttribute("postList");

			//ユーザ情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			//投稿を投稿リストに追加
			Post post = new Post(loginUser.getName(), text);
			PostTextLogic postTextLogic = new PostTextLogic();
			postTextLogic.execute(post);
//			Post post = new Post(loginUser.getName(), text);
//			PostTextLogic postTextLogic = new PostTextLogic();
//			postTextLogic.execute(post, postList);

			//投稿リストを保存
//			application.setAttribute("postList", postList);
		} else {
			//エラーメッセージを保存
			request.setAttribute("errorMsg", "This is a required field.");
		}

		//投稿をリクエストスコープに保存
		GetPostListLogic getPostListLogic =
				new GetPostListLogic();
		List<Post> postList = getPostListLogic.execute();
		request.setAttribute("postList", postList);

		//メイン画面へ
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
