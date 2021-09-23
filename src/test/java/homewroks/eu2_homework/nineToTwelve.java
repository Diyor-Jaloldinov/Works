package homewroks.eu2_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class nineToTwelve {

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

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "//a[@href='status_codes/200']", "This page returned a 200 status code." },
                { "//a[@href='status_codes/301']", "This page returned a 301 status code." },
                { "//a[@href='status_codes/404']", "This page returned a 404 status code." },
                { "//a[@href='status_codes/500']", "This page returned a 500 status code." },
        };
    }

    @Test(dataProvider = "test1")
    public void test9to12(String path , String actualMessage){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        driver.findElement(By.xpath(path)).click();
        String[] expectedMessage = driver.findElement(By.xpath("//p")).getText().split("\n");
        Assert.assertEquals(actualMessage,expectedMessage[0],"Verify that message is displayed");
    }
}
