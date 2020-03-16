package com.cdc.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cdc.user.entity.GoodVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cdc
 * @since 2020-03-14
 */
public interface GoodMapper extends BaseMapper<Good> {

    IPage<GoodVo> selectPageVo(Page<?> page, GoodVo vo,String searchName,Integer sprice,Integer eprice);

    Integer insertGood(GoodVo vo);
}
