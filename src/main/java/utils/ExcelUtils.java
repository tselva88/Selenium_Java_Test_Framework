package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private XSSFWorkbook workbook;

    public ExcelUtils(String excelPath) {
        try (FileInputStream fis = new FileInputStream(excelPath)) {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Excel file.");
        }
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    }

    public int getRowCount(String sheetName) {
        return workbook.getSheet(sheetName).getPhysicalNumberOfRows();
    }

    public int getColumnCount(String sheetName) {
        return workbook.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
    }
}