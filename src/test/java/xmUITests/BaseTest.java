package xmUITests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ExtentManager;
import static util.ConfigReader.*;
public class BaseTest {
	protected static ExtentReports extent;
	public static ThreadLocal parentTest = new ThreadLocal();
	protected static ThreadLocal test = new ThreadLocal();
	public ExtentTest child;
	ExtentHtmlReporter htmlReporter;
	String ExtentReport = "Reports";
	LocalTime time = LocalTime.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm");
	String reportName = ExtentReport + time.format(formatter) + ".html";
	
	private final static Logger log = LogManager.getLogger();
	protected WebDriver driver;
	//move url to file
	protected String baseUrl = getWebsiteConfig("website_url");
	@BeforeClass(alwaysRun = true)
	public synchronized void beforeClass() throws MalformedURLException {

		ExtentTest parent = extent.createTest(getClass().getName());
		parentTest.set(parent);
		
		
	}
	@BeforeSuite(alwaysRun = true)
	public void oneTimeSetup() {
		log.info("before suite");
		extent = ExtentManager.createInstance();
		htmlReporter = new ExtentHtmlReporter(
				ExtentReport + File.separator + File.separator + dtf.format(localDate) + File.separator + reportName);
		extent.attachReporter(htmlReporter);
	}
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		test.set(child);
	}
	@AfterMethod(alwaysRun = true)
	public void closeApp(ITestResult res) {

		log.info("get status of test just run");
		if (res.getStatus() == ITestResult.SUCCESS) {
			log.info("test passes");
		} else if (res.getStatus() == ITestResult.FAILURE) {
			log.info("test failed");
			child.log(Status.FAIL, "Test failed ");
			System.out.println("status for fail");
		} else if (res.getStatus() == ITestResult.SKIP) {
			log.info("test skipped ");
			child.log(Status.SKIP, "Test skipped");
		} else {
			log.info("test finished with status other than (pass,fail,skip) ");
			child.log(Status.ERROR, "Test skipped");
		}
		log.info("close driver browser in after method");

		driver.quit();
	}
	
	public void openDriverWithResolution(Object resolution)
	{
		
		
		
		Dimension windowSize;
		if(resolution instanceof String) 
		{
			driver .manage().window().maximize();

			

		}
		else 
		{
			 int width = (int) ((int[]) resolution)[0];
		     int height = (int) ((int[]) resolution)[1];
		     windowSize = new Dimension(width, height);
		     
		 	  windowSize = new Dimension(width, height);
		 	  
		 	  driver.manage().window().setSize(windowSize);
		 	 
			}
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void endSuite() throws IOException {
		log.info("end report in after class");
		extent.flush();

	}
}
