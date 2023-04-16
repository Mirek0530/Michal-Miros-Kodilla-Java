package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    public static final String XPATH_INPUT = "//html/body/main/section/form/fieldset/input";
    public static final String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";
    public static final String XPATH_WAITFOR = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"task-container\")]/form/div/fieldset/select[1]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://mirek0530.github.io/");

        WebElement searchField = driver.findElement(By.xpath(XPATH_INPUT));
        searchField.sendKeys("New robotic task");

        WebElement textField = driver.findElement(By.xpath(XPATH_TEXTAREA));
        textField.sendKeys("The robotic content");

        while (!driver.findElement(By.xpath(XPATH_WAITFOR)).isDisplayed());

        WebElement searchCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(searchCombo);
        selectBoard.selectByIndex(1);
    }



}
