package dao;

import java.util.ArrayList;

import model.AllColumnBeans;

public class TestLdJoin2DAO {

	public static void main(String[] args) {
		LdJoin2DAO dao = new LdJoin2DAO();
		ArrayList<AllColumnBeans> bean = dao.selectComment();
		System.out.println(bean.size());


	}

}
