package com.ksn.utils;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Map;

/**
 * @author ksn
 * @version 1.0
 * @date 2020/12/1 16:22
 */

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PDFUtil {

    private static Configuration cfg = null;

    // 导出到指定 PDF 路径
    public static void exportPDF(String html, String pdf, String... fonts) throws DocumentException, IOException, TemplateException {
        ITextRenderer renderer = new ITextRenderer();
        addFont(renderer, fonts);
        try (OutputStream os = new FileOutputStream(pdf)) {
            renderer.setDocumentFromString(html);
            // html中如果有图片，图片的路径则使用这里设置的路径的相对路径，这个是作为根路径
//            if (imageDiskPath != null && !"".equals(imageDiskPath)) {
//                renderer.getSharedContext().setBaseURL("file:/" + "G:\\\\Image\\\\0EE83437.jpg");
//            }
            renderer.getSharedContext().setBaseURL("file:/" + "G:\\\\Image\\\\0EE83437.jpg");
            renderer.layout();
            renderer.createPDF(os);
        }
    }

    // 解析 FreeMarker 模板
    public static String parseFreemarker(String freemarker, Map<String, Object> dataModel) throws IOException, TemplateException {
        if (cfg == null) {
            cfg = initConfiguration();
        }
        Template temp = cfg.getTemplate(freemarker);
        try (Writer out = new StringWriter()) {
            temp.process(dataModel, out);
            return out.toString();
        }
    }

    // 加载准备好的字体
    private static void addFont(ITextRenderer renderer, String... fonts) throws DocumentException, IOException {
        ITextFontResolver fontResolver = renderer.getFontResolver();
//        for (String font : fonts) {
//            fontResolver.addFont(font, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//        }
        fontResolver.addFont("F:\\idea-workspace\\Demo\\ksn-demo\\javaToPDF\\src\\main\\resources\\static\\FELIXTI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    }

    // 初始化 FreeMarker 配置
    private static Configuration initConfiguration() throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        // 模板路径
        cfg.setTemplateLoader(new SpringTemplateLoader(new DefaultResourceLoader(), "classpath:/templates/"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        return cfg;
    }

    public static void buidPDF(String pdfFile, String imageFile,
                               String waterMarkName, int permission) {
        try {
            File file = File.createTempFile("tempFile", ".pdf"); // 创建临时文件

            // 生成PDF
            if (createPDFFile(file)) {
                addWatermark(file.getPath(), imageFile, pdfFile, waterMarkName); // 添加水印
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean createPDFFile(File file) {
        Rectangle rect = new Rectangle(PageSize.A4);
        Document doc = new Document(rect, 50.0F, 50.0F, 50.0F, 50.0F);
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();

            BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",
                    "Identity-H", true);// 使用系统字体

            Font font = new Font(bf, 14.0F, 0);
            font.setStyle(37); // 设置样式
            font.setFamily("宋体"); // 设置字体

            Paragraph p = new Paragraph("付 款 通 知 书\r\n", font);
            p.setAlignment(1);
            doc.add(p);
            doc.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 添加水印
     *
     * @param pdfFilePath   pdf路径
     * @param imgPath       水印图片路径
     * @param waterMarkName 水印文字
     * @param storePath     存放路径
     */
    public static void addWatermark(String pdfFilePath, String imgPath, String waterMarkName, String storePath) throws IOException {
        PdfReader pdfReader = new PdfReader(pdfFilePath, "PDF".getBytes());
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(storePath));

        String font = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "static" + File.separator + "FELIXTI.TTF";
        BaseFont baseFont = BaseFont.createFont();
        // 获取文档页数
        int total = pdfReader.getNumberOfPages() + 1;
        // 获取图片示例
        Image image = Image.getInstance(imgPath);
        Image image1 = Image.getInstance(imgPath);

        // 水印位置
        image.setAbsolutePosition(400f, 750f);
        image.setTransparency(new int[] {1, 1});
        image.scalePercent(68.8f);

        image1.setAbsolutePosition(100f, 500f);
        image1.setTransparency(new int[] {1, 1});
//        调整图片整体缩小放大
//        image1.scalePercent(68.8f);
//      调整图片的长 宽
        image1.scaleAbsolute(100f, 100f);
//        image.setWidthPercentage(5f);

        PdfContentByte under;
//        int j = waterMarkName.length();
//        char c = 0;
//        int rise = 0;
//        for (int i = 1; i < total; i++) {
//            rise = 200;
            under = pdfStamper.getUnderContent(1);
            under.beginText();
            under.setFontAndSize(baseFont, 14);
//            if (j >= 15) {
//                under.setTextMatrix(200, 120);
//                for (int k = 0; k < j; k++) {
//                    under.setTextRise(rise);
//                    c = waterMarkName.charAt(k);
//                    under.showText(c + "");
//                }
//            } else {
//                under.setTextMatrix(300, 100);
//                for (int k = 0; k < j; k++) {
//                    under.setTextRise(rise);
//                    c = waterMarkName.charAt(k);
//                    under.showText(c + "");
//                    rise -= 18;
//
//                }
//            }
            // 添加水印文字
            // under.endText();
            // 添加水印图片
            under.addImage(image);
            under.addImage(image1);
            // 画个圈
            // under.ellipse(250, 450, 350, 550);
            under.setLineWidth(1f);
            under.stroke();
//        }
        pdfStamper.close();
    }

    public static void main(String[] args) {
        String imageFilePath = "G:/3.jpg"; // 水印图片路径
        String pdfFilePath = "G:/itext.pdf"; // 文件生成路径
        buidPDF(pdfFilePath, imageFilePath, "正版授权", 16);
    }
}
