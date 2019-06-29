<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${userInfo != null }">
  		尊敬的会员 ${userInfo.uname } 你好 !!!
  		<span><a href="servlet/UserServlet?method=logout">注销</a></span>
  	</c:if>
  	<c:if test="${userInfo== null }">
  		<p>请您<a href="login.jsp">登录</a> , <a href="page.jsp">注册</a>！！！</p>
  	</c:if>