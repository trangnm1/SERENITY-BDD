package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriver getDriver () {
        return this.driver;
    }

    public void openBrowser(){
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\trann\\Documents\\AutoTest\\AutoTool\\chromedriver-win64\\chromedriver.exe");
       // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.get("https://demowebshop.tricentis.com/");
        driver.get("https://tenderfyfe.vercel.app/");
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
