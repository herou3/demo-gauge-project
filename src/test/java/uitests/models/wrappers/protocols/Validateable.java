package uitests.models.wrappers.protocols;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.disabled;

public interface Validateable {

    By getRootLocator();

    default void shouldBeValid() {
        $(this.getRootLocator()).shouldBe(visible);
        $(this.getRootLocator()).shouldBe(enabled);
    }

    default void shouldBeInvalid() {
        $(this.getRootLocator()).shouldBe(visible);
        $(this.getRootLocator()).shouldBe(disabled);
    }
}