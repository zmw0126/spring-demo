package com.eccl.cloud.common.web;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

/***
 * 请求失败model
* @Description: 
* @author zhangda  
* @date 2018年9月29日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FailMsg extends Msg{
	private static FailMsg instance;
	private String msg;
	
	@NotNull
	private String errorCode;
	
	public static FailMsg getInstance() {
    	if(instance == null) {
    		instance = new FailMsg();
    		instance.setSuccess(false);
    	}else {
    		clear();
    	}
    	return instance;
    }
	
	public String getMsg() {
		return msg;
	}

	public FailMsg setMsg(String msg) {
		this.msg = msg;
		return instance;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public FailMsg setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return instance;
	}

	private static FailMsg clear() {
		instance.setErrorCode(null);
		instance.setMsg(null);
		return instance;
	}
	
}
