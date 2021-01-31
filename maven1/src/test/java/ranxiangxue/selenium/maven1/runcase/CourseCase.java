package ranxiangxue.selenium.maven1.runcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ranxiangxue.selenium.maven1.TestNgListenerScreen;
import ranxiangxue.selenium.maven1.handle.CourseHandle;

@Listeners({ TestNgListenerScreen.class })
public class CourseCase extends BaseCase {
	public Logger logger = Logger.getLogger(CourseCase.class);
	public WebDriver driver;
	CourseHandle CourseHandle;

	@Parameters({ "Courseurl", "browser" })
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
		CourseHandle = new CourseHandle(driver);
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

	@Parameters({ "coursename" })
	@Test
	public void AddCartCase(String coursename) {
		int a=0;
		String course_title =CourseHandle.GetCourseTitle();
		boolean flag=course_title.contains(coursename);
		Assert.assertEquals(flag, true);
		if (CourseHandle.UserIsLogin()==false) {
			CourseHandle.SetUserCookie();
		}
		int before_number=CourseHandle.GetCartNum();
		CourseHandle.ClickAddCart();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int after_number=CourseHandle.GetCartNum();
		a=after_number-before_number;
		Assert.assertEquals(a, 1);		
	}

	/*
	 * @Test(timeOut =3000,enabled=false,groups = "success",dependsOnMethods= {"beforeClass"})
	 * timeOut =3000---超时设置 
	 * enabled=false---跳过case设置
	 * groups = "success"---设置为success组的case
	 * dependsOnMethods= {"beforeClass"}---依赖于XXX方法
	 */ 
	@Test
	public void TestAleradyBuy() {
		CourseHandle.ClickAddCart();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CourseHandle.ClickBtnClose();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
