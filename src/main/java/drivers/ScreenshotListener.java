package drivers;

public class ScreenshotListener implements ITestListener {

    // Rest of the listener methods...

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = ((TakesScreenshot)BaseTest.driver.get()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("test-output/screenshots/" + result.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}