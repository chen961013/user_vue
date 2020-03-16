package com.cdc.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdc.user.entity.RoleVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
public interface IRoleService extends IService<Role> {

    /*
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @return 分页对象
     */
    IPage<RoleVo> selectPageVo(Page<?> page, RoleVo roleVo);
}
