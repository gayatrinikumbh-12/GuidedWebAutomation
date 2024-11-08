
import org.testng.TestNG;
import java.util.List;  // Add this import
import java.util.Collections;
public class TestRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        // Set testng.xml file location
        testNG.setTestSuites(Collections.singletonList("/testng.xml"));

        // Specify the output directory
        testNG.setOutputDirectory("build/web-reports");

        // Run the TestNG tests
        testNG.run();
    }
}
