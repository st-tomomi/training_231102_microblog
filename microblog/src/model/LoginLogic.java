package model;

public class LoginLogic {
	public boolean execute(User user) {

		//要修正
		//当座の動作確認のため
		return (user.getName().equals("user") && user.getPass().equals("1234"));
	}

}
