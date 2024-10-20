package com.entity.view;

import com.entity.DiscussliulangmaogouzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 流浪猫狗知识评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
@TableName("discussliulangmaogouzhishi")
public class DiscussliulangmaogouzhishiView  extends DiscussliulangmaogouzhishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussliulangmaogouzhishiView(){
	}
 
 	public DiscussliulangmaogouzhishiView(DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishiEntity){
 	try {
			BeanUtils.copyProperties(this, discussliulangmaogouzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
