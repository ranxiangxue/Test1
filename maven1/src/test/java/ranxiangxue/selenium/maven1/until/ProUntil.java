package ranxiangxue.selenium.maven1.until;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProUntil {
	
	
	Properties Pro;//全局变量
	public ProUntil(String FilePath) {
		/**
		 * 构造方法
		 * 构造方法是初始化对象的重要途径，
		 * 如:student s=new student();   
		 * s这个实例，是通过构造方法初始化的　　
		 * 构造方法：可创建一个对象，并可初始化对象的值
		 * */
		Pro=ReadProperties(FilePath);
	}
	private Properties ReadProperties(String FilePath) {
		Properties properties=new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(FilePath);
			BufferedInputStream bufferedInputStream =new BufferedInputStream(fileInputStream);
			properties.load(bufferedInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	public String GetPro(String key) {
		String UserString;
		if (Pro.containsKey(key)) {//判断Pro里面是否有对应的key值
			UserString = Pro.getProperty(key);
			return UserString;
		}else {
			return "Error";
		}
		
	}
	public int GetLines() {
		return Pro.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProUntil proUntil =new ProUntil("element.properties");//有参数的初始化
	    System.out.println(proUntil.GetPro("User"));

	}

}
