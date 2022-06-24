package model;
import java.io.Serializable;

public class HandmadeDiaryBeans implements Serializable{

	//メンバ変数
	private int handmadeId;
	private String emailAddress;
	private String hdFoodType;
	private String hdFoodPhoto;
	private String hdCategory;
	private String hdDate;
	private String hdFoodName;
	private String hdCost;
	private int hdStar;
	private String hdFeeling;
	private String cooktime;
	private String handmadeFlag;
	private String ldRegistTime;

	//ゲッターとセッター
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
	public String getHdFoodType() {
		return hdFoodType;
	}
	public void setHdFoodType(String hdFoodType) {
		this.hdFoodType = hdFoodType;
	}
	public String getHdFoodPhoto() {
		return hdFoodPhoto;
	}
	public void setHdFoodPhoto(String hdFoodPhoto) {
		this.hdFoodPhoto = hdFoodPhoto;
	}
	public String getHdCategory() {
		return hdCategory;
	}
	public void setHdCategory(String hdCategory) {
		this.hdCategory = hdCategory;
	}
	public String getHdDate() {
		return hdDate;
	}
	public void setHdDate(String hdDate) {
		this.hdDate = hdDate;
	}
	public String getHdFoodName() {
		return hdFoodName;
	}
	public void setHdFoodName(String hdFoodName) {
		this.hdFoodName = hdFoodName;
	}
	public String getHdCost() {
		return hdCost;
	}
	public void setHdCost(String hdCost) {
		this.hdCost = hdCost;
	}
	public int getHdStar() {
		return hdStar;
	}
	public void setHdStar(int hdStar) {
		this.hdStar = hdStar;
	}
	public String getHdFeeling() {
		return hdFeeling;
	}
	public void setHdFeeling(String hdFeeling) {
		this.hdFeeling = hdFeeling;
	}
	public String getCooktime() {
		return cooktime;
	}
	public void setCooktime(String cooktime) {
		this.cooktime = cooktime;
	}
	public String getHandmadeFlag() {
		return handmadeFlag;
	}
	public void setHandmadeFlag(String handmadeFlag) {
		this.handmadeFlag = handmadeFlag;
	}
	public String getLdRegistTime() {
		return ldRegistTime;
	}
	public void setLdRegistTime(String ldRegistTime) {
		this.ldRegistTime = ldRegistTime;
	}


}
