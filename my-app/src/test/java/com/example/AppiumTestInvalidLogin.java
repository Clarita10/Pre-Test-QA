package com.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class AppiumTestInvalidLogin {

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
  public void loginInvalid() {
    var el1 = driver.findElement(AppiumBy.id("com.eraspace.app.home:id/btnLogin"));
    el1.click();
    var el2 = driver.findElement(AppiumBy.id("com.eraspace.app.home:id/btnLogin"));
    el2.click();
    var el3 = driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/edtPhoneOrEmail"));
    el3.sendKeys("081234567890");
    var el4 = driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/edtPassword"));
    el4.sendKeys("testing");
    var el5 = driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/btnLogin"));
    el5.click();
    var el6 = driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/tvError"));
    el6.click();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
