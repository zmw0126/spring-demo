package com.eccl.cloud.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eccl.cloud.common.web.RM;
import com.eccl.cloud.demo.domain.SysUserPos;
import com.eccl.cloud.demo.service.SysUserPosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="用户岗位", tags= {"用户岗位接口"})
@RestController
@RequestMapping("/userPos")
public class SysUserPosController {
	@Autowired
	private SysUserPosService sysUserPosService;
	
	@ApiOperation(value="创建用户岗位")
	@PostMapping (produces = { "application/json;charset=UTF-8" })
	public RM insert(@Valid @RequestBody SysUserPos sysUserPos) {
		if(sysUserPosService.insert(sysUserPos) > 0) {
			return new RM(RM.SUCCESS);
		}else {
			return new RM(RM.ERROR,"操作失败！");
		}
	}
	
	@ApiOperation(value="设置用户主岗位")
	@PutMapping(value="/updateIsPrimaryPos",produces = { "application/json;charset=UTF-8" })
	public RM updateIsPrimaryPos(@RequestBody SysUserPos sysUserPos) {
		try {
			if(sysUserPosService.updateIsPrimaryPos(sysUserPos) > 0) {
				return new RM(RM.SUCCESS);
			}else {
				return new RM(RM.ERROR,"操作失败！");
			}
		}catch(Exception e) {
			Logger.getLogger(this.getClass()).error(e.getMessage());
			return new RM(RM.ERROR,"操作失败！");
		}
	}
	
	@ApiOperation(value="根据用户ID和岗位ID删除用户岗位")
	@DeleteMapping(value="/deleteByUserIdAndPosId",produces = { "application/json;charset=UTF-8" })
	public RM deleteByUserIdAndPosId(@RequestParam Long userId,@RequestParam Long posId) {
		if(sysUserPosService.deleteByUserIdAndPosId(userId,posId) > 0) {
			return new RM(RM.SUCCESS);
		}else {
			return new RM(RM.ERROR, "操作失败！");
		}
	}
	
	@ApiOperation(value="根据岗位ID删除岗位下的所有用户")
	@DeleteMapping(value="/deleteByPosId",produces = { "application/json;charset=UTF-8" })
	public RM deleteByPosId(@RequestParam Long posId) {
		if(sysUserPosService.deleteByPosId(posId) > 0) {
			return new RM(RM.SUCCESS);
		}else {
			return new RM(RM.ERROR, "操作失败！");
		}
	}

	@ApiOperation(value="根据用户ID删除该用户的所有岗位")
	@DeleteMapping(value="/deleteByUserId",produces = { "application/json;charset=UTF-8" })
	public RM deleteByUserId(@RequestParam Long userId) {
		if(sysUserPosService.deleteByUserId(userId) > 0) {
			return new RM(RM.SUCCESS);
		}else {
			return new RM(RM.ERROR, "操作失败！");
		}
	}
	
	@ApiOperation(value="删除用户岗位")
	@DeleteMapping(value="/{id}",produces = { "application/json;charset=UTF-8" })
	public RM delete(@PathVariable("id") Long id) {
		if(sysUserPosService.deleteOne(id) > 0) {
			return new RM(RM.SUCCESS);
		}else {
			return new RM(RM.ERROR, "操作失败！");
		}
	}
	
	@ApiOperation(value="按条件查询用户岗位")
	@PostMapping(value="/findAll",produces = { "application/json;charset=UTF-8" })
	public RM findAll(@RequestBody SysUserPos sysUserPos,@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize) {
		List<SysUserPos> list = sysUserPosService.select(sysUserPos, pageNo, pageSize);
		int totalCount = sysUserPosService.count(sysUserPos);
		return new RM(RM.SUCCESS,totalCount,list);
	}
	
	@ApiOperation(value="按主键查询用户岗位")
	@GetMapping(value="/{id}", produces = { "application/json;charset=UTF-8" })
	public RM findOne(@PathVariable("id") Long id) {
		SysUserPos sysUserPos = sysUserPosService.selectByPrimaryKey(id);
		return new RM(RM.SUCCESS,sysUserPos);
	}
	
}
