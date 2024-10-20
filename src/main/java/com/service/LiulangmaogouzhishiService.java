package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiulangmaogouzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LiulangmaogouzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LiulangmaogouzhishiView;


/**
 * 流浪猫狗知识
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface LiulangmaogouzhishiService extends IService<LiulangmaogouzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiulangmaogouzhishiVO> selectListVO(Wrapper<LiulangmaogouzhishiEntity> wrapper);
   	
   	LiulangmaogouzhishiVO selectVO(@Param("ew") Wrapper<LiulangmaogouzhishiEntity> wrapper);
   	
   	List<LiulangmaogouzhishiView> selectListView(Wrapper<LiulangmaogouzhishiEntity> wrapper);
   	
   	LiulangmaogouzhishiView selectView(@Param("ew") Wrapper<LiulangmaogouzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiulangmaogouzhishiEntity> wrapper);
   	

}

