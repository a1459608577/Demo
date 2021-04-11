package com.ksn.controller;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.parser.PdfDocumentContentParser;
import com.itextpdf.kernel.pdf.canvas.parser.listener.IPdfTextLocation;
import com.itextpdf.kernel.pdf.canvas.parser.listener.RegexBasedLocationExtractionStrategy;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import java.util.Collection;

public class PdfHandler2 {
    public static void main(String args[]) {
        String input = "G:\\freemarker.pdf";
        //通过指定pdf文件名，指定关键字，和指定的pdf文件的待处理页数做参数
        getKeyWordsLocation(input, "作者：", 1);
    }

    /**
     * 得到关键字位置
     * @param input 源文件
     * @param KEY_WORD 关键字
     * @param pageNum 文档页数
     */
    public static void getKeyWordsLocation(String input, String KEY_WORD, int pageNum) {
        RegexBasedLocationExtractionStrategy strategy = new RegexBasedLocationExtractionStrategy(KEY_WORD);
        try {
            //得到需要插入的图片
            ImageData imageData = ImageDataFactory.create("G:\\0EEAAAFC.jpg");
            //核心思路为对PdfDocument对象采用某种Strategy，这里使用RegexBasedLocationExtractionStrategy
            PdfReader pr = new PdfReader(input);
            //生成新的PDF文件
            PdfDocument pd = new PdfDocument(pr, new PdfWriter("G:\\test.pdf"));
            //int pageNum = pd.getNumberOfPages();获取新pdf的总页数
            Document document = new Document(pd);
            PdfDocumentContentParser pdcp = new PdfDocumentContentParser(pd);
            //文本内容具体解析借助使用PdfDocumentContentParser类(实质使用PdfCanvasProcessor进行处理)， 对待处理页面装配合适策略
            RegexBasedLocationExtractionStrategy regexStrategy = pdcp.processContent(pageNum, strategy);
            //获取处理结果
            Collection<IPdfTextLocation> resultantLocations = strategy.getResultantLocations();
            //自定义结果处理
            if (!resultantLocations.isEmpty()) {
                for (IPdfTextLocation item : resultantLocations) {
                    Rectangle boundRectangle = item.getRectangle();
                    System.out.println(item.getText());
                    System.out.println("关键字“" + KEY_WORD + "” 的坐标为 x: " + boundRectangle.getX() + "  ,y: " + boundRectangle.getY());
                    Image image = new Image(imageData).scaleAbsolute(70, 40).setFixedPosition(pageNum, boundRectangle.getRight() + 5f, boundRectangle.getBottom());
                    document.add(image);
                }
                document.close();
            } else {
                System.out.println("结果为空");
            }
            pr.close();
            pd.close();
        } catch (Exception e) {
            System.err.println("读取文件失败!");
            e.printStackTrace();
        }
    }
}

