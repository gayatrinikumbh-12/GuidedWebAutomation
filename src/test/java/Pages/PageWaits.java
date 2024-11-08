package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class PageWaits {

	 private WebDriver webDriver;
	 
	 private FluentWait wait;
	 
	    public PageWaits(WebDriver webDriver) {
	        this.webDriver = webDriver;
	        wait = initWait(webDriver);
	  
	    }
	    
	    private FluentWait initWait(WebDriver webDriver) {
	        return new FluentWait<>(webDriver)
	                .withTimeout(Duration.ofSeconds(30))
	                .pollingEvery(Duration.ofSeconds(5))
	                .ignoring(StaleElementReferenceException.class)
	                .ignoring(NoSuchElementException.class);
	    }
	    
	    
	    public void waitUntilAllElementsAreVisible(By by) {
	         wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	        
	    }
	    
	    public void waitForElementToBePresent(By by) {
	        wait.until(ExpectedConditions.presenceOfElementLocated(by));
	    }
	    
}