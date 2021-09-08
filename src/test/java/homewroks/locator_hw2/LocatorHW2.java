package homewroks.locator_hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class LocatorHW2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        System.out.println("Getting text of WebElements ---------");

        System.out.println(driver.findElement(By.xpath("//a[@href='/']")).getText());
        System.out.println(driver.findElement(By.xpath("//h2[.='Forgot Password']")).getText());
        System.out.println(driver.findElement(By.xpath("//label[@for='email']")).getText());
        System.out.println(driver.findElement(By.xpath("//button[@id='form_submit' and @class='radius']")).getText());

        System.out.println("Entering some dummy email to input WebElement -------");
        driver.findElement(By.xpath("//input[@name='email' and @pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$']")).sendKeys("dummy@dumail.dum");

        Thread.sleep(2000);
        driver.quit();

    }
}
