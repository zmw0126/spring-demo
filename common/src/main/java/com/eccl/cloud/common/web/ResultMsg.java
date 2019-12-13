package com.eccl.cloud.common.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/***
 * 返回json对象封装类（属性为null，不返回）
 * @author zhangda
 * v2.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultMsg {
	private static ResultMsg resultMsg = null;
	private static OkMsg okMsg = null;
	private static FailMsg failMsg = null;
	
    static {
    	if(resultMsg == null) {
    		resultMsg = new ResultMsg();
    	}
    }
    
    /**
     * 成功
     * @return
     */
    public static OkMsg ok() {
    	return OkMsg.getInstance();
    }
    
    /**
     * 失败
     * @return
     */
    public static FailMsg fail() {
    	return FailMsg.getInstance();
    }
	
}
