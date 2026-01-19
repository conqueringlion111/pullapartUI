package com.pullapart.test;

import com.pullapart.pages.HomePage;
import com.pullapart.utils.JsonReader;
import com.pullapart.utils.WebDriverSetUp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestBase {
    protected WebDriver driver;
    protected HomePage homepage;
    protected static Properties testConfig;
    protected String baseUrl;
    protected String email;
    protected String password;
    protected String myPassword;

    @BeforeSuite(alwaysRun = true)
    public void beforSuite() throws IOException {
        testConfig = new Properties();
        InputStream input = TestBase.class.getClassLoader().getResourceAsStream("testconfig.properties");
        testConfig.load(input);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserRemote"})
    public void beforeMethod(@Optional String browserRemote) {
        driver = WebDriverSetUp.createDriver(testConfig.getProperty("browser"), testConfig.getProperty("runFromSuite"), browserRemote);
        if(System.getProperty("test.env") != null) {
            baseUrl = System.getProperty("test.env");
        }
        else {
            baseUrl = testConfig.getProperty("baseUrl");
        }
        if(System.getProperty("email") != null) {
            email = System.getProperty("email");
        }
        else {
            email = testConfig.getProperty("email");
        }
        if(System.getProperty("password") != null) {
            password = System.getProperty("password");
        }
        else {
            password = testConfig.getProperty("password");
        }
        if(System.getProperty("myPassword") != null) {
            myPassword = System.getProperty("myPassword");
        }
        else {
            myPassword = testConfig.getProperty("myPassword");
        }
        driver.manage().window().maximize();
        driver.get(baseUrl);
        homepage = new HomePage(driver);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] passData(Method method) throws Exception {
        String className = this.getClass().getSimpleName();
        String filePath = "src/main/java/com/pullapart/dataprovider/" + className + ".json";
        return JsonReader.getData(filePath, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File srs = screenshot.getScreenshotAs(OutputType.FILE);
                String osName = System.getProperty("os.name");
                System.out.println(System.getProperty("os.name"));
                if (osName.contains("Windows")) {
                    FileUtils.copyFile(srs, new File(".\\printscreen\\failureprintscreen" + result.getName() + ".png"));
                } else {
                    FileUtils.copyFile(srs, new File("printscreen/failureprintscreen" + result.getName() + ".png"));
                }
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
            // call method to make post call to test rail api to send test failed status
        } else {
            // call method to make post call to test rail api to send test passed status
        }
        WebDriverSetUp.quitDriver(driver);
    }

}
