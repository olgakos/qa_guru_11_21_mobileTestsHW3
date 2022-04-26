package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackCredentials;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", "1.22.0");
        mutableCapabilities.setCapability("browserstack.user", BrowserstackCredentials.config.user());
        mutableCapabilities.setCapability("browserstack.key", BrowserstackCredentials.config.key());
        mutableCapabilities.setCapability("app", BrowserstackCredentials.config.app());
        mutableCapabilities.setCapability("device", "Google Pixel 3");
        mutableCapabilities.setCapability("os_version", "9.0");
        mutableCapabilities.setCapability("project", "Wiki Test Project");
        mutableCapabilities.setCapability("build", "browserstack-build-wiki");
        mutableCapabilities.setCapability("name", "wiki_test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
}
