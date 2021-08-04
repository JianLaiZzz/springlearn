package com.example.zhw.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangWei
 * @Date 2021/8/4 22:08
 * @Version 1.0
 */
@ApiModel(value = "com-example-zhw-entry-Assetstype")
@Data
@TableName(value = "t_b_assetstype")
public class Assetstype
{
	/**
	 * 节点编号
	 */
	@TableId(value = "uid", type = IdType.ASSIGN_UUID)
	@ApiModelProperty(value = "节点编号")
	private String uid;

	/**
	 * 区域编码
	 */
	@TableId(value = "area_code", type = IdType.ASSIGN_UUID)
	@ApiModelProperty(value = "区域编码")
	private String areaCode;

	/**
	 * 父节点名称
	 */
	@TableField(value = "puid")
	@ApiModelProperty(value = "父节点名称")
	private String puid;

	/**
	 * 名称
	 */
	@TableField(value = "`name`")
	@ApiModelProperty(value = "名称")
	private String name;

	/**
	 * 描述
	 */
	@TableField(value = "des")
	@ApiModelProperty(value = "描述")
	private String des;

	@TableField(value = "isQuote")
	@ApiModelProperty(value = "")
	private Boolean isquote;

	/**
	 * 模板
	 */
	@TableField(value = "`template`")
	@ApiModelProperty(value = "模板")
	private String template;

	/**
	 * 导入信息
	 */
	@TableField(value = "inputSit")
	@ApiModelProperty(value = "导入信息")
	private String inputsit;

	public static final String COL_UID = "uid";

	public static final String COL_AREA_CODE = "area_code";

	public static final String COL_PUID = "puid";

	public static final String COL_NAME = "name";

	public static final String COL_DES = "des";

	public static final String COL_ISQUOTE = "isQuote";

	public static final String COL_TEMPLATE = "template";

	public static final String COL_INPUTSIT = "inputSit";
}