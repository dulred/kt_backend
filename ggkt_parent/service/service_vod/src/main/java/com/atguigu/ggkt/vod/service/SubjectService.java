package com.atguigu.ggkt.vod.service;


import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author dulred
 * @since 2023-07-30
 */
public interface SubjectService extends IService<Subject> {

    //    课程分类列表
//    懒加载 , 每次查询一层数据
    List<Subject> selectSubjectList(Long id);
}
