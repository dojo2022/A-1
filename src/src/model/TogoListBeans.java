package model;
import java.io.Serializable;

public class TogoListBeans implements Serializable{

	//メンバ変数
	private int listId;
	private String emailAddress;
	private String listResName;
	private String listCategory;
	private String togoMemo;
	private int range;
	private int listFlag;

	//ゲッターとセッター
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
	public String getListResName() {
		return listResName;
	}
	public void setListResName(String listResName) {
		this.listResName = listResName;
	}
	public String getListCategory() {
		return listCategory;
	}
	public void setListCategory(String listCategory) {
		this.listCategory = listCategory;
	}
	public String getTogoMemo() {
		return togoMemo;
	}
	public void setTogoMemo(String togoMemo) {
		this.togoMemo = togoMemo;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getListFlag() {
		return listFlag;
	}
	public void setListFlag(int listFlag) {
		this.listFlag = listFlag;
	}


}
