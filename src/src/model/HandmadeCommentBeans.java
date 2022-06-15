package model;
import java.io.Serializable;

public class HandmadeCommentBeans implements Serializable{

	//メンバ変数
	private int hdCommentId;
	private int handmadeId;
	private String emailAddress;
	private String hdComment;

	//ゲッターとセッター
	public int getHdCommentId() {
		return hdCommentId;
	}
	public void setHdCommentId(int hdCommentId) {
		this.hdCommentId = hdCommentId;
	}
	public int getHandmadeId() {
		return handmadeId;
	}
	public void setHandmadeId(int handmadeId) {
		this.handmadeId = handmadeId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getHdComment() {
		return hdComment;
	}
	public void setHdComment(String hdComment) {
		this.hdComment = hdComment;
	}



}
