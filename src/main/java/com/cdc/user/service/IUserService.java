package com.cdc.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdc.user.entity.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
public interface IUserService extends IService<User> {

    /**
     *
     * @param page
     * @param userVo
     * @return
     */
    IPage<User> selectPageVo(Page<?> page, UserVo userVo);

}
