package driverCreation;

import io.appium.java_client.AppiumDriver;



public interface MobileDriverService {
    void spinUpDriver();

    void closeDriver();

    AppiumDriver getDriver();
}
