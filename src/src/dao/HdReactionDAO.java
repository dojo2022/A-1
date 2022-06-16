package dao;


import java.util.List;

import model.HandmadeReactionBeans;

public class HdReactionDAO {

	//手作り日記にスタンプを押した件数とユーザーを検索するメソッド
	public List<HandmadeReactionBeans> selectHdReaction(int hdReactionId, int handmadeId, String emailAddress, int hdToEat, int hdToTell, int hdToUse) {
		/*
		Connection conn = null;
		List<HandmadeReactionBeans> cardList = new ArrayList<HandmadeReactionBeans>();
		*/
		return null;
	}

	//手作り日記のスタンプを登録するメソッド
	public boolean insertLdReaction(int hdReactionId, int handmadeId, String emailAddress, int hdToEat, int hdToTell, int hdToUse) {
		/*
		Connection conn = null;
		boolean result = false;
		*/
		return false;
	}

	//手作り日記のスタンプを解除するメソッド
	public boolean deleteLdReaction(int hdReactionId) {
		/*
		Connection conn = null;
		boolean result = false;
		*/
		return false;
	}
}

