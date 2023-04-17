package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtill;

public  class DriverScript extends AppUtil
{
	static String inputpath="D:\\Sample.xlsx";
	static String outputpath="D:\\FileOutput.xlsx";
    @Test
    public void startTest() throws Throwable
    {
    	ExcelFileUtill xl=new ExcelFileUtill(inputpath);
    	int row=xl.rowCount("Empdata");
    	Reporter.log("row no"+row,true);
    	for(int i=1; i<=row; i++)
    	{
    		String username=xl.getCellData("Empdata", i, 1);
    		String password=xl.getCellData("Empdata", i, 2);
    		boolean res=FunctionLibrary.login_Verify(username, password);
    		if(res)
    		{
    			xl.setCellData("Empdata", i, 4, "LoginSucess", outputpath);
    			xl.setCellData("Empdata", i, 5, "Pass", outputpath);
    		}
    		else
    		{
    			File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    			FileUtils.copyFile(screen, new File("./screenshot/login"+"Login.png"));
    			xl.setCellData("Empdata", i, 4, "LoginFail", outputpath);
    			xl.setCellData("Empdata", i, 5, "Fail", outputpath);
    		}
    	}
    }
}



