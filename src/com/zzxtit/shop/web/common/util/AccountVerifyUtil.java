package com.zzxtit.shop.web.common.util;

import java.util.regex.Pattern;

public class AccountVerifyUtil {

	public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	
	public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
	
	public static boolean isEmail(String email) {
		return Pattern.matches(REGEX_EMAIL, email);
	}
	
	public static boolean isAccount(String account) {
		if(AccountVerifyUtil.isEmail(account)) {
			return true;
		}
		
		if(AccountVerifyUtil.isMobile(account)) {
			return true;
		}
		return false;
	}
}
