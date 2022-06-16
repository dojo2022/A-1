package dao;

public class ListDAO {

	//行きたい場所リストの登録を行うメソッド
	public boolean insertList(int listId ,String emailAddress, String listResName, String listCategory, String togoMemo) {
		return false;
	}

	//行きたい場所リストの更新を行うメソッド
	public boolean updateList(String emailAddress, int listFlag) {
		return false;
	}

	//行きたい場所リストの論理削除を行うメソッド
	public boolean updateListFlag(String emailAddress, int listFlag) {
		return false;
	}

	//行きたい場所リストの公開範囲を変更するメソッド
	public boolean updateRange(String emailAddress, int range) {
		return false;
	}

}
