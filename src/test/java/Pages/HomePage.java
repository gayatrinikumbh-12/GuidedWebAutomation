package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	 WebDriver webDriver;
	    By searchIcon = By.cssSelector("summary[aria-label='Search']");
	    By searchBar = By.id("Search-In-Modal");
	    By searchResults = By.cssSelector("li[id^='predictive-search-option'] a");

	      // Scoped Element
	    By productName = By.cssSelector(".predictive-search__item-heading");

	    public HomePage(WebDriver webDriver) {
	        this.webDriver = webDriver;
	    }

	
	    public HomePage search(String searchItem) {
	        webDriver.findElement(searchIcon).click();
	        webDriver.findElement(searchBar).sendKeys(searchItem);
	        return this;
	    }
	    
	    
	    public List<Item> getSearchItems() {
	        List<WebElement> elements = webDriver.findElements(searchResults);
	        List<Item> items = new ArrayList<>();
	        for(WebElement element : elements) {
	            String name = element.findElement(productName).getText();
	            Item item = new Item();
	            item.setName(name);
	            items.add(item);
	        }
	        return items;
	    }
	    
	    
	
	
	

}
