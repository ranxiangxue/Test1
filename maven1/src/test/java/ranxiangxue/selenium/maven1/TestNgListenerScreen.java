package ranxiangxue.selenium.maven1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.google.common.io.Files;

import ranxiangxue.selenium.maven1.runcase.BaseCase;

public class TestNgListenerScreen extends TestListenerAdapter {   //继承TestListenerAdapter
	public void onTestFailure(ITestResult tr) {
		
		
		/*
		 * TestNgCase testCase=new TestNgCase(); 
		 * TakeScreenShot(testCase.driver);
		 */
		
		BaseCase BaseCase= (BaseCase)tr.getInstance();
		System.out.println(tr.getInstance());
		TakeScreenShot(BaseCase.driver,BaseCase.getClass().getName());
		 
		//tr.getInstance()：对象使用之前通过getInstance得到而不需要自己定义，用完之后不需要delete；
		
		super.onTestFailure(tr);
		//super.xxx();的意义是直接访问父类中的xxx()方法并调用
	}
	public void TakeScreenShot(WebDriver driver,String curClassName) {
		//图片名字
		//图片存的路径
		//获取当前时间
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String curTime =sdf.format(new Date());
		
		//获取当前类名
		//String curClassName=getClass().getName();
		//System.out.println("curClassName-----"+curClassName);
		String pngPath=curClassName+"_"+curTime+".png";
		
		//项目路径
		String curPath=System.getProperty("user.dir");
		File scrFile=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile, new File(curPath+"\\"+pngPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
