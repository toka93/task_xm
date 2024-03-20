package mobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;

public class LoginPage extends BasePage {

	public LoginPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public void tabOnLoginLater()
{
WebElement doItLaterButton=	createWebElment(By::id,"com.yummly.android:id/skip_view");

tap(doItLaterButton);
}	
	
}