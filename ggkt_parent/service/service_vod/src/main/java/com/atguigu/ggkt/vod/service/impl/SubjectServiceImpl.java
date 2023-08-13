package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.vod.mapper.SubjectMapper;
import com.atguigu.ggkt.vod.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author dulred
 * @since 2023-07-30
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    //    课程分类列表
//    懒加载 , 每次查询一层数据
    @Override
    public List<Subject> selectSubjectList(Long id) {
        //SELECT * FROM SUBJECT WHERE parent_id = 0
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        List<Subject> subjectList = baseMapper.selectList(wrapper);
        //TODO
        for (Subject s :
                subjectList) {
            boolean isChild = this.isChildren(s.getId());
            s.setHasChildren(isChild);
        }

        return subjectList;
    }

    private boolean isChildren( Long id) {
        QueryWrapper<Subject> subjectQueryWrapper  = new QueryWrapper<>();
        subjectQueryWrapper.eq("parent_id",id);
        Integer count =  baseMapper.selectCount(subjectQueryWrapper);
        return count>0;
    }


}
