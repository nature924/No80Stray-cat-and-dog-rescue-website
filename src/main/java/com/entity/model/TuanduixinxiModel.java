package com.entity.model;

import com.entity.TuanduixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 团队信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public class TuanduixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
