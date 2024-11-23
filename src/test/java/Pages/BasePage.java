package Pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;

import static utilities.DriverSetup.getDriver;

public class BasePage {
    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public String getPageURL(){
        return getDriver().getCurrentUrl();
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public void loadWebPage(String url){
        getDriver().get(url);
    }

   public Boolean is_element_visible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
   }

   public void addScreenShots(){
       Allure.addAttachment("After Tests", new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
   }
}