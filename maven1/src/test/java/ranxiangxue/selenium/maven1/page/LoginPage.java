package ranxiangxue.selenium.maven1.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public WebElement GetEmailElement() {
		return GetElement("User");
	}
	public WebElement GetPasswordElement() {
		return GetElement("Pass");
	}
	public WebElement GetSevenElement() {
		return GetElement("seven");
	}
	public WebElement GetLoginButtonElement() {
		return GetElement("LoginButton");
	}
	public WebElement GetUserPngElement() {
		return GetElement("HeadPng");
	}
	public WebElement GetUserInfoElement() {
		return GetElement("userinfo");
	}
	

}
