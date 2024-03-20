package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StocksPage extends BasePage {

	public StocksPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void filterByCountry( String country) {
		WebElement countryButton = createWebElment( By::xpath, "//button[@data-value='" + country + "']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		scrollToElement(countryButton);

		wait.until(ExpectedConditions.elementToBeClickable(countryButton));

		clickUsingJS(countryButton);
	}

	public void enterSearchValue( String value) {

		WebElement searchInput = createWebElment(By::xpath,
				"//*[@id='DataTables_Table_0_filter']//input[@type='search']");

		searchInput.sendKeys(value);

	}

	public void clickonReadMore() {

		WebElement readmoreButton = createWebElment( By::xpath, "//*[@class='btn btn-green']");
		WebElement expand = createWebElment( By::xpath, "//tr/td[@data-xm-qa-name='symbolWithDescription']");

		if (expand.isDisplayed())
			expand.click();

		clickUsingJS(readmoreButton);

	}

	public String getSymbol() {
		WebElement symbolValue = createWebElment( By::xpath, "(//td[@data-xm-qa-name='symbol'])[1]");

		return symbolValue.getText();

	}

	public String getMinSpread() {
		WebElement minSpreadValue = createWebElment( By::xpath, "(//td[@data-xm-qa-name='minSpread'])[1]");

		return minSpreadValue.getText();

	}

	public String getMinMaxTradeSize() {
		WebElement minMaxTradeValue = createWebElment( By::xpath,
				"(//td[@data-xm-qa-name='minMaxTradeSize'])[1]");

		return minMaxTradeValue.getText();

	}

	public String getMarginRequirement() {
		WebElement marginRequirementValue = createWebElment( By::xpath,
				"(//td[@data-xm-qa-name='marginRequirement'])[1]");

		return marginRequirementValue.getText();

	}

	public String getSwapLong() {
		WebElement swapLongValue = createWebElment( By::xpath, "(//td[@data-xm-qa-name='swapLong'])[1]");

		return swapLongValue.getText();

	}

	public String getSwapShort() {
		WebElement swapShortValue = createWebElment( By::xpath, "(//td[@data-xm-qa-name='swapShort'])[1]");

		return swapShortValue.getText();

	}

	public String getLimitLevel() {
		WebElement limitStopLevelValue = createWebElment( By::xpath,
				"(//td[@data-xm-qa-name='limitStopLevel'])[1]");

		return limitStopLevelValue.getText();

	}

	public StocksValues getStocksValuefromTable() {
		StocksValues stocks = new StocksValues();

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
