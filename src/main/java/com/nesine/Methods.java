package com.nesine;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static com.nesine.Drivers.driver;

public class Methods {

    public void goToUrl(String url) {
        driver.get(url);
        clickBy(PageVariables.POP_UP);
        Logger.info("Opened Website:" + url);
    }

    public void clickBy(By by) {
        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable((by)));
        element.click();
        Logger.info("Element clicked");
    }

    public void sendValue(String value, By name) {
        WebElement send = driver.findElement(name);
        send.click();
        send.sendKeys(value);
        Logger.info("Value written " + value);
    }

    public void waitSeconds(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public JSONArray checkPlay() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"eventType\": 1,\n    \"date\": null\n}");
        Request request = new Request.Builder()
                .url("https://www.nesine.com/iddaa/GetPopularBets")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String responseData = null;
        try {
            responseData = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(responseData);
        JSONObject jsonObj = new JSONObject(responseData);

        return jsonObj.getJSONArray("PopularBetList");
    }

    public void getCodeAndPlayerList() {
        JSONArray responseData = checkPlay();

        List<WebElement> betLineList = driver.findElements(By.cssSelector("[class='betLine']"));
        for (WebElement item : betLineList) {
            String matchCode = item.findElement(By.className("matchCode")).getText();
            String playerCount = item.findElement(By.className("playedCount")).getText();

            for (int i = 0; i < responseData.length(); i++) {
                JSONObject jsonItem = responseData.getJSONObject(i);
                if (jsonItem.getString("MarketNo").equals(matchCode)) {
                    Assert.assertEquals(jsonItem.getInt("PlayedCount"), Integer.parseInt(playerCount.replace(".", "")));
                }
            }
        }

    }


}
