package com.trello.qa26.fw;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));

    }

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.id("user"), user.getEmail());
        pause(2000);
        click(By.id("login"));
        type(By.id("password"), user.getPassword());
        

    }

    public void confirmLogin() {
        click(By.id("login-submit"));
    }

    public boolean isAvatarPresent() throws InterruptedException {
        pause(20000);
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logIn() throws InterruptedException {
       click(By.cssSelector("[href='/login']"));
        fillLoginForm(new User().setEmail("yrosenblum1994@gmail.com").setPassword("rosenblum94"));
        pause(2000);
        click(By.cssSelector("#login-submit"));



    }

    public void cliackOnTheAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void goToProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlasianAcc() {
      //  System.out.println(wd.getWindowHandles());
        click(By.cssSelector("[href$=manage-profile]"));
        swichToWindowHanleIndex(1);

    }
    public void closeWindow(){
        wd.close();
        swichToWindowHanleIndex(0);
    }

   

    public void changeAvatar (String path) throws InterruptedException {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']")))
                .moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info'] [class^=Droplist__Trigger]")))
                //.moveToElement(wd.findElement(By.xpath(".//*[@class='Droplist__Trigger-sc-1z05y4v-3 eteVrT']")))
                .click()
                .perform();
        //click(By.xpath("//div[@id='uid16']/span[1]"));
         click(By.xpath("//div[@class='sc-iuJeZd gyunVU']/span[1]"));
         pause(1000);

        attachPhoto(By.cssSelector("#image-input"), new File(path));
        pause(1000);
        clickXpath("//div[@class='sc-cNnxps eYeGXT']/button[1]");
  
    }


}
