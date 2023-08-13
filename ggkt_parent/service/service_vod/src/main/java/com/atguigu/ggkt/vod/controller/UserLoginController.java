package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.config.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/admin/vod/user")
@CrossOrigin
public class UserLoginController {


    @PostMapping("login")
    public Result login (){
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }

    @GetMapping("info")
    public Result info () {
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("admin");
        map.put("roles",list);
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        return Result.ok(map);
    }

}
