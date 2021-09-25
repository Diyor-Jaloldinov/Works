package homewroks.eu2_homework;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class sixToEighth {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }

    @Test
    public void test6()  {
        driver.get("https://www.fakemail.net/");
        String email = driver.findElement(By.className("animace")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.name("full_name")).sendKeys("John Doe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.className("radius")).click();
        String actualSubheader = "Thank you for signing up. Click the button below to return to the home page.";
        String expectedSubheader = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actualSubheader,expectedSubheader,"Verify confirmation message");
        driver.get("https://www.fakemail.net/");
        String actualEmail = "do-not-reply@practice.cybertekschool.com";
        String actualSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String expectedEmail = driver.findElement(By.xpath("//tr[@data-href='2']//td")).getText().replace(" ","");
        String expectedSubject = driver.findElement(By.xpath("//tr[@data-href='2']//td[2]")).getText();
        Assert.assertEquals(actualEmail,expectedEmail,"Verify email");
        Assert.assertEquals(actualSubject,expectedSubject,"Verify email's subject");


    }

    @Test
    public void test7(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/upload']")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\azizl\\Desktop\\Java\\flipgrid stuff\\arrayVSarraylist.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualSubject = "File Uploaded!";
        String actualFileName = "arrayVSarraylist.txt";
        String expectedSubject = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(actualSubject,expectedSubject,"Verify that subject is uploaded");
        String expectedFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expectedFileName,"Verify that uploaded file name is displayed");

    }

    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        String actualMessage = "You selected: United States of America";
        String expectedMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that message is displayed");

    }

}
