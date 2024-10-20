package com.dao;

import com.entity.ZhiyuanshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiyuanshenqingVO;
import com.entity.view.ZhiyuanshenqingView;


/**
 * 志愿申请
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface ZhiyuanshenqingDao extends BaseMapper<ZhiyuanshenqingEntity> {
	
	List<ZhiyuanshenqingVO> selectListVO(@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);
	
	ZhiyuanshenqingVO selectVO(@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);
	
	List<ZhiyuanshenqingView> selectListView(@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);

	List<ZhiyuanshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);
	
	ZhiyuanshenqingView selectView(@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhiyuanshenqingEntity> wrapper);



}
