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
	

	
	//添加商品的方法
	public void addProduct(Product product){
		String sql = "insert into product (pname,lid,amount,tags,cost,img,memory) values (?,?,?,?,?,?,?)";
		Object []params={product.getPname(),product.getLid(),product.getAmount(),product.getTags(), product.getCost() , product.getImg(),product.getMemory()};
		int a =execOther(sql, params);
		System.out.println(a+"行商品被添加");
	}
	
	//显示所有商品的方法
	@SuppressWarnings("unchecked")
	public List<Product> showProducts(){
		return executeQuery("select * from product", Product.class, null);
	}
	
	//根据ID查询商品以便放入购物车
	@SuppressWarnings("unchecked")
	public Product selectProduct(int id){
		String sql="select * from product where pid=?";
		List<Product> products=executeQuery(sql, Product.class, id);
		if(products!=null&&products.size()>0){
			return products.get(0);
			
		}
		 return null;
	}
	
	//删除商品的方法
	public void delete(int pid){
		Object []id={pid};
		int a = execOther("delete from product where pid=?", id);
		System.out.println(a+"行商品被删除");
	}
	
	//分组显示商品
	@SuppressWarnings("unchecked")
	public List<Product> se(String name){
		Object[] a ={name};
		return executeQuery("select * from product where lid =?", Product.class, a);
	}
	
	//显示单个商品的信息以便修改
	@SuppressWarnings("unchecked")
	public Product getProduct(int pid){
		Object []id={pid};
		List<Product> product=executeQuery("select * from product where pid=?",Product.class,id);
		if(product!=null&&product.size()>0){
			return product.get(0);
		}
		return null;
	}
	
	//修改产品信息
	public void updateProduct(Product product){
		String sql="update product set pname=?,pnum=?,cost=?,img=? where pid=?";
		Object []params={product.getPname(),product.getAmount(),product.getLid(),product.getTags(), product.getCost() , product.getImg()};
		int a = execOther(sql, params);
		System.out.println(a+"行被修改");
	}
	
	//分页显示
	@SuppressWarnings("unchecked")
	public PageBean getPageBean(int currentPage,int pageSize){
		PageBean pagebean = new PageBean();		
		//查询区域数据
		String sql="select * from product limit ?,?";
		Object []params={(currentPage-1)*pageSize,pageSize};
		List<Product> products=executeQuery(sql, Product.class, params);
		pagebean.setData(products);
		
		//查询总共记录数
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
	
	//批量删除商品的方法
	public void deleteProducts(String []ids){
		//获取连接
		Connection conn= new DaoSupport().getConn();
		try {
			conn.setAutoCommit(false);//设置事物不自动提交
			Statement stm  = conn.createStatement();
			if(ids!=null){
				for(String i :ids){
					stm.addBatch("delete from product where pid="+Integer.parseInt(i));
				}
			}
			//返回影响行参数
			int []a = stm.executeBatch();
			//提交事物，是数据库修改生效
			conn.commit();
			System.out.println(a.length+"行被删除了");
		} catch (SQLException e) {
			try {
				//如果发生异常，回滚到更新前的状态。
				conn.rollback();
				System.out.println("批量删除有误，事务已经回滚");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
  
}
