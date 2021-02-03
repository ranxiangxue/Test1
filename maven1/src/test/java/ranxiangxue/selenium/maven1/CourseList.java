package ranxiangxue.selenium.maven1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CourseList {
	public WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		/**
		 * 初始化driver
		 */
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://coding.imooc.com/?sort=0&unlearn=0&page=1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	/*
	 * @Test public void f1() {
	 * 
	 * String CurlHandle = driver.getWindowHandle(); List<String>
	 * StringCourse=StringCourse(); for (int i=0;i<=StringCourse.size();i++ ) {
	 * String xpath="//p[contains(text(),'"+StringCourse.get(i)+"')]";
	 * System.out.println(xpath); driver.findElement(By.xpath(xpath)).click(); try {
	 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * driver.switchTo().window(CurlHandle); //切换到点击前的窗口 //
	 * driver.navigate().back();当前窗口打开新页面的返回操作
	 * 
	 * System.out.println(StringCourse.get(i)); } }
	 */

	@Test
	public void f2() {
		List<Integer> numList = GetPageNum();
		System.out.println(numList.size());
		for (int i = 0; i < numList.size() - 1; i++) {
			String MainHandle = driver.getWindowHandle();
			List<WebElement> courselist = driver.findElements(By.className("ellipsis2"));
			for (int j = 0; j < courselist.size(); j++) {
				courselist.get(i).click();

				// 单击click之后，会打开一个新的窗口，获取所有窗口的句柄
				Set<String> allHandles = driver.getWindowHandles();

				// 对获取的所有句柄进行循环判断，把Main句柄从所有句柄中移除，剩下的就是想要获得的新窗口的句柄
				WebDriver driverNew = null;
				for (String string : allHandles) {
					if (string.equals(MainHandle)) {
						continue;
					} else {
						driverNew = driver.switchTo().window(string);
						driverNew.close();
					}
				}

				driver.switchTo().window(MainHandle);
				courselist = driver.findElements(By.className("ellipsis2"));
			}

			driver.findElement(By.partialLinkText("下一页")).click();
			System.out.println("点击第" + i + "页");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Integer> GetPageNum() {
		List<Integer> pageNumList = new ArrayList<Integer>();
		List<WebElement> aElementList = driver.findElement(By.className("page")).findElements(By.tagName("a"));
		for (WebElement aElement : aElementList) {
			String pageNum = aElement.getText();
			if (isNumber(pageNum) == true) {
				pageNumList.add(Integer.valueOf(pageNum).intValue());
			}
		}
		return pageNumList;

	}

	public boolean isNumber(String pageNum) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(pageNum);
		if (isNum.matches()) {
			return true;
		}
		return false;
	}

	public List<String> StringCourse() {
		List<String> StringCourse = new ArrayList<String>();
		List<WebElement> courselist = driver.findElements(By.className("ellipsis2"));
		for (WebElement coursename : courselist) {
			StringCourse.add(coursename.getText());
		}
		return StringCourse;
	}

}
