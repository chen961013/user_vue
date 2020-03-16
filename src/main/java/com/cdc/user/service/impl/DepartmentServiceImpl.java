package com.cdc.user.service.impl;

import com.cdc.user.entity.Department;
import com.cdc.user.mapper.DepartmentMapper;
import com.cdc.user.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
