package com.entity.view;

import com.entity.LiulangmaogouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 流浪猫狗
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@TableName("liulangmaogou")
public class LiulangmaogouView  extends LiulangmaogouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LiulangmaogouView(){
	}
 
 	public LiulangmaogouView(LiulangmaogouEntity liulangmaogouEntity){
 	try {
			BeanUtils.copyProperties(this, liulangmaogouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
