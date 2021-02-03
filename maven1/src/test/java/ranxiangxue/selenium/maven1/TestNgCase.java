package ranxiangxue.selenium.maven1;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestNgListenerScreen.class })
public class TestNgCase {
	public WebDriver driver;
	private static Logger logger = Logger.getLogger(TestNgCase.class);

	@BeforeTest
	public void beforeTest() {
	}

	@BeforeClass

	public void beforeClass() {
		/**
		 * 初始化driver
		 */
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.imooc.com/user/newlogin");
	}

	@Test
	public void test1() {
		logger.error("error email1");
		driver.findElement(By.name("email1")).sendKeys("18349271429");
		System.out.println("这个第一个Case");
	}

	@Test
	public void test2() {
		logger.debug("email");
		driver.findElement(By.name("email")).sendKeys("18349271429");
		System.out.println("这个第二个Case");
	}

	@Test
	public void test3() {
		driver.findElement(By.name("password1")).sendKeys("Rxx123456");
		System.out.println("这个第三个Case");
	}

	@Test

	public void test4() {

		driver.findElement(By.name("password")).sendKeys("Rxx123456");
		System.out.println("这个第四个Case");

	}

	@Test
	public void test5() {

		driver.findElement(By.className("moco-btn")).click();
		System.out.println("这个第五个Case");
		//
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		SendToMeail();
	}

	@AfterTest
	public void afterTest() {
	}

	public void SendToMeail() {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.qq.com");
		email.setAuthentication("1475460310@qq.com", "dyvppkviinsmfjfh");
		try {
			email.setFrom("1475460310@qq.com");
			email.addTo("ranxiangxue@cqliving.com");
			email.setSubject("selenium subject");
			email.setMsg("this is test");
			email.send();
			logger.debug("发送成功");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
