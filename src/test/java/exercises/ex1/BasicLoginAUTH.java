package exercises.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class BasicLoginAUTH {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver  = BrowserFactory.getDriver("edge");

        testCase1(driver);
        testCase2(driver);
        driver.close();




    }

    public static void testCase1(WebDriver driver) throws InterruptedException {
        String exTitle = "Web Orders Login";
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String titleAfter = driver.getTitle();

        if (exTitle.equals(titleAfter)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAIL");
        }

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        Thread.sleep(2000);



    }

    public static void testCase2(WebDriver driver) throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        String confirm = "Clicked on button one!";
        driver.findElement(By.xpath("//button[.='Button 1' and @onclick='button1()']")).click();
        String elementP = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        if(confirm.equals(elementP)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        Thread.sleep(2000);


    }
}
