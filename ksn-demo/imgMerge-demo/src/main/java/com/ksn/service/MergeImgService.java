package com.ksn.service;

import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/9 10:14
 */
@Service
public interface MergeImgService {

    /**
     * 获取图片的缓存流
     * @param filePath
     * @return
     * @throws IOException
     */
    BufferedImage loadBufferedImage(String filePath) throws IOException;


    /**
     * 构建画布
     * @param a
     * @param b
     * @return
     */
    BufferedImage mergeImg(BufferedImage a, BufferedImage b);

    /**
     * 生成图片
     * @param filePath
     * @param newImg
     * @return
     * @throws IOException
     */
    Boolean createImg(String filePath, BufferedImage newImg) throws IOException;
}
