package com.cdc.user.service.impl;

import com.cdc.user.entity.Nation;
import com.cdc.user.entity.NationVo;
import com.cdc.user.mapper.NationMapper;
import com.cdc.user.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 城市字典表 服务实现类
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

    @Autowired
    private NationMapper nationMapper;

    @Override
    public List<NationVo> findAll() {
        return nationMapper.findAll();
    }
}
