package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;


public class Second {
    AndroidDriver driver;
    AppiumDriverLocalService service;
    @Test
    public void m1() throws Throwable {
        try {
          /*  service = AppiumDriverLocalService.buildDefaultService();
        service.start();*/

            UiAutomator2Options options = new UiAutomator2Options()
                    .setUdid("7a8ad89d6224")
                    .setAppPackage("com.miui.calculator")
                    .setAppActivity("com.miui.calculator.cal.CalculatorActivity");
            // .setApp("/home/myapp.apk");
            AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);


            driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_7")).click();
            driver.findElement(AppiumBy.id("com.miui.calculator:id/op_add")).click();
            driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_8")).click();
            driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_equal_s")).click();
            String result=driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();
            result=result.replace("=","").trim();
            Assert.assertEquals(result,"15");
            Thread.sleep(3000);
            driver.quit();

        }
        finally {
            //service.stop();
        }

    }
}
