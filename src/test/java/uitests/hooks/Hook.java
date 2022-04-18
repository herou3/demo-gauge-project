package uitests.hooks;

import com.codeborne.selenide.Configuration;

import com.thoughtworks.gauge.BeforeSuite;

import uitests.assistants.ConstantValues;
import uitests.config.browser.Browser;

public class Hook {
    @BeforeSuite
    public void setupApp() {
        Configuration.timeout = ConstantValues.STANDARD_DURATION;
        System.setProperty("browser", "GH");
        System.setProperty("environment", "PROD");
        Configuration.browser = Browser.getCurrentBrowser().getName();
    }
}
