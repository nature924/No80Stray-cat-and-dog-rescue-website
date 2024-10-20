package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuanduixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuanduixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuanduixinxiView;


/**
 * 团队信息
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface TuanduixinxiService extends IService<TuanduixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuanduixinxiVO> selectListVO(Wrapper<TuanduixinxiEntity> wrapper);
   	
   	TuanduixinxiVO selectVO(@Param("ew") Wrapper<TuanduixinxiEntity> wrapper);
   	
   	List<TuanduixinxiView> selectListView(Wrapper<TuanduixinxiEntity> wrapper);
   	
   	TuanduixinxiView selectView(@Param("ew") Wrapper<TuanduixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuanduixinxiEntity> wrapper);
   	

}

