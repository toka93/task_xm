package driverCreation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static driverCreation.DriverConstants.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static java.util.concurrent.TimeUnit.SECONDS;


public class IosDriverServiceImpl implements MobileDriverService {
    private IOSDriver iosDriver;
    private final static Logger log = LogManager.getLogger();

    @Override
    public void spinUpDriver() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(DEVICE_NAME, IOS_DEVICE_NAME);
        capabilities.setCapability(AUTOMATION_NAME, IOS_AUTOMATION_NAME);
        capabilities.setCapability(PLATFORM_NAME, IOS);
        capabilities.setCapability(PLATFORM_VERSION, IOS_PLATFORM_VERSION);
      

        try {
            iosDriver = new IOSDriver(new URL(APPIUM_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @Override
    public void closeDriver() {
        iosDriver.closeApp();
    }

    @Override
    public AppiumDriver getDriver() {
        return iosDriver;
    }
}
