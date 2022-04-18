package uitests.models.controls;

import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;

import static com.codeborne.selenide.Condition.*;

public class Button extends UIObject<Button> {

    // constructors for the class object
    public Button(By locator) {
        super(locator);
    }

    public Button(By locator, By parent) {
        super(locator, parent);
    }

    // methods for the check elements
    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(enabled);
    }

    @Override
    public void shouldBeInvalid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(disabled);
    }
}
