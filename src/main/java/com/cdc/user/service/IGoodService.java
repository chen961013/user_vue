package com.cdc.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.Good;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdc.user.entity.GoodVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdc
 * @since 2020-03-14
 */
public interface IGoodService extends IService<Good> {

    IPage<GoodVo> selectPageVo(Page<?> page, GoodVo vo,String searchName,Integer sprice,Integer eprice);

    Integer insertGood(GoodVo vo);
}
