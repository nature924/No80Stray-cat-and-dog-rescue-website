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


import com.dao.DiscussliulangmaogouzhishiDao;
import com.entity.DiscussliulangmaogouzhishiEntity;
import com.service.DiscussliulangmaogouzhishiService;
import com.entity.vo.DiscussliulangmaogouzhishiVO;
import com.entity.view.DiscussliulangmaogouzhishiView;

@Service("discussliulangmaogouzhishiService")
public class DiscussliulangmaogouzhishiServiceImpl extends ServiceImpl<DiscussliulangmaogouzhishiDao, DiscussliulangmaogouzhishiEntity> implements DiscussliulangmaogouzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussliulangmaogouzhishiEntity> page = this.selectPage(
                new Query<DiscussliulangmaogouzhishiEntity>(params).getPage(),
                new EntityWrapper<DiscussliulangmaogouzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussliulangmaogouzhishiEntity> wrapper) {
		  Page<DiscussliulangmaogouzhishiView> page =new Query<DiscussliulangmaogouzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussliulangmaogouzhishiVO> selectListVO(Wrapper<DiscussliulangmaogouzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussliulangmaogouzhishiVO selectVO(Wrapper<DiscussliulangmaogouzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussliulangmaogouzhishiView> selectListView(Wrapper<DiscussliulangmaogouzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussliulangmaogouzhishiView selectView(Wrapper<DiscussliulangmaogouzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
