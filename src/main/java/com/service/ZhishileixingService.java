package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhishileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhishileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhishileixingView;


/**
 * 知识类型
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface ZhishileixingService extends IService<ZhishileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhishileixingVO> selectListVO(Wrapper<ZhishileixingEntity> wrapper);
   	
   	ZhishileixingVO selectVO(@Param("ew") Wrapper<ZhishileixingEntity> wrapper);
   	
   	List<ZhishileixingView> selectListView(Wrapper<ZhishileixingEntity> wrapper);
   	
   	ZhishileixingView selectView(@Param("ew") Wrapper<ZhishileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhishileixingEntity> wrapper);
   	

}

