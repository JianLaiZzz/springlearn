package com.example.zhw.springshardingsphere.mapper;

import com.example.zhw.springshardingsphere.vo.OrderConfigVo;

public interface OrderConfigMapper
{
	int deleteByPrimaryKey(Integer id);

	int insert(OrderConfigVo record);

	int insertSelective(OrderConfigVo record);

	OrderConfigVo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderConfigVo record);

	int updateByPrimaryKey(OrderConfigVo record);
}