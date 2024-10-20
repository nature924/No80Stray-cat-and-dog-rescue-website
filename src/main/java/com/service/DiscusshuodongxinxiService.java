package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusshuodongxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusshuodongxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusshuodongxinxiView;


/**
 * 活动信息评论表
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface DiscusshuodongxinxiService extends IService<DiscusshuodongxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusshuodongxinxiVO> selectListVO(Wrapper<DiscusshuodongxinxiEntity> wrapper);
   	
   	DiscusshuodongxinxiVO selectVO(@Param("ew") Wrapper<DiscusshuodongxinxiEntity> wrapper);
   	
   	List<DiscusshuodongxinxiView> selectListView(Wrapper<DiscusshuodongxinxiEntity> wrapper);
   	
   	DiscusshuodongxinxiView selectView(@Param("ew") Wrapper<DiscusshuodongxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusshuodongxinxiEntity> wrapper);
   	

}

