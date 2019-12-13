package com.eccl.cloud.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eccl.cloud.common.domain.SysUser;
import com.eccl.cloud.common.web.RM;
import com.eccl.cloud.demo.remote.UserRemoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="用户",tags={"用户接口"})
@RestController
@RequestMapping("/user")
public class SysUserController{
	
	@Autowired   
    private UserRemoteService userRemoteService;
	
	@ApiOperation(value="创建用户")
	@PostMapping (produces = { "application/json;charset=UTF-8" })
	public RM insert(@Valid @RequestBody SysUser sysUser) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return userRemoteService.insert(sysUser);
	}
	
	@ApiOperation(value="修改用户")
	@PutMapping (value = "/{id}", produces = { "application/json;charset=UTF-8" })
	public RM update(@PathVariable("id") Long id, @RequestBody SysUser sysUser) {
		return userRemoteService.update(id, sysUser);
	}
	
	@ApiOperation(value="删除用户")
	@DeleteMapping (value = "/{id}", produces = { "application/json;charset=UTF-8" })
	public RM deleteOne(@PathVariable("id") Long id) {
		return userRemoteService.deleteOne(id);
	}
	
	@ApiOperation(value="按条件查询用户")
	@GetMapping (value="/", produces = { "application/json;charset=UTF-8" })
	public RM findAll(@RequestBody SysUser sysUser, @RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize) {
		return userRemoteService.findAll(sysUser, pageNo, pageSize);
	}
	
	@ApiOperation(value="按主键查询用户")
	@GetMapping (value = "/{id}", produces = { "application/json;charset=UTF-8" })
	public RM findOne(@PathVariable("id") Long id) {
		return userRemoteService.findOne(id);
	}
}
