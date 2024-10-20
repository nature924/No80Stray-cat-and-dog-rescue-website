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


import com.dao.ZhiyuanshenqingDao;
import com.entity.ZhiyuanshenqingEntity;
import com.service.ZhiyuanshenqingService;
import com.entity.vo.ZhiyuanshenqingVO;
import com.entity.view.ZhiyuanshenqingView;

@Service("zhiyuanshenqingService")
public class ZhiyuanshenqingServiceImpl extends ServiceImpl<ZhiyuanshenqingDao, ZhiyuanshenqingEntity> implements ZhiyuanshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanshenqingEntity> page = this.selectPage(
                new Query<ZhiyuanshenqingEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanshenqingEntity> wrapper) {
		  Page<ZhiyuanshenqingView> page =new Query<ZhiyuanshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhiyuanshenqingVO> selectListVO(Wrapper<ZhiyuanshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiyuanshenqingVO selectVO(Wrapper<ZhiyuanshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiyuanshenqingView> selectListView(Wrapper<ZhiyuanshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanshenqingView selectView(Wrapper<ZhiyuanshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ZhiyuanshenqingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ZhiyuanshenqingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ZhiyuanshenqingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
