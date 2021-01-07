package com.trello.qa26.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoards extends TestBase{


    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
            app.user().logIn();
    }
    @Test
    public void testCreateBoards() throws InterruptedException {
        app.board().initAddingNewBoard();
        app.board().fillBoardForm("Week schedule");
        app.board().pause(3000);
        app.board().clickButtonCreateBoard();
        app.board().pause(2000);

      //  Assert.assertTrue(app.board().isBoardCreationFormPresent());



    }

}
