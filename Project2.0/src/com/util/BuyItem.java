package com.util;

import com.pojo.Product;

public class BuyItem {
	private Product product;//定义产品
	private int amount;//定义产品数量
 public BuyItem(Product product,int amount) {
	this.product=product;
	this.amount=amount;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public boolean equals(Object obj) {
	Product p1 = getProduct();
	Product p2 =( (BuyItem)obj).getProduct();
	
	if(p1.getPid()==p2.getPid()) return true;
	else return false;
	
}
}
