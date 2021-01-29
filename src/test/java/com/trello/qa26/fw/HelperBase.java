package com.trello.qa26.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void swichToWindowHanleIndex(int index1) {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(index1));


    }
    public void click(By locator){
        wd.findElement(locator).click();
        //Actions actions = new Actions(wd);
        //actions.moveToElement(wd.findElement(locator)).click().perform();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
    public void attachPhoto(By locator, File file) {
        if(file!=null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }


    public void typeByCss(String cssSelector, String text) {
        if (text != null) {


            clickByCss(cssSelector);
            wd.findElement(By.cssSelector(cssSelector)).clear();
            wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
        }
    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickXpath(String xpath) {
        wd.findElement(By.xpath(xpath)).click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void clickButtonCreateBoard() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }


}
