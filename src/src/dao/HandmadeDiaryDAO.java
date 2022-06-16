package dao;

import java.util.ArrayList;

import model.HandmadeDiaryBeans;

public class HandmadeDiaryDAO {

	//手作り日記の検索を行うメソッド（タイムラインの検索ボックス用）
	public ArrayList<HandmadeDiaryBeans> selectHandmade(String cooktime, String hdFoodName) {
		return null;
	}

	//手作り日記の全件検索を行うメソッド(タイムライン表示用)
	public ArrayList<HandmadeDiaryBeans> select() {
		return null;
	}

	//手作り日記の更新を行うメソッド
	public boolean updateHd(String hdFoodphoto, String hdCategory, String hdDate, String hdCost, String hdStar, String hdFeeling, String cooktime) {
		return false;
	}

	//手作り日記の論理削除を行うメソッド
	public boolean updateHdFlag(int handmadeFlag) {
		return false;
	}
}
