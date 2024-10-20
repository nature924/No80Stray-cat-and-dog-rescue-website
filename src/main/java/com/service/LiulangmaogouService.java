package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiulangmaogouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LiulangmaogouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LiulangmaogouView;


/**
 * 流浪猫狗
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface LiulangmaogouService extends IService<LiulangmaogouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiulangmaogouVO> selectListVO(Wrapper<LiulangmaogouEntity> wrapper);
   	
   	LiulangmaogouVO selectVO(@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);
   	
   	List<LiulangmaogouView> selectListView(Wrapper<LiulangmaogouEntity> wrapper);
   	
   	LiulangmaogouView selectView(@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiulangmaogouEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<LiulangmaogouEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<LiulangmaogouEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<LiulangmaogouEntity> wrapper);



}

