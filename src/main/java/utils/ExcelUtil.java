package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    private static Workbook workbook;
    private static Sheet sheet;
    public static void loadExcel() throws IOException {
        FileInputStream fis =new FileInputStream("src/test/resources/BookingData.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Sheet1");
    }
    public static String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }
    public static int getRowCount() {
        return sheet.getLastRowNum();
    }
    public static void closeExcel() throws IOException {
        workbook.close();
    }
}