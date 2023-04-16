package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_BUTTON_COOKIES = "//button[contains(@class, \"_42ft _4jy0 _9xo6 _4jy3 _4jy1\")]";
    public static final String XPATH_CREATE_NEW_ACCOUNT = "//a[contains(@class, \"_42ft _4jy0 _6lti _4jy6 _4jy2\")]";
    public static final String XPATH_SELECT_DAY = "//select[contains(@name, \"birthday_day\")]";
    public static final String XPATH_SELECT_MONTH = "//select[contains(@name, \"birthday_month\")]";
    public static final String XPATH_SELECT_YEAR = "//select[contains(@name, \"birthday_year\")]";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.facebook.com/");

        while (!webDriver.findElement(By.xpath(XPATH_BUTTON_COOKIES)).isDisplayed());

        WebElement buttonAcceptCookies = webDriver.findElement(By.xpath(XPATH_BUTTON_COOKIES));
        buttonAcceptCookies.click();

        while (!webDriver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT)).isDisplayed());

        WebElement buttonCreateNewAccount = webDriver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT));
        buttonCreateNewAccount.click();

        while (!webDriver.findElement(By.xpath(XPATH_SELECT_DAY)).isDisplayed());

        WebElement fieldDay = webDriver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select day = new Select(fieldDay);
        day.selectByIndex(25);

        WebElement fieldMonth = webDriver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select month = new Select(fieldMonth);
        month.selectByIndex(5);

        WebElement fieldYear = webDriver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select year = new Select(fieldYear);
        year.selectByIndex(35);

    }
}
