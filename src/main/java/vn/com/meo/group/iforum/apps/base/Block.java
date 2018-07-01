/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import vn.com.meo.group.iforum.selenium.SeleniumConfig;

/**
 *
 * @author ducvu
 */
public abstract class Block {
    private final WebDriver driver;

    public Block(boolean headless) {
        this.driver = SeleniumConfig.getDefaultDriver(headless);
    }
    
    public Block(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebDriver getDriver() {
        return this.driver;
    }
    
    public void closeDriver() {
        this.driver.close();
    }
    
    public void gotoUrl(String url) {
        this.driver.get(url);
    }
    
    public WebElement findElementById(String element) {
        return driver.findElement(By.id(element));
    }
    
    public WebElement findElementByName(String element) {
        return driver.findElement(By.name(element));
    }
    
    public WebElement findElementByClass(String element) {
        return driver.findElement(By.className(element));
    }
    
    public WebElement findElementByXPath(String element) {
        return driver.findElement(By.xpath(element));
    }
    
    public void actionInput(WebElement element, String content) {
        Actions action = new Actions(this.driver);
        action.moveToElement(element);
        action.click();
        action.sendKeys(content);
        action.build().perform();
    }
    
    public void sleep(Integer time) {
        this.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    
    public void resetCookies() {
        this.driver.manage().deleteAllCookies();
    }
}
