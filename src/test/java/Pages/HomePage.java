package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage  extends BasePage {

	// WebDriver webDriver;
	    By searchIcon = By.cssSelector("summary[aria-label='Search']");
	    By searchBar = By.id("Search-In-Modal");
	    By searchResults = By.cssSelector("li[id^='predictive-search-option'] a");
	    private By displayedCount = By.cssSelector(".result-count"); // Locator for displayed count of items
	      // Scoped Element
	    By productName = By.cssSelector(".predictive-search__item-heading");

	    private By searchInput = By.name("search"); // Adjust locator based on the site
	    private By searchButton = By.cssSelector("button[type='submit']"); // Adjust as necessary
	    private By productTitles = By.cssSelector(".product-title"); // Adjust locator for product titles
	    
	    
	    public HomePage (WebDriver webDriver) {
	        super(webDriver);
	    }

	   
	    //------------
	    public HomePage search(String searchItem) {
	        PageActions.click(searchIcon);
	        PageActions.type(searchBar, searchItem);
	        return this;
	      }
	    
	    //-----------------
	    public List<Item> getSearchItems() {
	    	
	    	//waits.waitUntilAllElementsAreVisible(searchResults);
	        List<WebElement> elements = webDriver.findElements(searchResults);
	        System.out.println(elements);
	        List<Item> items = new ArrayList<>();
	        for(WebElement element : elements) {
	            String name = element.findElement(productName).getText();
	            Item item = new Item();
	            item.setName(name);
	            items.add(item);
	        }
	        return items;
	    }
	    
	   
	    
	    public void productUnavilablity(List<Item>items)
	    {
	    	if(items.size()==0)
	    	{
	    		System.out.println("Product is indeed unavailable");
	    	}
	    }
	    
	    public void searchBrand(String brandName) {
	    	waits.waitForElementToBePresent(searchInput);
	    	PageActions.type(searchInput, brandName);
	    	PageActions.click(searchButton);
	        
	        
	    }

	    public boolean verifyBrandInResults(String brandName) {
	        List<WebElement> products = webDriver.findElements(productTitles);
	        for (WebElement product : products) {
	            if (!product.getText().toLowerCase().contains(brandName.toLowerCase())) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public int countItemsInResults() {
	        List<WebElement> products = webDriver.findElements(productTitles);
	        return products.size();
	    }

	    public boolean verifyDisplayedCountMatchesActualCount() {
	        int actualCount = countItemsInResults();
	        String displayedText = webDriver.findElement(displayedCount).getText();
	        int displayedCount = Integer.parseInt(displayedText.replaceAll("[^0-9]", "")); // Remove any non-numeric characters
	        return displayedCount == actualCount;
	    }



		public int getItemCount() {
			// TODO Auto-generated method stub
			 return countItemsInResults();
			
		}
	
	
	

}
