package pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	 public final WebDriver driver;
	public BasePage(WebDriver driver) {
		 this.driver = driver;
		
	}
	public  WebElement createWebElment( Function<String, By> locatorStrategy, String locator) {
		return driver.findElement(locatorStrategy.apply(locator));
	}
	
	
	public void scrollToElement(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.scrollToElement(element).perform();
	}
	
	public void clickUsingJS(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	
}
