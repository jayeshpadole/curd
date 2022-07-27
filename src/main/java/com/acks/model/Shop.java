package com.acks.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Shop {
	
	@Id
	private int shopid;
	@NotBlank
	@NotEmpty(message = "username connot be null")
	@Size(min = 3,max = 13,message = "shopname must be in between 3to13")
	private String shopname;
	private String shopaddress;
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopaddress() {
		return shopaddress;
	}
	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}
	public Shop(int shopid, String shopname, String shopaddress) {
		super();
		this.shopid = shopid;
		this.shopname = shopname;
		this.shopaddress = shopaddress;
	}
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Shop [shopid=" + shopid + ", shopname=" + shopname + ", shopaddress=" + shopaddress + "]";
	}
	
	

}
