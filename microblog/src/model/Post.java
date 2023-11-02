package model;

public class Post {
	private String userName;
	private String text;
	public Post() {}
	public Post(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	public String getUserName() {return userName;}
	public String getText() {return text;}

}
