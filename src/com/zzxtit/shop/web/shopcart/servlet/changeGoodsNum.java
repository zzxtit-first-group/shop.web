package com.zzxtit.shop.web.shopcart.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.google.gson.Gson;
import com.zzxtit.shop.web.common.util.DbUtil;
import com.zzxtit.shop.web.shopcart.entity.GoodsInfo;
import com.zzxtit.shop.web.shopcart.entity.ShopNumInfo;

/**
 * Servlet implementation class changeGoodsNum
 */
@WebServlet("/changeGoodsNum")
public class changeGoodsNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner qr=new QueryRunner(DbUtil.getDataSource());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String value=request.getParameter("value");
		String bar_code=request.getParameter("bar_code");
		String user_id=request.getParameter("user_id");
		ShopNumInfo gi=new ShopNumInfo();
		double singleGoodSum=0;
		GoodsInfo gd=null;;
		if(value.equals("+")){
			String sql_select="select * from shopcart where bar_code="+bar_code+"&&user_id="+user_id;
			try {
				gd=qr.query(DbUtil.getConn(), sql_select, new BeanHandler<GoodsInfo>(GoodsInfo.class));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			gd.goods_num++;
			BigDecimal num=new BigDecimal(gd.goods_num);
			singleGoodSum=num.multiply(gd.price).doubleValue();
			gi.setNum(gd.goods_num);
			gi.setSingleGoodSum(singleGoodSum);
			String sql_int="update shopcart set goods_num=?where bar_code="+bar_code+"&&user_id="+user_id;
			String sql_double="update shopcart set sumMoney=?where bar_code="+bar_code+"&&user_id="+user_id;
			try {
				qr.update(sql_int, num);
				qr.update(sql_double, singleGoodSum);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			String sql_select="select * from shopcart where bar_code="+bar_code+"&&user_id="+user_id;
			try {
				gd=qr.query(DbUtil.getConn(), sql_select, new BeanHandler<GoodsInfo>(GoodsInfo.class));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			gd.goods_num--;
			BigDecimal num=new BigDecimal(gd.goods_num);
			singleGoodSum=num.multiply(gd.price).doubleValue();
			gi.setNum(gd.goods_num);
			gi.setSingleGoodSum(singleGoodSum);
			String sql_int="update shopcart set goods_num=?where bar_code="+bar_code+"&&user_id="+user_id;
			String sql_double="update shopcart set sumMoney=?where bar_code="+bar_code+"&&user_id="+user_id;
			try {
				qr.update(sql_int, num);
				qr.update(sql_double, singleGoodSum);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		response.getWriter().write(new Gson().toJson(gi));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
