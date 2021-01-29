package com.trello.qa26.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.PropertyPermission;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    UserHelper user;
    BoardHelper board;
    Properties properties;


    public void start() throws IOException {
        properties = new Properties();
        String target = System.getProperty("target", "user1");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        wd = new ChromeDriver();
        wd.navigate().to(properties.getProperty("web.url"));
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(wd);
        board = new BoardHelper(wd);

    }

    public String setEmail(){
        return properties.getProperty("web.email");
    }

    public String setPassword(){
        return properties.getProperty("web.password");
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
