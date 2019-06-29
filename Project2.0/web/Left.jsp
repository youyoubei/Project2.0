<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
 A {
	COLOR: #566984; TEXT-DECORATION: none
}
</STYLE>

<META content="MSHTML 6.00.2900.5848" name=GENERATOR>

  </head>
  
  <BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
  <TBODY>
    <TR>
      <TD width=10 height=29><IMG src="images/bg_left_tl.gif"></TD>
      <TD 
    style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(images/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system">主菜单</TD>
      <TD width=10><IMG src="images/bg_left_tr.gif"></TD>
    </TR>
    <TR>
      <TD style="BACKGROUND-IMAGE: url(images/bg_left_ls.gif)"></TD>
      <TD id=menuTree 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px; HEIGHT: 100%; BACKGROUND-COLOR: white" 
    vAlign=top></TD>
      <TD style="BACKGROUND-IMAGE: url(images/bg_left_rs.gif)"></TD>
    </TR>
    <TR>
      <TD width=10></TD>
      <TD style="BACKGROUND-IMAGE: url(images/bg_left_bc.gif); FONT-SIZE: 16px; padding-left:2px;COLOR:#999; FONT-FAMILY: system"><p>        &nbsp;&nbsp;&nbsp;&nbsp;</p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<a href="servlet/UserServlet?method=findAll" target=mainFrame>会员管理</a></p>
      <p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <a href="add.jsp" target=mainFrame>添加商品</a></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <a href="servlet/ProductServlet?method=show" target=mainFrame> 查询商品</a></p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 产品分布</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;销售业绩</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;</p></TD></TR></TBODY></TABLE></TD></TR>
      </TD>
      <TD width=10></TD>
    </TR>
  </TBODY>
</TABLE>

</BODY>
</html>
