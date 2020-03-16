package com.cdc.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cdc.user.entity.RoleVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
public interface RoleMapper extends BaseMapper<Role> {

    /*
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @return 分页对象
     */
    IPage<RoleVo> selectPageVo(Page<?> page, RoleVo roleVo);

}
