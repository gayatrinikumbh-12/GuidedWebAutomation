

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LauncherPage;
import drivers.DriverCreator;

public class BuyAProductTests {
    WebDriver driver;
    public String browser = "chrome";
    @Test
    public void buyProduct() {
        // Step 1: Navigate to Home Page
       // driver.get("https://web-playground.ultralesson.com");
        
        WebDriver webDriver = new DriverCreator().getFactory(browser);
		LauncherPage launcherPage = new LauncherPage(webDriver); // Assume webdriver is created and handy
		launcherPage.navigateTo("https://web-playground.ultralesson.com/");
        
        // Step 2: Log in
        driver.findElement(By.id("loginButton")).click();
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("submitLogin")).click();
        Assert.assertTrue(driver.findElement(By.id("accountSection")).isDisplayed(), "User is logged in");

        // Step 3: Search for Product
        driver.findElement(By.id("searchBar")).sendKeys("Product Name");
        driver.findElement(By.id("searchButton")).click();

        // Step 4: Select Product
        driver.findElement(By.xpath("//a[contains(text(),'Product Name')]")).click();
        Assert.assertTrue(driver.findElement(By.id("productDetail")).isDisplayed(), "Product detail page is displayed");

        // Step 5: Add Product to Cart
        driver.findElement(By.id("addToCart")).click();

        // Step 6: Navigate to Cart
        driver.findElement(By.id("cart")).click();
        Assert.assertTrue(driver.findElement(By.id("cartItems")).isDisplayed(), "Product is in cart");

        // Step 7: Proceed to Checkout
        driver.findElement(By.id("checkout")).click();

        // Step 8: Enter Shipping Information
        driver.findElement(By.id("shippingAddress")).sendKeys("123 Main St, City, Country");

        // Step 9: Select Payment Method
        driver.findElement(By.id("paymentMethod")).click();

        // Step 10: Place Order
        driver.findElement(By.id("placeOrder")).click();
        Assert.assertTrue(driver.findElement(By.id("orderConfirmation")).isDisplayed(), "Order confirmation page is displayed");

        // Step 11: Verify Order Confirmation
        String orderId = driver.findElement(By.id("orderId")).getText();
        Assert.assertNotNull(orderId, "Order ID is displayed");

        // Optional Step: Log Out
        driver.findElement(By.id("logout")).click();
    }
}
