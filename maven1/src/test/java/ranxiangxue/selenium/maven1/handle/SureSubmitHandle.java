package ranxiangxue.selenium.maven1.handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ranxiangxue.selenium.maven1.page.SureSubmitPage;

public class SureSubmitHandle extends BaseHandle{
	public SureSubmitPage sureSubmitPage;
	public Logger logger = Logger.getLogger(SureSubmitHandle.class);
	public  SureSubmitHandle(WebDriver driver) {
		super(driver);
		sureSubmitPage=new SureSubmitPage(driver);
		
	}
	public void ClickSureSubmitElement() {
		/* 点击确认订单按钮 */
		ClickElement(sureSubmitPage.GetSureSubmitElement());
	}

}
