<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'macPro17.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Apple-用iPod播放音乐以及更多</title>

<link rel="stylesheet" type="text/css" href="css/css.css"/>
<script type="text/javascript" src="JavaScript/js.js">
</script>eta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="MM_preloadImages('images/serch2.png')">
<!--总层-->
<div id="zong" style="background-color:#e8e8e8; margin-top:0px">
<!--顶部模板层-->
<div id="ding1">   <table align="center" class="table" border="0" cellspacing="0" cellpadding="0" >
             <tr>
               <td align="center" valign="middle" class="td" id="ap" onmouseover=
"javascript:change(ap);this.style.cursor='pointer';" onmouseout="javascript:changeout(ap)"><img src="images/apple.png" /></td>
                <td align="center" valign="middle" class="td" id="zi1" onmouseover="javascript:change1(zi1);this.style.cursor='pointer';" onmouseout="javascript:changeout1(zi1)"><img src="images/zi1.png" /></td>
                <td align="center" valign="middle" class="td" id="zi2" onmouseover="javascript:change2(zi2);this.style.cursor='pointer';" onmouseout="javascript:changeout2(zi2)"><img src="images/zi2.png" /></td>
                <td align="center" valign="middle" class="td" id="zi3" onmouseover="javascript:change3(zi3);this.style.cursor='pointer';" onmouseout="javascript:changeout3(zi3)"><img src="images/zi3.png" /></td>
                <td align="center" valign="middle" class="td" id="zi4" onmouseover="javascript:change4(zi4);this.style.cursor='pointer';" onmouseout="javascript:changeout4(zi4)"><img src="images/zi4.png" /></td>
                <td align="center" valign="middle" class="td" id="zi5" onmouseover="javascript:change5(zi5);this.style.cursor='pointer';" onmouseout="javascript:changeout5(zi5)"><img src="images/zi5.png" /></td>
                <td align="center" valign="middle" class="td" id="zi6" onmouseover="javascript:change6(zi6);this.style.cursor='pointer';" onmouseout="javascript:changeout6(zi6)"><img src="images/zi6.png" /></td>
                <td align="center" valign="middle" class="td" id="zi7" onmouseover="javascript:change7(zi7);this.style.cursor='pointer';" onmouseout="javascript:changeout7(zi7)"><img src="images/zi7.png" /></td>
                <td align="center" valign="middle" class="td">
                
                
                      <input name="" type="text"  id="serch"  onfocus="serch()" onblur="serchout()"
                      style=" width:140px; height:16px; background:url(images/serch1.png); padding-left:20px; padding-right:20px; border:none"/>
                      
               
                </td>
            </tr>
          </table>
 </div>
<!---产品模板层--->
<div style="width: auto; height: auto; float:none; margin-top:10px">
<table  align="center" width="950"  height="580"border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td width="323" rowspan="6" align="center" bgcolor="#FFFFFF"><h3><img src="imagesmac/macPro17.jpg" width="300" height="300" /></h3></td>
    <td width="310" height="70" bgcolor="#737373"><h3>价格：￥19448</h3></td>
    <td width="311" height="70" align="center" valign="middle" bgcolor="#737373">
    <a href="servlet/CartServlet?method=addCart&pid=${pid }"><img src="images/btn_addcart.gif" width="122" height="35" border="0"/></a></td>
  </tr>
  <tr>
    <td height="70" bgcolor="#737373">外观设计：笔记本</td>
    <td height="70" bgcolor="#737373">网络模式：内置AirPort Extrem</td>
  </tr>
  <tr>
    <td height="70" bgcolor="#737373">触摸屏：不支持</td>
    <td height="70" bgcolor="#737373">摄像头：200万像素</td>
  </tr>
  <tr>
    <td height="70" bgcolor="#737373">主屏尺寸：17英寸</td>
    <td height="70" bgcolor="#737373">电池容量：十个小时</td>
  </tr>
  <tr>
    <td height="70" bgcolor="#737373">机身内存：32G</td>
    <td height="70" bgcolor="#737373">操作系统：狮子操作系统</td>
  </tr>
  <tr>
    <td height="70" bgcolor="#737373">蓝牙传输：支持蓝牙4.0</td>
    <td height="70" bgcolor="#737373">CPU频率：3GHz</td>
  </tr>
  <tr>
    <td width="323" align="center" bgcolor="#737373">macPro17寸版</td>
    <td height="70" bgcolor="#737373">产品系列：苹果mac系列</td>
    <td height="70" bgcolor="#737373">&nbsp;</td>
  </tr>
</table>

</div>


<!--底部模板层-->
 <hr   style="margin-left:40px;"/>
<!---------------------- foot -------------------------->
		<center>
			<div style="width: 980px; margin: auto">
				<!--------------------- left  -------------------------->
				<div style="float: left;">
					<div>
						<ul style="list-style: none">
							<li class="li">
								<font color="#333333">访问</font>&nbsp;
							</li>
							<li class="li">
								<a href="#">Apple Store 在线商店</a>&nbsp;
							</li>
							<li class="li">
								<font color="#333333">(400-666-8800)，</font>
							</li>
							<li class="li">
								<a href="#">Apple Store 零售</a>&nbsp;
							</li>
							<li class="li">
								<font color="#333333">，或查找在你附近的</font>&nbsp;
							</li>
							<li class="li">
								<a href="#">Apple 经销商</a>。&nbsp;
							</li>
						</ul>
					</div>
					<!--------------------- right -------------------------->
					<div style="float: right;">
						<ul style="list-style: none">
							<li class="li">
								<a href="#">网站地图</a>&nbsp;
							</li>
							<li class="li">
								<img src="images/hr2.png" />
								&nbsp;
							</li>
							<li class="li">
								<a href="#">热点新闻</a>&nbsp;
							</li>
							<li class="li">
								<img src="images/hr2.png" />
								&nbsp;
							</li>
							<li class="li">
								<a href="#">媒体中心</a>&nbsp;
							</li>
							<li class="li">
								<img src="images/hr2.png" />
								&nbsp;
							</li>
							<li class="li">
								<a href="#">环境</a>&nbsp;
							</li>
							<li class="li">
								<img src="images/hr2.png" />
								&nbsp;
							</li>
							<li class="li">
								<a href="#">工作机会</a>&nbsp;
							</li>
							<li class="li">
								<img src="images/hr2.png" />
								&nbsp;
							</li>
							<li class="li">
								<a href="#">联系我们</a>&nbsp;
							</li>
						</ul>
					</div>

					<div style="margin-top: 10px;">
						<img src="images/hr4.png"
							style="width: 980px; height: 1px; margin-top: 10px;" />
						<ul style="list-style: none;">
							<li class="li">
								<font color="#333333">Copyright © 2012 Apple Inc. 保留所有权利。</font>
							</li>
							<li class="li">
								<a href="#">使用条款</a>&nbsp;
							</li>
							<li class="li">
								<img src="images/hr2.png" />
								&nbsp;
							</li>
							<li class="li">
								<a href="#">客户私隐政策</a>&nbsp;
							</li>
						</ul>
					</div>
				</div>
			</div>
		</center>
</body>
</html>
