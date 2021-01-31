package ranxiangxue.selenium.maven1.handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ranxiangxue.selenium.maven1.page.BasePage;

public class BaseHandle {
	public BasePage basePage;
	public Logger logger = Logger.getLogger(BaseHandle.class);
	public WebDriver driver;
	public  BaseHandle(WebDriver driver) {
		this.driver=driver;
		basePage=new BasePage(driver);
	}
	
	/* 植入cookie */
	public void SetUserCookie() {
		String Value="k3ZWIxYTMzZDZiNTk5YTRiNzg5MTc1MDI2YTY2MTUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOTU4MDIzNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAxNDc1NDYwMzEwQHFxLmNvbQAAAAAAAAAAAAAAAAAAADEwNjQ0Mjc0NzIwMWQ4YzRmZWNjMTUyM2Q4OWIyYmJlPQkEYB6Q4F8%3DNT";
		Cookie cookie=new Cookie("apsid",Value,".imooc.com","/",null);
		driver.manage().addCookie(cookie);
		driver.navigate().refresh();
	}
	
	/* 获取title */
	public String GetCourseTitle() {
		return driver.getTitle();
	}

	/* 点击Element */
	public void ClickElement(WebElement element) {
		element.click();
	}

}
