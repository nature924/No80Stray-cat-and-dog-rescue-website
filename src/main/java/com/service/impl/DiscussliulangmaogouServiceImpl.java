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


import com.dao.DiscussliulangmaogouDao;
import com.entity.DiscussliulangmaogouEntity;
import com.service.DiscussliulangmaogouService;
import com.entity.vo.DiscussliulangmaogouVO;
import com.entity.view.DiscussliulangmaogouView;

@Service("discussliulangmaogouService")
public class DiscussliulangmaogouServiceImpl extends ServiceImpl<DiscussliulangmaogouDao, DiscussliulangmaogouEntity> implements DiscussliulangmaogouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussliulangmaogouEntity> page = this.selectPage(
                new Query<DiscussliulangmaogouEntity>(params).getPage(),
                new EntityWrapper<DiscussliulangmaogouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussliulangmaogouEntity> wrapper) {
		  Page<DiscussliulangmaogouView> page =new Query<DiscussliulangmaogouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussliulangmaogouVO> selectListVO(Wrapper<DiscussliulangmaogouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussliulangmaogouVO selectVO(Wrapper<DiscussliulangmaogouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussliulangmaogouView> selectListView(Wrapper<DiscussliulangmaogouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussliulangmaogouView selectView(Wrapper<DiscussliulangmaogouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
