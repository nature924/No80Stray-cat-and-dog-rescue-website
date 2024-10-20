package com.dao;

import com.entity.DiscusstuanduixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusstuanduixinxiVO;
import com.entity.view.DiscusstuanduixinxiView;


/**
 * 团队信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
public interface DiscusstuanduixinxiDao extends BaseMapper<DiscusstuanduixinxiEntity> {
	
	List<DiscusstuanduixinxiVO> selectListVO(@Param("ew") Wrapper<DiscusstuanduixinxiEntity> wrapper);
	
	DiscusstuanduixinxiVO selectVO(@Param("ew") Wrapper<DiscusstuanduixinxiEntity> wrapper);
	
	List<DiscusstuanduixinxiView> selectListView(@Param("ew") Wrapper<DiscusstuanduixinxiEntity> wrapper);

	List<DiscusstuanduixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstuanduixinxiEntity> wrapper);
	
	DiscusstuanduixinxiView selectView(@Param("ew") Wrapper<DiscusstuanduixinxiEntity> wrapper);
	

}
