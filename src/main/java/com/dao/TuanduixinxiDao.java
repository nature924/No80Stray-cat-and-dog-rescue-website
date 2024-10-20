package com.dao;

import com.entity.TuanduixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuanduixinxiVO;
import com.entity.view.TuanduixinxiView;


/**
 * 团队信息
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface TuanduixinxiDao extends BaseMapper<TuanduixinxiEntity> {
	
	List<TuanduixinxiVO> selectListVO(@Param("ew") Wrapper<TuanduixinxiEntity> wrapper);
	
	TuanduixinxiVO selectVO(@Param("ew") Wrapper<TuanduixinxiEntity> wrapper);
	
	List<TuanduixinxiView> selectListView(@Param("ew") Wrapper<TuanduixinxiEntity> wrapper);

	List<TuanduixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TuanduixinxiEntity> wrapper);
	
	TuanduixinxiView selectView(@Param("ew") Wrapper<TuanduixinxiEntity> wrapper);
	

}
