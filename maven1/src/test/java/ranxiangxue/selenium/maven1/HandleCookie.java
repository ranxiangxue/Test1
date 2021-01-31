package ranxiangxue.selenium.maven1;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleCookie {
	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://coding.imooc.com/class/469.html");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod执行完毕");
	}

	@BeforeClass
	public void beforeClass() {
		/**
		 * 初始化driver
		 */
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		//driver.close();
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@Test
	public void test1() {
		int i=0;
		String Value="k3ZWIxYTMzZDZiNTk5YTRiNzg5MTc1MDI2YTY2MTUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOTU4MDIzNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAxNDc1NDYwMzEwQHFxLmNvbQAAAAAAAAAAAAAAAAAAADEwNjQ0Mjc0NzIwMWQ4YzRmZWNjMTUyM2Q4OWIyYmJlPQkEYB6Q4F8%3DNT";
		Set<Cookie> Cookies=driver.manage().getCookies();
		for (Cookie cookie : Cookies) {
			if (cookie.equals("apsid")) {
				System.out.println("已登录");
				i++;
				break;
			}
		}
		if (i==0) {
			Cookie cookie=new Cookie("apsid",Value,".imooc.com","/",null);
			driver.manage().addCookie(cookie);
			driver.navigate().refresh();
			System.out.println("登录成功");
		}
	}
}
