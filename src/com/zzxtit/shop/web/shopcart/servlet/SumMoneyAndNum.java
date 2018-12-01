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
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.google.gson.Gson;
import com.zzxtit.shop.web.common.util.DbUtil;
import com.zzxtit.shop.web.shopcart.entity.GoodsInfo;
import com.zzxtit.shop.web.shopcart.entity.SumMoneyAndNumObject;

@WebServlet("/SumMoneyAndNum")
public class SumMoneyAndNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner qr=new QueryRunner(DbUtil.getDataSource());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double sumMoney=(double) request.getSession().getAttribute("sumMoney");
		String user_id=request.getParameter("user_id");
		int sumNum=(int) request.getSession().getAttribute("sumNum");
		String bar_code=request.getParameter("bar_code");
		String value=request.getParameter("value");
		if(value.equals("+")){
			String sql_select="select * from shopcart where bar_code="+bar_code+"&&user_id="+user_id;
			BigDecimal num;
			try {
				num = new BigDecimal(qr.query(DbUtil.getConn(), sql_select, new BeanHandler<GoodsInfo>(GoodsInfo.class)).goods_num);
				sumMoney+=num.multiply(qr.query(DbUtil.getConn(), sql_select, new BeanHandler<GoodsInfo>(GoodsInfo.class)).price).doubleValue();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			sumNum++;
		}else {
			String sql_select="select * from shopcart where bar_code="+bar_code+"&&user_id="+user_id;
			BigDecimal num;
			try {
				num = new BigDecimal(qr.query(DbUtil.getConn(), sql_select, new BeanHandler<GoodsInfo>(GoodsInfo.class)).goods_num);
				sumMoney-=num.multiply(qr.query(DbUtil.getConn(), sql_select, new BeanHandler<GoodsInfo>(GoodsInfo.class)).price).doubleValue();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			sumNum--;
		}
		request.getSession().setAttribute("sumMoney", sumMoney);
		request.getSession().setAttribute("sumNum", sumNum);
		SumMoneyAndNumObject sumMonAndNumOb=new SumMoneyAndNumObject();
		sumMonAndNumOb.setSumMoney(sumMoney);
		sumMonAndNumOb.setSumNum(sumNum);
		response.getWriter().write(new Gson().toJson(sumMonAndNumOb));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
