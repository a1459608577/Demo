package com.ksn.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class PdfHandler1 {


    public static void imagePdf(String urljPG, String urlPdf) throws Exception {
        // 获取去除后缀的文件路径
        String fileName = urlPdf.substring(0, urlPdf.lastIndexOf("."));
        //把截取的路径，后面追加四位随机数
        String pdfUrl = fileName + (int) ((Math.random() * 9 + 1) * 1000) + ".pdf";
        //要加水印的原pdf文件路径
        PdfReader reader = new PdfReader("F:\\minxing\\javaToPDF\\src\\main\\resources\\static\\assessment.pdf", "PDF".getBytes());
        //加了水印后要输出的路径
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(pdfUrl));
        // 插入水印
        Image img = Image.getInstance("G:\\0EEAAAFC.jpg");
        //原pdf文件的总页数
        int pageSize = reader.getNumberOfPages();
        //印章位置
        img.setAbsolutePosition(350, 620);
        //印章大小
        img.scalePercent(50);
        for (int i = 1; i <= pageSize; i++) {
            //背景被覆盖
//            PdfContentByte under = stamp.getUnderContent(i);
            //文字被覆盖
            PdfContentByte under = stamp.getOverContent(i);
            //添加电子印章
            under.addImage(img);
        }
        // 关闭
        stamp.close();
        //关闭
        reader.close();
        System.out.println("结束");
    }

    public static void main(String[] args) throws Exception {
        imagePdf("G:\\0EEAAAFC.jpg", "G:\\assessment.pdf");

    }
}

