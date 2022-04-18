package uitests.models.controls;

import org.openqa.selenium.By;

import uitests.models.wrappers.UIObject;

import static uitests.utils.SelectorsUtils.*;
import static com.codeborne.selenide.Condition.visible;

public class Input extends UIObject<Input> {

    // constructors for the class object
    public Input(By locator) {
        super(locator);
    }

    public Input(By locator, By parent) {
        super(locator, parent);
    }

    // methods for the check elements
    @Override
    public void shouldBeValid() {
        super.shouldBeValid();
    }

    @Override
    public void shouldBeInvalid() {
        super.shouldBeInvalid();
    }

    // Interactions
    public Input enterText(String text) {
        this.$().shouldBe(visible);
        this.$().sendKeys(text);
        return this;
    }

    public Input enterTextAndConfirm(String text) {
        this.$().shouldBe(visible);
        this.$().sendKeys(text);
        this.$().pressEnter();
        return this;
    }

    public Input scroll() {
        this.$().scrollTo();
        return this;
    }

    public Input clear() {
        clearInputElement(this.$());
        return this;
    }

    public Input clearAllText() {
        clearAllTextInInputableElement(this.$());
        return this;
    }
}