package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adidas {



    public static void buy(WebDriver driver,WebDriverWait wait,String category, String product){

        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.xpath("//a[contains(text(), '"+category+"')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), '"+product+"')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();

        Alert popup = wait.until(ExpectedConditions.alertIsPresent());
        popup.accept();
    }

    public static void delete(WebDriver driver,WebDriverWait wait,String product){
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.id("cartur")).click();
        driver.findElement(By.xpath("//td[contains(text(),'"+product+"')]/following-sibling::td[2]//a")).click();
        wait.until(ExpectedConditions
                .invisibilityOfElementWithText(By.xpath("//td[contains(text(),'"+product+"')]/following-sibling::td[2]//a"), "Delete"));

    }

    public static  String[]  placeOrder(WebDriver driver, String[][] buyerInfo){
        //navigate to cart
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.id("cartur")).click();
        driver.findElement(By.cssSelector("button[data-target*='#orderModal']")).click();
        //getting info from source and iterate through it one by one
        for (String[] strings : buyerInfo) {
            driver.findElement(By.cssSelector(strings[0])).sendKeys(strings[1]);
        }
        //click place order
        driver.findElement(By.cssSelector("button[onclick*='purchase']")).click();
        // get the info from popup and split into array
        String[] purchaseInfo = driver.findElement(By.cssSelector("p[class*='lead']")).getText().split("\n");
        return purchaseInfo;

    }

}
