package com.cdc.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.User;
import com.cdc.user.entity.UserVo;
import com.cdc.user.service.IUserService;

import com.cdc.user.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    // @Autowired
    // private RedisTemplate redisTemplate;

    @RequestMapping("/list")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current, @RequestParam(defaultValue = "3") long size, UserVo vo) {
        Page<User> page = new Page(current, size);
        IPage<User> pageInfo = iUserService.selectPageVo(page, vo);
        // 存入redis
        //redisTemplate.opsForValue().set("user",pageInfo);
        return ResultEntity.ok(pageInfo);
    }

    @RequestMapping("/delete")
    public ResultEntity delete(Integer ids[]) {
        boolean flag = iUserService.removeByIds(Arrays.asList(ids));
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/insert")
    public ResultEntity insert(@RequestBody User entity) {
        boolean flag = iUserService.save(entity);
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/update")
    public ResultEntity update(@RequestBody User entity) {
        boolean flag = iUserService.updateById(entity);
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/login")
    public ResultEntity login(HttpServletRequest request,@RequestBody User user) {
        HttpSession session = request.getSession();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", user.getUsername());
        User entity = iUserService.getOne(wrapper);
        if (entity != null) {
            if(entity.getPassword().equals(user.getPassword())){
                session.setAttribute("user",entity);
                return ResultEntity.ok(entity);
            }
        }
        return ResultEntity.error(5001, "用户名不存在");
    }

    @RequestMapping("loginOut")
    public ResultEntity loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        session.removeAttribute("user");
        return ResultEntity.ok(true);
    }

}

