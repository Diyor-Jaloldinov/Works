package real_life_automations.adidas_web_fe;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;


import static java.util.concurrent.TimeUnit.SECONDS;

public class adidasWebFE {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        // waiting 2 seconds checking the progress for my self
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        // Having data in array format, so we can iterate through  each product id
        String[] product = new String[] {"8","12"};
        // iterating through each product id and buy by id
        for (String s : product) {
            driver.get("https://www.demoblaze.com/index.html");
            driver.findElement(By.xpath("//a[@onclick=\"byCat('notebook')\"]")).click();
            driver.findElement(By.cssSelector("a[href*='"+s+"']")).click();
            driver.findElement(By.cssSelector("a[onclick*='"+s+"']")).click();
            WebDriverWait wait = new WebDriverWait(driver,2);
            Alert popup = wait.until(ExpectedConditions.alertIsPresent());
            popup.accept();
        }

        driver.findElement(By.id("cartur")).click();
        driver.findElement(By.xpath("//td[contains(text(),'Dell i7 8gb')]/following-sibling::td[2]//a")).click();
        // wait until button is done executing //what can be used instead of Thread.sleep ?
        Thread.sleep(1000);
        //click buy and fill in the inputs with personal info
        driver.findElement(By.cssSelector("button[data-target*='#orderModal']")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("John Doe");
        driver.findElement(By.cssSelector("#country")).sendKeys("Automation");
        driver.findElement(By.cssSelector("#city")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#card")).sendKeys("Master Bistro");
        driver.findElement(By.cssSelector("#month")).sendKeys("November");
        driver.findElement(By.cssSelector("#year")).sendKeys("2021");
        driver.findElement(By.cssSelector("button[onclick*='purchase']")).click();
        // get the info from popup and split into array
        String[] purchaseInfo = driver.findElement(By.cssSelector("p[class*='lead']")).getText().split("\n");



    }

}
