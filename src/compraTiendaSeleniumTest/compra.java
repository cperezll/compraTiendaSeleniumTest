package compraTiendaSeleniumTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class compra {
	private static WebDriver driver= null;
	WebElement element;
	
	@Before
	public void beforeTest(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cperezll\\Selenium Files\\chromedriver.exe");//	

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void afterTest(){
		driver.quit();
	}
	
	@Test
	public void test() {
		driver.get("https://www.youtube.com/watch?v=lZHyGdYwynM");
	}
}
