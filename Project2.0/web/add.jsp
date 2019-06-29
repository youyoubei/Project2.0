<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>

  </head>
  
  <BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<form action=" servlet/ProductServlet?method=addproduct"  method="post"  enctype="multipart/form-data" >
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR 
  style="BACKGROUND-IMAGE: url(images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" 
  height=47>
        <TD width=10><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
         <TD><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN 
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">添加商品</SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
    
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align="center">
          <DIV>
            <TABLE width="99%" 
      border=1 cellSpacing=0 rules=all class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%; BORDER-COLLAPSE: collapse">
              <TBODY>
                <TR>
                  <TH width="74" class=gridViewHeader style="WIDTH: 50px" scope=col>&nbsp;</TH>
                  <TH width="171" class=gridViewHeader scope=col>产品名称</TH>
                  <TH width="151" class=gridViewHeader scope=col>数量</TH>
                  <TH width="151" class=gridViewHeader scope=col>价格</TH>
                  <TH width="244" class=gridViewHeader scope=col>图片</TH>
                  <TH width="190" class=gridviewHeader scope=col>系列名</TH>
                  <TH width="227" class=gridviewHeader scope=col>产品介绍</TH>
                  <TH width="173" class=gridviewHeader scope=col>机身内存</TH>
                </TR>
                
                <TR>
                  <TD class=gridViewItem style="WIDTH: 50px"><IMG 
            src="images/bg_users.gif"> </TD>
                  <TD class=gridViewItem><input name="pname" type="text" size="15"    /></TD>
                  <TD class=gridViewItem><input name="amount" type="text" size="10"    /></TD>
                  <TD class=gridViewItem><input name="cost" type="text" size="10"    />
                    </TD>
                  <TD class=gridViewItem><input name="img" type="file" size="20"    /></TD>
                  <TD class=gridViewItem><p>
                    <label>
                      <select name="lid" id="lid">
                        <option value="ipone">ipone</option>
                        <option value="ipad">ipad</option>
                        <option value="ipod">ipod</option>
                        <option value="mac">mac</option>    
                      </select>
                    </label>                  
                  </p></TD>
                  <TD class=gridViewItem><label>
                    <textarea name="tags" id="tags" cols="20" rows="5"></textarea>
                  </label></TD>
                 <TD class=gridViewItem><p>
                    <label>
                      <select name="memory" id="memory">
                        <option value="512M">512M</option>
                        <option value="2G">2G</option>
                        <option value="4G">4G</option>
                        <option value="8G">8G</option>
                        <option value="16G">16G</option>
                        <option value="32G">32G</option>
                        <option value="64G">64G</option>   
                      </select>
                    </label>                  
                  </p></TD>
                </TR>
               
                
              <TR >
                  <TH class=gridViewHeader style="WIDTH: 50px" scope=col colspan="8" align="center"><input type="submit"  value="添加商品"></TH>
                 
                </TR>
            </TABLE>
          </DIV>
     
        </TD>
        <TD style="BACKGROUND-IMAGE: url(images/main_rs.gif)"></TD>
      </TR>
      <TR 
  style="BACKGROUND-IMAGE: url(images/main_fs.gif); BACKGROUND-REPEAT: repeat-x" 
  height=10>
        <TD style="BACKGROUND-IMAGE: url(images/main_lf.gif)"></TD>
        <TD style="BACKGROUND-IMAGE: url(images/main_fs.gif)"></TD>
        <TD 
style="BACKGROUND-IMAGE: url(images/main_rf.gif)"></TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>
 </form>
</BODY>
</html>
