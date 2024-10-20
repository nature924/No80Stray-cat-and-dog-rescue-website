package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiyuanshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiyuanshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiyuanshenqingView;


/**
 * 志愿申请
 *
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface ZhiyuanshenqingService extends IService<ZhiyuanshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanshenqingVO> selectListVO(Wrapper<ZhiyuanshenqingEntity> wrapper);
   	
   	ZhiyuanshenqingVO selectVO(@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);
   	
   	List<ZhiyuanshenqingView> selectListView(Wrapper<ZhiyuanshenqingEntity> wrapper);
   	
   	ZhiyuanshenqingView selectView(@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanshenqingEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZhiyuanshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZhiyuanshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZhiyuanshenqingEntity> wrapper);



}

