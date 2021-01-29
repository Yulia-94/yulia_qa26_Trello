package com.trello.qa26.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ChangeAvatar extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.user().isAvatarPresent()){
            app.user().logIn();

        }
    }

    @Test
    public void testChangeAvatar() throws InterruptedException {
        app.user().cliackOnTheAvatar();
        app.user().goToProfile();
        app.user().goToAtlasianAcc();
        app.user().pause(2000);
        app.user().changeAvatar("C:\\Users\\Юля\\Documents\\GitHub\\yulia_qa26_Trello\\src\\test\\resources\\dog1.jpg");



    }
}
