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

public class sixToEighth {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test6(){
        driver.get("https://www.fakemail.net/");
        String email = driver.findElement(By.className("animace")).getText();
        System.out.println(email);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.name("full_name")).sendKeys("John Doe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.className("radius")).click();
        //need to check the link is corrupted ! ! !

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
