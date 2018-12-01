package com.zzxtit.shop.web.home.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zzxtit.shop.web.common.util.DbUtil;
import com.zzxtit.shop.web.home.entity.Goods;

public class SearchDao {

	private QueryRunner qr = new QueryRunner(DbUtil.getDataSource());
	
	public List<Goods> searchGoods(String keyWord){
		String sql = "select * from goods where type='"+keyWord+"'";
		try {
			return qr.query(sql,new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
