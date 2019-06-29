// JavaScript Document
function change(id){
	
	if(id=="ap")
	var ap = document.getElementById("ap");
	document.getElementById("ap").style.backgroundColor='#3e3e3e';
	
	}
function changeout(id){
	if(id=="ap")
	var ap = document.getElementById("ap");
	document.getElementById("ap").style.backgroundColor='#737373';
	}
function change1(id){
	if(id=="zi1")
	var ap = document.getElementById("zi1");
	document.getElementById("zi1").style.backgroundColor='#3e3e3e';	
	}
function changeout1(id){
	if(id=="zi1")
	var ap = document.getElementById("zi1");
	document.getElementById("zi1").style.backgroundColor='#737373';
	}
function change2(id){
	if(id=="zi2")
	var ap = document.getElementById("zi2");
	document.getElementById("zi2").style.backgroundColor='#3e3e3e';	
	}
function changeout2(id){
	if(id=="zi2")
	var ap = document.getElementById("zi2");
	document.getElementById("zi2").style.backgroundColor='#737373';
	}
function change3(id){
	if(id=="zi3")
	var ap = document.getElementById("zi3");
	document.getElementById("zi3").style.backgroundColor='#3e3e3e';	
	}
function changeout3(id){
	if(id=="zi3")
	var ap = document.getElementById("zi3");
	document.getElementById("zi3").style.backgroundColor='#737373';
	}
function change4(id){
	if(id=="zi1")
	var ap = document.getElementById("zi4");
	document.getElementById("zi4").style.backgroundColor='#3e3e3e';	
	}
function changeout4(id){
	if(id=="zi4")
	var ap = document.getElementById("zi4");
	document.getElementById("zi4").style.backgroundColor='#737373';
	}
function change5(id){
	if(id=="zi5")
	var ap = document.getElementById("zi5");
	document.getElementById("zi5").style.backgroundColor='#3e3e3e';	
	}
function changeout5(id){
	if(id=="zi5")
	var ap = document.getElementById("zi5");
	document.getElementById("zi5").style.backgroundColor='#737373';
	}
function change6(id){
	if(id=="zi6")
	var ap = document.getElementById("zi6");
	document.getElementById("zi6").style.backgroundColor='#3e3e3e';	
	}
function changeout6(id){
	if(id=="zi6")
	var ap = document.getElementById("zi6");
	document.getElementById("zi6").style.backgroundColor='#737373';
	}
function change7(id){
	if(id=="zi7")
	var ap = document.getElementById("zi7");
	document.getElementById("zi7").style.backgroundColor='#3e3e3e';	
	}
function changeout7(id){
	if(id=="zi7")
	var ap = document.getElementById("zi7");
	document.getElementById("zi7").style.backgroundColor='#737373';
	}

function serch(){
	var serch = document.getElementById("serch");
	document.getElementById("serch").style.background='url(images/serch2.png)';
	}
function serchout(){
	var serch = document.getElementById("serch");
	document.getElementById("serch").style.background='url(images/serch1.png)';
	}

//移除商品时的确认方法
function chk(url){
   if(confirm("确定移除此商品?")){
   window.location.href=url;
   }
   else return;
}
//修改商品数量
function update(acount,id){
//创建交互对象
var xhr= new XMLHttpRequest();
//指定交互方法，路径，方式
xhr.open("get","http://localhost:8888/Project2.0/servlet/CartServlet?method=updateCart&id="+id+"&acount="+acount, true);
//指定回调函数
xhr.onreadystatechange=function(){
	if(xhr.readyState==4&&xhr.status==200){
		//获取服务器端的Json数据并格式化
		var totalPrice=eval('('+xhr.responseText+')');
		document.getElementById("zong").innerHTML = totalPrice;
		document.getElementById("zong1").innerHTML = totalPrice;
		}
	
};
//开始发送请求
xhr.send();
}

function del(id){
    //让浏览器页面跳转        js跳转要加项目名
	window.location.href = "/Project2.0/servlet/CartServlet?method=adddel&type=del&id="+id;
    }
function add(id){
    //让浏览器页面跳转        js跳转要加项目名
	window.location.href = "/Project2.0/servlet/CartServlet?method=adddel&type=add&id="+id;
    }