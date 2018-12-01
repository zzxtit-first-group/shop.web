package com.zzxtit.shop.web.shopcart.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zzxtit.shop.web.common.util.DbUtil;
import com.zzxtit.shop.web.shopcart.entity.GoodsInfo;

/**
 * Servlet implementation class ShopCartToList
 */
@WebServlet("/ShopCartToList")
public class ShopCartToList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner qr=new QueryRunner(DbUtil.getDataSource());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String [] Array_barcode=request.getParameterValues("items[]");
			String user_id=request.getParameter("user_id");
			double sumMoney=0;
			List<GoodsInfo> goodlist=new ArrayList<>();
			for(String good_barcode:Array_barcode) {
				String sql_select="select * from shopcart where bar_code="+good_barcode+"&&user_id="+user_id;
				BigDecimal num;
				try {
					num = new BigDecimal(qr.query(DbUtil.getConn(), sql_select, new BeanHandler<GoodsInfo>(GoodsInfo.class)).goods_num);
					sumMoney+=num.multiply(qr.query(DbUtil.getConn(), sql_select, new BeanHandler<GoodsInfo>(GoodsInfo.class)).price).doubleValue();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					goodlist.add( qr.query(DbUtil.getConn(),sql_select,new BeanHandler<GoodsInfo>(GoodsInfo.class)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			request.getSession().setAttribute("goodlist", goodlist);
			request.getSession().setAttribute("sumMoney", sumMoney);
			request.getSession().setAttribute("user_id", user_id);
			response.sendRedirect("");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
