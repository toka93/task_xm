package mobilePages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;

public class HomePage extends BasePage {

	public HomePage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public void searchForRecipe(String recipe)
{
	tap(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]"));

inputText(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.yummly.android:id/search_src_text']"),recipe);
}	
	
}