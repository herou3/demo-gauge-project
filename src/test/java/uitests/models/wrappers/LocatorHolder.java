package uitests.models.wrappers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class LocatorHolder {

    private final By locator;
    private By parent;

    // init LocatorHolder with use only one target locator
    public LocatorHolder(By locator) {
        this.locator = locator;
    }

    // init LocatorHolder with use parent locator for the target and a target locator
    public LocatorHolder(By locator, By parent) {
        this.locator = locator;
        this.parent = parent;
    }

    // getter for the locator
    public By getRootLocator() {
        if (parent == null) {
            return locator;
        } else {
            return parent;
        }
    }

    // get SelenideElement with using target locator
    public SelenideElement getElement() {
        if (parent == null) {
            return Selenide.$(locator);
        } else {
            return Selenide.$(parent).shouldBe(visible).find(locator);
        }
    }

    // get collection elements of selenide with use target locator
    public ElementsCollection getElements() {
        if (parent == null) {
            return Selenide.$$(locator);
        } else {
            Selenide.$(parent).shouldBe(visible);
            return Selenide.$(parent).$$(locator);
        }
    }
}