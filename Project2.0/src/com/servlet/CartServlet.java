package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.pojo.Product;
import com.util.BuyItem;
import com.util.Cart;

@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
         String method=request.getParameter("method");
          if("addCart".equals(method)){
	       addCart(request,response);
     }
          else if("deleteCart".equals(method)){
	       deleteCart(request,response);
     }
          else if("updateCart".equals(method)){
	       updateCart(request,response);
     }
          else if("adddel".equals(method)){
	       adddel(request,response);
   }
          else if("showOrder".equals(method)){
        	  showOrder(request,response);
          }
}
//�����Ʒ����
public void addCart(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {

          HttpSession session = request.getSession();
          //��ȡ���ﳵ
          Cart cart = session.getAttribute("cart")==null?new Cart():(Cart)session.getAttribute("cart");
          //��ȡ����Ĳ�Ʒ
          int pid = Integer.parseInt(request.getParameter("pid"));
          ProductDao dao = new ProductDao();
          Product product = dao.selectProduct(pid);
          if(product!=null){
	        BuyItem buyItem = new BuyItem(product,1);
	        cart.addToCart(buyItem);
  }

            session.setAttribute("cart", cart);
            showCart(request,response);
 }   
//��ʾ��Ʒ
public void showCart(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
     request.getRequestDispatcher("/showCart.jsp").forward(request, response);
}
//�Ƴ���Ʒ����
public void deleteCart(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            //��ȡ���ﳵ
            HttpSession sion = request.getSession();
            Cart cart = (Cart)sion.getAttribute("cart");
            //��ȡҪɾ����Ʒ��ID
            int pid=Integer.parseInt(request.getParameter("pid"));
            System.out.println(pid);
            for (Iterator<BuyItem> iterator = cart.getItems().iterator(); iterator.hasNext();) {
	          BuyItem item = (BuyItem) iterator.next();
	        if( pid == item.getProduct().getPid()) {
		        iterator.remove();
		           break;
	}
}
           //���±��湺�ﳵ
           sion.setAttribute("cart", cart);
           showCart(request,response);
}
public void updateCart(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
	//�ֱ��ȡ ��Ҫ�޸ĵĲ�ƷID  ��  �޸�����
	int pid = Integer.parseInt(request.getParameter("id"));
	int count = Integer.parseInt(request.getParameter("acount"));
	//��ȡ���ﳵ
	HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	//�ҵ���Ҫ�޸ĵ���Ʒ , ������������Ϊ���º��ֵ
	for (Iterator<BuyItem> iterator = cart.getItems().iterator(); iterator.hasNext();) {
		BuyItem item = (BuyItem) iterator.next();
		if( pid == item.getProduct().getPid()) {
			item.setAmount(count);
			break;
		}
	}
	//���µĹ��ﳵ�����·��õ� Session ��������
	session.setAttribute("cart", cart);
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	out.print(cart.getTotalPrice());
	System.out.println(cart.getTotalPrice());
	out.flush();
	out.close();
}

public void adddel(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
	String type=request.getParameter("type");
	int pid = Integer.parseInt(request.getParameter("id"));
	int a=0;
	if("add".equals(type)) a=1;
	else if("del".equals(type)) a=-1;
	HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	//�ҵ���Ҫ�޸ĵ���Ʒ , ������������Ϊ���º��ֵ
	for (Iterator<BuyItem> iterator = cart.getItems().iterator(); iterator.hasNext();) {
		BuyItem item = (BuyItem) iterator.next();
		if( pid == item.getProduct().getPid()) {
			item.setAmount(item.getAmount()+a);
			break;
		}
	}
	session.setAttribute("cart", cart);
	showCart(request,response);
}

public void showOrder(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
	HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	session.setAttribute("cart", cart);
	//ҳ��Ǩ��
	request.getRequestDispatcher("/showOrder.jsp").forward(request, response);
}


}
