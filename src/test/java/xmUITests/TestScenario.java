package xmUITests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;
import pages.ReadMorePage;
import pages.StocksPage;
import pages.StocksValues;
import util.ExtentManager;
import util.JsonDataReader;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestScenario extends BaseTest {
	private final static Logger log = LogManager.getLogger();

	String methodname;

	@Test(dataProvider = "resolutionData", dataProviderClass = DPResolutions.class)
	public void Open_XM_With_Resolution(Method method, Object resolution) throws InterruptedException {
		methodname = method.getName() ;

		child = ((ExtentTest) parentTest.get()).createNode(methodname);
		openDriverWithResolution(resolution);
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		assertTrue(driver.getTitle().equals("Forex & CFD Trading on Stocks, Indices, Oil, Gold by XM™"));

		HomePage home = new HomePage(driver);
		home.acceptCookies();
		home.openTradingMenu();
		home.openStocksLink();
		StocksPage stocks = new StocksPage(driver);
		String url = JsonDataReader.getValue("StockURL");
		boolean flagPage = driver.getCurrentUrl().equals(url);
		assertTrue(flagPage);
		ExtentManager.logsreportsinfo(child, "User is redirected to stocks Page", flagPage);
		String country = JsonDataReader.getValue("Country");

		stocks.filterByCountry(country);
		String company = JsonDataReader.getValue("Company");

		stocks.enterSearchValue(company);

		StocksValues stock = new StocksValues();
		StocksValues stockReadme = new StocksValues();

		stock = stocks.getStocksValuefromTable();

		stocks.clickonReadMore();
		ReadMorePage readmorePage = new ReadMorePage(driver);

		stockReadme = readmorePage.getStocksValuefromTable();
		boolean stocksValuesFlag = stock.equals(stockReadme);
		System.out.println(stock.limit + stock.longSwap + stock.marginPercentage + stock.minmaxTradeSize + stock.minspread + stock.shortSwap + stock.symbol);
		System.out.println(stockReadme.limit + stockReadme.longSwap + stockReadme.marginPercentage + stockReadme.minmaxTradeSize + stockReadme.minspread + stockReadme.shortSwap + stockReadme.symbol);

		assertTrue(stocksValuesFlag);
		ExtentManager.logsreportsinfo(child, "Stocks value are the same in Readme File", stocksValuesFlag);
	}

}
