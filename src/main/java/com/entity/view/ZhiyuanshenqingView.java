package com.entity.view;

import com.entity.ZhiyuanshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 志愿申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
@TableName("zhiyuanshenqing")
public class ZhiyuanshenqingView  extends ZhiyuanshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhiyuanshenqingView(){
	}
 
 	public ZhiyuanshenqingView(ZhiyuanshenqingEntity zhiyuanshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, zhiyuanshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
