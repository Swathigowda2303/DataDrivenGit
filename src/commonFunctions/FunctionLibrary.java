package commonFunctions;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil
{
public static boolean login_Verify(String user, String pass)
{
	driver.get(con.getProperty("url"));
	driver.findElement(By.cssSelector(con.getProperty("user"))).sendKeys(user);
	driver.findElement(By.cssSelector(con.getProperty("objpass"))).sendKeys(pass);
	driver.findElement(By.cssSelector(con.getProperty("objlogin"))).click();
	String exp="dashboard";
	String act=driver.getCurrentUrl();
	if(act.contains(exp))
	{
		Reporter.log("login sucess",true);
		return true;
	}
	else
	{
		String error=driver.findElement(By.cssSelector(con.getProperty("objerror"))).getText();
		Reporter.log("error msg"+error,true);
		return false;
	}
}

}