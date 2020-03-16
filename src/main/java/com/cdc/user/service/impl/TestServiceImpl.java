package com.cdc.user.service.impl;

import com.cdc.user.entity.Test;
import com.cdc.user.mapper.TestMapper;
import com.cdc.user.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdc
 * @since 2020-03-03
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
