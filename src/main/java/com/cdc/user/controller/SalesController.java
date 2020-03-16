package com.cdc.user.controller;


import com.cdc.user.entity.Sales;
import com.cdc.user.service.ISalesService;
import com.cdc.user.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cdc
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private ISalesService iSalesService;

    @RequestMapping("list")
    public ResultEntity list() {
        List<Sales> list = iSalesService.list();
        return ResultEntity.ok(list);
    }
}

