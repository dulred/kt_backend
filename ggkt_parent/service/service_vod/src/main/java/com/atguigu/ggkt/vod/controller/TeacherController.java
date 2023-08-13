package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.config.exception.GgktException;
import com.atguigu.ggkt.config.result.Result;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-07-12
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping(value="/admin/vod/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
//http://localhost:8301/admin/vod/teacher/findAll
//    查询所有讲师
    @GetMapping("findAll")
    @ApiOperation("所有讲师列表")
    public Result findAllTeacher(){
//        try {
//            int c = 10/0;
//        }catch (Exception e ){
//            throw new GgktException(201,"抛出了自定义的异常");
//        }

        //调用service方法
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }


    @DeleteMapping("remove/{id}")
    @ApiOperation("逻辑删除讲师")
    public Result deleteById (@ApiParam(name = "id", value = "ID", required = true)
                                   @PathVariable Long id){
       boolean isSuccess =  teacherService.removeById(id);
           if (isSuccess){
             return   Result.ok(null);
           }else {
               return  Result.fail(null);
           }

    }

    //条件查询分页列表
    @ApiOperation("条件查询分页")
    @PostMapping("findQueryPage/{current}/{limit}")
    public Result findPage(
            @PathVariable long current,
            @PathVariable long limit,
            @RequestBody(required = false) TeacherQueryVo teacherQueryVo
    )
    {

    //创建Page对象，传递当前页和每页记录数
    Page<Teacher> pageParam = new Page<>(current,limit);
    //判断teacherQueryVo 对象是否为空
        if (teacherQueryVo==null){ //查询全部
            IPage<Teacher> pageModel = teacherService.page(pageParam,null);
            return Result.ok(pageModel);
        }else {
            //获取条件值
            String name  = teacherQueryVo.getName();//讲师名称
            Integer level = teacherQueryVo.getLevel();//讲师级别
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();//开始时间
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();//结束时间
            //封装条件
            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
            if(!StringUtils.isEmpty(name)) {
                wrapper.like("name",name);
            }
            if(!StringUtils.isEmpty(level)) {
                wrapper.eq("level",level);
            }
            if(!StringUtils.isEmpty(joinDateBegin)) {
                wrapper.ge("join_date",joinDateBegin);
            }
            if(!StringUtils.isEmpty(joinDateEnd)) {
                wrapper.le("join_date",joinDateEnd);
            }
            //调用方法得到查询条件
            IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);

            return Result.ok(pageModel);
        }



    }



//    添加讲师
    @ApiOperation("添加讲师")
    @PostMapping("saveTeacher")
    public Result saveTeacher (
           @RequestBody Teacher teacher
    ){
        boolean isSuccess  = teacherService.save(teacher);
        if (isSuccess)
        {
            return Result.ok(null);
        }else {
            return Result.fail(null);
        }

    }

//    根据id查询
    @ApiOperation("根据id查询")
    @GetMapping("getTeacher/{id}")
    public Result getTeacher (@PathVariable long id){
            Teacher teacher = teacherService.getById(id);
            return Result.ok(teacher);
    }

//    修改讲师
@ApiOperation("修改讲师")
@PostMapping("updateTeacher")
public Result updateTeacher ( @RequestBody Teacher teacher){

    boolean isSuccess  = teacherService.updateById(teacher);
    if (isSuccess)
    {
        return Result.ok(null);
    }else {
        return Result.fail(null);
    }
}

//批量删除讲师
@ApiOperation("批量删除讲师")
@DeleteMapping("removeBatch")
    public  Result removeBatch  (@RequestBody List<Long> idList){
    boolean isSuccess  =  teacherService.removeByIds(idList);
    if (isSuccess)
    {
        return Result.ok(null);
    }else {
        return Result.fail(null);
    }
}







}

