package cucumber.msdc.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
@author Shahnaaz Rahamatullah
@version 1.0
 */

public abstract class ConnectionManager {
private WebDriver webDriver;
private static final String CHROME_DRIVER_LOCATION="\\src\\test\\resources\\chromedriver\\win32_2.2\\chromedriver.exe";

public void setUp(){
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+CHROME_DRIVER_LOCATION);
	webDriver = new ChromeDriver();
	webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

public void tearDown(){
	webDriver.quit();
}


}
