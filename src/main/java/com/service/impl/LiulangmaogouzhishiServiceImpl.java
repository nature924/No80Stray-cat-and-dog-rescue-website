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


import com.dao.LiulangmaogouzhishiDao;
import com.entity.LiulangmaogouzhishiEntity;
import com.service.LiulangmaogouzhishiService;
import com.entity.vo.LiulangmaogouzhishiVO;
import com.entity.view.LiulangmaogouzhishiView;

@Service("liulangmaogouzhishiService")
public class LiulangmaogouzhishiServiceImpl extends ServiceImpl<LiulangmaogouzhishiDao, LiulangmaogouzhishiEntity> implements LiulangmaogouzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiulangmaogouzhishiEntity> page = this.selectPage(
                new Query<LiulangmaogouzhishiEntity>(params).getPage(),
                new EntityWrapper<LiulangmaogouzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiulangmaogouzhishiEntity> wrapper) {
		  Page<LiulangmaogouzhishiView> page =new Query<LiulangmaogouzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LiulangmaogouzhishiVO> selectListVO(Wrapper<LiulangmaogouzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LiulangmaogouzhishiVO selectVO(Wrapper<LiulangmaogouzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LiulangmaogouzhishiView> selectListView(Wrapper<LiulangmaogouzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiulangmaogouzhishiView selectView(Wrapper<LiulangmaogouzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
