--liquibase formatted sql

--changeset zhangda:20180926admin-init-table



CREATE TABLE `sys_dict_prop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type_id` varchar(36) DEFAULT NULL COMMENT '字典类型ID',
  `prop_id` varchar(36) DEFAULT NULL COMMENT '属性ID',
  `prop_name` varchar(100) DEFAULT NULL COMMENT '属性名称',
  `state` varchar(20) DEFAULT NULL COMMENT '状态',
  `show_index` int(10) DEFAULT NULL COMMENT '排序',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='数据字典属性表';



CREATE TABLE `sys_dict_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type_id` varchar(36) DEFAULT NULL COMMENT '类型ID',
  `type_name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父节点ID',
  `show_index` int(10) DEFAULT NULL COMMENT '排序',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='数据字典类型表';



CREATE TABLE `sys_group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色组ID',
  `group_name` varchar(100) DEFAULT NULL COMMENT '角色组名称',
  `remark` varchar(400) DEFAULT NULL COMMENT '备注',
  `show_index` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`group_id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='角色组';



CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_name` varchar(200) DEFAULT NULL COMMENT '菜单名称',
  `parent_menu_id` bigint(20) DEFAULT NULL COMMENT '父菜单名称',
  `loc_type` varchar(45) DEFAULT NULL COMMENT '菜单位置',
  `url` varchar(1000) DEFAULT NULL COMMENT '菜单路径',
  `icon` varchar(200) DEFAULT NULL COMMENT '菜单图标',
  `icon_path` varchar(500) DEFAULT NULL COMMENT '图标路径',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `show_index` int(11) DEFAULT NULL COMMENT '序号',
  `page_type` varchar(45) DEFAULT NULL COMMENT '页面类型',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `operate_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;



CREATE TABLE `sys_org` (
  `org_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `org_name` varchar(200) DEFAULT NULL COMMENT '组织名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级组织id',
  `show_index` int(11) DEFAULT NULL COMMENT '序号',
  `org_code` varchar(45) DEFAULT NULL COMMENT '组织编码',
  `org_level` varchar(100) DEFAULT NULL COMMENT '组织级别',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `org_leader` varchar(200) DEFAULT NULL COMMENT '组织负责人',
  `org_vice_leader` varchar(500) DEFAULT NULL COMMENT '组织副负责人',
  `state` varchar(20) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`org_id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;


CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `code` varchar(200) DEFAULT NULL COMMENT '权限代码',
  `type` varchar(45) DEFAULT NULL COMMENT '权限类型',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `operate_time` date DEFAULT NULL COMMENT '操作时间',
  `operator` varchar(45) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='权限表';



CREATE TABLE `sys_pos` (
  `pos_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pos_name` varchar(100) DEFAULT NULL COMMENT '岗位名称',
  `pos_code` varchar(45) DEFAULT NULL COMMENT '岗位编码',
  `show_index` int(11) DEFAULT NULL COMMENT '序号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `level` varchar(45) DEFAULT NULL COMMENT '职级',
  `job` varchar(45) DEFAULT NULL COMMENT '职务',
  PRIMARY KEY (`pos_id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;


CREATE TABLE `sys_resource_api` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(300) DEFAULT NULL COMMENT '路径url',
  `name` varchar(500) DEFAULT NULL COMMENT '名称',
  `type` varchar(45) DEFAULT NULL COMMENT '类型（自动扫描，人工录入）',
  `operate_time` date DEFAULT NULL COMMENT '操作时间',
  `operator` varchar(45) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='资源api库';



CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(400) DEFAULT NULL COMMENT '备注',
  `show_index` int(10) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`role_id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;



CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;



CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(100) DEFAULT NULL COMMENT '工号',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) DEFAULT NULL COMMENT '用户密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `org_id` bigint(20) DEFAULT NULL COMMENT '直接上级组织id',
  `org_name` varchar(100) DEFAULT NULL COMMENT '组织',
  `company_id` bigint(20) DEFAULT NULL COMMENT '单位id',
  `org_path` varchar(300) DEFAULT NULL COMMENT '所属组织路径',
  `login_state` varchar(45) DEFAULT NULL COMMENT '登录状态',
  `account_state` varchar(45) DEFAULT NULL COMMENT '账户状态',
  `leader_id` bigint(20) DEFAULT NULL COMMENT '直接上级id',
  `leader_name` varchar(45) DEFAULT NULL COMMENT '直接上级',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(45) DEFAULT NULL COMMENT '座机号',
  `cell_phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `lock_time_start` datetime DEFAULT NULL COMMENT '锁定开始时间',
  `lock_time_end` datetime DEFAULT NULL COMMENT '锁定截止时间',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `show_index` int(10) DEFAULT NULL COMMENT '排序',
  `photo` varchar(500) DEFAULT NULL COMMENT '头像',
  `id_number` varchar(45) DEFAULT NULL COMMENT '身份证号',
  `face_id` varchar(500) DEFAULT NULL COMMENT '面部特征',
  `user_no` varchar(45) DEFAULT NULL COMMENT '人员编号',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `job` varchar(45) DEFAULT NULL COMMENT '职务',
  `category` varchar(45) DEFAULT NULL COMMENT '人员类别',
  `work_type` varchar(45) DEFAULT NULL COMMENT '工种',
  `education` varchar(45) DEFAULT NULL COMMENT '文化程度',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_code_UNIQUE` (`user_code`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='用户信息表';



CREATE TABLE `sys_user_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `org_id` bigint(20) DEFAULT NULL COMMENT '组织id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `is_primary_org` varchar(10) DEFAULT NULL COMMENT '是否主组织',
  `is_org_leader` varchar(10) DEFAULT NULL COMMENT '是否组织负责人',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;



