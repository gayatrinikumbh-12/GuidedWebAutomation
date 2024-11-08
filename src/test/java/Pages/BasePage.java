package Pages;

import org.openqa.selenium.WebDriver;

abstract  public class BasePage {

	 protected PageWaits waits;
	 protected PageActions PageActions;
	    protected WebDriver webDriver;
	   // String url = "https://web-playground.ultralesson.com/";
	    public BasePage(WebDriver webDriver) {
	        this.webDriver = webDriver;
	        this.waits = new PageWaits(webDriver);
	        this.PageActions= new PageActions(webDriver);
	    }
	    
	    
}
