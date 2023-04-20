package com.ait.phonebook.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser;
    UserHelper user;
    ContactHelper contact;

    HeaderHelper header;
    HomePageHelper homePage;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void init() {
        System.err.close();

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new ChromeDriver(options);
            logger.info("All test starts in Chrome browser");

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("All test starts in Firefox browser");

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new EdgeDriver(options);
            logger.info("All test starts in Edge browser");
        }


        driver.get("https://telranedu.web.app");

        logger.info("Current URL --> " + driver.getCurrentUrl());

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        header = new HeaderHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
