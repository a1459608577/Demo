package com.ksn.controller;

import com.ksn.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/9 11:19
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @ResponseBody
    @PostMapping("/upload")
    public String test1(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        fileUploadService.upload(file, response);
        return "success";
    }

    @ResponseBody
    @PostMapping("/uploadFile")
    public String test2(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        fileUploadService.uploadFile(file, response);
        return "success";
    }

    @ResponseBody
    @GetMapping("/test/{id}")
    public String test3(@PathVariable("id") String id) throws IOException {
        System.out.println(id);
        return "success";
    }
}
