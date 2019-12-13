package com.eccl.cloud.common.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table
public class EventRecord implements Serializable {
    /**
     * 主键
     */
	@Id
    private Long id;

    /**
     * 业务id
     */
    private String bid;

    /**
     * 安全帽预警、人员距离预警、安全梯预警、安全带预警等
     */
    private String eventType;

    /**
     * 预警描述，如安全帽sos，人员距离超过30m等
     */
    private String eventDesc;

    /**
     * 关联的人员id
     */
    private Long userId;

    /**
     * 关联的用户账号
     */
    private String userCode;

    /**
     * 关联的用户名
     */
    private String userName;

    /**
     * 关联的组织id
     */
    private Long orgId;

    /**
     * 关联的组织名称
     */
    private String orgName;

    /**
     * 关联的任务id
     */
    private String taskId;

    /**
     * 关联的任务名称
     */
    private String taskName;

    /**
     * 关联的工序id
     */
    private String processId;

    /**
     * 预警时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eventTime;

    /**
     * 是否存在
     */
    private String isexist;

    /**
     * 超限距离
     */
    private String distance;

    /**
     * 是否预警
     */
    private String isSos;

    /**
     * 安全帽告警id
     */
    private Long helmetEventId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc == null ? null : eventDesc.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getIsexist() {
        return isexist;
    }

    public void setIsexist(String isexist) {
        this.isexist = isexist == null ? null : isexist.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getIsSos() {
        return isSos;
    }

    public void setIsSos(String isSos) {
        this.isSos = isSos == null ? null : isSos.trim();
    }

    public Long getHelmetEventId() {
        return helmetEventId;
    }

    public void setHelmetEventId(Long helmetEventId) {
        this.helmetEventId = helmetEventId;
    }
}