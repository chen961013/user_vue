package com.cdc.user.service.impl;

import com.cdc.user.entity.Goods_sales;
import com.cdc.user.mapper.Goods_salesMapper;
import com.cdc.user.service.IGoods_salesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdc
 * @since 2020-03-14
 */
@Service
public class Goods_salesServiceImpl extends ServiceImpl<Goods_salesMapper, Goods_sales> implements IGoods_salesService {

    @Autowired
    private Goods_salesMapper Goods_salesMapper;

    @Override
    public int deleteByGid(Integer id) {
        return Goods_salesMapper.deleteByGid(id);
    }
}
