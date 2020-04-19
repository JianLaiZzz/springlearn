package com.example.zhw.entry;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "uesr")
public class User implements Serializable
{
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField(value = "username")
	private String username;

	@TableField(value = "password")
	private String password;

	@TableField(value = "birthday")
	private Date birthday;

	private static final long serialVersionUID = 1L;

	public static final String COL_USERNAME = "username";

	public static final String COL_PASSWORD = "password";

	public static final String COL_BIRTHDAY = "birthday";
}