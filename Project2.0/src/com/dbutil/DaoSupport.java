package com.dbutil;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;






public class DaoSupport {

	//������Ľӿ�
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//�ĸ�����
	//method1: �������ݿ������
	private void getConntion(){		
		try {
			//1: ��������������Java����ԭ��
			Class.forName(Config.CLASS_NAME);
			//2:����Connection�ӿڶ������ڻ�ȡMySQL���ݿ�����Ӷ�������������url�����ַ���    �˺�  ����
			String url = Config.DATABASE_URL+"://"+Config.SERVER_IP+":"+Config.SERVER_PORT+"/"+Config.DATABASE_SID+"?autoReconnect=true&useUnicode=true&characterEncoding=utf-8";
			conn = DriverManager.getConnection(url,Config.USERNAME,Config.PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public Connection getConn() {
		getConntion();
		return conn;
	}

	public static void main(String[] args) {
		System.out.println();
	}
	
	//method2���ر����ݿ�ķ���
	public void closeConn(){
			try {
				if(rs!=null){  rs.close();  }
				if(pstmt!=null){  pstmt.close();  }
				if(conn!=null){  conn.close();  }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	//method3: ר�����ڷ�����ɾ�����ķ���
	public int execOther(final String strSQL,final Object[] params ){
		//1����ȡ���ݿ�����
		getConntion();
		//2��Ԥ�ȴ�ӡ������ִ�е�SQL���(������Ŀ���ԣ���Hibernate���)
		System.out.println("SQL:> "+strSQL);		
		try {
			//3������Statement�ӿڶ���
			pstmt = conn.prepareStatement(strSQL);
			//4����̬Ϊpstmt����ֵ
			if(params!=null) {
				for(int i=0; i< params.length ;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			//5��ʹ��Statement������SQL���
			int affectedRows = pstmt.executeUpdate();
			//6�����ؽ��
			return affectedRows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	//method4: ר�����ڷ��Ͳ�ѯ���
	public ResultSet execQuery(final String strSQL,final Object[] params){
		//1����ȡ���ݿ�����
		getConntion();
		//2��Ԥ�ȴ�ӡ������ִ�е�SQL���(������Ŀ���ԣ���Hibernate���)
		System.out.println("SQL:> "+strSQL);
		try {
			//3������PreparedStatement�ӿڶ���
			pstmt = conn.prepareStatement(strSQL);
			//4����̬Ϊpstmt����ֵ
			if(params!=null) {
				for(int i=0; i< params.length ;i++){
					pstmt.setObject(i+1, params[i]);
				}		
			}
			//5��ʹ��Statement������SQL���
			rs = pstmt.executeQuery();
			//6�����ؽ��
			return rs;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	//�Զ���װ��������
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List executeQuery(String sql, Class clazz, Object... objects) {
		//��ӡ��ǰSQL��䡣
		System.out.println("SQL:> "+sql);		
		getConntion();  //�������
		try {
			List list = new ArrayList(); //��������
			pstmt = conn.prepareStatement(sql); //  select * from table where p1=? and p2 =? and p3 like %?%;
	
			if(objects !=null ){
				for (int j = 0; j < objects.length; j++) {
					pstmt.setObject(j + 1, objects[j]);
				}
			}
	
			rs = pstmt.executeQuery();
			//��ȡģ��
			ResultSetMetaData metaData = rs.getMetaData();
	
			while (rs.next()) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				//ʵ��������  �൱�� new .
				Object object = clazz.newInstance();   //Emp emp = new Emp();
	
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					//�������䵱 Key  �õõ��Ľ�� �䵱Value  ��
					//���� Key�оͺ�Java���е���������ͬ���� �� ��ôValue �ͻ�ͨ������ķ�����ֵ�������ԡ�
					map.put(metaData.getColumnLabel(i), rs.getObject(i));
	
				}
				//���ʵ��
				BeanUtils.populate(object, map);   //Emp  .... set
	
				list.add(object);
			}
	
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		return null;
	}
	
	
	// [a,b,c]   => "a,b,c"
	public static String arrayToString(String[] param , String link) {
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < param.length; i++) {
			builder.append(param[i]).append(link);
		}
		
		builder.deleteCharAt(builder.lastIndexOf(link));
		
		return builder.toString();
		
	}
	//���ַ�������ת���� int ����
	public static int[] StringArrayToIntArray( String[] strArray ) {
		int[] intArray = null;
		if(strArray!=null && strArray.length > 0 ) {
			intArray = new int[strArray.length]; //��ʼ�� int[] �ĳ��� 
				for (int i = 0; i < intArray.length; i++) {
					intArray[i] = Integer.parseInt(strArray[i]);
				}
			}
		
		return intArray;
	}
	
	//��int���� ת���� Object[] 
	
	public static Object[] IntArrayToObjectArray( int[] intArray ) {
		Object[] objectArray = null;
		if(intArray!=null && intArray.length > 0 ) {
			objectArray = new Object[intArray.length]; //��ʼ�� int[] �ĳ��� 
				for (int i = 0; i < objectArray.length; i++) {
					objectArray[i] =intArray[i];
				}
			}
		
		return objectArray;
	}
	
//��String���� ת���� Object[] 
	
	public static Object[] strArrayToObjectArray( String[] strArray ) {
		Object[] objectArray = null;
		if(strArray!=null && strArray.length > 0 ) {
			objectArray = new Object[strArray.length]; //��ʼ�� int[] �ĳ��� 
				for (int i = 0; i < objectArray.length; i++) {
					objectArray[i] =strArray[i];
				}
			}
		
		return objectArray;
	}
	
	//�����ʺ�  ?,?,?,?
	public static String getQuestionMark(String[] history) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < history.length; i++) {
			builder.append("?").append(",");
		}
		builder.deleteCharAt(builder.lastIndexOf(","));
		
		return builder.toString();
	}
	
	
	protected static String buildOrderby(LinkedHashMap<String, String> orderby){
		
		//pid desc , name
		StringBuilder orderbyql = new StringBuilder("");
		if(orderby!=null && orderby.size()>0){
			orderbyql.append(" order by "); //- order by pid desc 
			for(String key : orderby.keySet()){
				orderbyql.append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length()-1);
		}
		return orderbyql.toString();
	}
	
	
	@SuppressWarnings("rawtypes")
	protected static void setQueryParams(PreparedStatement p, List queryParams) {
		try {
			if(queryParams!=null && queryParams.size()>0){
				for(int i = 0; i<queryParams.size(); i++){
						p.setObject(i+1, queryParams.get(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}

