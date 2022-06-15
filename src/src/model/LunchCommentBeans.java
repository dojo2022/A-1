package model;
import java.io.Serializable;

public class LunchCommentBeans implements Serializable{

	//メンバ変数
	private int ldCommentId;
	private int lunchId;
	private String emailAddress;
	private String ldComment;

	//ゲッターとセッター
	public int getLdCommentId() {
		return ldCommentId;
	}
	public void setLdCommentId(int ldCommentId) {
		this.ldCommentId = ldCommentId;
	}
	public int getLunchId() {
		return lunchId;
	}
	public void setLunchId(int lunchId) {
		this.lunchId = lunchId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getLdComment() {
		return ldComment;
	}
	public void setLdComment(String ldComment) {
		this.ldComment = ldComment;
	}


}
