package com.cdc.user.mapper;

import com.cdc.user.entity.Goods_sales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cdc
 * @since 2020-03-14
 */
public interface Goods_salesMapper extends BaseMapper<Goods_sales> {

    int deleteByGid(Integer id);
}
