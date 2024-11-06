package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LauncherPage {

	 private WebDriver webDriver;

	    public LauncherPage(WebDriver webDriver) {
	        this.webDriver = webDriver;
	    }


	    public boolean navigateTo(String url) {
	        webDriver.get(url);
	        return isSiteLoaded();
	    }
	    
	    public boolean isSiteLoaded() {
	        return new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(
	                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	    }
}
