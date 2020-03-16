package com.cdc.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cdc.user.entity.UserVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     *
     * @param page
     * @param userVo
     * @return
     */
    IPage<User> selectPageVo(Page<?> page, UserVo userVo);

}
