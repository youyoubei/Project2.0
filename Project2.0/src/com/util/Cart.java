package com.util;

import java.util.ArrayList;
import java.util.List;



public class Cart {
	private List<BuyItem> items = new ArrayList<BuyItem>();
	

	public List<BuyItem> getItems() {
		return items;
	}
	//将物品添加到购物车
public void addToCart(BuyItem buyItem){
	if(!(items.contains(buyItem))){//如果购物车中没有此类商品
		items.add(buyItem);
		System.out.println(!items.contains(buyItem)+"不同种商品");
	}else {
		for(BuyItem item:items){
			if(item.getProduct().getPid()==buyItem.getProduct().getPid()){
				item.setAmount(item.getAmount()+1);
				System.out.println("同种商品");
				break;
			}
		}
	}
 }
  //获取总价格
  public float getTotalPrice(){
	float totalPrice=0f;//定义总价
	for(BuyItem bi : this.items){
		
		totalPrice += Integer.parseInt(bi.getProduct().getCost()) * bi.getAmount();
	}
	return totalPrice;

}
}