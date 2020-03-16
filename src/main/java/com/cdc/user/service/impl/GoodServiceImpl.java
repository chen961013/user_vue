package com.cdc.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdc.user.entity.Good;
import com.cdc.user.entity.GoodVo;
import com.cdc.user.mapper.GoodMapper;
import com.cdc.user.service.IGoodService;
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
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements IGoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public IPage<GoodVo> selectPageVo(Page<?> page, GoodVo vo,String searchName,Integer sprice,Integer eprice) {
        return goodMapper.selectPageVo(page,vo,searchName,sprice,eprice);
    }

    @Override
    public Integer insertGood(GoodVo vo) {
        return goodMapper.insertGood(vo);
    }
}
