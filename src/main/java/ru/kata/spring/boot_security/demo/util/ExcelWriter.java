package ru.kata.spring.boot_security.demo.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {


    public static void writeCellValue(String filePath, int rowIndex, int columnIndex, int value) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0); // выбор первого листа

        // получение строки
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex); // создание новой строки, если она не существует
        }

        // получение ячейки или создание новой
        Cell cell = row.getCell(columnIndex);
        if (cell == null) {
            cell = row.createCell(columnIndex); // создание новой ячейки, если она не существует
        }

        // запись значения в ячейку
        cell.setCellValue(value);

        // сохранение изменений в файле
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
        file.close();
    }




    public static void writeCellValue(String filePath, int rowIndex, int columnIndex, String value) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0); // выбор первого листа

        // получение строки
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex); // создание новой строки, если она не существует
        }

        // получение ячейки или создание новой
        Cell cell = row.getCell(columnIndex);
        if (cell == null) {
            cell = row.createCell(columnIndex); // создание новой ячейки, если она не существует
        }

        // запись значения в ячейку
        cell.setCellValue(value);

        // сохранение изменений в файле
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
        file.close();
    }














}
































//УНЕВЕРСАЛЬНЫЙ ФОРМАТ
//
//    public static void writeCellValue(String filePath, int rowIndex, int columnIndex, int value, String format) throws IOException {
//        FileInputStream file = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheetAt(0); // выбор первого листа
//
//        // получение строки
//        Row row = sheet.getRow(rowIndex);
//        if (row == null) {
//            row = sheet.createRow(rowIndex); // создание новой строки, если она не существует
//        }
//
//        // получение ячейки или создание новой
//        Cell cell = row.getCell(columnIndex);
//        if (cell == null) {
//            cell = row.createCell(columnIndex); // создание новой ячейки, если она не существует
//        }
//
//        // запись значения в ячейку
//        if (format != null && !format.isEmpty()) {
//            CellStyle style = workbook.createCellStyle();
//            DataFormat dataFormat = workbook.createDataFormat();
//            style.setDataFormat(dataFormat.getFormat(format));
//            cell.setCellStyle(style);
//        }
//        cell.setCellValue(value);
//
//        // сохранение изменений в файле
//        FileOutputStream fileOut = new FileOutputStream(filePath);
//        workbook.write(fileOut);
//        fileOut.close();
//
//        workbook.close();
//        file.close();
//    }
