package homewroks.locator_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class LocatorHW {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("edge");
        testCase1(driver);
        testCase2(driver);
        testCase3(driver);
        driver.close();

    }

    public static void testCase1(WebDriver driver) throws InterruptedException {

        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//input[@autocorrect='off']")).sendKeys("nothing");
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        System.out.println(driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText());

        Thread.sleep(2000);
    }

    public static void testCase2(WebDriver driver) throws InterruptedException {
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//input[@autocorrect='off']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        System.out.println("Checking if Title contains 'selenium'.....");
        if (driver.getTitle().toLowerCase().contains("selenium")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
    }

    public static void testCase3(WebDriver driver) throws InterruptedException {
        driver.get("http://wikipedia.org/");
        driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@href='/wiki/Selenium_(software)']")).click();
        System.out.println("Cheking if url ends with 'Selenium_(software)'....");
        if (driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(2000);

    }


}
