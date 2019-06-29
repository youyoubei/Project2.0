<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"    %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function buy(){
	document.forms[0].submit();
	}
	</script>
		<link rel="stylesheet" href="css/csscss.css" type="text/css"></link>
		<script type="text/javascript" src="scripts/cart.js"></script>
	
  </head>
  <script type="text/javascript">
  function getname(){
            var v="";
	        var sel=document.getElementById("sel");
	        for(var i=0;i<sel.options.length;i++){
	            if(sel.options[i].selected==true){
	                v=sel.options[i].value;
	                }
	            }
	location="http://localhost:8888/Project2.0/servlet/ProductServlet?method=selectProduct&name="+v;
  }
  </script>
  <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
		onload="MM_preloadImages('images/serch2.png')"
		style="background: #f3f4f5">
		<center>
			<!---------------------- head -------------------------->
			<div style="width: 980px; margin: auto">
				<div>
					<table align="center" class="table" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td align="center" valign="middle" class="td" id="ap"
								onmouseover="javascript:change(ap);this.style.cursor='pointer';"
								onmouseout="javascript:changeout(ap)">
								<img src="images/apple.png" />
							</td>
							<td align="center" valign="middle" class="td" id="zi1"
								onmouseover="javascript:change1(zi1);this.style.cursor='pointer';"
								onmouseout="javascript:changeout1(zi1)">
								<img src="images/zi1.png" />
							</td>
							<td align="center" valign="middle" class="td" id="zi2"
								onmouseover="javascript:change2(zi2);this.style.cursor='pointer';"
								onmouseout="javascript:changeout2(zi2)">
								<img src="images/zi2.png" />
							</td>
							<td align="center" valign="middle" class="td" id="zi3"
								onmouseover="javascript:change3(zi3);this.style.cursor='pointer';"
								onmouseout="javascript:changeout3(zi3)">
								<img src="images/zi3.png" />
							</td>
							<td align="center" valign="middle" class="td" id="zi4"
								onmouseover="javascript:change4(zi4);this.style.cursor='pointer';"
								onmouseout="javascript:changeout4(zi4)">
								<img src="images/zi4.png" />
							</td>
							<td align="center" valign="middle" class="td" id="zi5"
								onmouseover="javascript:change5(zi5);this.style.cursor='pointer';"
								onmouseout="javascript:changeout5(zi5)">
								<img src="images/zi5.png" />
							</td>
							<td align="center" valign="middle" class="td" id="zi6"
								onmouseover="javascript:change6(zi6);this.style.cursor='pointer';"
								onmouseout="javascript:changeout6(zi6)">
								<img src="images/zi6.png" />
							</td>
							<td align="center" valign="middle" class="td" id="zi7"
								onmouseover="javascript:change7(zi7);this.style.cursor='pointer';"
								onmouseout="javascript:changeout7(zi7)">
								<img src="images/zi7.png" />
							</td>
							<td align="center" valign="middle" class="td">

								<div style="width: 165px; background-color: #737373;">
									<div>
										<input name="" type="text" id="serch" onfocus="serch()"
											onblur="serchout()"
											style="width: 140px; height: 16px; background: url(images/serch1.png); border: none" />
									</div>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</center>
		<!---------------------- main -------------------------->
		<center>
			<div style="width: 980px;">
				<!-- 第一部分 -->
				<div style="width: 980px;">
					<!-------------------------left ----------------------->
					<div>
						<img src="images/hph.png" style="float: left; margin-top: 20px;" />
						<img src="images/hr4.png"
							style="width: 980px; height: 1px; margin-top: -5px;" />
					</div>
					<div>
						<div style="float: left;">
							<img src="images/home.png" width="15" height="17"
								style="margin-bottom: -5px; margin-left: 5px;" />
							<img src="images/hr2.png" width="1" height="15"
								style="margin-bottom: -3px;" />
							<span class="zi"><jsp:include page="head.jsp"></jsp:include></span>

						</div>
						<!--------------------------right --------------------->
						<div style="float: right; margin-top: 3px;">
							<ul style="list-style: none">
								<li class="li">
									<span class="zi">请选择产品类别：<select name="sel" id="sel" onchange="getname()">
   <c:if test=""></c:if>
                        <option value="ipone">ipone</option>
                        <option value="ipad">ipad</option>
                        <option value="ipod">ipod</option>
                        <option value="mac">mac</option>    
                      </select>&nbsp;</span>
								</li>
								
							</ul>
						</div>
					</div>
				</div>

				<!-- 第二部分 -->
				<div>
					<!---------------- left ---------------->
					<div
						style="float: left; margin-top: 10px; background: #FFF; width: 980px;">

						<div
							style="background: url(images/h2.png); width: 980px; height: 20px; padding-top: 5px; float: left;">
						<p>
                      </p>
						</div>
   <c:forEach var="product" items="${requestScope.products }">   
   <ul style="float: left"><li>
   <table border="0" height="300" width="200"   style="font-size: 12px">
   <tr><td colspan="2" align="center">
   <!--  <a href="${product.pname }.jsp">-->
   <a href="servlet/ProductServlet?method=showProduct&name=${product.pname }&id=${product.pid}">
   <img src="${product.img }" border="0" style="width: 150;height: 150"></a></td></tr>
   <tr ><td>产品名</td><td>${product.pname }</td></tr>
   <tr><td>产品价格</td><td>${product.cost }</td></tr>
   <tr><td>产品系列</td><td>${product.lid }</td></tr>   
   </table></li></ul></c:forEach>
   </div>

					
				</div>


				<!-------------- 第三部分------------>
				<div>
					<div
						style="width: 800px; height:10px; float: left; margin-top: -14px; margin-bottom: 10px;">
						<img src="images/hr4.png" width="980" height="1" />

					</div>
				</div>
		
		</center>

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
