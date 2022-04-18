package uitests.models.wrappers;

import org.openqa.selenium.By;

import uitests.models.wrappers.protocols.Displayable;
import uitests.models.wrappers.protocols.Existable;
import uitests.models.wrappers.protocols.Validateable;
import uitests.assistants.ConstantValues;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.texts;

@SuppressWarnings("unchecked")
public class UIObject<T> implements Validateable, Displayable<T>, Existable<T> {

    private final LocatorHolder locatorHolder;

    @Override
    public By getRootLocator() {
        return locatorHolder.getRootLocator();
    }

    // constructors
    public UIObject(By locator) {
        this.locatorHolder = new LocatorHolder(locator);
    }

    public UIObject(By locator, By parent) {
        this.locatorHolder = new LocatorHolder(locator, parent);
    }

    // getters for the element with use locator
    public SelenideElement $() {
        return locatorHolder.getElement();
    }

    protected ElementsCollection $$() {
        return locatorHolder.getElements();
    }

    // verification methods for the element
    @Override
    public T shouldBeVisible() {
        this.$().shouldBe(exist);
        this.$().shouldBe(visible);
        return (T) this;
    }

    @Override
    public T shouldBeVisible(Integer timeDuration) {
        this.$().shouldBe(visible, Duration.ofSeconds(timeDuration));
        return (T) this;
    }

    @Override
    public T shouldNotBeVisible() {
        this.$().shouldNotBe(visible);
        return (T) this;
    }

    public T shouldBeEnabled() {
        this.shouldBeValid();
        return (T) this;
    }

    public T shouldNotBeEnabled() {
        this.shouldBeInvalid();
        return (T) this;
    }

    @Override
    public T shouldBeExist(Integer timeDuration) {
        this.$().shouldBe(exist, Duration.ofSeconds(timeDuration));
        return (T) this;
    }

    @Override
    public T shouldBeExist() {
        this.$().shouldBe(exist);
        return (T) this;
    }

    @Override
    public T shouldNotBeExist(Integer timeDuration) {
        this.$().shouldNotBe(exist, Duration.ofSeconds(timeDuration));
        return (T) this;
    }

    @Override
    public T shouldNotBeExist() {
        this.$().shouldNotBe(exist);
        return (T) this;
    }

    public T shouldHaveText(String text) {
        this.$().shouldBe(visible).shouldHave(Condition.text(text));
        return (T) this;
    }

    // Interactions
    public T click() {
        this.shouldBeExist();
        this.$().click();
        return (T) this;
    }

    public String text() {
        return this.$().text();
    }

    //todo me in the next iteration I will create a new class for work with a collection

    // methods for the elements collection
    public T elementsCollectionShouldHaveSizeOver(Integer quantityElements) {
        this.$$().shouldBe(sizeGreaterThan(quantityElements), Duration.ofSeconds(ConstantValues.STANDARD_DURATION));
        return (T) this;
    }

    public T elementsCollectionShouldHaveSizeLessOrEqual(Integer quantityElements) {
        this.$$().shouldBe(sizeLessThanOrEqual(quantityElements), Duration.ofSeconds(ConstantValues.STANDARD_DURATION));
        return (T) this;
    }

    public T elementsCollectionEveryElementShouldHaveText(String text) {
        this.$$().shouldHave(texts(text));
        return (T) this;
    }

    public T getElement(int index) {
        this.shouldBeVisible();
        return (T) this.$$().get(index);
    }
}