package com.trello.qa26.tests;


import com.trello.qa26.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp(){
        app.start();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();

    }


}
