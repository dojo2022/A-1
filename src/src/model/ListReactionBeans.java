package model;
import java.io.Serializable;

public class ListReactionBeans implements Serializable{

	//メンバ変数
	private int listReactionId;
	private int listId;
	private String emailAddress;
	private int listToGo;
	private int listToTell;
	private int listToUse;

	//ゲッターとセッター
	public int getListReactionId() {
		return listReactionId;
	}
	public void setListReactionId(int listReactionId) {
		this.listReactionId = listReactionId;
	}
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getListToGo() {
		return listToGo;
	}
	public void setListToGo(int listToGo) {
		this.listToGo = listToGo;
	}
	public int getListToTell() {
		return listToTell;
	}
	public void setListToTell(int listToTell) {
		this.listToTell = listToTell;
	}
	public int getListToUse() {
		return listToUse;
	}
	public void setListToUse(int listToUse) {
		this.listToUse = listToUse;
	}


}
