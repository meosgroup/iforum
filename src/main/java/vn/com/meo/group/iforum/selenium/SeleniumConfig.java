/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.selenium;

import java.net.URL;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author loda
 */
public class SeleniumConfig {

    public static final String DRIVER_LINUX = "geckodriver_linux";
    public static final String DRIVER_WIN = "geckodriver_win";
    public static final String DRIVER_MAC = "geckodriver_mac";

    public static WebDriver getDefaultDriver(boolean isHeadless) {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.out.println("Detect OS: Window");
            System.setProperty("webdriver.gecko.driver", DRIVER_WIN);
        }
        if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_UNIX) {
            System.out.println("Detect OS: Linux");
            System.setProperty("webdriver.gecko.driver", DRIVER_LINUX);
        }
        if (SystemUtils.IS_OS_MAC) {
            System.out.println("Detect OS: Mac OS");
            System.setProperty("webdriver.gecko.driver", DRIVER_MAC);
        }

        //Set Firefox Headless mode as TRUE
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("general.useragent.override", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        if (isHeadless) {
            options.setHeadless(true);
        }
        //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        return new FirefoxDriver(options);
    }
}
