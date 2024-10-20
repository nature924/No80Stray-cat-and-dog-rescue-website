package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussliulangmaogouzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussliulangmaogouzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussliulangmaogouzhishiView;


/**
 * 流浪猫狗知识评论表
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface DiscussliulangmaogouzhishiService extends IService<DiscussliulangmaogouzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussliulangmaogouzhishiVO> selectListVO(Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
   	
   	DiscussliulangmaogouzhishiVO selectVO(@Param("ew") Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
   	
   	List<DiscussliulangmaogouzhishiView> selectListView(Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
   	
   	DiscussliulangmaogouzhishiView selectView(@Param("ew") Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
   	

}

