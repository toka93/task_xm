package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadMorePage extends BasePage {

	public ReadMorePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getSymbol()
	{
		WebElement symbolValue=createWebElment( By::xpath, "//td[@data-xm-qa-name='symbols__value']/span");

	return	symbolValue.getText();
		
	}
	public String getMinSpread()
	{
		WebElement minSpreadValue=createWebElment( By::xpath, "(//td[@data-xm-qa-name='spreads_as_low_as__value']/span/strong)[2]");
		return minSpreadValue.getText();
		
	}
	
	public String getMinMaxTradeSize()
	{
		WebElement minMaxTradeValue=createWebElment( By::xpath, "//td[@data-xm-qa-name='min_max_trade_size__value']/span");

	return	minMaxTradeValue.getText();
		
	}
	
	public String getMarginRequirement()
	{
		WebElement marginRequirementValue=createWebElment( By::xpath, "//td[@data-xm-qa-name='margin_requirement__value']/span/strong");

	return	marginRequirementValue.getText();
		
	}
	
	public String getSwapLong()
	{
		WebElement swapLongValue=createWebElment( By::xpath, "//td[@data-xm-qa-name='swap_value_in_margin_currency_long__value']/span");

	return	swapLongValue.getText();
		
	}
	
	public String getSwapShort()
	{
		WebElement swapShortValue=createWebElment( By::xpath, "//td[@data-xm-qa-name='swap_value_in_margin_currency_short__value']/span");

		 return swapShortValue.getText();
		
	}
	public String getLimitLevel()
	{
		WebElement limitStopLevelValue=createWebElment( By::xpath, "//td[@data-xm-qa-name='limit_and_stop_levels__title']/span");

		 return limitStopLevelValue.getText();
		
	}
	
	public StocksValues getStocksValuefromTable()
	{
		StocksValues stocks=new StocksValues();
		
		stocks.setSymbol(getSymbol());
		stocks.setShortSwap(getSwapShort());
		stocks.setMinspread(getMinSpread());
		stocks.setMinmaxTradeSize(getMinMaxTradeSize());
		stocks.setMarginPercentage(getMarginRequirement());
		stocks.setLongSwap(getSwapLong());
		stocks.setLimit(getLimitLevel());
		
		return stocks;
		
		
		
	}
	
	
}
