package com.dao;

import com.entity.LiulangmaogouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LiulangmaogouVO;
import com.entity.view.LiulangmaogouView;


/**
 * 流浪猫狗
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface LiulangmaogouDao extends BaseMapper<LiulangmaogouEntity> {
	
	List<LiulangmaogouVO> selectListVO(@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);
	
	LiulangmaogouVO selectVO(@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);
	
	List<LiulangmaogouView> selectListView(@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);

	List<LiulangmaogouView> selectListView(Pagination page,@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);
	
	LiulangmaogouView selectView(@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LiulangmaogouEntity> wrapper);



}
