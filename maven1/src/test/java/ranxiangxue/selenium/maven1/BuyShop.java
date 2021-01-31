package ranxiangxue.selenium.maven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuyShop {
	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://coding.imooc.com/class/469.html");
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
		driver.close();
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@Test
	public void test1() {
		int Number = 0;
		int BeforeNumber = 0;
		int AfterNumber;
		String CourseTitle = driver.getTitle();
		if (CourseTitle.contains("Go+Python双语言混合开发")) {// CourseTitle是否包含"Go+Python双语言混合开发"
			System.out.println("获取title成功");
			try {
				BeforeNumber = Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());
			} catch (Exception e) {
				System.out.println("购物车数量为空");
			}
			LoginCookile LoginCookile=new LoginCookile(driver);
			LoginCookile.Login();
			driver.findElement(By.className("js-addcart")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			String After=driver.findElement(By.className("js-cart-num")).getText();
//			AfterNumber = Integer.parseInt(After);			
			AfterNumber = Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());
			Number = AfterNumber - BeforeNumber;
			if (Number == 1) {
				System.out.println("添加购物车成功");
			}
		}
	}
  
  
  
  
  
  
  

}
