package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        
        // Excel file path
        String path = ".\\testData\\DataDrivenTC.xlsx";
        
        // Create object for ExcelUtility
        ExcelUtility xlutil = new ExcelUtility(path); // create an object for XLUtility
        
        // Get row and column counts
        int totalRows = xlutil.getRowCount("Sheet1");
        int totalCols = xlutil.getCellCount("Sheet1", 1);
        
        // Create 2D array to store Excel data
        String[][] loginData = new String[totalRows][totalCols]; // created string type 2d array to store data from excel file
        
        // Read data from Excel into 2D array
        for (int i = 1; i <= totalRows; i++) { 
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }
        
        // Return 2D array for DataProvider
        return loginData;
    }
    
    //DataProvider 2
    
    //DataProvider 3
    
    //DataProvider 4
    
    
    
    
}
