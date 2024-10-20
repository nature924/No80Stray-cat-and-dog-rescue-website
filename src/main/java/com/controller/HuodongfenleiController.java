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

import com.entity.HuodongfenleiEntity;
import com.entity.view.HuodongfenleiView;

import com.service.HuodongfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 活动分类
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@RestController
@RequestMapping("/huodongfenlei")
public class HuodongfenleiController {
    @Autowired
    private HuodongfenleiService huodongfenleiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongfenleiEntity huodongfenlei,
		HttpServletRequest request){
        EntityWrapper<HuodongfenleiEntity> ew = new EntityWrapper<HuodongfenleiEntity>();

		PageUtils page = huodongfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongfenleiEntity huodongfenlei, 
		HttpServletRequest request){
        EntityWrapper<HuodongfenleiEntity> ew = new EntityWrapper<HuodongfenleiEntity>();

		PageUtils page = huodongfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongfenleiEntity huodongfenlei){
       	EntityWrapper<HuodongfenleiEntity> ew = new EntityWrapper<HuodongfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongfenlei, "huodongfenlei")); 
        return R.ok().put("data", huodongfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongfenleiEntity huodongfenlei){
        EntityWrapper< HuodongfenleiEntity> ew = new EntityWrapper< HuodongfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongfenlei, "huodongfenlei")); 
		HuodongfenleiView huodongfenleiView =  huodongfenleiService.selectView(ew);
		return R.ok("查询活动分类成功").put("data", huodongfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongfenleiEntity huodongfenlei = huodongfenleiService.selectById(id);
        return R.ok().put("data", huodongfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongfenleiEntity huodongfenlei = huodongfenleiService.selectById(id);
        return R.ok().put("data", huodongfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongfenleiEntity huodongfenlei, HttpServletRequest request){
    	huodongfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongfenlei);
        huodongfenleiService.insert(huodongfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongfenleiEntity huodongfenlei, HttpServletRequest request){
    	huodongfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongfenlei);
        huodongfenleiService.insert(huodongfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongfenleiEntity huodongfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongfenlei);
        huodongfenleiService.updateById(huodongfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
