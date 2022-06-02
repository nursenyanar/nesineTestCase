package com.nesine;

import org.openqa.selenium.By;

public class PageVariables {
    public static final String BASE_URL = "https://www.nesine.com/";

    public static final By USER_NAME = By.cssSelector("[id='txtUsername']");
    public static final By PASSWORD = By.id("realpass");
    public static final By LOGIN_BUTTON = By.cssSelector("[class='btn btn-login lgbtn']");
    public static final By POPULAR_BETS = By.cssSelector("li[class='popular-bets ']>a");
    public static final By FOOTBALL = By.cssSelector("div.top-filter > nav > button:nth-child(1)");
    public static final By ACCOUNT_BUTTON = By.cssSelector("#profile-nav > nav > ul > li:nth-child(2) > a");
    public static final By LOGOUT_BUTTON = By.xpath("//div[@id='profile-nav']//nav//ul//li[2]//ul//li[7]//a");
    public static final By VOLLEYBALL = By.cssSelector("div.top-filter > nav > button:nth-child(4)");
    public static final By POP_UP = By.id("c-p-bn");
}
