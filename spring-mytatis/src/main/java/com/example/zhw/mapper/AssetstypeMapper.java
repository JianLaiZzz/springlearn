package com.example.zhw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zhw.entry.Assetstype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZhangWei
 * @Date 2021/8/4 22:08
 * @Version 1.0
 */

@Mapper
public interface AssetstypeMapper extends BaseMapper<Assetstype>
{
	int batchInsert(@Param("list") List<Assetstype> list);
}