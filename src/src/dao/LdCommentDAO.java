package dao;

import java.util.ArrayList;

import model.LunchCommentBeans;

public class LdCommentDAO {

//	ランチ日記のコメントを検索するメソッド
	public ArrayList<LunchCommentBeans> selectHdComment(int ldCommentId, int lunchId, String emailAddress, String ldComment) {
		return null;
	}

	//手作り日記のコメントを登録するメソッド
	public boolean insertLdComment(int ldCommentId, int lunchId, String emailAddress, String ldComment) {
		return false;
	}


}
