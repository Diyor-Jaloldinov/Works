package real_life_automations.adidas_web_fe;

import jdk.internal.dynalink.support.AutoDiscovery;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Adidas;
import utilities.BrowserFactory;
import java.util.Arrays;

import static java.util.concurrent.TimeUnit.SECONDS;

public class adidasWebFE {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        // waiting 2 seconds checking the progress for my self
        driver.quit();
    }

    @Test
    public void test1() {
        // Having data in array format, so we can iterate through  each product id
//        String[] product = new String[] {"8","12"};

        String[][] buyerInfo = new String[][] {{"#name","John Doe"}, {"#country","Automation"},
                {"#city","Selenium"},{"#card","Master Card"},{"#month","October"},{"#year","2021"}};

        WebDriverWait wait = new WebDriverWait(driver,2);
        //buying products using utility class
        Adidas.buy(driver,wait,"Laptops","Sony vaio i5");
        Adidas.buy(driver,wait,"Laptops","Dell i7 8gb");
        //deleting product from cart using utility class
        Adidas.delete(driver,wait,"Dell i7 8gb");
        System.out.println(Arrays.toString(Adidas.placeOrder(driver,buyerInfo)));


        //doing the task manually
        /*
        // iterating through each product id and buy by id
        for (String s : product) {
            driver.get("https://www.demoblaze.com/index.html");
            driver.findElement(By.xpath("//a[@onclick=\"byCat('notebook')\"]")).click();
            driver.findElement(By.cssSelector("a[href*='"+s+"']")).click();
            driver.findElement(By.cssSelector("a[onclick*='"+s+"']")).click();

            Alert popup = wait.until(ExpectedConditions.alertIsPresent());
            popup.accept();
        }



        //delete product from cart
        driver.findElement(By.id("cartur")).click();
        driver.findElement(By.xpath("//td[contains(text(),'Dell i7 8gb')]/following-sibling::td[2]//a")).click();
        // wait until buttons text "Delete" is invisible
        wait.until(ExpectedConditions
                .invisibilityOfElementWithText(By.xpath("//td[contains(text(),'Dell i7 8gb')]/following-sibling::td[2]//a"), "Delete"));



        //click buy and fill in the inputs with personal info
        driver.findElement(By.cssSelector("button[data-target*='#orderModal']")).click();
        //getting info from source and iterate through it one by one
        for (String[] strings : buyerInfo) {
            driver.findElement(By.cssSelector(strings[0])).sendKeys(strings[1]);
        }

         // inserting info one by one
        driver.findElement(By.cssSelector("#name")).sendKeys("John Doe");
        driver.findElement(By.cssSelector("#country")).sendKeys("Automation");
        driver.findElement(By.cssSelector("#city")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#card")).sendKeys("Master Bistro");
        driver.findElement(By.cssSelector("#month")).sendKeys("October");
        driver.findElement(By.cssSelector("#year")).sendKeys("2021");


        driver.findElement(By.cssSelector("button[onclick*='purchase']")).click();
        // get the info from popup and split into array
        String[] purchaseInfo = driver.findElement(By.cssSelector("p[class*='lead']")).getText().split("\n");
        System.out.println(Arrays.toString(purchaseInfo));
*/


    }

}
