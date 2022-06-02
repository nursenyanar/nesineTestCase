package com.nesine.steps;

import com.nesine.Methods;
import com.nesine.PageVariables;
import com.nesine.XMLParser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class NesineSteps extends Methods {

    XMLParser xmlParser = new XMLParser();

    @Given("Go to nesine home page")
    public void goToWebsite() throws InterruptedException {
        goToUrl(PageVariables.BASE_URL);
    }

    @And("Check login button")
    public void checkLoginButton() {

    }

    @When("Login with a valid username and password")
    public void login() throws InterruptedException {
        clickBy(PageVariables.USER_NAME);
        waitSeconds(5);
        sendValue(xmlParser.getUsername(), PageVariables.USER_NAME);
        sendValue(xmlParser.getPassword(), PageVariables.PASSWORD);
        clickBy(PageVariables.LOGIN_BUTTON);
    }

    @When("{string} button is clicked")
    public void clickPopularBetTab(String string) {
        clickBy(PageVariables.POPULAR_BETS);
    }

    @And("{string} page url check")
    public void checkPopularBetUrl(String string) {
        System.out.println(getUrl());
        Assert.assertEquals(getUrl(), "https://www.nesine.com/iddaa/populer-bahisler");
    }

    @When("Go to football tab")
    public void footballTab() {
        clickBy(PageVariables.FOOTBALL);
    }

    @When("Go to volleyball tab")
    public void volleyballTab() {
        clickBy(PageVariables.VOLLEYBALL);
    }

    @And("Page tab check")
    public void checkTab() {
        Assert.assertEquals(getUrl(), "https://www.nesine.com/iddaa/populer-bahisler/voleybol");
    }

    @When("Code and number of plays is checked")
    public void checkNumberOfPlay() {
        getCodeAndPlayerList();
    }

    @And("Log out by clicking on my account button")
    public void logOut() {
        clickBy(PageVariables.ACCOUNT_BUTTON);
        waitSeconds(4);
        clickBy(PageVariables.LOGOUT_BUTTON);
    }


}
