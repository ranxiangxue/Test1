package ranxiangxue.selenium.maven1.handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ranxiangxue.selenium.maven1.page.CoursePage;

public class CourseHandle extends BaseHandle{
	public CoursePage coursePage;
	public Logger logger = Logger.getLogger(CourseHandle.class);
	public  CourseHandle(WebDriver driver) {
		super(driver);
		coursePage=new CoursePage(driver);
	}
	
	/* 点击添加购物车 */
	public void ClickAddCart() {
		ClickElement(coursePage.GetAddCartElement());
	}
	
	/* 点击立即购买 */
	public void ClickBuyNow() {
		ClickElement(coursePage.GetBuyElement());
	}
	
	/* 点击继续逛逛 */
	public void ClickBtnClose() {
		ClickElement(coursePage.GetBtnCloseElement());
	}
	
	/* 点击去购物车结算 */
	public void ClickBtnGo() {
		ClickElement(coursePage.GetBtnGoElement());
	}
	
	/* 点击右上角购物车 */
	public void ClickCart() {
		ClickElement(coursePage.GetCartElement());
	}
	
	/* 获取购物车商品数量 */
	public int GetCartNum() {
		int CartNum;
		try {
			CartNum=Integer.parseInt(coursePage.GetCartNumElement().getText());
		} catch (Exception e) {
			CartNum=0;
		}
		return CartNum;	
	}
	
	/* 返回登录状态 */
	public boolean UserIsLogin() {
		return coursePage.GetUserIsLogin();
	}
	
}
