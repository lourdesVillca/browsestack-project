package org.fundacionjala.browserstack;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaSample {

    @Test
    public void test01() throws MalformedURLException {
        String USERNAME = System.getProperty("browserstack.username") != null? System.getProperty("browserstack.username"): "miguelaldobalder1";
        String AUTOMATE_KEY = System.getProperty("browserstack.key") != null ? System.getProperty("browserstack.key") : "FsyQMJ7r4yuvjo1wQfEa";
        final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        //System.getProperties().put("https.proxyHost", "172.31.90.162");
        //System.getProperties().put("https.proxyPort", "8080");

        caps.setCapability("browser", "chrome");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "First build");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();

    }
}