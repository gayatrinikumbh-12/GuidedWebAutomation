import java.util.List;
import Pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Pages.Item;
import Pages.LauncherPage;
import drivers.DriverCreator;

public class SearchTest {
	public String browser = "chrome";
	@Test
	public void verifyIfSearchTermShowsRelevantResults() throws InterruptedException {

		// Arrange
		String searchItem = "Jeans";
		String searchKey = "Jean";
		
		WebDriver webDriver = new DriverCreator().getFactory(browser);
		LauncherPage launcherPage = new LauncherPage(webDriver); // Assume webdriver is created and handy
		launcherPage.navigateTo("https://web-playground.ultralesson.com/");

		// Act
		HomePage homepage = new HomePage(webDriver);
		homepage.search(searchItem);
		
		Thread.sleep(5000);
		List<Item> searchItems = homepage.getSearchItems();
		System.out.println("searchItems"+searchItems);
		// Assert
		Assert.assertEquals(4, searchItems.size());
		boolean allItemsContainSearchKey = true;
		for (Item item : searchItems) {
		  if (!item.getName().contains(searchKey)) {
		    allItemsContainSearchKey = false;
		    break;
		  }
		}
		assert allItemsContainSearchKey : "Not all items contain the search key: " + searchKey;
		//Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));

	}

	@Test
	public void verifySearchUnavailableProduct() {
		// Arrange
		String unavailableProduct = "Unobtainium Widget";
		WebDriver webDriver = new DriverCreator().getFactory(browser);
		LauncherPage launcherPage = new LauncherPage(webDriver);
		launcherPage.navigateTo("https://web-playground.ultralesson.com/");

		// Act
		HomePage homepage = new HomePage(webDriver);
		homepage.search(unavailableProduct);
		List<Item> searchItems = homepage.getSearchItems();

		// Assert
		Assert.assertTrue(searchItems.isEmpty());
	}

	@Test
	public void verifyBrandSearchListsOnlyBrandItems() {
		// Arrange
		String brandName = "Nike";
		WebDriver webDriver = new DriverCreator().getFactory(browser);;
		LauncherPage launcherPage = new LauncherPage(webDriver);
		launcherPage.navigateTo("https://web-playground.ultralesson.com/");

		// Act
		HomePage homepage = new HomePage(webDriver);
		homepage.search(brandName);
		List<Item> searchItems = homepage.getSearchItems();

		// Assert
		// Assert.assertTrue(searchItems.stream().allMatch(item - >
		// item.getName().contains(brandName)));
		boolean allItemsHaveBrand = true;

		// Loop through each item in the searchItems list
		for (Item item : searchItems) {
			// Check if the item's name contains the brand name
			if (!item.getName().contains(brandName)) {
				allItemsHaveBrand = false;
				break; // Exit the loop if a mismatch is found
			}
		}

		// Assert the condition based on the loop result
		assert allItemsHaveBrand : "Not all items have the brand name: " + brandName;
	}

	@Test
	public void verifySearchResultCountMatchesDisplayedItems() {
		// Arrange
		String searchItem = "Shoes";
		WebDriver webDriver = new DriverCreator().getFactory(browser);
		LauncherPage launcherPage = new LauncherPage(webDriver);
		launcherPage.navigateTo("https://web-playground.ultralesson.com/");

		// Act
		HomePage homepage = new HomePage(webDriver);
		homepage.search(searchItem);
		List<Item> searchItems = homepage.getSearchItems();
		//int itemCountDisplayed = homepage.getItemCount();

		// Assume
		// getItemCount method returns the number displayed on the page

		// Assert
		//Assert.assertEquals(searchItems.size(), countItemsInResults);
	}

}
