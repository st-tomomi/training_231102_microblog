package model;

import dao.AccountsDao;

public class LoginLogic {

	public boolean execute(User user) {
		AccountsDao dao = new AccountsDao();
		Account account = dao.searchAccount(user);

		return (account != null);
	}

	//model "Login"を廃止したい
//	public boolean execute (Login login) {
//		AccountsDao dao = new AccountsDao();
//		Account account = dao.serchAccount(login);
//
//		//登録済みアカウントであればtrue
//		return (account != null);
//	}

//	public boolean execute(User user) {
//		//要修正
//		//当座の動作確認のため
//		//渡されたuserのnameとpassがuser/1234と一致すればtrue
//		return (user.getName().equals("user") && user.getPass().equals("1234"));
//	}

}
