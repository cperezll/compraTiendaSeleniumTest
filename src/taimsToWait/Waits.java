package taimsToWait;

import org.openqa.selenium.WebDriver;

public class Waits {

		/**
	    * Metodo que se encarga de esperar X cantidad de segundos durante
	    * la ejecucion de la prueba utilizando el driver
	    * @param driver
	    * @param segundos
	    */
	
	   public void esperarSegundos(WebDriver driver, int segundos){
	       
	      synchronized(driver){
	         try {
	            driver.wait(segundos * 1000);
	         } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	   }
}
