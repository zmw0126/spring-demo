package com.eccl.cloud.common.domain;

import java.io.Serializable;
import java.util.HashMap;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/***
 *   消息实体
 * @author zhangda
 *
 */

@ApiModel(value = "MqttMessage", description = "消息实体")
public class MqttMessage implements Serializable{
	
	@ApiModelProperty(value = "topic", required=true, notes="推送的topic，可以是指定的userId，all代表全部推送")
	private String topic;
	
	@ApiModelProperty(value = "推送标题",  required=true)
	private String title;
	
	@ApiModelProperty(value = "推送内容",  required=true)
	private String text;
	
	@ApiModelProperty(value = "推送类型",  notes="用于终端判断消息类型，进而进行下一步的操作")
	private String type;
	
	@ApiModelProperty(value = "附加参数",  notes="自定义键值对")
	private HashMap<String, Object> map;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public HashMap<String, Object> getMap() {
		return map;
	}
	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
}
