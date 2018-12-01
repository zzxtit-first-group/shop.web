package com.zzxtit.shop.web.common.pojo;

public class ResMessage {

	private int resCode;
	
	private String resMsg;
	
	private Object data;

	/**
	 * @return the resCode
	 */
	public int getResCode() {
		return resCode;
	}

	/**
	 * @param resCode the resCode to set
	 */
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	/**
	 * @return the resMsg
	 */
	public String getResMsg() {
		return resMsg;
	}

	/**
	 * @param resMsg the resMsg to set
	 */
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
}
