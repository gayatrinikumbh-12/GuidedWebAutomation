package drivers;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverCreator {
	
	//String browserType = "firefox";
	
	WebDriver driver;
	
	 public  WebDriver getFactory(String browser) {
	     
		String browserType = setDefaultBrowser(browser);
		 
		 switch (browserType) {
	            case "chrome":
	                return new ChromeDriver();
	            case "firefox":
	                return new FirefoxDriver();
	            case "Edge":
	                return new EdgeDriver(); 
	            case "HEADLESS":
	            	 //if(Toggles.HEADLESS.isOn()) {
	            	        return createHeadlessChromeDriver();
	            	   // }
	            default:
	                throw new IllegalArgumentException("Invalid browser type: " + browserType);
	        }
	    }
	 
	 
	 private String setDefaultBrowser(String browser) {
	        if(Objects.isNull(browser) || browser.isEmpty()) {
	           // browser = "chrome";
	        }
	        return browser;
	    }
	 
	   private ChromeDriver createHeadlessChromeDriver() {
	        new io.github.bonigarcia.wdm.managers.ChromeDriverManager().setup();
	        ChromeOptions chromeOptions = getHeadlessChromeOptions();
	        return new ChromeDriver(chromeOptions);
	    }
	   
	   private ChromeOptions getHeadlessChromeOptions() {
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--no-sandbox");
	        chromeOptions.addArguments("--headless");
	        chromeOptions.addArguments("disable-gpu");
	        return chromeOptions;
	  }
	
}
