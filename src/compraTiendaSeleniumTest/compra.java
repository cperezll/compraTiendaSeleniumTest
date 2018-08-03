package compraTiendaSeleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import compraTiendaSeleniumTest.Piezas;

public class compra {
	
	private static WebDriver driver= null;
	
	WebElement element;
	WebElement tagName;
	WebElement insertarVehiculo;
	WebElement test;
	WebElement txtBusquedaProducto;
	
	
	private String expectedTitle="Sus garantias";
	private String baseUrl = "https:info.oscaro.es/Warranty.html";
	private	String tagPhone;
	private String miVehiculo="5469 BVP";
	String actualTitle;
	
	protected Integer presupuestoMaximoCompra = 1000; //1000€
	
	@Before
	public void beforeTest(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cperezll\\Selenium Files\\chromedriver.exe");//	

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void afterTest(){
		driver.quit();
		driver.close();
	}
	
	@Test
	public void test() {
		//Obtención de la url que conectaremos
		driver.get(baseUrl);
		
		//Obtención titulo pagina URL
		actualTitle = driver.getTitle();
		
		//Condición cierre navegador
		if (!actualTitle.contentEquals(expectedTitle)) {
			driver.close();
		}else {
			tagName=driver.findElement(By.cssSelector("a[href*='www.oscaro.es/Home/ResetVehicle']"));
			tagName.click();
			
			tagPhone=driver.findElement(By.className("phone-number")).getText(); 
			driver.findElement(By.cssSelector("h3[id*='btnTab2']")).click();
			test=driver.findElement(By.cssSelector("h3[id*='btnTab2']"));
			test.click();
			
			//Introducimos el vehiculo que tenemos
			insertarVehiculo = driver.findElement(By.xpath("//div/div/form/p/input[1]"));
			insertarVehiculo.sendKeys(miVehiculo);
			driver.findElement(By.xpath("//*[@id=\"carselector\"]/div/div[1]/div[2]/form[1]/p/input[2]")).click();
			
			//Modelo vehiculo
			Select opcionModeloCoche = new Select(driver.findElement(By.xpath("//div/div/form[2]/p/select")));
			opcionModeloCoche.selectByValue("1");
			driver.findElement(By.xpath("//form[1]/p/input[2]")).click();
			
			//Eliminacón de cookis
			driver.findElement(By.id("cookie-block-btn")).click();
						
			
			System.out.println(test);
			System.out.println(tagPhone);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
			
			//Selecionamos un menu aleatorio (Mantenimiento)
			driver.findElement(By.cssSelector("a[href*='llave-dinamometrica'")).click();
			
			if (driver.getCurrentUrl().contentEquals("https://www.oscaro.es/llave-dinamometrica-10196-gu")) {
				System.out.println("Correcta url :" + driver.getCurrentUrl());
				//List<WebElements> fg= driver.findElements(By.cssSelector("label[for*=osc"));
			}
			
			String productoBusquedaCaracteres = "KSTOOLS";
			
			txtBusquedaProducto= driver.findElement(By.xpath(".//input[@name=\"q\"]"));
			
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
			.moveToElement(txtBusquedaProducto)
			.click()
			.keyDown(txtBusquedaProducto, Keys.SHIFT)
			.sendKeys(txtBusquedaProducto,productoBusquedaCaracteres)
			.keyUp(txtBusquedaProducto,Keys.SHIFT)
			.doubleClick(txtBusquedaProducto)
			.build();
			
			seriesOfActions.perform();
			
			driver.findElement(By.xpath("*[@id=\"results-autocomplete\"]/li/a")).click();
			//driver.findElement(By.cssSelector("//input[@name='compatible-with-24085-' and @type='radio']")).click();	
			driver.findElement(By.cssSelector("label[for*='restrict-compatible-with-vehicle']")).click();
			
			//List<WebElement> li = driver.findElements(By.className("thumbnails"));
			
			//System.out.println(li.size());
			
			
			while(true) {	}			
		}
	}
}