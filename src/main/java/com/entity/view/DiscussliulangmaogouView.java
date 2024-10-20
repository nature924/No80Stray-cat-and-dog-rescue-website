package com.entity.view;

import com.entity.DiscussliulangmaogouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 流浪猫狗评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
@TableName("discussliulangmaogou")
public class DiscussliulangmaogouView  extends DiscussliulangmaogouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussliulangmaogouView(){
	}
 
 	public DiscussliulangmaogouView(DiscussliulangmaogouEntity discussliulangmaogouEntity){
 	try {
			BeanUtils.copyProperties(this, discussliulangmaogouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
