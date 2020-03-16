package com.cdc.user.mapper;

import com.cdc.user.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> listMenus();

    /**
     * 根据用户名称查询对应的menu资源
     * @param userName
     * @return
     */
    List<Menu> listMenusByUserName(String userName);

}
