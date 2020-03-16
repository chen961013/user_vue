package com.cdc.user.service.impl;

import com.cdc.user.entity.Menu;
import com.cdc.user.mapper.MenuMapper;
import com.cdc.user.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> listMenus() {
        return menuMapper.listMenus();
    }

    @Override
    public List<Menu> listMenusByUserName(String userName) {
        return menuMapper.listMenusByUserName(userName);
    }
}
