package com.zzxtit.shop.web.home.service;

import java.util.List;

import com.zzxtit.shop.web.home.dao.SearchDao;
import com.zzxtit.shop.web.home.entity.Goods;
import com.zzxtit.shop.web.sys.util.Constance;

public class SearchService {

	private SearchDao sd = new SearchDao();
	
	public List<Goods> searchGoodsByType(String keyWord){
		List<Goods> goodsList = sd.searchGoods(keyWord);
		if(goodsList != null) {
			String IMG_SERVER = Constance.IMG_SERVER;
			for (Goods goods : goodsList) {
				goods.setPhotoPath(IMG_SERVER+goods.getPhotoPath());
			}
			return goodsList;
		}
		return null;
	}
}
