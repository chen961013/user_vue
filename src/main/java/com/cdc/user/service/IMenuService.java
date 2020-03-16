package com.cdc.user.service;

import com.cdc.user.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> listMenus();

    /**
     * 根据用户名称查询对应的menu资源
     * @param userName
     * @return
     */
    List<Menu> listMenusByUserName(String userName);

}
