package com.zzxtit.shop.web.sys.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constance {

	public static String IMG_SERVER = "http://localhost";
	
	static {
		Properties properties = new Properties();
		InputStream inputStream = Constance.class.getClassLoader().getResourceAsStream("sys.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		IMG_SERVER = properties.getProperty("imgServer");
	}
}
