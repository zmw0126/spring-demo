package com.eccl.cloud.common.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/***
 * 返回json对象封装类（属性为null，不返回）
 * @author zhangda
 * version：1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RM {
	public final static boolean SUCCESS = true;
	public final static boolean ERROR = false;

	public RM() {}

	public RM(boolean isSuccess){
		this.success = isSuccess;
	}
	
	public RM(boolean isSuccess, String msg){
		this.success = isSuccess;
		this.msg = msg;
	}
	
	public RM(boolean isSuccess, String msg, String errorCode){
		this.success = isSuccess;
		this.msg = msg;
		this.errorCode = errorCode;
	}
	
	public RM(boolean isSuccess, List list){
		this.success = isSuccess;
		this.list = list;
	}
	
	public RM(boolean isSuccess, Integer totalCount, List list){
		this.success = isSuccess;
		this.totalCount = totalCount;
		this.list = list;
	}
	
	
	public RM(boolean isSuccess, Long recordsTotal,List data){
		this.success = isSuccess;
		this.total = recordsTotal;
		this.data = data;
	}
	
	public RM(boolean isSuccess, Object object){
		this.success = isSuccess;
		this.object = object;
	}
	
	private boolean success;
	private String msg;
	private String errorCode;
	private List list;
	private Object object;
	private Integer totalCount;
	private Long total;
	private List data;
    private Long recordsTotal;   

    private Long recordsFiltered;  


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
	


	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
	
}
