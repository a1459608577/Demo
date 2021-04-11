package com.ksn.service.impl;

import com.ksn.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/9 11:18
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public void upload(MultipartFile file, HttpServletResponse response) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        ServletOutputStream outputStream = response.getOutputStream();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) > 0) {
            outputStream.write(bytes);
        }
    }

    @Override
    public void uploadFile(MultipartFile file, HttpServletResponse response) throws IOException {
        InputStream inputStream = file.getInputStream();
        File file1 = new File("G:\\2.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) > 0) {
            fileOutputStream.write(bytes);
        }
    }
}
