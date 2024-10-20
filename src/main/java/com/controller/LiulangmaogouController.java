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

import com.entity.LiulangmaogouEntity;
import com.entity.view.LiulangmaogouView;

import com.service.LiulangmaogouService;
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
 * 流浪猫狗
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-04 23:10:31
 */
@RestController
@RequestMapping("/liulangmaogou")
public class LiulangmaogouController {
    @Autowired
    private LiulangmaogouService liulangmaogouService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LiulangmaogouEntity liulangmaogou,
		HttpServletRequest request){
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();

		PageUtils page = liulangmaogouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangmaogou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LiulangmaogouEntity liulangmaogou, 
		HttpServletRequest request){
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();

		PageUtils page = liulangmaogouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangmaogou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LiulangmaogouEntity liulangmaogou){
       	EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( liulangmaogou, "liulangmaogou")); 
        return R.ok().put("data", liulangmaogouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LiulangmaogouEntity liulangmaogou){
        EntityWrapper< LiulangmaogouEntity> ew = new EntityWrapper< LiulangmaogouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( liulangmaogou, "liulangmaogou")); 
		LiulangmaogouView liulangmaogouView =  liulangmaogouService.selectView(ew);
		return R.ok("查询流浪猫狗成功").put("data", liulangmaogouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LiulangmaogouEntity liulangmaogou = liulangmaogouService.selectById(id);
		liulangmaogou.setClicktime(new Date());
		liulangmaogouService.updateById(liulangmaogou);
        return R.ok().put("data", liulangmaogou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LiulangmaogouEntity liulangmaogou = liulangmaogouService.selectById(id);
		liulangmaogou.setClicktime(new Date());
		liulangmaogouService.updateById(liulangmaogou);
        return R.ok().put("data", liulangmaogou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LiulangmaogouEntity liulangmaogou, HttpServletRequest request){
    	liulangmaogou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liulangmaogou);
        liulangmaogouService.insert(liulangmaogou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LiulangmaogouEntity liulangmaogou, HttpServletRequest request){
    	liulangmaogou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liulangmaogou);
        liulangmaogouService.insert(liulangmaogou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LiulangmaogouEntity liulangmaogou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(liulangmaogou);
        liulangmaogouService.updateById(liulangmaogou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        liulangmaogouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,LiulangmaogouEntity liulangmaogou, HttpServletRequest request,String pre){
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = liulangmaogouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangmaogou), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,LiulangmaogouEntity liulangmaogou, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "chongwufenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "liulangmaogou").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<LiulangmaogouEntity> liulangmaogouList = new ArrayList<LiulangmaogouEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                liulangmaogouList.addAll(liulangmaogouService.selectList(new EntityWrapper<LiulangmaogouEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = liulangmaogouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangmaogou), params), params));
        List<LiulangmaogouEntity> pageList = (List<LiulangmaogouEntity>)page.getList();
        if(liulangmaogouList.size()<limit) {
            int toAddNum = (limit-liulangmaogouList.size())<=pageList.size()?(limit-liulangmaogouList.size()):pageList.size();
            for(LiulangmaogouEntity o1 : pageList) {
                boolean addFlag = true;
                for(LiulangmaogouEntity o2 : liulangmaogouList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    liulangmaogouList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(liulangmaogouList.size()>limit) {
            liulangmaogouList = liulangmaogouList.subList(0, limit);
        }
        page.setList(liulangmaogouList);
        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
        List<Map<String, Object>> result = liulangmaogouService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = liulangmaogouService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
        List<Map<String, Object>> result = liulangmaogouService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = liulangmaogouService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
        List<Map<String, Object>> result = liulangmaogouService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,LiulangmaogouEntity liulangmaogou, HttpServletRequest request){
        EntityWrapper<LiulangmaogouEntity> ew = new EntityWrapper<LiulangmaogouEntity>();
        int count = liulangmaogouService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangmaogou), params), params));
        return R.ok().put("data", count);
    }


}
