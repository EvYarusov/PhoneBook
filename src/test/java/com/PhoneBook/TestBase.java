package com.PhoneBook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class TestBase {
    static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }

    public boolean isElementPresentByLocator(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public boolean isElementPresentByLocator2(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresentByLocator(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresentByLocator(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[contains(.,'Registration')]"));
    }

    public void fillLoginRegForm(String email, String password) {
        type(By.cssSelector("[placeholder='Email']"), email);

        type(By.cssSelector("[placeholder='Password']"), password);
    }

    public boolean isLoginRegFormPresent() {
        return isElementPresentByLocator(By.className("login_login__3EHKB"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,'Login')]"));
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());

        if (alert==null){
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void addContact(String name, String lastName, String phone, String email, String address, String description) {
        type(By.cssSelector("input:nth-child(1)"), name);
        type(By.cssSelector("input:nth-child(2)"), lastName);
        type(By.cssSelector("input:nth-child(3)"), phone);
        type(By.cssSelector("input:nth-child(4)"), email);
        type(By.cssSelector("input:nth-child(5)"), address);
        type(By.cssSelector("input:nth-child(6)"), description);
    }

    public void clickOnAddLink() {
        click(By.cssSelector("a:nth-child(5)"));
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));

        for (WebElement el: contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));

        click(By.xpath("//button[contains(.,'Remove')]"));
    }

    public int sizeOfContacts() {
        if (driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()>0) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } else
            return 0;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size()>0;
    }

    public boolean isHomeComponentPresent2() {
        try {
            driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
