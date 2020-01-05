package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_DAY_SELECT = "//div[@id=\"birthday_wrapper\"]/div[2]/span/span/select[1]";
    public static final String XPATH_MONTH_SELECT = "//div[@id=\"birthday_wrapper\"]/div[2]/span/span/select[2]";
    public static final String XPATH_YEAR_SELECT = "//div[@id=\"birthday_wrapper\"]/div[2]/span/span/select[3]";
    public static void main(String[] args) {


        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        Select daySelectBox = new Select(driver.findElement(By.xpath(XPATH_DAY_SELECT)));
        Select monthSelectBox = new Select(driver.findElement(By.xpath(XPATH_MONTH_SELECT)));
        Select yearSelectBox = new Select(driver.findElement(By.xpath(XPATH_YEAR_SELECT)));

        while(!driver.findElement(By.xpath(XPATH_DAY_SELECT)).isDisplayed());
        daySelectBox.selectByValue("13");
        monthSelectBox.selectByVisibleText("cze");
        yearSelectBox.selectByValue("2000");
    }
}
