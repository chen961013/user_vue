package com.cdc.user.controller;


import com.cdc.user.entity.User;
import com.cdc.user.service.IMenuService;
import com.cdc.user.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    @RequestMapping("/list")
    public ResultEntity list() {
        return ResultEntity.ok(iMenuService.listMenus());
    }

    @RequestMapping("/listByUserName")
    public ResultEntity listByUserName(HttpServletRequest request,
                                       @RequestParam(defaultValue = "lisi")String userName){
        System.out.println(request.getSession().getId()+"init");
        //获取session中的值
        User user  = (User) request.getSession().getAttribute("user");
        //判断是否未空
        if(user!=null){
            //登录的用户
            userName = user.getUsername();
            System.out.println("@@@@@@@"+userName);
        }
        return ResultEntity.ok(iMenuService.listMenusByUserName(userName));
    }
}

