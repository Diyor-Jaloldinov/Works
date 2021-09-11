package homewroks.check_box;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class checkBox {


    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = BrowserFactory.getDriver("edge");

        driver.manage().window().maximize();
    }

    @Test
    public void testCase1()   {


        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        Assert.assertFalse(driver.findElement(By.id("txtAge")).isDisplayed());

        driver.findElement(By.id("isAgeSelected")).click();

        Assert.assertTrue(driver.findElement(By.id("isAgeSelected")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("txtAge")).isDisplayed());



    }

    @Test
    public void testCase2(){


        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement button = driver.findElement(By.id("check1"));
        Assert.assertEquals(button.getAttribute("value"),"Check All");
        button.click();

        for (int i =1;i<=4;i++){
            Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Option "+i+"']/input")).isSelected());
        }



        Assert.assertEquals(button.getAttribute("value"),"Uncheck All");




    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
