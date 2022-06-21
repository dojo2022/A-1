package model;
import java.io.Serializable;

public class AllColumnBeans implements Serializable{

	//メンバ変数
	//UserMaster
	private String emailAddress;
	private String pw;
	private String accountName;
	private String depName;
	private int userFlag;
	private String icon;
	private String reason;

	//LunchDiary
	private int lunchId;
	private String ldfoodType;
	private String ldFoodPhoto;
	private String ldResName;
	private String ldFoodType;
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

	//HandMadeDiary
	private int handmadeId;
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
	private String hdRegsitTime;

	//Togolist
	private int listId;
	private String listResName;
	private String listCategory;
	private String togoMemo;
	private int range;
	private int listFlag;

	//LunchReaction
	private int ldReactionId;
	private int ldToGo;
	private int ldToTell;
	private int ldToUse;

	//HandMadeReaction
	private int hdReactionId;
	private int hdToEat;
	private int hdToTell;
	private int hdToUse;

	//ListReaction
	private int listReactionId;
	private int listToGo;
	private int listToTell;
	private int listToUse;

	//LunchComment
	private int ldCommentId;
	private String ldComment;

	//HandMadeComment
	private int hdCommentId;
	private String hdComment;

	//join用のbeans
	private int countLdToGo;
	private int countLdToTell;
	private int countLdToUse;
	private int countHdToEat;
	private int countHdToTell;
	private int countHdToUse;


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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getLunchId() {
		return lunchId;
	}
	public void setLunchId(int lunchId) {
		this.lunchId = lunchId;
	}
	public String getLdfoodType() {
		return ldfoodType;
	}
	public void setLdfoodType(String ldfoodType) {
		this.ldfoodType = ldfoodType;
	}
	public String getLdResName() {
		return ldResName;
	}
	public void setLdResName(String ldResName) {
		this.ldResName = ldResName;
	}
	public String getLdFoodType() {
		return ldFoodType;
	}
	public void setLdFoodType(String ldFoodType) {
		this.ldFoodType = ldFoodType;
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
	public int getHandmadeId() {
		return handmadeId;
	}
	public void setHandmadeId(int handmadeId) {
		this.handmadeId = handmadeId;
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
	public String getHdRegsitTime() {
		return hdRegsitTime;
	}
	public void setHdRegsitTime(String hdRegsitTime) {
		this.hdRegsitTime = hdRegsitTime;
	}
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
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
	public int getLdReactionId() {
		return ldReactionId;
	}
	public void setLdReactionId(int ldReactionId) {
		this.ldReactionId = ldReactionId;
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
	public int getHdReactionId() {
		return hdReactionId;
	}
	public void setHdReactionId(int hdReactionId) {
		this.hdReactionId = hdReactionId;
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
	public int getListReactionId() {
		return listReactionId;
	}
	public void setListReactionId(int listReactionId) {
		this.listReactionId = listReactionId;
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
	public int getLdCommentId() {
		return ldCommentId;
	}
	public void setLdCommentId(int ldCommentId) {
		this.ldCommentId = ldCommentId;
	}
	public String getLdComment() {
		return ldComment;
	}
	public void setLdComment(String ldComment) {
		this.ldComment = ldComment;
	}
	public int getHdCommentId() {
		return hdCommentId;
	}
	public void setHdCommentId(int hdCommentId) {
		this.hdCommentId = hdCommentId;
	}
	public String getHdComment() {
		return hdComment;
	}
	public void setHdComment(String hdComment) {
		this.hdComment = hdComment;
	}
	public int getCountLdToGo() {
		return countLdToGo;
	}
	public void setCountLdToGo(int countLdToGo) {
		this.countLdToGo = countLdToGo;
	}
	public int getCountLdToTell() {
		return countLdToTell;
	}
	public void setCountLdToTell(int countLdToTell) {
		this.countLdToTell = countLdToTell;
	}
	public int getCountLdToUse() {
		return countLdToUse;
	}
	public void setCountLdToUse(int countLdToUse) {
		this.countLdToUse = countLdToUse;
	}
	public int getCountHdToEat() {
		return countHdToEat;
	}
	public void setCountHdToEat(int countHdToEat) {
		this.countHdToEat = countHdToEat;
	}
	public int getCountHdToTell() {
		return countHdToTell;
	}
	public void setCountHdToTell(int countHdToTell) {
		this.countHdToTell = countHdToTell;
	}
	public int getCountHdToUse() {
		return countHdToUse;
	}
	public void setCountHdToUse(int countHdToUse) {
		this.countHdToUse = countHdToUse;
	}


}
