//修改商品数量时总价变化的方法
//删除前的确认方法
function checkdelete(url){
	if(confirm("确定删除？")){
		window.location.href = url;
	}
	else{
		return;
	}
		
}    