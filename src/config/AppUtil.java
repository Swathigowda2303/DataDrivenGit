package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil 
{
	public static Properties con;
	public static WebDriver driver;
	@BeforeTest
	public static void setUp() throws Throwable
	{
		con=new Properties();
		con.load(new FileInputStream("D:\\Selenium\\DDT_Framework\\PropertyFile\\Environment.properties"));
		if(con.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else
		{
			Reporter.log("Wrong browser",true);
		}
	}
	@AfterTest
	public static void tearUp()
	{
		driver.close();
	}

}