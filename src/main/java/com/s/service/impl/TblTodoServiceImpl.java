package com.s.service.impl;

import com.s.bean.TblTodo;
import com.s.mapper.TblTodoMapper;
import com.s.service.TblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author smile
 * @since 2021-07-17
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
