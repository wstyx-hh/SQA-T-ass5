package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utils.LoggerUtil;
import utils.ScreenshotUtil;

import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger;

    @BeforeMethod
    public void setup() {
        logger = LoggerUtil.getLogger(this.getClass());
        logger.info("===== TEST STARTED =====");

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            logger.error("TEST FAILED: " + result.getName());

            ScreenshotUtil.takeScreenshot(driver, result.getName());
        } else {
            logger.info("TEST PASSED: " + result.getName());
        }

        driver.quit();
        logger.info("===== TEST FINISHED =====");
    }
}
