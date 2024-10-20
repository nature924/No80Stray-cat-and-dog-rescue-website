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

import com.entity.DiscussliulangmaogouzhishiEntity;
import com.entity.view.DiscussliulangmaogouzhishiView;

import com.service.DiscussliulangmaogouzhishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 流浪猫狗知识评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 23:10:32
 */
@RestController
@RequestMapping("/discussliulangmaogouzhishi")
public class DiscussliulangmaogouzhishiController {
    @Autowired
    private DiscussliulangmaogouzhishiService discussliulangmaogouzhishiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi,
		HttpServletRequest request){
        EntityWrapper<DiscussliulangmaogouzhishiEntity> ew = new EntityWrapper<DiscussliulangmaogouzhishiEntity>();

		PageUtils page = discussliulangmaogouzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussliulangmaogouzhishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi, 
		HttpServletRequest request){
        EntityWrapper<DiscussliulangmaogouzhishiEntity> ew = new EntityWrapper<DiscussliulangmaogouzhishiEntity>();

		PageUtils page = discussliulangmaogouzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussliulangmaogouzhishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi){
       	EntityWrapper<DiscussliulangmaogouzhishiEntity> ew = new EntityWrapper<DiscussliulangmaogouzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussliulangmaogouzhishi, "discussliulangmaogouzhishi")); 
        return R.ok().put("data", discussliulangmaogouzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi){
        EntityWrapper< DiscussliulangmaogouzhishiEntity> ew = new EntityWrapper< DiscussliulangmaogouzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussliulangmaogouzhishi, "discussliulangmaogouzhishi")); 
		DiscussliulangmaogouzhishiView discussliulangmaogouzhishiView =  discussliulangmaogouzhishiService.selectView(ew);
		return R.ok("查询流浪猫狗知识评论表成功").put("data", discussliulangmaogouzhishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi = discussliulangmaogouzhishiService.selectById(id);
        return R.ok().put("data", discussliulangmaogouzhishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi = discussliulangmaogouzhishiService.selectById(id);
        return R.ok().put("data", discussliulangmaogouzhishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi, HttpServletRequest request){
    	discussliulangmaogouzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussliulangmaogouzhishi);
        discussliulangmaogouzhishiService.insert(discussliulangmaogouzhishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi, HttpServletRequest request){
    	discussliulangmaogouzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussliulangmaogouzhishi);
        discussliulangmaogouzhishiService.insert(discussliulangmaogouzhishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussliulangmaogouzhishiEntity discussliulangmaogouzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussliulangmaogouzhishi);
        discussliulangmaogouzhishiService.updateById(discussliulangmaogouzhishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussliulangmaogouzhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
