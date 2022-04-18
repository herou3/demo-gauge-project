package uitests.assistants;

import com.thoughtworks.gauge.Step;

import org.openqa.selenium.JavascriptExecutor;

import uitests.config.environment.Environment;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CommonSteps {
    @Step("Открыть главную страницу сайта")
    public void openMainPage() {
        System.out.println(Environment.getCurrentEnvironment().getUrl());
        open(Environment.getCurrentEnvironment().getUrl());
    }

    @Step("Открыть страницу <pageName>")
    public void openPage(String pageName) {
        open(pageName);
    }

    @Step("Почистить куки")
    public void clearCookie() {
        if (WebDriverRunner.hasWebDriverStarted() && !url().startsWith("data")) {
            try {
                WebDriverRunner.getWebDriver().manage().deleteAllCookies();
                WebDriverRunner.clearBrowserCache();
                System.out.println("deleting cookies...");
            } catch (Exception e) {
                System.out.println("exception occurs while trying clear cookies {} \n " + e);
            }
        }
    }
    @Step("Почистить локальные данные")
    public void clearLocalStorage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        try {
            if (WebDriverRunner.hasWebDriverStarted() && !url().contains("data:")) {
                System.out.println("clearing local storage...");
                javascriptExecutor.executeScript("window.localStorage.clear();");
            }
        } catch (Exception e) {
            System.out.println("exception occurs while trying clear local storage {} \n " + e);
        }
        WebDriverRunner.getWebDriver().close();
    }

    @Step("Ожидание в течение <seconds> секунд")
    public void sleep(String seconds) {
        Selenide.sleep(Integer.parseInt(seconds) * 1000L);
    }
    @Step("Проверка открыт ли сайт PIS2")
    public boolean isSiteOpen() {
        return WebDriverRunner.getWebDriver().getCurrentUrl().contains(Environment.getCurrentEnvironment().getUrl());
    }

    @Step("Обновить страницу")
    public void refreshPage() {
        Selenide.refresh();
    }
}