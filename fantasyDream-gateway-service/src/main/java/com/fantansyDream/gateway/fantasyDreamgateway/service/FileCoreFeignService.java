package com.fantansyDream.gateway.fantasyDreamgateway.service;

import com.fantansyDream.core.fantasyDreamcore.service.request.FileInfoRequest;
import com.fantansyDream.core.fantasyDreamcore.service.response.FileInfoVO;
import com.fantansyDream.gateway.fantasyDreamgateway.service.config.FileCoreFeignServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
@FeignClient(value = "fantasyDream-core", contextId = "FileCoreFeignService", configuration = FileCoreFeignServiceConfig.class)
public interface FileCoreFeignService {

    @GetMapping("/test")
    String test();

    @PostMapping("/uploadFile")
    String upload(File file);


    @PostMapping("/selectById")
    FileInfoVO selectById(FileInfoRequest request);

    @PostMapping(value = "/uploadMultipartFile",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    String uploadMultipartFile(@RequestPart("file") MultipartFile file, @RequestParam("userId") String userId);

}
