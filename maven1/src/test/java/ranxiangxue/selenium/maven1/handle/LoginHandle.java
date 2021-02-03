package ranxiangxue.selenium.maven1.handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ranxiangxue.selenium.maven1.page.LoginPage;

public class LoginHandle extends BaseHandle{
	public LoginPage loginpage;
	public Logger logger = Logger.getLogger(LoginHandle.class);
	
	public  LoginHandle(WebDriver driver) {
		super(driver);
		loginpage=new LoginPage(driver);
	}
	public void SendEmail(String email) {
		logger.debug("你输入的email:"+email);
		loginpage.GetEmailElement().sendKeys(email);
	}
	public void SendPassword(String password) {
		logger.debug("你输入的password:"+password);
		loginpage.GetPasswordElement().sendKeys(password);
	}
	public void ClickSevenBox() {
		logger.debug("你开始点击SevenBox");
		ClickElement(loginpage.GetSevenElement());
	}
	public void ClickLogin() {
		logger.debug("你开始点击登录按钮");
		ClickElement(loginpage.GetLoginButtonElement());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String GetUserText() {
		loginpage.MoveToElement(loginpage.GetUserPngElement());
		String username =loginpage.GetUserInfoElement().getText();
		return username;
		
	}

}
