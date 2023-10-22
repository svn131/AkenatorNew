package ru.kata.spring.boot_security.demo.util;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.repository.Repository;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class PsrserExel {

    int nomerVoprosa = 1;

    int nomerTemp = 1;


    @Autowired
    Repository repository;


    List<Vopros> voprosyLst = new ArrayList<>();

    List<Znamenitost> znamenitostList = new ArrayList<>();


    public PsrserExel() {
        Repository repository = new Repository();
        this.repository = repository;

    }

    @PostConstruct
    public void parsExel() throws Exception {


        FileInputStream file = new FileInputStream("C:/AkinatorAI.xlsx");

        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0); // Получение первого листа

        // Получение количества ячеек в первой строке
        Row headerRow = sheet.getRow(0);
        int numCells = headerRow.getLastCellNum();
        List<String> voprosyS1PoMax = new ArrayList<>();

        for (int i = 0; i < numCells; i++) {
            Cell cell = headerRow.getCell(i);

            if (cell != null && cell.getCellType() == CellType.STRING) {
                String cellValue = cell.getStringCellValue();
                voprosyS1PoMax.add(cellValue);
            }
        }


        // Парсинг значений первого столбца в массив
        int numRows = sheet.getLastRowNum() + 1;
        List<String> znamenytostyS1PoMax = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);

            if (cell != null && cell.getCellType() == CellType.STRING) {
                String cellValue = cell.getStringCellValue().trim();
                if (!cellValue.isEmpty()) {
                    znamenytostyS1PoMax.add(cellValue);
                }
            }
        }


        // наполнение репозитория - значений массивов
        System.out.println("Значения первой строки - Знаменитости:");
        for (String odinIz : znamenytostyS1PoMax) {
            Znamenitost znamenitost = new Znamenitost(odinIz);
            //парсим вопрсы

          znamenitost.setOtvetyList(poluchitNaKonkretnogo(sheet));

                    //парсим вопрсы
                    znamenitostList.add(znamenitost);
                    System.out.println(odinIz);
                }


                System.out.println("Значения первого столбца - Вопросы:");


                for (String value : voprosyS1PoMax) {
                    Vopros vopros = new Vopros(nomerVoprosa, value);
                    nomerVoprosa++;
                    voprosyLst.add(vopros);
                    System.out.println(value);
                }

                repository.setZnamenitostList(znamenitostList);
                repository.setVoprosList(voprosyLst);


                workbook.close();
                file.close();


            }





    public List<Vopros> poluchitNaKonkretnogo(Sheet sheet) {

        Row otvetyExel = sheet.getRow(nomerTemp);
        int dlina = otvetyExel.getLastCellNum();
        List<Vopros> otvetyDlyaOndnogo = new ArrayList<>();

        for (int i = 0; i < dlina; i++) {
            Cell cell = otvetyExel.getCell(i);


            if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                int intValue = (int) cell.getNumericCellValue();
                otvetyDlyaOndnogo.add(new Vopros(intValue));



            }

        }
//        nomerTemp = 1;
        nomerTemp++;
        return otvetyDlyaOndnogo;

    }
}