CREATE TABLE `sys_user_pos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pos_id` bigint(20) DEFAULT NULL COMMENT '岗位id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `is_primary_pos` varchar(10) DEFAULT NULL COMMENT '是否是主岗位',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;



CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;


create table `sys_role_group`(
   `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
   `group_id` bigint COMMENT '角色组ID',
   `role_id` bigint COMMENT '角色ID',
   PRIMARY KEY (`id`)
 ) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
alter table sys_role_group comment '角色与角色组对应表';

--changeset wangdr:20181018admin-table-init

CREATE TABLE `sys_user_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `group_id` bigint(20) DEFAULT NULL COMMENT '角色组ID',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='角色组对应用户';

--changeset wangderen:20180928admin-table

CREATE TABLE `user_credentials` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `certificate_number` varchar(100) DEFAULT NULL COMMENT '证书编号',
  `credentials_name` varchar(100) DEFAULT NULL COMMENT '资质名称',
  `credentials_type` varchar(30) DEFAULT NULL COMMENT '资质分类',
  `begin_date` date DEFAULT NULL COMMENT '证书下发日期',
  `end_date` date DEFAULT NULL COMMENT '证书截止日期',
  `attachment` varchar(500) DEFAULT NULL COMMENT '证书附件',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=100000  DEFAULT CHARSET=utf8 COMMENT='用户资质';

CREATE TABLE `user_train` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `train_name` varchar(100) DEFAULT NULL COMMENT '培训名称',
  `train_level` varchar(30) DEFAULT NULL COMMENT '培训级别',
  `train_type` varchar(30) DEFAULT NULL COMMENT '培训类别',
  `train_score` decimal(10,0) DEFAULT NULL COMMENT '成绩',
  `train_date` date DEFAULT NULL COMMENT '培训时间',
  `train_place` varchar(100) DEFAULT NULL COMMENT '培训地点',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=100000  DEFAULT CHARSET=utf8 COMMENT='人员培训记录';

--changeset wangdr:20181031admin-table

ALTER TABLE user_train MODIFY COLUMN train_score decimal(10,2) DEFAULT NULL NULL COMMENT '成绩';

--changeset wangdr:20181101admin-table

ALTER TABLE sys_org ADD org_leadername varchar(200) DEFAULT NULL COMMENT '组织负责人姓名';
ALTER TABLE sys_org ADD org_vice_leadername varchar(200) DEFAULT NULL COMMENT '组织副负责人姓名';

--changeset wangdr:20181102admin-table

ALTER TABLE sys_user MODIFY COLUMN job varchar(45) COMMENT '岗位名称';

--changeset wangdr:20181105admin-table

ALTER TABLE user_credentials ADD flow_state varchar(100) NULL COMMENT '流程状态';

--changeset wangdr:20181106admin-table

ALTER TABLE sys_user ADD major varchar(100) NULL COMMENT '专业';

--changeset wangdr:20181107admin-table
ALTER TABLE sys_user ADD jobName varchar(1000) NULL COMMENT '岗位名称';
ALTER TABLE sys_user MODIFY COLUMN job varchar(1000) NULL COMMENT '岗位ID';


--changeset yangliuqing:20190110admin-init-table
CREATE TABLE `sys_flow_type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `bid` varchar(50) DEFAULT NULL,
  `typeid` varchar(200) DEFAULT NULL COMMENT '类型id',
  `typename` varchar(200) DEFAULT NULL COMMENT '类型名称',
  `typedesc` varchar(200) DEFAULT NULL COMMENT '类型描述',
  `spare0` varchar(200) DEFAULT NULL COMMENT '备用0',
  `spare1` varchar(200) DEFAULT NULL COMMENT '备用1',
  `spare2` varchar(200) DEFAULT NULL COMMENT '备用2',
  `spare3` varchar(200) DEFAULT NULL COMMENT '备用3',
  `spare4` varchar(200) DEFAULT NULL COMMENT '备用4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='流程类型';


CREATE TABLE `sys_flow_url` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `bid` varchar(50) DEFAULT NULL,
  `urltype` varchar(100) DEFAULT NULL COMMENT '表单类型',
  `urlid` varchar(200) DEFAULT NULL COMMENT '表单id',
  `urlname` varchar(200) DEFAULT NULL COMMENT '表单名称',
  `urldesc` varchar(200) DEFAULT NULL COMMENT '表单描述',
  `spare0` varchar(200) DEFAULT NULL COMMENT '备用0',
  `spare1` varchar(200) DEFAULT NULL COMMENT '备用1',
  `spare2` varchar(200) DEFAULT NULL COMMENT '备用2',
  `spare3` varchar(200) DEFAULT NULL COMMENT '备用3',
  `spare4` varchar(200) DEFAULT NULL COMMENT '备用4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='流程表单';

--changeset qixiaodong:20190116admin-init-table
ALTER TABLE sys_user ADD politicalfeature varchar(100) DEFAULT NULL NULL COMMENT '政治面貌';
