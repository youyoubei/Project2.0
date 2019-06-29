package com.dao;

import java.util.List;

import com.dbutil.DaoSupport;
import com.pojo.User;

public class UserDao extends DaoSupport {
	// ����û��ķ���
	public void saveUser(User user) {
		String sql = "insert into user (uname,upwd,uemail)values(?,?,?)";
		Object[] params = { user.getUname(), user.getUpwd(), user.getUemail() };
		int a = execOther(sql, params);
		System.out.println(a + "�б����");
	}

	// �鿴����ע���û�
	@SuppressWarnings("unchecked")
	public List<User> showUsers() {
		return executeQuery("select * from user", User.class, null);
	}

	public void removeUserById(int id) {
		// ׼��SQL���
		String sql = "delete from user where uid= ?"; // ��Ӽ�¼��sql
		// ׼�������б�
		Object[] params = { id };
		int affectRows = execOther(sql, params);

		System.out.println(affectRows + " �м�¼��ɾ���� !");

	}

	public User getUserById(int id) {
		// ׼��SQL
		String sql = "select * from user  where uid = ? ";
		System.out.println(sql);
		Object[] params = { id };

		List<User> users = executeQuery(sql, User.class, params);

		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public void updateUserById(User user) {

		String sql = "update user set uname = ? , upwd = ? , uemail=? where uid = ?";
		Object[] params = { user.getUname(), user.getUpwd(), user.getUemail(),
				user.getUid() };
		int affectRows = execOther(sql, params);

		System.out.println(affectRows + " �����ݱ��޸��� ......");
	}

	// ��֤��¼ʱ�����������
	@SuppressWarnings("unchecked")
	public User check(String name, String pass) {
		String sql = "select * from user where uname=? and upwd=?";
		Object[] params = { name, pass };
		List<User> user = executeQuery(sql, User.class, params);
		if (user != null && user.size() > 0) {
			return user.get(0);
		}
		return null;
	}

}
