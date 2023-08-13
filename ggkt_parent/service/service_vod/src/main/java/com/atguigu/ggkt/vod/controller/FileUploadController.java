package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.config.result.Result;
import com.atguigu.ggkt.vod.service.FileServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileServer fileServer;

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public Result uploadFile (MultipartFile file){

        String url = fileServer.uploadFile(file);
        return Result.ok(url).message("文件上传成功");

    }

}
