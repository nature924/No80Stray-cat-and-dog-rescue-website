package com.dao;

import com.entity.DiscussliulangmaogouzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussliulangmaogouzhishiVO;
import com.entity.view.DiscussliulangmaogouzhishiView;


/**
 * 流浪猫狗知识评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface DiscussliulangmaogouzhishiDao extends BaseMapper<DiscussliulangmaogouzhishiEntity> {
	
	List<DiscussliulangmaogouzhishiVO> selectListVO(@Param("ew") Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
	
	DiscussliulangmaogouzhishiVO selectVO(@Param("ew") Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
	
	List<DiscussliulangmaogouzhishiView> selectListView(@Param("ew") Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);

	List<DiscussliulangmaogouzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
	
	DiscussliulangmaogouzhishiView selectView(@Param("ew") Wrapper<DiscussliulangmaogouzhishiEntity> wrapper);
	

}
