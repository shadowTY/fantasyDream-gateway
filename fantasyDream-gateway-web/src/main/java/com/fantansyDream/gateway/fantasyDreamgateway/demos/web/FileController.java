package com.fantansyDream.gateway.fantasyDreamgateway.demos.web;

import com.alibaba.fastjson2.JSON;
import com.fantansyDream.core.fantasyDreamcore.service.request.FileInfoRequest;
import com.fantansyDream.core.fantasyDreamcore.service.response.FileInfoVO;
import com.fantansyDream.gateway.fantasyDreamgateway.service.FileCoreFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件管理系统
 */
@RestController
@Slf4j
public class FileController {

    @Autowired
    private FileCoreFeignService fileCoreFeignService;


    @GetMapping("/test123")
    @ResponseBody
    public String test() {
        log.info("test------远程调用开始");
        String test = fileCoreFeignService.test();
        log.info("test---- 远程调用结束");
        return test;
    }


    @RequestMapping("/test11")
    @ResponseBody
    public String test11() {
        File file = new File("./test");
        String s = fileCoreFeignService.upload(file);
        return s;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public FileInfoVO selectById(@RequestBody FileInfoRequest request) {
        log.info("test---- request is {}", JSON.toJSONString(request));
        FileInfoVO fileInfoVO = fileCoreFeignService.selectById(request);
        log.info(JSON.toJSONString(fileInfoVO));
        return fileInfoVO;
    }

    @RequestMapping("/uploadMultipartFile")
    @ResponseBody
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId) {
        String fileId = fileCoreFeignService.uploadMultipartFile(file, userId);
        log.info("c.f.g.f.d.w.FileController fileId is {}", fileId);
        return fileId;
    }




}
