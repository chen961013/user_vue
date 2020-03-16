package com.cdc.user.mapper;

import com.cdc.user.entity.Nation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cdc.user.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 Mapper 接口
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
public interface NationMapper extends BaseMapper<Nation> {

    List<NationVo> findAll();
}
