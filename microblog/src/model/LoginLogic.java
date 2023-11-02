package model;

public class LoginLogic {
	public boolean execute(User user) {
//		参考にしたテキスト通りのメソッド
//		if(user.getPass().equals("1234")) {
//			return true;
//		}
//		return false;

		return user.getPass().equals("1234");
	}

}
