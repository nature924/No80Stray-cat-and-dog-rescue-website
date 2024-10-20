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


import com.dao.LiulangmaogouDao;
import com.entity.LiulangmaogouEntity;
import com.service.LiulangmaogouService;
import com.entity.vo.LiulangmaogouVO;
import com.entity.view.LiulangmaogouView;

@Service("liulangmaogouService")
public class LiulangmaogouServiceImpl extends ServiceImpl<LiulangmaogouDao, LiulangmaogouEntity> implements LiulangmaogouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiulangmaogouEntity> page = this.selectPage(
                new Query<LiulangmaogouEntity>(params).getPage(),
                new EntityWrapper<LiulangmaogouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiulangmaogouEntity> wrapper) {
		  Page<LiulangmaogouView> page =new Query<LiulangmaogouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LiulangmaogouVO> selectListVO(Wrapper<LiulangmaogouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LiulangmaogouVO selectVO(Wrapper<LiulangmaogouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LiulangmaogouView> selectListView(Wrapper<LiulangmaogouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiulangmaogouView selectView(Wrapper<LiulangmaogouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<LiulangmaogouEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<LiulangmaogouEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<LiulangmaogouEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
