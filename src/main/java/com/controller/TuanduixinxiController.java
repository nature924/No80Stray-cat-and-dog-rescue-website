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

import com.entity.TuanduixinxiEntity;
import com.entity.view.TuanduixinxiView;

import com.service.TuanduixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 团队信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@RestController
@RequestMapping("/tuanduixinxi")
public class TuanduixinxiController {
    @Autowired
    private TuanduixinxiService tuanduixinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuanduixinxiEntity tuanduixinxi,
		HttpServletRequest request){
        EntityWrapper<TuanduixinxiEntity> ew = new EntityWrapper<TuanduixinxiEntity>();

		PageUtils page = tuanduixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuanduixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuanduixinxiEntity tuanduixinxi, 
		HttpServletRequest request){
        EntityWrapper<TuanduixinxiEntity> ew = new EntityWrapper<TuanduixinxiEntity>();

		PageUtils page = tuanduixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuanduixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuanduixinxiEntity tuanduixinxi){
       	EntityWrapper<TuanduixinxiEntity> ew = new EntityWrapper<TuanduixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuanduixinxi, "tuanduixinxi")); 
        return R.ok().put("data", tuanduixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuanduixinxiEntity tuanduixinxi){
        EntityWrapper< TuanduixinxiEntity> ew = new EntityWrapper< TuanduixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuanduixinxi, "tuanduixinxi")); 
		TuanduixinxiView tuanduixinxiView =  tuanduixinxiService.selectView(ew);
		return R.ok("查询团队信息成功").put("data", tuanduixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuanduixinxiEntity tuanduixinxi = tuanduixinxiService.selectById(id);
        return R.ok().put("data", tuanduixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuanduixinxiEntity tuanduixinxi = tuanduixinxiService.selectById(id);
        return R.ok().put("data", tuanduixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuanduixinxiEntity tuanduixinxi, HttpServletRequest request){
    	tuanduixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuanduixinxi);
        tuanduixinxiService.insert(tuanduixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuanduixinxiEntity tuanduixinxi, HttpServletRequest request){
    	tuanduixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuanduixinxi);
        tuanduixinxiService.insert(tuanduixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuanduixinxiEntity tuanduixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuanduixinxi);
        tuanduixinxiService.updateById(tuanduixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuanduixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
