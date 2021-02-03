package ranxiangxue.selenium.maven1.page;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ranxiangxue.selenium.maven1.until.ProUntil;

public class BasePage {
	public Logger logger = Logger.getLogger(BasePage.class);
	public WebDriver driver;
	
	public  BasePage(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement GetElement(String key) {
		for (int i = 0; i <=10; i++) {
			try {
				WebElement element = driver.findElement(this.GetByLocal(key));
				return element;
			} catch (Exception e) {
				logger.debug(i+"次查找元素失败");
			}
		}
		return null;
		
	}
	public By GetByLocal(String key) {
		ProUntil proUntil = new ProUntil("element.properties");// 拿取element配置信息
		logger.debug("你的定位信息为："+key);
		String loadString = proUntil.GetPro(key);
		String loadByString = loadString.split(">")[0];
		String loadValuesString = loadString.split(">")[1];
		logger.debug("你的定位方式为："+loadByString);
		logger.debug("你的定位值为："+loadValuesString);
		if (loadByString.equals("id")) {
			return By.id(loadValuesString);
		} else if (loadByString.equals("name")) {
			return By.name(loadValuesString);
		} else if (loadByString.equals("className")) {
			return By.className(loadValuesString);
		} else {
			return By.xpath(loadValuesString);
		}
	}
	public void MoveToElement(WebElement key) {
		Actions Mouse = new Actions(driver);
		Mouse.moveToElement(key).perform();
	}
	
	public boolean GetCookie(String key) {
		boolean flag=false;
		Set<Cookie> Cookies=driver.manage().getCookies();
		for (Cookie cookie : Cookies) {
			if (cookie.equals(key)) {
				flag=true;
			}
		}
		return flag;
	}

}
