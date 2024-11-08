package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LauncherPage extends BasePage  {

	// private WebDriver webDriver;

	    public LauncherPage(WebDriver webDriver) {
	    	 super(webDriver);
	    }


	    public boolean navigateTo(String url) {
	        webDriver.get(url);
	        return isSiteLoaded();
	    }
	    
	    public boolean isSiteLoaded() {
	    	 WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
	    	    return wait.until(new ExpectedCondition<Boolean>() {
	    	        @Override
	    	        public Boolean apply(WebDriver driver) {
	    	            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");  

	    	        }
	    	    });
	    }
}
