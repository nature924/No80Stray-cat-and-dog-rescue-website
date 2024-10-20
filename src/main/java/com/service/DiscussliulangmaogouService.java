package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussliulangmaogouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussliulangmaogouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussliulangmaogouView;


/**
 * 流浪猫狗评论表
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface DiscussliulangmaogouService extends IService<DiscussliulangmaogouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussliulangmaogouVO> selectListVO(Wrapper<DiscussliulangmaogouEntity> wrapper);
   	
   	DiscussliulangmaogouVO selectVO(@Param("ew") Wrapper<DiscussliulangmaogouEntity> wrapper);
   	
   	List<DiscussliulangmaogouView> selectListView(Wrapper<DiscussliulangmaogouEntity> wrapper);
   	
   	DiscussliulangmaogouView selectView(@Param("ew") Wrapper<DiscussliulangmaogouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussliulangmaogouEntity> wrapper);
   	

}

