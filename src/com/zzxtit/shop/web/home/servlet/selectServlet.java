package com.zzxtit.shop.web.home.servlet;

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
import com.zzxtit.shop.web.home.entity.Goods;
import com.zzxtit.shop.web.sys.util.Constance;

@WebServlet("/select")
public class selectServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private QueryRunner qr=new QueryRunner(DbUtil.getDataSource());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goods_name=request.getParameter("index_none_header_sysc");
		List<Goods> goodlist=new ArrayList<>();
		String sql_selectSimilar="select * from goods where goodsName like '%"+goods_name+"%'";
		try {
			goodlist=qr.query(sql_selectSimilar,new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String IMG_SERVER = Constance.IMG_SERVER;
		for (Goods goods : goodlist) {
			goods.setPhotoPath(IMG_SERVER+goods.getPhotoPath());
		}
		request.getSession().setAttribute("goodsList", goodlist);
		response.sendRedirect("jsp/home/search.jsp");
	}

}
