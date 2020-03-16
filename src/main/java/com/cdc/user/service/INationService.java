package com.cdc.user.service;

import com.cdc.user.entity.Nation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdc.user.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 服务类
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
public interface INationService extends IService<Nation> {

    List<NationVo> findAll();
}
