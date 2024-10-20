package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusstuanduixinxiEntity;
import com.entity.view.DiscusstuanduixinxiView;

import com.service.DiscusstuanduixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 团队信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
@RestController
@RequestMapping("/discusstuanduixinxi")
public class DiscusstuanduixinxiController {
    @Autowired
    private DiscusstuanduixinxiService discusstuanduixinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusstuanduixinxiEntity discusstuanduixinxi,
		HttpServletRequest request){
        EntityWrapper<DiscusstuanduixinxiEntity> ew = new EntityWrapper<DiscusstuanduixinxiEntity>();

		PageUtils page = discusstuanduixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusstuanduixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusstuanduixinxiEntity discusstuanduixinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscusstuanduixinxiEntity> ew = new EntityWrapper<DiscusstuanduixinxiEntity>();

		PageUtils page = discusstuanduixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusstuanduixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusstuanduixinxiEntity discusstuanduixinxi){
       	EntityWrapper<DiscusstuanduixinxiEntity> ew = new EntityWrapper<DiscusstuanduixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusstuanduixinxi, "discusstuanduixinxi")); 
        return R.ok().put("data", discusstuanduixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusstuanduixinxiEntity discusstuanduixinxi){
        EntityWrapper< DiscusstuanduixinxiEntity> ew = new EntityWrapper< DiscusstuanduixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusstuanduixinxi, "discusstuanduixinxi")); 
		DiscusstuanduixinxiView discusstuanduixinxiView =  discusstuanduixinxiService.selectView(ew);
		return R.ok("查询团队信息评论表成功").put("data", discusstuanduixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusstuanduixinxiEntity discusstuanduixinxi = discusstuanduixinxiService.selectById(id);
        return R.ok().put("data", discusstuanduixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusstuanduixinxiEntity discusstuanduixinxi = discusstuanduixinxiService.selectById(id);
        return R.ok().put("data", discusstuanduixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusstuanduixinxiEntity discusstuanduixinxi, HttpServletRequest request){
    	discusstuanduixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusstuanduixinxi);
        discusstuanduixinxiService.insert(discusstuanduixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusstuanduixinxiEntity discusstuanduixinxi, HttpServletRequest request){
    	discusstuanduixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusstuanduixinxi);
        discusstuanduixinxiService.insert(discusstuanduixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusstuanduixinxiEntity discusstuanduixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusstuanduixinxi);
        discusstuanduixinxiService.updateById(discusstuanduixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusstuanduixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
