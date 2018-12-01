package com.zzxtit.shop.web.shopcart.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.zzxtit.shop.web.common.util.DbUtil;
import com.zzxtit.shop.web.shopcart.entity.GoodInfoFromDatabase;

/**
 * Servlet implementation class AddShopToShopCart
 */
@WebServlet("/AddShopToShopCart")
public class AddShopToShopCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner qr=new QueryRunner(DbUtil.getDataSource());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodInfoFromDatabase gidb=(GoodInfoFromDatabase) request.getSession().getAttribute("");
		int num=(int) request.getSession().getAttribute("num");
		String user_id= (String) request.getSession().getAttribute("user_id");
		BigDecimal num1=new BigDecimal(num);
		double sumMoney=num1.multiply(gidb.price).doubleValue();
		String sql_String="insert into shopcart(bar_code,goods_name,photo1,taste,pack,user_id)"+"values(?,?,?,?,?,?)";
		String [] value_String= {gidb.barcode,gidb.goodsName,gidb.photo1,gidb.taste,gidb.goodsPackage,user_id};
		String sql_bigDecimal="update shopcart set price=?where bar_code="+gidb.barcode;
		BigDecimal price= gidb.price;
		String sql_int="update shopcart set goods_num=?where bar_code="+gidb.barcode;
		String sql_double="update shopcart set sumMoney=?where bar_code="+gidb.barcode;
		try {
			qr.update(sql_String, value_String);
			qr.update(sql_bigDecimal, price);
			qr.update(sql_int, num);
			qr.update(sql_double, sumMoney);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
