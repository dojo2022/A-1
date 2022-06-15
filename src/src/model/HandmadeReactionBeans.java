package model;
import java.io.Serializable;

public class HandmadeReactionBeans implements Serializable{

	//メンバ変数
	private int hdReactionId;
	private int handmadeId;
	private String emailAddress;
	private int hdToEat;
	private int hdToTell;
	private int hdToUse;

	//ゲッターとセッター
	public int getHdReactionId() {
		return hdReactionId;
	}
	public void setHdReactionId(int hdReactionId) {
		this.hdReactionId = hdReactionId;
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
	public int getHdToEat() {
		return hdToEat;
	}
	public void setHdToEat(int hdToEat) {
		this.hdToEat = hdToEat;
	}
	public int getHdToTell() {
		return hdToTell;
	}
	public void setHdToTell(int hdToTell) {
		this.hdToTell = hdToTell;
	}
	public int getHdToUse() {
		return hdToUse;
	}
	public void setHdToUse(int hdToUse) {
		this.hdToUse = hdToUse;
	}


}
