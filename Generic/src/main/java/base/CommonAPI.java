package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonAPI {

   public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
       System.setProperty("webdriver.chrome.driver","C:\\Users\\Omar Al-Faruque\\IdeaProjects\\SeleniumApril2020\\Generic\\Driver\\chromedriver81.exe");
       driver = new ChromeDriver();
       driver.get("https://learn.letskodeit.com/p/practice");
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       driver.manage().deleteAllCookies();
    }
    public void takeScreenShot() throws IOException {
        //TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot");
        FileUtils.copyFile(srcFile,destFile);
    }
    @AfterMethod
    public void tearDown() throws IOException {
        takeScreenShot();
        driver.quit();
    }
}
