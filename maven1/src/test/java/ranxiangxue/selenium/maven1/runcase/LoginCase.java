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
import ranxiangxue.selenium.maven1.handle.LoginHandle;

@Listeners({ TestNgListenerScreen.class })
public class LoginCase extends BaseCase{
	public Logger logger = Logger.getLogger(LoginCase.class);
	public WebDriver driver;
	//ProUntil proUntil;
	LoginHandle Loginhandle;
	
	
	@Parameters({"url","browser"})
	@BeforeClass
	public void beforeClass(String url,String browser) {
		/**
		 * 初始化driver
		 */
		//proUntil = new ProUntil("user.properties");
		PropertyConfigurator.configure("log4j.properties");
		logger.debug("初始化浏览器");
		driver = GetDriver(browser);
		logger.debug("初打开浏览器");
		driver.get(url);
		Loginhandle=new LoginHandle(driver);
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
	
	//默认没在xml中取值时@Optional("18349271429,Rxx123456")
    @Parameters({"username","password"})
	@Test
	public void case1(String username,String password) {
		logger.debug("开始执行case");
		Loginhandle.SendEmail(username);
		Loginhandle.SendPassword(password);
		//Loginhandle.ClickSevenBox();
		Loginhandle.ClickLogin();
		String userinfo=Loginhandle.GetUserText();
		Assert.assertEquals(userinfo, "慕神7358689");
	}

}
