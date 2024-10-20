package com.dao;

import com.entity.LiulangmaogouzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LiulangmaogouzhishiVO;
import com.entity.view.LiulangmaogouzhishiView;


/**
 * 流浪猫狗知识
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface LiulangmaogouzhishiDao extends BaseMapper<LiulangmaogouzhishiEntity> {
	
	List<LiulangmaogouzhishiVO> selectListVO(@Param("ew") Wrapper<LiulangmaogouzhishiEntity> wrapper);
	
	LiulangmaogouzhishiVO selectVO(@Param("ew") Wrapper<LiulangmaogouzhishiEntity> wrapper);
	
	List<LiulangmaogouzhishiView> selectListView(@Param("ew") Wrapper<LiulangmaogouzhishiEntity> wrapper);

	List<LiulangmaogouzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<LiulangmaogouzhishiEntity> wrapper);
	
	LiulangmaogouzhishiView selectView(@Param("ew") Wrapper<LiulangmaogouzhishiEntity> wrapper);
	

}
