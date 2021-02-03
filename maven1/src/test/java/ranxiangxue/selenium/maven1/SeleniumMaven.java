package ranxiangxue.selenium.maven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import ranxiangxue.selenium.maven1.until.ProUntil;

public class SeleniumMaven {
	
	
	public WebDriver driver;
	public void InitDriver(String url){
		/**
		 *初始化driver
		 * */
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get(url);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.close();
	}
	public WebElement GetElement(String key) {
		WebElement element=driver.findElement(this.GetByLocal(key));
		return element;
	}
	public By GetByLocal(String key) {
		ProUntil proUntil =new ProUntil("element.properties");//有参数的初始化
		String loadString=proUntil.GetPro(key);
		String loadByString=loadString.split(">")[0];
		String loadValuesString=loadString.split(">")[1];
		if (loadByString.equals("id")) {
			return By.id(loadValuesString);
		}else if (loadByString.equals("name")) {
			return By.name(loadValuesString);
		}else if (loadByString.equals("className")) {
			return By.className(loadValuesString);
		}else {
			return By.xpath(loadValuesString);
		}
		
	}
	
	
	@Test
	public void UserLogin() {
		
		ProUntil proUntil =new ProUntil("user.properties");//有参数的初始化
		for (int i = 0; i < proUntil.GetLines(); i++) {
			InitDriver("https://www.imooc.com/user/newlogin");
			String loadString=proUntil.GetPro("user"+i);
			String UserNameString=loadString.split(">")[0];
			String PassWordString=loadString.split(">")[1];
			
			//WebElement UserElement=driver.findElement(By.name(UserString));
			//WebElement UserElement=driver.findElement(GetByLocal(UserGetByString, UserString));
			WebElement UserElement=GetElement("User");
			WebElement PassWordElement=GetElement("Pass");
			WebElement LoginButtonElement=GetElement("LoginButton");
			
			UserElement.sendKeys(UserNameString);
			PassWordElement.sendKeys(PassWordString);
			LoginButtonElement.click();//点击登录
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Actions Mouse =new Actions(driver);
				String Name="慕神7358689";
				WebElement moveToElement=GetElement("HeadPng");
				Mouse.moveToElement(moveToElement).perform();
				String userName=GetElement("userName").getText();
				//System.out.println(userName);
				if (userName.equals(Name)) {
					System.out.println("登录成功");
				}else {
					System.out.println("登录用户名不匹配"+userName);
				}			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("登录失败");
			}
			driver.close();
		}		
	}



	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * SeleniumMaven SeleniumMaven =new SeleniumMaven(); SeleniumMaven.UserLogin();
	 * 
	 * }
	 */
}
