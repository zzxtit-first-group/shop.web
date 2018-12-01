<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>购物车页面</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="../css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="../js/jquery.js"></script>
		<style type="text.css">
				#goodNum{
				}
		
		</style>
	</head>
	<script type="text/javascript">
		try{
			xhr = new XMLHttpRequest();
		}catch(e){
			try{
			 	xhr = new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
	
		function judge(bar_code,user_id){
			
			if($('#J_CheckBox_${good.bar_code}').is(':checked')) {
				var reqUrl = "${pageContext.request.contextPath}/SumMoneyAndNum?bar_code="+barcode+"&value="+"+"+"&user_id="user_id;
				xhr.open("get",reqUrl,true);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4 && xhr.status == 200){
						var respText = JSON.parse(xhr.responseText);
						$("#J_Total").html(respText.sumMoney);
						$("#sumNum").html(respText.sumNum);
					}
				}
				xhr.send();
			}else{
				var reqUrl = "${pageContext.request.contextPath}/SumMoneyAndNum?bar_code="+barcode+"&value="+"-"+"&user_id="user_id;
				xhr.open("get",reqUrl,true);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4 && xhr.status == 200){
						var respText = JSON.parse(xhr.responseText);
						$("#J_Total").html(respText.sumMoney);
						$("#sumNum").html(respText.sumNum);
					}
				}
				xhr.send();
			}
			
		}
		
		function addGoodNum(bar_code,user_id){
			var reqUrl = "${pageContext.request.contextPath}/changeGoodsNum?bar_code="+barcode+"&value="+"+"+"&user_id="user_id;
			xhr.open("get",reqUrl,true);
			xhr.onreadystatechange=function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					var respText = JSON.parse(xhr.responseText);
					$("#goodNum").html(respText.num);
					$("#J_Total").html(respText.singleGoodSum);
				}
			}
			xhr.send();
		}
		
		function subGoodNum(bar_code,user_id){
			var reqUrl = "${pageContext.request.contextPath}/changeGoodsNum?bar_code="+barcode+"&value="+"-"+"&user_id="user_id;
			xhr.open("get",reqUrl,true);
			xhr.onreadystatechange=function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					var respText = JSON.parse(xhr.responseText);
					$("goodNum").html(respText.num);
					$("#J_Total").html(respText.singleGoodSum);
				}
			}
			xhr.send();
		}
	
	</script>
	<body>
	
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">亲，请登录</a>
						<a href="#" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
			</ul>
			</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="../images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="../images/logobig.png" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>

			<!--购物车 -->
			<form action="/ShopCartToList">
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
							</div>
							<div class="clear"></div>
							<div class="bundle-main">
							<c:forEach items="${goodlist}" var="good" }>
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" id="J_CheckBox_${good.bar_code }" name="items[]" value="${good.bar_code }" type="checkbox" onclick="judge(${good.goods_bar_code },${good.user_id })">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title="${good.goods_name }" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="${good.goods_photo1 }" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title="${good.goods_name }" class="item-title J_MakePoint" data-point="tbcart.8.11">${good.goods_name }</a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
											<span class="sku-line">口味：${good.goods_taste }</span>
											<span class="sku-line">包装：${good.goods_pack }</span>
											<i class="theme-login am-icon-sort-desc"></i>
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">${good.goods_price }</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
												<input class="min am-btn" name="" type="button" value="-" onclick="sumGoodNum(${good.goods_bar_code },${good.user_id })">
													<input class="text_box" id="goodNum" name="" type="text" value="${good.goods_num }"  style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+" onclick="addGoodNum(${good.goods_bar_code },${good.user_id })">
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number"></em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a href="/Delete?goods_name=${good.goods_name}&user_id=${good.user_id}" data-point-url="#" class="delete">
                  删除</a>
										</div>
									</li>
								</ul>
													
								
								
							</c:forEach>
							</div>
						</div>
					</tr>
					<div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="clear"></div>
						</div>
					</tr>
				</div>
				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
							<label for="J_SelectAllCbx2"></label>
						</div>
					</div>
					<div class="operations">
						<a href="/Delete?goods_name= " data-point-url="#" class="delete">删除</a>
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">${sumNum}</em><span class="txt" id="sumNum">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total"></em></strong>
						</div>
						<div class="btn-area">
							<a href="pay.html" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<input type="submit" value="结&nbsp;算"></a>
						</div>
					</div>

				</div>
				</form>
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
						</p>
					</div>
				</div>

			</div>
	</body>

</html>