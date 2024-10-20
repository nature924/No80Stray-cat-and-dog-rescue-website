package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TuanduixinxiDao;
import com.entity.TuanduixinxiEntity;
import com.service.TuanduixinxiService;
import com.entity.vo.TuanduixinxiVO;
import com.entity.view.TuanduixinxiView;

@Service("tuanduixinxiService")
public class TuanduixinxiServiceImpl extends ServiceImpl<TuanduixinxiDao, TuanduixinxiEntity> implements TuanduixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuanduixinxiEntity> page = this.selectPage(
                new Query<TuanduixinxiEntity>(params).getPage(),
                new EntityWrapper<TuanduixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuanduixinxiEntity> wrapper) {
		  Page<TuanduixinxiView> page =new Query<TuanduixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TuanduixinxiVO> selectListVO(Wrapper<TuanduixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuanduixinxiVO selectVO(Wrapper<TuanduixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuanduixinxiView> selectListView(Wrapper<TuanduixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuanduixinxiView selectView(Wrapper<TuanduixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
