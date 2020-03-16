package com.cdc.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.Role;
import com.cdc.user.entity.RoleVo;
import com.cdc.user.service.IMenu_roleService;
import com.cdc.user.service.IRoleService;
import com.cdc.user.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IMenu_roleService iMenu_roleService;

    @RequestMapping("/list")
    public ResultEntity list() {
        return ResultEntity.ok(iRoleService.list());
    }

    @RequestMapping("/select")
    public ResultEntity select(@RequestParam(defaultValue = "1") long current,
                               @RequestParam(defaultValue = "3") long size, RoleVo roleVo) {
        Page page = new Page(current, size);
        IPage<RoleVo> pageInfo = iRoleService.selectPageVo(page, roleVo);

        return ResultEntity.ok(pageInfo);
    }

    @RequestMapping("/deletes")
    public ResultEntity deletes(Integer ids[]){
        //首先删除管理的表
        for(Integer id:ids) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("rid", id);
            iMenu_roleService.remove(wrapper);
        }
        //再去删除主表

        //批量删除操作
        boolean flag =  iRoleService.removeByIds(Arrays.asList(ids));
        //定义返回结果
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/update")
    public ResultEntity update(@RequestBody Role role) {
        boolean b = iRoleService.updateById(role);
        if(b) {
            return ResultEntity.ok("修改成功");
        }
        return ResultEntity.error();
    }


}

