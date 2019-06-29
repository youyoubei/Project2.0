package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.pojo.User;

@SuppressWarnings({ "unused", "serial" })
public class UserServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("saveUser".equals(method)) {
			saveUser(request, response);
		} else if ("findAll".equals(method)) {
			findAll(request, response);
		} else if ("removeUser".equals(method)) {
			removeUser(request, response);

		} else if ("getUser".equals(method)) {

			getUser(request, response);
		} else if ("updateUser".equals(method)) {
			updateUser(request, response);
		} else if ("login".equals(method)) {
			login(request, response);
		} else if ("logout".equals(method)) {
			logout(request, response);
		}
	}

	public void saveUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		User user = new User();
		user.setUname(name);
		user.setUpwd(pwd);
		user.setUemail(email);
		UserDao dao = new UserDao();
		dao.saveUser(user);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/Userlogin.jsp").forward(request,
				response);
	}

	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// (1)��ȡ���ݿ������д���ѯ������
		UserDao dao = new UserDao();
		List<User> users = dao.showUsers();

		// (2)�����ݱ����� ����������
		request.setAttribute("users", users);

		// (3)Ǩ�ƽ���
		request.getRequestDispatcher("/conect.jsp").forward(request, response);
         
	}

	public void removeUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ����Ҫɾ�����ݵ� ID ��
		int id = Integer.parseInt(request.getParameter("uid"));

		UserDao dao = new UserDao();

		dao.removeUserById(id);

		// ҳ��Ǩ��
		// request.getRequestDispatcher("/servlet/GetUsersServlet").forward(request,
		// response);
		findAll(request, response);
	}

	// ����ID��һ������
	public void getUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ȡ��Ҫ�޸����ݵ�ID��
		int id = Integer.parseInt(request.getParameter("uid"));
		// ����Dao���ѯ����ǰ����
		UserDao dao = new UserDao();
		User user = dao.getUserById(id);
		// ������;�Ĳ���
		request.setAttribute("user", user);
		// ҳ��Ǩ��
		request.getRequestDispatcher("/showuser.jsp")
				.forward(request, response);
	}

	public void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// (1) ��ȡ�ͻ��˵Ĳ���
		int uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String uemail = request.getParameter("uemail");
		// (2)���� Pojo ģ��
		User user = new User();
		user.setUid(uid);
		user.setUname(uname);
		user.setUpwd(upwd);
		user.setUemail(uemail);
		// (3) ���� pojo ����
		UserDao dao = new UserDao();
		dao.updateUserById(user);

		// ҳ��Ǩ��
		// request.getRequestDispatcher("/servlet/GetUsersServlet").forward(request,
		// response);
		findAll(request, response);
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ò���
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		// ��ȡ�Ự (httpSession)
		HttpSession session = request.getSession();

		UserDao dao = new UserDao();
		User user = dao.check(name, pwd);
		if (user != null) {

			System.out.println("��ǰ Session ID : " + session.getId());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");

			Date date = new Date();
			date.setTime(session.getCreationTime());
			System.out.println("��ǰ�Ự����ʱ��" + sdf.format(date));

			date.setTime(session.getLastAccessedTime());
			System.out.println("Session ��������ʱ�� : " + sdf.format(date));
			session.setAttribute("userInfo", user); // �� HttpSession �������� �������� /
													// �ᱣ��һ��ʱ��
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("../Userlogin.jsp");
		}

	}

	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ȡ�Ự (httpSession)
		HttpSession session = request.getSession();

		session.invalidate();// �� HttpSession ʧЧ / Ҳ���Խ������� .
		request.getRequestDispatcher("/Userlogin.jsp").forward(request,
				response);
	}

}
