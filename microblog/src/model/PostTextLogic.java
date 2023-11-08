package model;

import dao.PostDAO;

public class PostTextLogic {
//	public void execute(Post post, List<Post> postList) {
//		postList.add(0, post);
//	}

	public void execute(Post post) {
		PostDAO dao = new PostDAO();
		dao.create(post);
	}

}
