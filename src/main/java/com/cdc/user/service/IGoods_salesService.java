package com.cdc.user.service;

import com.cdc.user.entity.Goods_sales;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdc
 * @since 2020-03-14
 */
public interface IGoods_salesService extends IService<Goods_sales> {

    int deleteByGid(Integer id);
}
