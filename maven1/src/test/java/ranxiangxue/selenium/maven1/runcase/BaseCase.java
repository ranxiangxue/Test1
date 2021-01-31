package ranxiangxue.selenium.maven1.runcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseCase {
	public WebDriver driver = null;
	public WebDriver GetDriver(String browser) {		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}
}
