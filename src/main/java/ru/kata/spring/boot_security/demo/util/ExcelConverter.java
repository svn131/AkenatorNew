package ru.kata.spring.boot_security.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;

public class ExcelConverter {
    public static void main(String[] args) {
        try {
            // Чтение Excel-файла
            FileInputStream файл = new FileInputStream(new File("C:/AkinatorAI2222.xlsx"));
            Workbook книга = new XSSFWorkbook(файл);
            Sheet лист = книга.getSheetAt(0);

            // Создание новой книги для транспонированных данных
            Workbook транспонированнаяКнига = new XSSFWorkbook();
            Sheet транспонированныйЛист = транспонированнаяКнига.createSheet("Транспонированные Данные");

            int количествоСтрок = лист.getLastRowNum();
            int количествоСтолбцов = лист.getRow(0).getLastCellNum();

            for (int строка = 0; строка <= количествоСтрок; строка++) {
                Row текущаяСтрока = лист.getRow(строка);

                for (int столбец = 0; столбец < количествоСтолбцов; столбец++) {
                    Cell текущаяЯчейка = текущаяСтрока.getCell(столбец);
//                    if (текущаяЯчейка == null) continue;

                    // Создание новой строки и ячейки в транспонированном листе
                    Row транспонированнаяСтрока = транспонированныйЛист.getRow(столбец);
                    if (транспонированнаяСтрока == null)
                        транспонированнаяСтрока = транспонированныйЛист.createRow(столбец);
                    Cell транспонированнаяЯчейка = транспонированнаяСтрока.createCell(строка);

                    // Установка значения на основе содержимого исходной ячейки
// Установка значения на основе содержимого исходной ячейки
                    DataFormatter форматтер = new DataFormatter();
                    String значениеЯчейки = форматтер.formatCellValue(текущаяЯчейка);

                    System.out.println("----------------------------------------------------------------- "+значениеЯчейки);

                    if ( текущаяЯчейка == null )
                        транспонированнаяЯчейка.setCellValue(0);
                    else if (значениеЯчейки.equals("Да"))
                        транспонированнаяЯчейка.setCellValue(1);
                    else if (значениеЯчейки.equals("Нет"))
                        транспонированнаяЯчейка.setCellValue(-1);
                    else
                        транспонированнаяЯчейка.setCellValue(значениеЯчейки);


                }
            }

            // Запись транспонированных данных в новый Excel-файл
            FileOutputStream выход = new FileOutputStream(new File("C:/111.xlsx"));
            транспонированнаяКнига.write(выход);

            // Закрытие книг
            книга.close();
            транспонированнаяКнига.close();
            файл.close();
            выход.close();

            System.out.println("Конвертация Excel завершена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//    Workbook workbook = WorkbookFactory.create(new File("C:/AkinatorAI.xlsx"));
//    Sheet sheet = workbook.getSheetAt(0); // Получаем первый лист
//    Row row = sheet.getRow(0); // Получаем первую строку
//    Cell cell = row.getCell(0); // Получаем ячейку в столбце 0
//
//    DataFormatter formatter = new DataFormatter();
//    String value = formatter.formatCellValue(cell);
//            System.out.println("----"+value+"-----");
//                    System.out.println(value.equals(""));
//
//                    workbook.close();
//                    }