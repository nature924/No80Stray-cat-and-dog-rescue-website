package com.entity.view;

import com.entity.ZhishileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 知识类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@TableName("zhishileixing")
public class ZhishileixingView  extends ZhishileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhishileixingView(){
	}
 
 	public ZhishileixingView(ZhishileixingEntity zhishileixingEntity){
 	try {
			BeanUtils.copyProperties(this, zhishileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
