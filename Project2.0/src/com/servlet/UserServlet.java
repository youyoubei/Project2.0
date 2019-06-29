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
		// (1)获取数据库中所有待查询的数据
		UserDao dao = new UserDao();
		List<User> users = dao.showUsers();

		// (2)将数据保存在 请求周期中
		request.setAttribute("users", users);

		// (3)迁移界面
		request.getRequestDispatcher("/conect.jsp").forward(request, response);
         
	}

	public void removeUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 接收要删除数据的 ID 号
		int id = Integer.parseInt(request.getParameter("uid"));

		UserDao dao = new UserDao();

		dao.removeUserById(id);

		// 页面迁移
		// request.getRequestDispatcher("/servlet/GetUsersServlet").forward(request,
		// response);
		findAll(request, response);
	}

	// 根据ID查一个数据
	public void getUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取将要修改数据的ID号
		int id = Integer.parseInt(request.getParameter("uid"));
		// 利用Dao层查询出当前数据
		UserDao dao = new UserDao();
		User user = dao.getUserById(id);
		// 保存中途的参数
		request.setAttribute("user", user);
		// 页面迁移
		request.getRequestDispatcher("/showuser.jsp")
				.forward(request, response);
	}

	public void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// (1) 获取客户端的参数
		int uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String uemail = request.getParameter("uemail");
		// (2)构造 Pojo 模型
		User user = new User();
		user.setUid(uid);
		user.setUname(uname);
		user.setUpwd(upwd);
		user.setUemail(uemail);
		// (3) 保存 pojo 对象
		UserDao dao = new UserDao();
		dao.updateUserById(user);

		// 页面迁移
		// request.getRequestDispatcher("/servlet/GetUsersServlet").forward(request,
		// response);
		findAll(request, response);
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获得参数
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		// 获取会话 (httpSession)
		HttpSession session = request.getSession();

		UserDao dao = new UserDao();
		User user = dao.check(name, pwd);
		if (user != null) {

			System.out.println("当前 Session ID : " + session.getId());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");

			Date date = new Date();
			date.setTime(session.getCreationTime());
			System.out.println("当前会话创建时间" + sdf.format(date));

			date.setTime(session.getLastAccessedTime());
			System.out.println("Session 的最后访问时间 : " + sdf.format(date));
			session.setAttribute("userInfo", user); // 在 HttpSession 作用域下 放入数据 /
													// 会保存一段时间
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("../Userlogin.jsp");
		}

	}

	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取会话 (httpSession)
		HttpSession session = request.getSession();

		session.invalidate();// 让 HttpSession 失效 / 也可以叫做过期 .
		request.getRequestDispatcher("/Userlogin.jsp").forward(request,
				response);
	}

}
