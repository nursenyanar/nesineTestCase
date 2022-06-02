package com.nesine;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Drivers {
    public static WebDriver driver;

    @Before("@Chrome")
    public void chromeDriverSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-extensions");
    }

    @Before("@Firefox")
    public void firefoxDriverSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @Before("@Opera")
    public void operaDriverSetUp() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @After("@Chrome")
    public void closeChromeDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", "Fail screenshot");
        }
        driver.close();

    }

    @After("@Firefox")
    public void closeGeckoDiver(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", "Fail screenshot");
        }
        driver.close();

    }

    @After("@Opera")
    public void closeOperaDiver(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", "Fail screenshot");
        }
        driver.close();
    }
}
