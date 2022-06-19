package model;

import java.io.Serializable;

public class UserMasterBeans implements Serializable{

	//メンバ変数
	private String emailAddress;
	private String pw;
	private String accountName;
	private String depName;
	private int userFlag;
	private String icon;
	private int range;
	private String reason;

	//ゲッターとセッター
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public int getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(int userFlag) {
		this.userFlag = userFlag;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}


}
