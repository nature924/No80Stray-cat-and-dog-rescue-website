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


import com.dao.HuodongfenleiDao;
import com.entity.HuodongfenleiEntity;
import com.service.HuodongfenleiService;
import com.entity.vo.HuodongfenleiVO;
import com.entity.view.HuodongfenleiView;

@Service("huodongfenleiService")
public class HuodongfenleiServiceImpl extends ServiceImpl<HuodongfenleiDao, HuodongfenleiEntity> implements HuodongfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongfenleiEntity> page = this.selectPage(
                new Query<HuodongfenleiEntity>(params).getPage(),
                new EntityWrapper<HuodongfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongfenleiEntity> wrapper) {
		  Page<HuodongfenleiView> page =new Query<HuodongfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongfenleiVO> selectListVO(Wrapper<HuodongfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongfenleiVO selectVO(Wrapper<HuodongfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongfenleiView> selectListView(Wrapper<HuodongfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongfenleiView selectView(Wrapper<HuodongfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
