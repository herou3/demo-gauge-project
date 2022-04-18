package uitests.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    public abstract void shouldBeShown();

    public static void loseFocus() {
        $(By.xpath("//body")).click();
    }

    public static void waitOneOf(long millis, By... locators) {
        int sleepTime = 500;
        do {
            for (By loc : locators) {
                if ($(loc).isDisplayed()) {
                    Selenide.sleep(sleepTime);
                    if ($(loc).isDisplayed()) {
                        return;
                    }
                }
            }
            Selenide.sleep(sleepTime);
            millis -= sleepTime;
        } while (millis > 0);
        System.out.println("no one locator is found");
    }
}