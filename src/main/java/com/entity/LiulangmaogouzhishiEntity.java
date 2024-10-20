package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 流浪猫狗知识
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@TableName("liulangmaogouzhishi")
public class LiulangmaogouzhishiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LiulangmaogouzhishiEntity() {
		
	}
	
	public LiulangmaogouzhishiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 知识标题
	 */
					
	private String zhishibiaoti;
	
	/**
	 * 知识类型
	 */
					
	private String zhishileixing;
	
	/**
	 * 宠物图片
	 */
					
	private String chongwutupian;
	
	/**
	 * 形态特征
	 */
					
	private String xingtaitezheng;
	
	/**
	 * 生活习性
	 */
					
	private String shenghuoxixing;
	
	/**
	 * 驯养方法
	 */
					
	private String xunyangfangfa;
	
	/**
	 * 注意事项
	 */
					
	private String zhuyishixiang;
	
	/**
	 * 知识内容
	 */
					
	private String zhishineirong;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：知识标题
	 */
	public void setZhishibiaoti(String zhishibiaoti) {
		this.zhishibiaoti = zhishibiaoti;
	}
	/**
	 * 获取：知识标题
	 */
	public String getZhishibiaoti() {
		return zhishibiaoti;
	}
	/**
	 * 设置：知识类型
	 */
	public void setZhishileixing(String zhishileixing) {
		this.zhishileixing = zhishileixing;
	}
	/**
	 * 获取：知识类型
	 */
	public String getZhishileixing() {
		return zhishileixing;
	}
	/**
	 * 设置：宠物图片
	 */
	public void setChongwutupian(String chongwutupian) {
		this.chongwutupian = chongwutupian;
	}
	/**
	 * 获取：宠物图片
	 */
	public String getChongwutupian() {
		return chongwutupian;
	}
	/**
	 * 设置：形态特征
	 */
	public void setXingtaitezheng(String xingtaitezheng) {
		this.xingtaitezheng = xingtaitezheng;
	}
	/**
	 * 获取：形态特征
	 */
	public String getXingtaitezheng() {
		return xingtaitezheng;
	}
	/**
	 * 设置：生活习性
	 */
	public void setShenghuoxixing(String shenghuoxixing) {
		this.shenghuoxixing = shenghuoxixing;
	}
	/**
	 * 获取：生活习性
	 */
	public String getShenghuoxixing() {
		return shenghuoxixing;
	}
	/**
	 * 设置：驯养方法
	 */
	public void setXunyangfangfa(String xunyangfangfa) {
		this.xunyangfangfa = xunyangfangfa;
	}
	/**
	 * 获取：驯养方法
	 */
	public String getXunyangfangfa() {
		return xunyangfangfa;
	}
	/**
	 * 设置：注意事项
	 */
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
	/**
	 * 设置：知识内容
	 */
	public void setZhishineirong(String zhishineirong) {
		this.zhishineirong = zhishineirong;
	}
	/**
	 * 获取：知识内容
	 */
	public String getZhishineirong() {
		return zhishineirong;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}

}
