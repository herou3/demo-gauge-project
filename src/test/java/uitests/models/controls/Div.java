package uitests.models.controls;

import org.openqa.selenium.By;
import uitests.models.wrappers.UIObject;

import static com.codeborne.selenide.Condition.visible;
import static uitests.utils.CustomCondition.marked;

public class Div extends UIObject<Div> {

    // Constructors for the class object
    public Div(By locator) {
        super(locator);
    }

    public Div(By locator, By parent) {
        super(locator, parent);
    }

    // methods for check the element
    @Override
    public void shouldBeValid() {
        this.$().parent().shouldBe(visible);
    }

    @Override
    public void shouldBeInvalid() {
        this.$().parent().shouldBe(visible);
        this.$().parent().shouldBe(marked());
    }

    // Interactions
    public Div scroll() {
        this.$().scrollTo();
        return this;
    }
}