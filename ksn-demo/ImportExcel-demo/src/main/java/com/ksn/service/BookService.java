package com.ksn.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/3/15 15:20
 */
public interface BookService {

    /**
     * excel数据导入数据库
     * @param path
     * @return
     */
    List<List<String>> excelToData(String path) throws IOException, InvalidFormatException;
}
