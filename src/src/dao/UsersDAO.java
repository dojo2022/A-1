package dao;

import java.util.ArrayList;

import model.UserMasterBeans;

public class UsersDAO {

	//引数として送られてきたメアドとパスワードに該当するデータがあるか検索するメソッド
	public boolean isLoginOK(String emailAddress, String pw) {
		return false;
	}

	//ユーザー情報の更新をするメソッド
	public boolean updateUser(String emailAddress, String pw, String accountName, String depName, int userFlag, String icon, String reason) {
		return false;
	}

	//フラグを更新するメソッド
	public boolean updateUserFlag(int userFlag) {
		return false;
	}

	//引数として送られてきたメアドに該当するユーザーを検索するメソッド
	public ArrayList<UserMasterBeans> selectUser(String emailAddress){
		return null;
	}

	//登録しているユーザーの全件検索を行うメソッド
	public ArrayList<UserMasterBeans> selectUser(){
		return null;
	}
}
