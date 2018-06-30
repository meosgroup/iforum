/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.selenium;

import java.net.URL;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
            System.setProperty("webdriver.gecko.driver", SeleniumConfig.class
                    .getClassLoader().getResource(DRIVER_WIN).getPath());
        }
        if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_UNIX) {
            System.out.println("Detect OS: Linux");
            System.setProperty("webdriver.gecko.driver", SeleniumConfig.class
                    .getClassLoader().getResource(DRIVER_LINUX).getPath());
        }
        if (SystemUtils.IS_OS_MAC) {
            System.out.println("Detect OS: Mac OS");
            System.setProperty("webdriver.gecko.driver", SeleniumConfig.class
                    .getClassLoader().getResource(DRIVER_MAC).getPath());
        }

        //Set Firefox Headless mode as TRUE
        if (isHeadless) {
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);

            //Instantiate Web Driver
            return new FirefoxDriver(options);
        }
        //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        return new FirefoxDriver();
    }

    public static void main(String[] args) {
        WebDriver driver = SeleniumConfig.getDefaultDriver(true);
        driver.get("http://www.google.com");
        System.out.println("Page title is - " + driver.getTitle());

        //Search on Google
    }

}
