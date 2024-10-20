package com.dao;

import com.entity.ZhishileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhishileixingVO;
import com.entity.view.ZhishileixingView;


/**
 * 知识类型
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface ZhishileixingDao extends BaseMapper<ZhishileixingEntity> {
	
	List<ZhishileixingVO> selectListVO(@Param("ew") Wrapper<ZhishileixingEntity> wrapper);
	
	ZhishileixingVO selectVO(@Param("ew") Wrapper<ZhishileixingEntity> wrapper);
	
	List<ZhishileixingView> selectListView(@Param("ew") Wrapper<ZhishileixingEntity> wrapper);

	List<ZhishileixingView> selectListView(Pagination page,@Param("ew") Wrapper<ZhishileixingEntity> wrapper);
	
	ZhishileixingView selectView(@Param("ew") Wrapper<ZhishileixingEntity> wrapper);
	

}
