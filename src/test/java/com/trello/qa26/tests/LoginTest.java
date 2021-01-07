package com.trello.qa26.tests;

import com.trello.qa26.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @Test
    public void testAtlassianUserLogin() throws InterruptedException {
        app.user().initLogin();
        app.user().fillLoginForm(new User().setEmail("yrosenblum1994@gmail.com").setPassword("rosenblum94"));
        app.user().confirmLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }
}
