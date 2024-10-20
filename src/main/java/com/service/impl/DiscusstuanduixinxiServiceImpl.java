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


import com.dao.DiscusstuanduixinxiDao;
import com.entity.DiscusstuanduixinxiEntity;
import com.service.DiscusstuanduixinxiService;
import com.entity.vo.DiscusstuanduixinxiVO;
import com.entity.view.DiscusstuanduixinxiView;

@Service("discusstuanduixinxiService")
public class DiscusstuanduixinxiServiceImpl extends ServiceImpl<DiscusstuanduixinxiDao, DiscusstuanduixinxiEntity> implements DiscusstuanduixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstuanduixinxiEntity> page = this.selectPage(
                new Query<DiscusstuanduixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusstuanduixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstuanduixinxiEntity> wrapper) {
		  Page<DiscusstuanduixinxiView> page =new Query<DiscusstuanduixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusstuanduixinxiVO> selectListVO(Wrapper<DiscusstuanduixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstuanduixinxiVO selectVO(Wrapper<DiscusstuanduixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstuanduixinxiView> selectListView(Wrapper<DiscusstuanduixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstuanduixinxiView selectView(Wrapper<DiscusstuanduixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
