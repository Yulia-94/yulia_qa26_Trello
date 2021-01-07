package com.trello.qa26.fw;

import com.trello.qa26.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    WebDriver wd;

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
}
