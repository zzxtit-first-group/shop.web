package com.zzxtit.shop.web.common.util;
	
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;

public class FormUtil {

	//生成bean对象
	public static Object formToBean(HttpServletRequest request, Class beanClass) {
		ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
    	convertUtilsBean.deregister(Date.class);//将默认的日期转换器去掉
    	convertUtilsBean.register(new DateTimeConverter(), Date.class);//注册自己写的日期转换器
    	//实例化BeanUtilsBean
    	BeanUtilsBean beanUtilsBean = new BeanUtilsBean(convertUtilsBean, new PropertyUtilsBean());
		Object o = null;
		try {
			//通过此Class类表示类创建对象
			o = beanClass.newInstance();
			beanUtilsBean.populate(o, request.getParameterMap());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return o;
	}
}
