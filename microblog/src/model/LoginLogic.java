package model;

import dao.AccountsDao;

public class LoginLogic {

	public boolean execute(User user) {
		AccountsDao dao = new AccountsDao();
		Account account = dao.searchAccount(user);

		return (account != null);
	}

//	public boolean execute(User user) {
//		//当座の動作確認のため
//		//渡されたuserのnameとpassがuser/1234と一致すればtrue
//		return (user.getName().equals("user") && user.getPass().equals("1234"));
//	}

}
