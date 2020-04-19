package com.example.zhw.entry;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zhw
 * @createDate: 2020/4/19
 */
@Data
public class UserEntity implements Serializable
{

	private Long id;
	private String guid;
	private String name;
	private String age;
	private Date createTime;
}
