package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.dbutil.DaoSupport;
import com.pojo.Product;
import com.pojo.User;
import com.util.PageBean;


@SuppressWarnings("unused")
public class ProductDao extends DaoSupport{
	

	
	//�����Ʒ�ķ���
	public void addProduct(Product product){
		String sql = "insert into product (pname,lid,amount,tags,cost,img,memory) values (?,?,?,?,?,?,?)";
		Object []params={product.getPname(),product.getLid(),product.getAmount(),product.getTags(), product.getCost() , product.getImg(),product.getMemory()};
		int a =execOther(sql, params);
		System.out.println(a+"����Ʒ�����");
	}
	
	//��ʾ������Ʒ�ķ���
	@SuppressWarnings("unchecked")
	public List<Product> showProducts(){
		return executeQuery("select * from product", Product.class, null);
	}
	
	//����ID��ѯ��Ʒ�Ա���빺�ﳵ
	@SuppressWarnings("unchecked")
	public Product selectProduct(int id){
		String sql="select * from product where pid=?";
		List<Product> products=executeQuery(sql, Product.class, id);
		if(products!=null&&products.size()>0){
			return products.get(0);
			
		}
		 return null;
	}
	
	//ɾ����Ʒ�ķ���
	public void delete(int pid){
		Object []id={pid};
		int a = execOther("delete from product where pid=?", id);
		System.out.println(a+"����Ʒ��ɾ��");
	}
	
	//������ʾ��Ʒ
	@SuppressWarnings("unchecked")
	public List<Product> se(String name){
		Object[] a ={name};
		return executeQuery("select * from product where lid =?", Product.class, a);
	}
	
	//��ʾ������Ʒ����Ϣ�Ա��޸�
	@SuppressWarnings("unchecked")
	public Product getProduct(int pid){
		Object []id={pid};
		List<Product> product=executeQuery("select * from product where pid=?",Product.class,id);
		if(product!=null&&product.size()>0){
			return product.get(0);
		}
		return null;
	}
	
	//�޸Ĳ�Ʒ��Ϣ
	public void updateProduct(Product product){
		String sql="update product set pname=?,pnum=?,cost=?,img=? where pid=?";
		Object []params={product.getPname(),product.getAmount(),product.getLid(),product.getTags(), product.getCost() , product.getImg()};
		int a = execOther(sql, params);
		System.out.println(a+"�б��޸�");
	}
	
	//��ҳ��ʾ
	@SuppressWarnings("unchecked")
	public PageBean getPageBean(int currentPage,int pageSize){
		PageBean pagebean = new PageBean();		
		//��ѯ��������
		String sql="select * from product limit ?,?";
		Object []params={(currentPage-1)*pageSize,pageSize};
		List<Product> products=executeQuery(sql, Product.class, params);
		pagebean.setData(products);
		
		//��ѯ�ܹ���¼��
		String count ="select count(pid)from product";
		ResultSet rs=execQuery(count, null);
		try {
			if(rs.next()){
				pagebean.setTotalRows(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pagebean.setCurrentPage(currentPage);
		pagebean.setPageSize(pageSize);
		return pagebean;
	}
	
	//����ɾ����Ʒ�ķ���
	public void deleteProducts(String []ids){
		//��ȡ����
		Connection conn= new DaoSupport().getConn();
		try {
			conn.setAutoCommit(false);//�������ﲻ�Զ��ύ
			Statement stm  = conn.createStatement();
			if(ids!=null){
				for(String i :ids){
					stm.addBatch("delete from product where pid="+Integer.parseInt(i));
				}
			}
			//����Ӱ���в���
			int []a = stm.executeBatch();
			//�ύ��������ݿ��޸���Ч
			conn.commit();
			System.out.println(a.length+"�б�ɾ����");
		} catch (SQLException e) {
			try {
				//��������쳣���ع�������ǰ��״̬��
				conn.rollback();
				System.out.println("����ɾ�����������Ѿ��ع�");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
  
}
