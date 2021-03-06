package com.example.zhw.springshardingsphere.mapper;

import com.example.zhw.springshardingsphere.vo.Orders;

public interface OrdersMapper
{
	/**
	 * delete by primary key
	 * 
	 * @param id
	 *            primaryKey
	 * @return deleteCount
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * insert record to table
	 * 
	 * @param record
	 *            the record
	 * @return insert count
	 */
	int insert(Orders record);

	/**
	 * insert record to table selective
	 * 
	 * @param record
	 *            the record
	 * @return insert count
	 */
	int insertSelective(Orders record);

	/**
	 * select by primary key
	 * 
	 * @param id
	 *            primary key
	 * @return object by primary key
	 */
	Orders selectByPrimaryKey(Long id);

	/**
	 * update record selective
	 * 
	 * @param record
	 *            the updated record
	 * @return update count
	 */
	int updateByPrimaryKeySelective(Orders record);

	/**
	 * update record
	 * 
	 * @param record
	 *            the updated record
	 * @return update count
	 */
	int updateByPrimaryKey(Orders record);
}