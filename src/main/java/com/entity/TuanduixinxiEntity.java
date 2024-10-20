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
 * 团队信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@TableName("tuanduixinxi")
public class TuanduixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TuanduixinxiEntity() {
		
	}
	
	public TuanduixinxiEntity(T t) {
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
	 * 团队名称
	 */
					
	private String tuanduimingcheng;
	
	/**
	 * 团队封面
	 */
					
	private String tuanduifengmian;
	
	/**
	 * 团队地址
	 */
					
	private String tuanduidizhi;
	
	/**
	 * 团队人数
	 */
					
	private Integer tuanduirenshu;
	
	/**
	 * 团队口号
	 */
					
	private String tuanduikouhao;
	
	/**
	 * 负责人
	 */
					
	private String fuzeren;
	
	/**
	 * 创建日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chuangjianriqi;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 团队详情
	 */
					
	private String tuanduixiangqing;
	
	
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
	 * 设置：团队名称
	 */
	public void setTuanduimingcheng(String tuanduimingcheng) {
		this.tuanduimingcheng = tuanduimingcheng;
	}
	/**
	 * 获取：团队名称
	 */
	public String getTuanduimingcheng() {
		return tuanduimingcheng;
	}
	/**
	 * 设置：团队封面
	 */
	public void setTuanduifengmian(String tuanduifengmian) {
		this.tuanduifengmian = tuanduifengmian;
	}
	/**
	 * 获取：团队封面
	 */
	public String getTuanduifengmian() {
		return tuanduifengmian;
	}
	/**
	 * 设置：团队地址
	 */
	public void setTuanduidizhi(String tuanduidizhi) {
		this.tuanduidizhi = tuanduidizhi;
	}
	/**
	 * 获取：团队地址
	 */
	public String getTuanduidizhi() {
		return tuanduidizhi;
	}
	/**
	 * 设置：团队人数
	 */
	public void setTuanduirenshu(Integer tuanduirenshu) {
		this.tuanduirenshu = tuanduirenshu;
	}
	/**
	 * 获取：团队人数
	 */
	public Integer getTuanduirenshu() {
		return tuanduirenshu;
	}
	/**
	 * 设置：团队口号
	 */
	public void setTuanduikouhao(String tuanduikouhao) {
		this.tuanduikouhao = tuanduikouhao;
	}
	/**
	 * 获取：团队口号
	 */
	public String getTuanduikouhao() {
		return tuanduikouhao;
	}
	/**
	 * 设置：负责人
	 */
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
	/**
	 * 设置：创建日期
	 */
	public void setChuangjianriqi(Date chuangjianriqi) {
		this.chuangjianriqi = chuangjianriqi;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getChuangjianriqi() {
		return chuangjianriqi;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：团队详情
	 */
	public void setTuanduixiangqing(String tuanduixiangqing) {
		this.tuanduixiangqing = tuanduixiangqing;
	}
	/**
	 * 获取：团队详情
	 */
	public String getTuanduixiangqing() {
		return tuanduixiangqing;
	}

}
