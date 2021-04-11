package com.ksn.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/9 11:19
 */
public interface FileUploadService {
    /**
     * 直接返回文件流
     * @param file
     * @param response
     * @throws IOException
     */
    void upload(MultipartFile file, HttpServletResponse response) throws IOException;

    void uploadFile(MultipartFile file, HttpServletResponse response) throws IOException;
}
