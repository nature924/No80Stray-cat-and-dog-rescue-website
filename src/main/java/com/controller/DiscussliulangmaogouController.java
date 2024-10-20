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

import com.entity.DiscussliulangmaogouEntity;
import com.entity.view.DiscussliulangmaogouView;

import com.service.DiscussliulangmaogouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 流浪猫狗评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
@RestController
@RequestMapping("/discussliulangmaogou")
public class DiscussliulangmaogouController {
    @Autowired
    private DiscussliulangmaogouService discussliulangmaogouService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussliulangmaogouEntity discussliulangmaogou,
		HttpServletRequest request){
        EntityWrapper<DiscussliulangmaogouEntity> ew = new EntityWrapper<DiscussliulangmaogouEntity>();

		PageUtils page = discussliulangmaogouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussliulangmaogou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussliulangmaogouEntity discussliulangmaogou, 
		HttpServletRequest request){
        EntityWrapper<DiscussliulangmaogouEntity> ew = new EntityWrapper<DiscussliulangmaogouEntity>();

		PageUtils page = discussliulangmaogouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussliulangmaogou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussliulangmaogouEntity discussliulangmaogou){
       	EntityWrapper<DiscussliulangmaogouEntity> ew = new EntityWrapper<DiscussliulangmaogouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussliulangmaogou, "discussliulangmaogou")); 
        return R.ok().put("data", discussliulangmaogouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussliulangmaogouEntity discussliulangmaogou){
        EntityWrapper< DiscussliulangmaogouEntity> ew = new EntityWrapper< DiscussliulangmaogouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussliulangmaogou, "discussliulangmaogou")); 
		DiscussliulangmaogouView discussliulangmaogouView =  discussliulangmaogouService.selectView(ew);
		return R.ok("查询流浪猫狗评论表成功").put("data", discussliulangmaogouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussliulangmaogouEntity discussliulangmaogou = discussliulangmaogouService.selectById(id);
        return R.ok().put("data", discussliulangmaogou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussliulangmaogouEntity discussliulangmaogou = discussliulangmaogouService.selectById(id);
        return R.ok().put("data", discussliulangmaogou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussliulangmaogouEntity discussliulangmaogou, HttpServletRequest request){
    	discussliulangmaogou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussliulangmaogou);
        discussliulangmaogouService.insert(discussliulangmaogou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussliulangmaogouEntity discussliulangmaogou, HttpServletRequest request){
    	discussliulangmaogou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussliulangmaogou);
        discussliulangmaogouService.insert(discussliulangmaogou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussliulangmaogouEntity discussliulangmaogou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussliulangmaogou);
        discussliulangmaogouService.updateById(discussliulangmaogou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussliulangmaogouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
