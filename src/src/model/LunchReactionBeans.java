package model;
import java.io.Serializable;

public class LunchReactionBeans implements Serializable{

	//メンバ変数
	private int ldReactionId;
	private int lunchId;
	private String emailAddress;
	private int ldToGo;
	private int ldToTell;
	private int ldToUse;

	//ゲッターとセッター
	public int getLdReactionId() {
		return ldReactionId;
	}
	public void setLdReactionId(int ldReactionId) {
		this.ldReactionId = ldReactionId;
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
	public int getLdToGo() {
		return ldToGo;
	}
	public void setLdToGo(int ldToGo) {
		this.ldToGo = ldToGo;
	}
	public int getLdToTell() {
		return ldToTell;
	}
	public void setLdToTell(int ldToTell) {
		this.ldToTell = ldToTell;
	}
	public int getLdToUse() {
		return ldToUse;
	}
	public void setLdToUse(int ldToUse) {
		this.ldToUse = ldToUse;
	}


}
