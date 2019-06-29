<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="css/login.css" type="text/css"></link>
  
  <script type="text/javascript">
	
		function ref() {
			var ck_img = document.getElementById("ck_img");
			ck_img.setAttribute("src","/servlet/ValidateCodeServlet?random="+Math.random());

		}

		</script>
  </head>
  
 <BODY>
 
<DIV id=div1>
  <TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800 
align=center>
    <TBODY>
      <TR id=main>
        <TD>
        <form action="servlet/ProcessServlet" method="post" enctype="application/x-www-form-urlencoded" >
          <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
            <TBODY>
              <TR>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
              <TR height=30>
                <TD width=427>&nbsp;</TD>
                <TD width="47">&nbsp;</TD>
                <TD width="202">&nbsp;</TD>
                <TD>&nbsp;</TD>
              </TR>
              <TR height=30>
                <TD rowSpan=4>&nbsp;</TD>
                <TD height="30">用户名：</TD>
                <TD>
                  <INPUT class=textbox id=txtUserName name="name">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=30>
                <TD height="30">密　码：</TD>
                <TD>
                  <INPUT class=textbox id=txtUserPassword type=password 
            name="pwd">
                </TD>
                <TD width=120 height="30">&nbsp;</TD>
              </TR>
              <TR height=30>
                <TD height="30">验证码：</TD>
                <TD vAlign="center" colSpan=2>
                  &nbsp;<span id="ck_span"  > 
					<INPUT id=txtSN  name="inputCode" maxlength="4"  size="4" />
					<img id="ck_img" src="/servlet/ValidateCodeServlet"  width="80" height="23"  onclick="ref()" />
					
				</span></TD>
              </TR>
              <TR height=30>
                <TD height="30"></TD>
                <TD align=right>
                  <INPUT id=btnLogin type=submit value=" 登 录 " name=btnLogin>
                </TD>
             
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=110>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
            </TBODY>
          </TABLE>
          </form>
        </TD>
      </TR>
      <TR id=root height=104>
        <TD>&nbsp;</TD>
      </TR>
    </TBODY>
  </TABLE>
 
</DIV>
<DIV id=div2 style="DISPLAY: none"></DIV>


</BODY>
</html>
