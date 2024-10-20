package com.entity.view;

import com.entity.HuodongfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@TableName("huodongfenlei")
public class HuodongfenleiView  extends HuodongfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongfenleiView(){
	}
 
 	public HuodongfenleiView(HuodongfenleiEntity huodongfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, huodongfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
