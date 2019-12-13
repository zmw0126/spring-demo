package com.eccl.cloud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.eccl.cloud.demo.dao.SysUserPosMapper;
import com.eccl.cloud.demo.domain.SysUserPos;
import com.eccl.cloud.demo.domain.SysUserPosExample;
import com.github.pagehelper.PageHelper;

@Service
public class SysUserPosService {

	@Autowired
	private SysUserPosMapper sysUserPosMapper;
	
	public int insert(SysUserPos sysUserPos) {
		return sysUserPosMapper.insert(sysUserPos);
	}
	
	public int updateByPrimaryKeySelective(SysUserPos sysUserPos) {
		return sysUserPosMapper.updateByPrimaryKeySelective(sysUserPos);
	}
	
	public List<SysUserPos> select(SysUserPos sysUserPos,int pageNo,int pageSize){
		PageHelper.startPage(pageNo,pageSize);
		return sysUserPosMapper.select(sysUserPos);
	}
	
	public List<SysUserPos> selectByExample(SysUserPosExample example){
		return sysUserPosMapper.selectByExample(example);
	}
	
	public SysUserPos selectByPrimaryKey(Long id) {
		return sysUserPosMapper.selectByPrimaryKey(id);
	}
	
	public int count(SysUserPos sysUserPos) {
		return sysUserPosMapper.selectCount(sysUserPos);
	}
	
	public int deleteOne(Long id) {
		return sysUserPosMapper.deleteByPrimaryKey(id);
	}
	
	public int deleteByUserIdAndPosId(Long userId,Long posId) {
		SysUserPos sysUserPos = new SysUserPos();
		sysUserPos.setPosId(posId);
		sysUserPos.setUserId(userId);
		return sysUserPosMapper.delete(sysUserPos);
	}
	
	public int deleteByPosId(Long posId) {
		SysUserPos sysUserPos = new SysUserPos();
		sysUserPos.setPosId(posId);
		return sysUserPosMapper.delete(sysUserPos);
	}
	
	public int deleteByUserId(Long userId) {
		SysUserPos sysUserPos = new SysUserPos();
		sysUserPos.setUserId(userId);
		return sysUserPosMapper.delete(sysUserPos);
	}
	
	@Transactional(rollbackFor={RuntimeException.class, Exception.class})
	public int updateIsPrimaryPos(SysUserPos sysUserPos) throws Exception{
		//先更新该用户所有的岗位为非主岗位
		SysUserPos tempUserPos = new SysUserPos();
		tempUserPos.setIsPrimaryPos("0");
		SysUserPosExample example = new SysUserPosExample();
		example.createCriteria().andUserIdEqualTo(sysUserPos.getUserId());
		int rowCount = sysUserPosMapper.updateByExampleSelective(tempUserPos, example);
		if(rowCount == 0){	
			throw new RuntimeException("更新用户所有岗位为非主岗位时发生异常！");
		}
		//再更新用户的指定岗位为主岗位
		if(sysUserPos.getId() != null) {
			tempUserPos = new SysUserPos();
			tempUserPos.setId(sysUserPos.getId());
			tempUserPos.setIsPrimaryPos("1");
			return sysUserPosMapper.updateByPrimaryKeySelective(sysUserPos);
		}else {
			tempUserPos = new SysUserPos();
			tempUserPos.setIsPrimaryPos("1");
			example = new SysUserPosExample();
			example.createCriteria()
			.andUserIdEqualTo(sysUserPos.getUserId())
			.andPosIdEqualTo(sysUserPos.getPosId());
			return sysUserPosMapper.updateByExampleSelective(tempUserPos, example);
		}
	}
	
}
