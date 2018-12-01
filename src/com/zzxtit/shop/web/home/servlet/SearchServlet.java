package com.zzxtit.shop.web.home.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxtit.shop.web.home.entity.Goods;
import com.zzxtit.shop.web.home.service.SearchService;

@WebServlet("/Search")
public class SearchServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyWord = request.getParameter("keyWord");
		List<Goods> goodsList = new SearchService().searchGoodsByType(keyWord);
		request.setAttribute("goodsList", goodsList);
		request.getRequestDispatcher("jsp/home/search.jsp").forward(request, response);
	}
}
