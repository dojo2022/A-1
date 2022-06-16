package dao;

import java.util.ArrayList;

import model.LunchReactionBeans;

public class LdReactionDAO {

	//ランチ日記のスタンプの件数とユーザーの検索を行うメソッド
	public ArrayList<LunchReactionBeans> selectLdReaction(int ldReactionId, int lunchId, String emailAddress, int ldToGo, int ldToTell, int ldToUse) {
		/*
		Connection conn = null;
		ArrayList<LunchReactionBeans> cardList = new ArrayList<LunchReactionBeans>();
		*/
		return null;
	}

	//ランチ日記のスタンプを登録するメソッド
	public boolean insertLdReaction(int ldReactionId, int lunchId, String emailAddress, int ldToGo, int ldToTell, int ldToUse) {
		/*
		Connection conn = null;
		boolean result = false;
		*/
		return false;
	}

	//ランチ日記のスタンプを削除するメソッド
	public boolean deleteLdReaction(int ldReactionId) {
		/*
		Connection conn = null;
		boolean result = false;
		*/
		return false;
	}
}
