package com.lirui.service.impl;

import com.lirui.bean.Emp;
import com.lirui.mapper.EmpMapper;
import com.lirui.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lirui
 * @since 2020-07-19
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
