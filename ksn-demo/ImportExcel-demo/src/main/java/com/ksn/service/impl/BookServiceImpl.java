package com.ksn.service.impl;

import com.ksn.service.BookService;
import entity.Book;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/3/15 15:21
 */
@Service
public class BookServiceImpl implements BookService {

    public static void main(String[] args) throws IOException, InvalidFormatException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        BookService bookService = new BookServiceImpl();
        List<List<String>> lists = bookService.excelToData("F:\\minxing\\testExcel.xlsx");
        System.out.println(lists);

        for (int i = 0; i < lists.size(); i++) {
            Book book = BookServiceImpl.getObj(Book.class, lists.get(i));
            System.out.println(book);
        }
    }

    public static <T>T getObj(Class<T> clazz, List list) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length != list.size()) {
            throw new RuntimeException("数组越界");
        }
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            fields[i].set(t, list.get(i));
        }
        return t;
    }

    @Override
    public ArrayList excelToData(String path) throws IOException, InvalidFormatException {
        // 获取文件的输入流对象
        FileInputStream fileInputStream = new FileInputStream(path);
        //
        Workbook sheets = WorkbookFactory.create(fileInputStream);
        // 获取第一个excel表格，左下角部位
        Sheet sheetAt = sheets.getSheetAt(0);
        // 获取总行数
        int rows = sheetAt.getPhysicalNumberOfRows();
        // 获取总列数
        int cells = 0;
        if (sheetAt.getRow(0) != null && rows > 0) {
            cells = sheetAt.getRow(0).getPhysicalNumberOfCells();
        }

        ArrayList<List> lists = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            Row row = sheetAt.getRow(i);
            if (row == null) {
                continue;
            }
            ArrayList<String> cellStrs = new ArrayList<>();
            for (int j = 0; j < cells; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (cell != null) {
                    String cellValue = "";
                    CellType cellTypeEnum = cell.getCellTypeEnum();
                    switch (cellTypeEnum) {
                        // 数字
                        case NUMERIC:
                            cellValue = cell.getNumericCellValue() + "";
                            break;
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case BOOLEAN:
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        // 公式
                        case FORMULA:
                            try {
                                cellValue = cell.getStringCellValue();
                            } catch (IllegalStateException e) {
                                cellValue = String.valueOf(cell.getNumericCellValue());
                            }
                            break;  /* cellValue = cell.getCellFormula() + ""; break;*/
                        // 空值
                        case BLANK:
                            cellValue = "";
                            break;
                        // 故障
                        case _NONE:
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                    cellStrs.add(cellValue);
                }
            }
            lists.add(cellStrs);
        }
        return lists;
    }

}

