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


import com.dao.ZhishileixingDao;
import com.entity.ZhishileixingEntity;
import com.service.ZhishileixingService;
import com.entity.vo.ZhishileixingVO;
import com.entity.view.ZhishileixingView;

@Service("zhishileixingService")
public class ZhishileixingServiceImpl extends ServiceImpl<ZhishileixingDao, ZhishileixingEntity> implements ZhishileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhishileixingEntity> page = this.selectPage(
                new Query<ZhishileixingEntity>(params).getPage(),
                new EntityWrapper<ZhishileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhishileixingEntity> wrapper) {
		  Page<ZhishileixingView> page =new Query<ZhishileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhishileixingVO> selectListVO(Wrapper<ZhishileixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhishileixingVO selectVO(Wrapper<ZhishileixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhishileixingView> selectListView(Wrapper<ZhishileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhishileixingView selectView(Wrapper<ZhishileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
