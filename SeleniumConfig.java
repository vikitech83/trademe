import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

public class SeleniumConfig {
    public static WebDriver driver;
    public static String actualString;

    @BeforeClass
    public static void OpenBrowser (){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://www.tmsandbox.co.nz/");

        driver.findElement(By.id("SearchType")).click();
        Select category = new Select(driver.findElement(By.id("SearchType")));
        category.selectByValue("1"); //Cars, bikes & boats have category value '1'


        driver.findElement(By.className("btn-trademe")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.landing-header.motors-heading")));


        driver.findElement(By.partialLinkText("more")).click();
        driver.findElement(By.id("ListingsTitle_MotorsListingTypeControl_All_on")).click();

        String allListings = driver.findElement(By.id("ListView_listingTableHeader_headerColumnListViewText")).getText();
        String str_count = allListings.split(" ")[0];
        int count = Integer.parseInt(str_count);
        System.out.println(count);

        driver.findElement(By.xpath("//*[@id='ListViewList']/li[2]/div[1]/div")).click();
        WebElement carattributes = driver.findElement(By.cssSelector("#AttributesDisplay_attributesSection > ul"));
        List<WebElement> car = carattributes.findElements(By.tagName("li"));
        for (WebElement li : car){
            actualString = actualString + li.getText();

        }

        }

    @Test
    public void verifyNamePlate() {
        String expectedNumberplate = "Number plate";
        Assert.assertTrue(actualString.contains(expectedNumberplate));
    }
    @Test
    public void verifyKms() {
        String expectedKM = "Kilometres";
        Assert.assertTrue(actualString.contains(expectedKM));
    }
    @Test
    public void verifyBody() {
        String expectedBody = "Body";
        Assert.assertTrue(actualString.contains(expectedBody));
    }
    @Test
    public void verifySeats() {
        String expectedSeats = "Seats";
        Assert.assertTrue(actualString.contains(expectedSeats));
    }
    


}

