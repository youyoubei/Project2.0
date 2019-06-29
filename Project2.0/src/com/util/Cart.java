package com.util;

import java.util.ArrayList;
import java.util.List;



public class Cart {
	private List<BuyItem> items = new ArrayList<BuyItem>();
	

	public List<BuyItem> getItems() {
		return items;
	}
	//����Ʒ��ӵ����ﳵ
public void addToCart(BuyItem buyItem){
	if(!(items.contains(buyItem))){//������ﳵ��û�д�����Ʒ
		items.add(buyItem);
		System.out.println(!items.contains(buyItem)+"��ͬ����Ʒ");
	}else {
		for(BuyItem item:items){
			if(item.getProduct().getPid()==buyItem.getProduct().getPid()){
				item.setAmount(item.getAmount()+1);
				System.out.println("ͬ����Ʒ");
				break;
			}
		}
	}
 }
  //��ȡ�ܼ۸�
  public float getTotalPrice(){
	float totalPrice=0f;//�����ܼ�
	for(BuyItem bi : this.items){
		
		totalPrice += Integer.parseInt(bi.getProduct().getCost()) * bi.getAmount();
	}
	return totalPrice;

}
}