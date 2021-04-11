package com.ksn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.ksn.service.MergeImgService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/9 10:14
 */
public class MergeImgServiceImpl implements MergeImgService {

    @Override
    public BufferedImage loadBufferedImage(String filePath) throws IOException {
        File file = new File(filePath);
        if (StrUtil.isNotEmpty(filePath) && file.exists()) {
            return ImageIO.read(file);
        }
        return null;
    }

    @Override
    public BufferedImage mergeImg(BufferedImage a, BufferedImage b) {
        int width = a.getWidth() > b.getWidth() ? a.getWidth():b.getWidth();
        int height = a.getHeight() + b.getHeight() + 10;

        // 构建画布
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        // 把两张图都画进去
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.drawImage(a, 0, 0, null);
        graphics.drawImage(b, 0, a.getHeight() + 10, null);
        // 类似于关闭资源的操作
        graphics.dispose();
        return bufferedImage;
    }

    @Override
    public Boolean createImg(String filePath, BufferedImage newImg) throws IOException {
        if (StrUtil.isEmpty(filePath)) {
            return false;
        }
        File file = new File(filePath);
        ImageIO.write(newImg, "JPG", file);
        return true;
    }


    public static void main(String[] args) throws IOException {
        MergeImgServiceImpl mergeImgService = new MergeImgServiceImpl();
        BufferedImage a = mergeImgService.loadBufferedImage("G:\\a.jpg");
        BufferedImage b = mergeImgService.loadBufferedImage("G:\\b.jpg");

        BufferedImage image = mergeImgService.mergeImg(a, b);

        Boolean img = mergeImgService.createImg("G:\\c.jpg", image);
        System.out.println(img);
    }
}
