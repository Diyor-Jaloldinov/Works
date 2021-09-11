package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class isChecked {

    public static boolean verifyByXpath(WebDriver driver,String pathFirstHalf, String pathSecondHalf, int numberOfElements){
        try{
          for(int i=1;i<=numberOfElements;i++){
              driver.findElement(By.xpath(pathFirstHalf+i+pathSecondHalf)).isSelected();
          }
          return true;
        }catch (Exception  e){
            System.out.println(e);
            return false;
        }
    }


}
