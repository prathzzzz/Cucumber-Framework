package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        String browser = ConfigReader.getProperty("browser");
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicit.wait"));

        WebDriver webDriver = createDriver(browser, isHeadless);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.set(webDriver);
    }

    private static WebDriver createDriver(String browser, boolean isHeadless) {
        return switch (browser.toLowerCase()) {
            case "chrome" -> createChromeDriver(isHeadless);
            case "edge" -> createEdgeDriver(isHeadless);
            default -> throw new RuntimeException("Unsupported browser: " + browser);
        };
    }

    private static WebDriver createChromeDriver(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean isHeadless) {
        EdgeOptions options = new EdgeOptions();
        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        return new EdgeDriver(options);
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}