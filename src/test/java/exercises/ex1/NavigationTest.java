package exercises.ex1;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.StringUtility;

public class NavigationTest {

    public static void main(String[] args) throws InterruptedException {
        runBrowser("chrome");
        Thread.sleep(2000);
        runBrowser("edge");
        Thread.sleep(2000);



}

    public static void runBrowser(String name){
        WebDriver driver = BrowserFactory.getDriver(name);
        driver.get("https://google.com");
        String firstURL = driver.getTitle();
        driver.get("https://etsy.com");
        String secondURL = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(firstURL,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(secondURL,driver.getTitle());
        driver.quit();




    }

}
