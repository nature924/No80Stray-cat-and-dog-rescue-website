package com.entity.view;

import com.entity.TuanduixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 团队信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@TableName("tuanduixinxi")
public class TuanduixinxiView  extends TuanduixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TuanduixinxiView(){
	}
 
 	public TuanduixinxiView(TuanduixinxiEntity tuanduixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tuanduixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
