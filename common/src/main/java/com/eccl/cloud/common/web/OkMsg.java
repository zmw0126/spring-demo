package com.eccl.cloud.common.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/***
 * 请求成功model
* @Description: 
* @author zhangda  
* @date 2018年9月29日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OkMsg extends Msg{
	private static OkMsg instance;
	
	private String msg;
	private List list;
	private List data;
	private Object object;
	private Integer totalCount;
    private Long recordsTotal;   
    private Long recordsFiltered;  
    
    public static OkMsg getInstance() {
    	if(instance == null) {
    		instance = new OkMsg();
    		instance.setSuccess(true);
    	}else {
    		clear();
    	}
    	return instance;
    }
    
    public OkMsg msg(String msg) {
    	instance.setMsg(msg);
    	return instance;
    }
    
    public List getList() {
		return list;
	}

	public OkMsg setList(List list) {
		this.list = list;
		return this;
	}

	public List getData() {
		return data;
	}

	public OkMsg setData(List data) {
		this.data = data;
		return this;
	}

	public Object getObject() {
		return object;
	}

	public OkMsg setObject(Object object) {
		this.object = object;
		return this;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public OkMsg setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		return this;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public OkMsg setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
		return this;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public OkMsg setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
		return this;
	}
	
	public String getMsg() {
		return msg;
	}

	public OkMsg setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	
	private static OkMsg clear() {
		instance.setData(null);
		instance.setList(null);
		instance.setMsg(null);
		instance.setObject(null);
		instance.setRecordsFiltered(null);
		instance.setRecordsTotal(null);
		instance.setTotalCount(null);
		return instance;
	}
}
