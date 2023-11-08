package ru.kata.spring.boot_security.demo.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.repository.Repository;
import ru.kata.spring.boot_security.demo.repository.RepositoryZarodyshey;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class WriteZarodushy {

    Repository repository;
    private final RepositoryZarodyshey repositoryZarodyshey;

    public WriteZarodushy(RepositoryZarodyshey repositoryZarodyshey, Repository repository) {
        this.repositoryZarodyshey = repositoryZarodyshey;
        this.repository = repository;
    }

    public void writeExelZarodysh() {
        List<Znamenitost> listZarodyshey = repositoryZarodyshey.getZarodishList();

        // Создание новой книги Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Zarodyshy");

        // Запись заголовка в первую строку
        Row headerRow = sheet.createRow(0);
        List<Vopros> voprosList = repository.getVoprosList();

        for (int i = 0; i < voprosList.size(); i++) {
            Cell cell = headerRow.createCell(i + 1);
            cell.setCellValue(voprosList.get(i).getValue());
        }

        // Запись данных по знаменитостям
        for (int i = 0; i < listZarodyshey.size(); i++) {
            Znamenitost znamenitost = listZarodyshey.get(i);
            Row dataRow = sheet.createRow(i + 1);

            // Запись имени знаменитости в первый столбец
            Cell nameCell = dataRow.createCell(0);
            nameCell.setCellValue(znamenitost.getName());

            // Запись ответов на вопросы в остальные столбцы
            List<Vopros> otvetyList = znamenitost.getOtvetyList();
            for (Vopros vopros : otvetyList) {
                int columnIndex = vopros.getId(); // Получение id вопроса
                Cell cell = dataRow.createCell(columnIndex);
                cell.setCellValue(vopros.getOtvet());
            }
        }

//        // Сохранение файла Excel
//        try (FileOutputStream outputStream = new FileOutputStream("C:/Zarodyshy.xlsx")) {
//            workbook.write(outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Генерация уникального имени файла
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "C:\\3333\\Zarodyshy_" + timestamp + ".xlsx";

        // Сохранение файла Excel
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
