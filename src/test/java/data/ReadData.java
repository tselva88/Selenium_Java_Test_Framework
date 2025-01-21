package data;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class ReadData {
	
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
    	 return readValue("Login");
    }
    
    @DataProvider(name = "productsData")
    public Object[][] productsData() {
        return readValue("Products");
    }
    
    @DataProvider(name = "GETAPIData")
    public Object[][] GETAPIData() {
        return readValue("GET_API");
    }

    @DataProvider(name = "POSTAPIData")
    public Object[][] POSTAPIData() {
        return readValue("POST_API");
    }

    public Object[][] readValue(String sheetname) {
        ExcelUtils excel = new ExcelUtils("src/test/java/data/InputData.xlsx");
        int rows = excel.getRowCount(sheetname);
        int cols = excel.getColumnCount(sheetname);

        Object[][] data = new Object[rows - 1][cols]; // To exclude header row from data
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = excel.getCellData(sheetname, i, j);
            }
        }
        return data;	
    }
    
}
