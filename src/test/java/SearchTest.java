import java.util.List;

import org.openqa.selenium.devtools.v117.domstorage.model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Pages.HomePage;
import Pages.LauncherPage;

public class SearchTest {

	
	@Test
	public void verifyIfSearchTermShowsRelevantResults() {

		//Arrange
		  String searchItem = "Jeans";
		  String searchKey = "Jean";
		  LauncherPage launcherPage = new LauncherPage(webdriver); // Assume webdriver is created and handy
		  launcherPage.navigateTo("https://web-playground.ultralesson.com/");

		  //Act
		  HomePage homepage = new HomePage(webdriver);
		  homepage.search(searchItem);
		  List<Item> searchItems = homepage.getSearchItems();

		  //Assert
		  Assert.assertEquals(4, searchItems.size());
		  Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));

	}
	
}
