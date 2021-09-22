package homewroks.eu2_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.List;

public class oneToFive {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("edge");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String actualMessage = "The date of birth is not valid";
        String expectedMessage = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that warning message is displayed");


    }

    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        List<WebElement> elements = driver.findElements(By.className("form-check-input"));
        Assert.assertEquals(3,elements.size(),"Verify that we get 3 Web Elements");
        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }

    }

    @Test
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("A");
        String actualMessage = "first name must be more than 2 and less than 64 characters long";
        String expectedMessage = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that warning message is displayed");
    }

    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("A");
        String actualMessage = "The last name must be more than 2 and less than 64 characters long";
        String expectedMessage = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that warning message is displayed");

    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("johnDoe");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("john.doe@gmali.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("johnDoe123");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("571-000-0000");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("11/08/1997");
        WebElement elementOffice = driver.findElement(By.xpath("//select[@name='department']"));
        Select depOffice = new Select(elementOffice);
        depOffice.selectByIndex(1);

        WebElement elementJob = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select jobTitle = new Select(elementJob);
        jobTitle.selectByIndex(5);

        driver.findElement(By.xpath("//input[@value='java']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();

        String actualMessage = "You've successfully completed registration!";
        String expectedMessage = driver.findElement(By.xpath("//p")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that success message is displayed");


    }



}
