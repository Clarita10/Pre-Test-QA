package com.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("appium:appPackage", "com.eraspace.app")
                .amend("appium:appActivity", "com.eraspace.home.presentation.HomeActivity")
                .amend("platformName", "Android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:noReset", true)
                .amend("appium:newCommandTimeout", "3600")
                .amend("appium:platformVersion", "13")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Test
    public void loginTest() {
        WebElement btnLogin = driver.findElement(AppiumBy.id("com.eraspace.app.home:id/btnLogin"));
        btnLogin.click();

        WebElement inputEmail = driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/edtPhoneOrEmail"));
        inputEmail.sendKeys("081397154745");

        WebElement inputPassword = driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/edtPassword"));
        inputPassword.sendKeys("Clarita123.");

        WebElement btnSubmit = driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/btnLogin"));
        btnSubmit.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
