package com.zzxtit.shop.web.home.entity;

import java.math.BigDecimal;

public class Goods {

	private int id;
	
	private String barCode;
	
	private String goodsName;
	
	private BigDecimal price;
	
	private String type;
	
	private String taste;
	
	private String photoPath;

	public int getId() {
		return id;
	}

	public String getBarCode() {
		return barCode;
	}

	public String getGoodsName() {
		return goodsName;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public String getTaste() {
		return taste;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
}
