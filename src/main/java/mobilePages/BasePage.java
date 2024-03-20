package mobilePages;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	protected final static Logger log = LogManager.getLogger();
    public final AppiumDriver driver;
    public final WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
    }
	public  WebElement createWebElment( Function<String, By> locatorStrategy, String locator) {
		return driver.findElement(locatorStrategy.apply(locator));
	}
    public void waitUntilElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
   
    public void tap(By by) {
        waitUntilElementVisible(by);
        driver.findElement(by).click();
    }

	
	  public void tap(WebElement element) { element.click(); }
	 
    public void inputText(By by, String text) {
    waitUntilElementVisible(by);
        driver.findElement(by).sendKeys(text);
    }
    
    public String getText(By by) {
        waitUntilElementVisible(by);
        return driver.findElement(by).getText();
    }
    
}
	
    
