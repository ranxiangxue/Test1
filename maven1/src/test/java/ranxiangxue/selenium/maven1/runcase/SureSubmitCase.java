package ranxiangxue.selenium.maven1.runcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ranxiangxue.selenium.maven1.TestNgListenerScreen;
import ranxiangxue.selenium.maven1.handle.SureSubmitHandle;

@Listeners({ TestNgListenerScreen.class })
public class SureSubmitCase extends BaseCase {
	public Logger logger = Logger.getLogger(CourseCase.class);
	public WebDriver driver;
	SureSubmitHandle SureSubmitHandle;

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Parameters({ "SureOrderurl", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browser) {
		/**
		 * 初始化driver
		 */
		PropertyConfigurator.configure("log4j.properties");
		logger.debug("初始化浏览器");
		driver = GetDriver(browser);
		logger.debug("初打开浏览器");
		driver.get(url);
		driver.manage().window().maximize();//放大窗口
		SureSubmitHandle = new SureSubmitHandle(driver);
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
	@Parameters({ "SureOrderurl"})
	@Test
	public void SureSubmit(String SureOrderurl) {
		driver.get(SureOrderurl);
		String course_title =SureSubmitHandle.GetCourseTitle();
		boolean flag=course_title.contains("登录");
		Assert.assertEquals(flag, true);
	}
	
	@Parameters({ "SureOrderurl"})
	@Test(enabled = false)
	public void LoginSureSubmit(String SureOrderurl) {
		SureSubmitHandle.SetUserCookie();
		driver.get(SureOrderurl);
		String course_title =SureSubmitHandle.GetCourseTitle();
		boolean flag=course_title.contains("确认订单");
		Assert.assertEquals(flag, true);
		SureSubmitHandle.ClickSureSubmitElement();
	}
	
	

}
