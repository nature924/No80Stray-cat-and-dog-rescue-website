package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusstuanduixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusstuanduixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusstuanduixinxiView;


/**
 * 团队信息评论表
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface DiscusstuanduixinxiService extends IService<DiscusstuanduixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstuanduixinxiVO> selectListVO(Wrapper<DiscusstuanduixinxiEntity> wrapper);
   	
   	DiscusstuanduixinxiVO selectVO(@Param("ew") Wrapper<DiscusstuanduixinxiEntity> wrapper);
   	
   	List<DiscusstuanduixinxiView> selectListView(Wrapper<DiscusstuanduixinxiEntity> wrapper);
   	
   	DiscusstuanduixinxiView selectView(@Param("ew") Wrapper<DiscusstuanduixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstuanduixinxiEntity> wrapper);
   	

}

