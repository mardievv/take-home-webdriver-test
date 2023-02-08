package com.academy.techcenture.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.academy.techcenture.config.ConfigReader.getProperties;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    private WebDriverWait wait;

    public WebDriver getDriver(){

        String browser = getProperties("browser");

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("no driver found");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(getProperties("implicitWait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(getProperties("pageLoadTime"))));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }


    public static void quitDriver(){
        if (driver != null )
            driver.quit();
    }
}
