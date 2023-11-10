package model;
import java.io.Serializable;

@SuppressWarnings("unused")
public class Post implements Serializable {
	private int id;
	private String userName;
	private String text;

	public Post() {}
	public Post(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	public Post(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}

	public int getId() {return id;}
	public String getUserName() {return userName;}
	public String getText() {return text;}

}
