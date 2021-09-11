package homewroks.check_box;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class checkBox {



    @Test
    public void testCase1()   {
        WebDriver driver = BrowserFactory.getDriver("edge");

        driver.manage().window().maximize();

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        Assert.assertFalse(driver.findElement(By.id("txtAge")).isDisplayed());

        driver.findElement(By.id("isAgeSelected")).click();

        Assert.assertTrue(driver.findElement(By.id("isAgeSelected")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("txtAge")).isDisplayed());

        driver.quit();

    }

    @Test
    public void testCase2(){
        WebDriver driver = BrowserFactory.getDriver("edge");

        driver.manage().window().maximize();

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement button = driver.findElement(By.id("check1"));
        Assert.assertEquals(button.getAttribute("value"),"Check All");
        button.click();
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Option 1']/input")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Option 2']/input")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Option 3']/input")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Option 4']/input")).isSelected());

        Assert.assertEquals(button.getAttribute("value"),"Uncheck All");

        driver.quit();


    }


}
