package yummlyTests;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import util.ExtentManager;
import util.JsonDataReader;

public class AppTests extends BaseTest {

	private final static Logger log = LogManager.getLogger();

	String methodname;

	@Test(priority = 1)
	public void validateUserLoginWithValidCredentials(Method method) throws InterruptedException {
		methodname = method.getName();
		log.info("get test name to use it in extent report , name is : " + methodname);
		child = ((ExtentTest) parentTest.get()).createNode(methodname);
	
		login.tabOnLoginLater();
		ExtentManager.logsreportsinfo(child, "User is redirected to Home Page");
		String recipe = JsonDataReader.getValue("Recipe");

		home.searchForRecipe(recipe);
		ExtentManager.logsreportsinfo(child, "Search for recipe");
	

	}

	
}
