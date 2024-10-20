package com.dao;

import com.entity.LingyangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LingyangxinxiVO;
import com.entity.view.LingyangxinxiView;


/**
 * 领养信息
 * 
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
public interface LingyangxinxiDao extends BaseMapper<LingyangxinxiEntity> {
	
	List<LingyangxinxiVO> selectListVO(@Param("ew") Wrapper<LingyangxinxiEntity> wrapper);
	
	LingyangxinxiVO selectVO(@Param("ew") Wrapper<LingyangxinxiEntity> wrapper);
	
	List<LingyangxinxiView> selectListView(@Param("ew") Wrapper<LingyangxinxiEntity> wrapper);

	List<LingyangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LingyangxinxiEntity> wrapper);
	
	LingyangxinxiView selectView(@Param("ew") Wrapper<LingyangxinxiEntity> wrapper);
	

}
