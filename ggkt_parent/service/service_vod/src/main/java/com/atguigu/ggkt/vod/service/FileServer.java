package com.atguigu.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务器
 *
 * @author dulred
 * @date 2023/08/13
 */
public interface FileServer {
    String uploadFile(MultipartFile file);



}
