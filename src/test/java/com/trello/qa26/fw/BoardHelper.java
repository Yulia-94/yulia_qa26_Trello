package com.trello.qa26.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initAddingNewBoard() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void fillBoardForm(String title) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), title);
        click(By.cssSelector("[class='_1Lkx3EjS3wCrs7 voB8NatlbuEme5 _3JfnLi33JtGtIk']"));
        click(By.cssSelector("[name='private']"));


    }


}
