package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void acceptCookies()
	{
		WebElement accept= createWebElment(By::xpath,"//button[text()='ACCEPT ALL']");
		if(accept.isDisplayed())
		accept.click();
		
	}
	
	public void openTradingMenu()
	{
		WebElement tradingLink= createWebElment(By::xpath,"//*[@class='main_nav_trading']/a");
	
		tradingLink.click();
		
	}
	
	public void openStocksLink()
	{
		WebElement stocksLink= createWebElment(By::xpath,"//*[@class='menu-stocks']/a");
		stocksLink.click();
		
	}
	
	
	
}
