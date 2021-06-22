package com.ksn.controller;

import com.ksn.utils.BarcodeUtil;
import com.ksn.utils.PDFUtil;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ksn
 * @version 1.0
 * @date 2020/12/1 16:15
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("test")
    public static String test01(HttpServletResponse response) throws IOException, TemplateException {
        String imgPath = System.getProperty("user.dir") + File.separator + UUID.randomUUID() + ".png";
        File barcodeFile = BarcodeUtil.generateFile("123456789", imgPath);
        // 数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("author", "KSN ksn签名");
        dataModel.put("url", "baidu.com");
        // 图片地址
        String imagePath = System.getProperty("user.dir") + File.separator + "ksn-demo" +File.separator + "javaToPDF" + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "static" + File.separator + "img" + File.separator + "a.jpg";
        dataModel.put("imgUrl", "file:///" + imagePath);
        // 解析 FreeMarker 模板
        String content = PDFUtil.parseFreemarker("template.ftl", dataModel);
        // 导出 PDF 文件路径
        String pdf = "G:/test.pdf";
//        String pdf = System.getProperty("user.dir") + File.separator + "freemarker.pdf";
        // 微软雅黑字体
        String font = System.getProperty("user.dir") + File.separator + "javaToPDF" + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "static" + File.separator + "FELIXTI.TTF";
        // 导出到 PDF 文件
        PDFUtil.exportPDF(content, pdf, font);

        // 添加水印
//        String barcodePdf = pdf.substring(0, pdf.lastIndexOf(".")) + "123.pdf";
//        PDFUtil.addWatermark(pdf, imgPath, "mamaipi1111", barcodePdf);
//        log.info("水印添加完成");

        // 删除图片
        if (barcodeFile.exists() && !barcodeFile.isDirectory()) {
            barcodeFile.delete();
        }

        response.reset();
        response.setCharacterEncoding("UTF-8");
        // 定义输出类型
        response.setContentType("application/PDF;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + "assessment.pdf");

        File file = new File(pdf);
//        File file = new File(barcodePdf);
        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();

        int b = 0;
        byte[] bytes = new byte[1024];
        while (b != -1) {
            b = fileInputStream.read(bytes);
            outputStream.write(bytes, 0, b);
        }
        fileInputStream.close();
        outputStream.close();
        return "1";
    }

    @GetMapping("test1")
    public String test02(HttpServletRequest request) throws IOException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        File upload = new File(new File(path).getAbsolutePath(), "static/FELIXTI.TTF");
//        // if(!upload.exists()) upload.mkdirs();
        System.out.println("upload url:" + upload.getAbsolutePath());
        System.out.println(upload.getCanonicalPath());
        return null;
    }

    @GetMapping("test2")
    public String test03(HttpServletRequest request) throws IOException {
        String imageFilePath = "G:\\Image\\0EE82ECB.jpg"; // 水印图片路径
        String pdfFilePath = "G:/itext.pdf"; // 文件生成路径
        PDFUtil.buidPDF(pdfFilePath, imageFilePath, "正版授权", 16);
        return "success!";
    }


    public static void main(String[] args) throws IOException, TemplateException {

//        System.out.println("F:\\minxing\\javaToPDF\\src\\main\\resources\\static");
//
//        System.out.println(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
//                File.separator + "resources" + File.separator + "static" + File.separator + "FELIXTI.TTF");
//
//        System.out.println(System.getProperty("user.dir"));
//
//        File file = new File("");
//        System.out.println(file.getAbsolutePath());
//        test01();
    }
}
