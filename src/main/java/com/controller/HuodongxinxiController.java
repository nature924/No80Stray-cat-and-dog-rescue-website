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

import com.entity.HuodongxinxiEntity;
import com.entity.view.HuodongxinxiView;

import com.service.HuodongxinxiService;
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
 * 活动信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@RestController
@RequestMapping("/huodongxinxi")
public class HuodongxinxiController {
    @Autowired
    private HuodongxinxiService huodongxinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongxinxiEntity huodongxinxi,
		HttpServletRequest request){
        EntityWrapper<HuodongxinxiEntity> ew = new EntityWrapper<HuodongxinxiEntity>();

		PageUtils page = huodongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongxinxiEntity huodongxinxi, 
		HttpServletRequest request){
        EntityWrapper<HuodongxinxiEntity> ew = new EntityWrapper<HuodongxinxiEntity>();

		PageUtils page = huodongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongxinxiEntity huodongxinxi){
       	EntityWrapper<HuodongxinxiEntity> ew = new EntityWrapper<HuodongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongxinxi, "huodongxinxi")); 
        return R.ok().put("data", huodongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongxinxiEntity huodongxinxi){
        EntityWrapper< HuodongxinxiEntity> ew = new EntityWrapper< HuodongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongxinxi, "huodongxinxi")); 
		HuodongxinxiView huodongxinxiView =  huodongxinxiService.selectView(ew);
		return R.ok("查询活动信息成功").put("data", huodongxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongxinxiEntity huodongxinxi = huodongxinxiService.selectById(id);
        return R.ok().put("data", huodongxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongxinxiEntity huodongxinxi = huodongxinxiService.selectById(id);
        return R.ok().put("data", huodongxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongxinxiEntity huodongxinxi, HttpServletRequest request){
    	huodongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongxinxi);
        huodongxinxiService.insert(huodongxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongxinxiEntity huodongxinxi, HttpServletRequest request){
    	huodongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongxinxi);
        huodongxinxiService.insert(huodongxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongxinxiEntity huodongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongxinxi);
        huodongxinxiService.updateById(huodongxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
