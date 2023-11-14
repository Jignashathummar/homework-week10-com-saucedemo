package comsaucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class Saucedemo {
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;
    static String browser = "Chrome";

    public static void main(String[] args) {
        //Launch the Chrome Browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser");
        }
        //Get base URL
        driver.get(baseUrl);

        //Maximise the Browser
        driver.manage().window().maximize();
        String title = driver.getTitle();

        //Get the title of the Page.
        System.out.println("Title: " + title);

        //Get current URL
        System.out.println("The current URL : " + driver.getCurrentUrl());

        //Get Page source
        System.out.println("Page source : " + driver.getPageSource());

        //Enter username field
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //Enter password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Click on login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get current URL
        System.out.println("Print current URL: " + driver.getCurrentUrl());

        //Nevigate Base Url
        driver.navigate().back();

        //Refresh page
        driver.navigate().refresh();

        //browser close
        driver.quit();
    }
}
