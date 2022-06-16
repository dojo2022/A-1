package dao;

import java.util.ArrayList;

import model.ListReactionBeans;

public class ListReactionDAO {

	//行きたい場所リストにスタンプを押した件数とユーザーを検索するメソッド
	public ArrayList<ListReactionBeans> selectListReaction(int listReactionId, String emailAddress, int listToGo, int listToTell, int listToUse){
		return null;
	}

	//行きたい場所リストのスタンプを登録するメソッド
	public boolean insertListReaction(int listReactionId, String emailAddress, int listToGo, int listToTell, int listToUse) {
		return false;
	}

	//行きたい場所リストのスタンプを解除するメソッド
	public boolean deleteListReaction(int listReactionId, String emailAddress, int listToGo, int listToTell, int listToUse) {
		return false;
	}

}
