package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.UserDao;
import com.pojo.Product;
import com.util.FormUtil;
import com.util.PageBean;


@SuppressWarnings({ "serial", "unused" })
public class ProductServlet extends HttpServlet {


	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String method=request.getParameter("method");
		if("addproduct".equals(method)){
			addproduct(request,response);
		}
		else if("delproduct".equals(method)){
			delproduct(request,response);
		}
		else if("showProducts".equals(method)){
			showProducts(request,response);
		}
		else if("showProduct".equals(method)){
			showProduct(request,response);
		}
		else if("showProductsByPage".equals(method)){
			showProductsByPage(request,response);
		}
		else if("selectProduct".equals(method)){
			selectProduct(request,response);
		}
		else{
			showProductsByPage(request,response);
		}
	}
	//�����Ʒ�ķ���
	public void addproduct(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
      FormUtil form = new FormUtil();
      Product product =(Product)form.getInstanceByAdvanceForm(request,getServletContext(),Product.class,"upload");
      //System.out.println("shurushangpingwei"+product.getAmount());
      ProductDao dao =new ProductDao();
      dao.addProduct(product);
      showProductsByPage(request,response);
   }
	//��ʾ������Ʒ
	public void showProducts(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ProductDao dao =new ProductDao();
		request.setAttribute("products", dao.showProducts());
		//ҳ��Ǩ��
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	//��ҳ��ʾ��Ʒ
	public void showProductsByPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//Ĭ�������״ν���Servletʱ��ǰҳ����Ϊ1
		int currentPage=1;
		String pageCode=request.getParameter("pageCode");
		if(pageCode!=null){
			currentPage=Integer.parseInt(pageCode);
		}
		ProductDao dao  = new ProductDao();
		PageBean pageBean=dao.getPageBean(currentPage, 5);
		request.setAttribute("pageBean", pageBean);
		System.out.println("page"+pageBean);
		//ҳ��Ǩ��
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}
	
	//��ѯ������Ʒ
	public void showProduct(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pname=request.getParameter("name");
		String pid = request.getParameter("id");
		request.setAttribute("pid", pid);
		//ҳ��Ǩ��
		request.getRequestDispatcher("/"+pname+".jsp").forward(request, response);
	}
	//ɾ����Ʒ
	public void delproduct(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		System.out.println("id"+id);
		ProductDao dao =new ProductDao();
		dao.delete(id);
		showProductsByPage(request,response);
	}
	
	//��������ʾ��Ʒ
	public void selectProduct(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String name = request.getParameter("name");
		ProductDao dao =new ProductDao();
		request.setAttribute("products", dao.se(name));
		//ҳ��Ǩ��
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
