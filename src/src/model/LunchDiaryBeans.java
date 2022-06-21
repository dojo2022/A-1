package model;

import java.io.Serializable;
public class LunchDiaryBeans implements Serializable{

	//メンバ変数
	private int lunchId;
	private String emailAddress;
	private String ldResName;
	private String ldFoodPhoto;
	private String ldCategory;
	private String style;
	private String ldDate;
	private String ldFoodName;
	private String ldCost;
	private String time;
	private String distance;
	private int ldStar;
	private String ldFeeling;
	private int lunchFlag;
	private String ldRegistTime;


	//ゲッターとセッター
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
	public String getLdResName() {
		return ldResName;
	}
	public void setLdResName(String resName) {
		this.ldResName = resName;
	}
	public String getLdFoodPhoto() {
		return ldFoodPhoto;
	}
	public void setLdFoodPhoto(String ldFoodPhoto) {
		this.ldFoodPhoto = ldFoodPhoto;
	}
	public String getLdCategory() {
		return ldCategory;
	}
	public void setLdCategory(String ldCategory) {
		this.ldCategory = ldCategory;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getLdDate() {
		return ldDate;
	}
	public void setLdDate(String ldDate) {
		this.ldDate = ldDate;
	}
	public String getLdFoodName() {
		return ldFoodName;
	}
	public void setLdFoodName(String ldFoodName) {
		this.ldFoodName = ldFoodName;
	}
	public String getLdCost() {
		return ldCost;
	}
	public void setLdCost(String ldCost) {
		this.ldCost = ldCost;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public int getLdStar() {
		return ldStar;
	}
	public void setLdStar(int ldStar) {
		this.ldStar = ldStar;
	}
	public String getLdFeeling() {
		return ldFeeling;
	}
	public void setLdFeeling(String ldFeeling) {
		this.ldFeeling = ldFeeling;
	}
	public int getLunchFlag() {
		return lunchFlag;
	}
	public void setLunchFlag(int lunchFlag) {
		this.lunchFlag = lunchFlag;
	}
	public String getLdRegistTime() {
		return ldRegistTime;
	}
	public void setLdRegistTime(String ldRegistTime) {
		this.ldRegistTime = ldRegistTime;
	}



}
