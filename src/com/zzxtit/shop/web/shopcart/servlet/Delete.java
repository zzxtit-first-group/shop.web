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

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner qr=new QueryRunner(DbUtil.getDataSource());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goods_name=request.getParameter("goods_name");
		String user_id=request.getParameter("user_id");
		if(!goods_name.equals("")) {
			String sql_delete="delete * from shopcart where goods_name=?&&user_id="+user_id;
			try {
				qr.update(sql_delete, goods_name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			List<GoodsInfo> goodlist=new ArrayList<>();
			String sql_selectAll="select * from shopcartuser_id="+user_id;
			try {
				goodlist=qr.query(DbUtil.getConn(),sql_selectAll,new BeanListHandler<GoodsInfo>(GoodsInfo.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("goodlist", goodlist);
			response.sendRedirect("shopcart.jsp");
		}else {
			String sql_delete="delete * from shopcart";
			try {
				qr.update(sql_delete);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			List<GoodsInfo> goodlist=new ArrayList<>();
			String sql_selectAll="select * from shopcartuser_id="+user_id;
			try {
				goodlist=qr.query(DbUtil.getConn(),sql_selectAll,new BeanListHandler<GoodsInfo>(GoodsInfo.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("goodlist", goodlist);
			response.sendRedirect("shopcart.jsp");
		}
	}
}
