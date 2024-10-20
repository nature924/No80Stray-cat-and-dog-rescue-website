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

import com.entity.ZhishileixingEntity;
import com.entity.view.ZhishileixingView;

import com.service.ZhishileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 知识类型
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@RestController
@RequestMapping("/zhishileixing")
public class ZhishileixingController {
    @Autowired
    private ZhishileixingService zhishileixingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhishileixingEntity zhishileixing,
		HttpServletRequest request){
        EntityWrapper<ZhishileixingEntity> ew = new EntityWrapper<ZhishileixingEntity>();

		PageUtils page = zhishileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhishileixingEntity zhishileixing, 
		HttpServletRequest request){
        EntityWrapper<ZhishileixingEntity> ew = new EntityWrapper<ZhishileixingEntity>();

		PageUtils page = zhishileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhishileixingEntity zhishileixing){
       	EntityWrapper<ZhishileixingEntity> ew = new EntityWrapper<ZhishileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhishileixing, "zhishileixing")); 
        return R.ok().put("data", zhishileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhishileixingEntity zhishileixing){
        EntityWrapper< ZhishileixingEntity> ew = new EntityWrapper< ZhishileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhishileixing, "zhishileixing")); 
		ZhishileixingView zhishileixingView =  zhishileixingService.selectView(ew);
		return R.ok("查询知识类型成功").put("data", zhishileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhishileixingEntity zhishileixing = zhishileixingService.selectById(id);
        return R.ok().put("data", zhishileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhishileixingEntity zhishileixing = zhishileixingService.selectById(id);
        return R.ok().put("data", zhishileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhishileixingEntity zhishileixing, HttpServletRequest request){
    	zhishileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhishileixing);
        zhishileixingService.insert(zhishileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhishileixingEntity zhishileixing, HttpServletRequest request){
    	zhishileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhishileixing);
        zhishileixingService.insert(zhishileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhishileixingEntity zhishileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhishileixing);
        zhishileixingService.updateById(zhishileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhishileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
