package com.zzxtit.shop.web.shopcart.entity;

import java.math.BigDecimal;

import javax.xml.crypto.Data;

public class GoodInfoFromDatabase {
	
	int id;
	public String barcode;
	public String goodsName;
	public Data productData;
	public String produce;
	public String shelfLife;
	public BigDecimal price;
	public String type;
	public String taste;
	public String goodsPackage;
	public String photo1;
	public String photo2;
	public String photo3;
	public String photo4;
	public String photo5;
	int monthsales;
	int totalsales;
	int commentNum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Data getProductData() {
		return productData;
	}
	public void setProductData(Data productData) {
		this.productData = productData;
	}
	public String getProduce() {
		return produce;
	}
	public void setProduce(String produce) {
		this.produce = produce;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getGoodsPackage() {
		return goodsPackage;
	}
	public void setGoodsPackage(String goodsPackage) {
		this.goodsPackage = goodsPackage;
	}
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public String getPhoto3() {
		return photo3;
	}
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	public String getPhoto4() {
		return photo4;
	}
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}
	public String getPhoto5() {
		return photo5;
	}
	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}
	public int getMonthsales() {
		return monthsales;
	}
	public void setMonthsales(int monthsales) {
		this.monthsales = monthsales;
	}
	public int getTotalsales() {
		return totalsales;
	}
	public void setTotalsales(int totalsales) {
		this.totalsales = totalsales;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

}
