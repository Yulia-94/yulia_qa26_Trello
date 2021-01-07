package com.trello.qa26.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    UserHelper user;
    BoardHelper board;


    public void start() {
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(wd);
        board = new BoardHelper(wd);

    }

    public void stop() {

        wd.quit();
    }


    public BoardHelper board() {
        return board;
    }

    public UserHelper user(){
       return user;
    }

}
