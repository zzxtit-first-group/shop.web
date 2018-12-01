package com.zzxtit.shop.web.shopcart.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zzxtit.shop.web.common.util.DbUtil;
import com.zzxtit.shop.web.shopcart.entity.GoodsInfo;
import com.zzxtit.shop.web.user.entity.User;

@WebServlet("/Shopgoods")
public class Shopgoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner qr=new QueryRunner(DbUtil.getDataSource());

    public Shopgoods() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			double sumMoney=0;
			int sumNum=0;
			User user= (User) request.getSession().getAttribute("user");
			System.out.println(user.getUserId());
			String sql_selectAll="select * from shopcart where user_id="+user.getUserId();
			request.getSession().setAttribute("sumMoney", sumMoney);
			request.getSession().setAttribute("sumNum", sumNum);
			List<GoodsInfo> goodlist=new ArrayList<>();
			try {
				goodlist = qr.query(DbUtil.getConn(),sql_selectAll,new BeanListHandler<GoodsInfo>(GoodsInfo.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("goodlist", goodlist);
			response.sendRedirect("shopcart.jsp");
	}
}
