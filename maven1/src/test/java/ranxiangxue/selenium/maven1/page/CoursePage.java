package ranxiangxue.selenium.maven1.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage extends BasePage {

	public CoursePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*添加购物车按钮 */
	public WebElement GetAddCartElement() {
		return GetElement("add_cart");		
	}

	/* 购物车商品数量 */
	public WebElement GetCartNumElement() {
		return GetElement("cart_num");		
	}

	/* 立即购买按钮 */
	public WebElement GetBuyElement() {
		return GetElement("buynow");		
	}
	
	/*右上角购物车按钮 */
	public WebElement GetCartElement() {
		return GetElement("cart");		
	}
	
	/*继续逛逛按钮 */
	public WebElement GetBtnCloseElement() {
		return GetElement("btn-close");		
	}
	
	/*去购物车结算按钮 */
	public WebElement GetBtnGoElement() {
		return GetElement("btn-go");		
	}
	
	
	/* 登录状态信息 */
	public boolean GetUserIsLogin() {
		return GetCookie("apsid");
	}

}
