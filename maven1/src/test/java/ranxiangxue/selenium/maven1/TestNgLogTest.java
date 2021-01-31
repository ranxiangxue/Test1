package ranxiangxue.selenium.maven1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNgLogTest {
	private static Logger logger = Logger.getLogger(TestNgLogTest.class);

	@Test
	public void f1() {
		logger.error("error email");
	}

	@Test
	public void f2() {
		logger.debug("email");
	}

	@BeforeClass
	public void beforeClass() {
		PropertyConfigurator.configure("log4j.properties");
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
