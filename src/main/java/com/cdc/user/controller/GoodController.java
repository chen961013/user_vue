package com.cdc.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.GoodVo;
import com.cdc.user.entity.Goods_sales;
import com.cdc.user.service.IGoodService;
import com.cdc.user.service.IGoods_salesService;
import com.cdc.user.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.CheckedOutputStream;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cdc
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private IGoodService iGoodService;

    @Autowired
    private IGoods_salesService iGoods_salesService;

    @RequestMapping("/list")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current, @RequestParam(defaultValue = "3") long size,
                             GoodVo vo,String searchName,Integer sprice,Integer eprice) {
        Page page = new Page<>(current, size);
        IPage<GoodVo> pageInfo = iGoodService.selectPageVo(page, vo,searchName,sprice,eprice);

        return ResultEntity.ok(pageInfo);
    }

    @RequestMapping("/insert")
    public ResultEntity insert_good(@RequestBody GoodVo vo) {
        boolean save = iGoodService.save(vo);

        if(save){
            String asid = vo.getAsid();
            String[] split = asid.split(",");
            ArrayList<Goods_sales> g = new ArrayList<>();
            for(String sid : split) {
                Goods_sales goods_sales = new Goods_sales();
                goods_sales.setSid(Integer.valueOf(sid));
                goods_sales.setGid(vo.getId());
                g.add(goods_sales);
            }
            boolean b = iGoods_salesService.saveBatch(g);

             return ResultEntity.ok("添加成功");

        }

        return ResultEntity.error();
    }

    @RequestMapping("/edit")
    public ResultEntity edit_good(@RequestBody GoodVo vo) {

        boolean b = iGoodService.updateById(vo);
        if(b){
            int i = iGoods_salesService.deleteByGid(vo.getId());
            if(i>0) {
                String asid = vo.getAsid();
                String[] split = asid.split(",");
                ArrayList<Goods_sales> g = new ArrayList<>();
                for(String sid : split) {
                    Goods_sales goods_sales = new Goods_sales();
                    goods_sales.setSid(Integer.valueOf(sid));
                    goods_sales.setGid(vo.getId());
                    g.add(goods_sales);
                }
                boolean a = iGoods_salesService.saveBatch(g);

                return ResultEntity.ok("修改成功");
            }
        }
        return ResultEntity.error();
    }



    @RequestMapping("/deletes")
    public ResultEntity deltes(Integer ids[]) {
        System.out.println(ids);
        boolean b = iGoodService.removeByIds(Arrays.asList(ids));
        if(b) {
            for(Integer id : ids){
                iGoods_salesService.deleteByGid(id);
            }
        }
        return ResultEntity.ok("删除成功");
    }



}

