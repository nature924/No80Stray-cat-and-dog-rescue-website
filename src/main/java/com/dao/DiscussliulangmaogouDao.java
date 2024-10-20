package com.dao;

import com.entity.DiscussliulangmaogouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussliulangmaogouVO;
import com.entity.view.DiscussliulangmaogouView;


/**
 * 流浪猫狗评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface DiscussliulangmaogouDao extends BaseMapper<DiscussliulangmaogouEntity> {
	
	List<DiscussliulangmaogouVO> selectListVO(@Param("ew") Wrapper<DiscussliulangmaogouEntity> wrapper);
	
	DiscussliulangmaogouVO selectVO(@Param("ew") Wrapper<DiscussliulangmaogouEntity> wrapper);
	
	List<DiscussliulangmaogouView> selectListView(@Param("ew") Wrapper<DiscussliulangmaogouEntity> wrapper);

	List<DiscussliulangmaogouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussliulangmaogouEntity> wrapper);
	
	DiscussliulangmaogouView selectView(@Param("ew") Wrapper<DiscussliulangmaogouEntity> wrapper);
	

}
