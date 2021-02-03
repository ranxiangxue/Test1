package ranxiangxue.selenium.maven1;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LoginCookile {
	public WebDriver driver;
	int i=0;
	String Value="k3ZWIxYTMzZDZiNTk5YTRiNzg5MTc1MDI2YTY2MTUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOTU4MDIzNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAxNDc1NDYwMzEwQHFxLmNvbQAAAAAAAAAAAAAAAAAAADEwNjQ0Mjc0NzIwMWQ4YzRmZWNjMTUyM2Q4OWIyYmJlPQkEYB6Q4F8%3DNT";
	public  LoginCookile(WebDriver driver) {
		this.driver=driver;
	}
	public void Login() {
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
