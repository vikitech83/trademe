import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumConfig {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tmsandbox.co.nz/");

        driver.findElement(By.id("SearchType")).click();
        Select category = new Select(driver.findElement(By.id("SearchType")));
        category.selectByValue("1"); //Cars, bikes & boats have category value '1'


        driver.findElement(By.className("btn-trademe")).click();


        driver.findElement(By.cssSelector("//*[@id='ListViewList']/li[1]/div[1]/div/a/div[2]/div[1]")).click();


    }
}
