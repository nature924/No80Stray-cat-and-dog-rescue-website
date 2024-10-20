package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LingyangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LingyangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LingyangxinxiView;


/**
 * 领养信息
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface LingyangxinxiService extends IService<LingyangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LingyangxinxiVO> selectListVO(Wrapper<LingyangxinxiEntity> wrapper);
   	
   	LingyangxinxiVO selectVO(@Param("ew") Wrapper<LingyangxinxiEntity> wrapper);
   	
   	List<LingyangxinxiView> selectListView(Wrapper<LingyangxinxiEntity> wrapper);
   	
   	LingyangxinxiView selectView(@Param("ew") Wrapper<LingyangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LingyangxinxiEntity> wrapper);
   	

}

