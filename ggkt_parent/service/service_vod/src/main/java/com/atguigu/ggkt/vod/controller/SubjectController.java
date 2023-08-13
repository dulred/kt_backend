package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.config.result.Result;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.vod.service.SubjectService;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author dulred
 * @since 2023-07-30
 */


@NoArgsConstructor
@Data
@RestController
@RequestMapping("admin/vod/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    //    课程分类列表
//    懒加载 , 每次查询一层数据
    @ApiOperation("课程分类列表")
    @GetMapping("getChildSubject/{id}")
    public Result getChildSubject(@PathVariable Long id){
        List<Subject> list = subjectService.selectSubjectList(id);
        return Result.ok(list);
    }




}

