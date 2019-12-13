package com.eccl.cloud.demo.remote;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.eccl.cloud.common.domain.SysUser;
import com.eccl.cloud.common.web.RM;

@FeignClient (name="cloud-admin")
public interface UserRemoteService {
	
	@PostMapping 
	public RM insert(@Valid @RequestBody SysUser sysUser);
	
	@PutMapping (value = "/user/{id}")
	public RM update(@PathVariable("id") Long id, @RequestBody SysUser sysUser) ;
	
	@DeleteMapping (value = "/user/{id}")
	public RM deleteOne(@PathVariable("id") Long id) ;
	
	@PostMapping (value="/user/")
	public RM findAll(@RequestBody SysUser sysUser, @RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize) ;
	
	@GetMapping (value = "/user/{id}")
	public RM findOne(@PathVariable("id") Long id) ;
	
}
