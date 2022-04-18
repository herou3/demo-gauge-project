package uitests.utils;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;

import static uitests.assistants.CommonLocators.DIV_INVALID_XPATH;
import static uitests.assistants.CommonLocators.QUANTITY_INVALID_ELEMENTS_XPATH;

public class CustomCondition {

    private static int currentInvalidElements;

    public static Condition valid() {
        //noinspection NullableProblems
        return new Condition("Invalid " + QUANTITY_INVALID_ELEMENTS_XPATH + " not found") {
            @Nonnull
            @Override
            public CheckResult check(Driver driver,
                                     WebElement element) {
                if (getSizeOfElementsWithInvalidAttribute(element) == 0) {
                    return new CheckResult(CheckResult.Verdict.ACCEPT, currentInvalidElements);
                } else {
                    return new CheckResult(CheckResult.Verdict.REJECT, currentInvalidElements);
                }
            }
        };
    }

    public static Condition invalid() {
        //noinspection NullableProblems
        return new Condition("Invalid " + QUANTITY_INVALID_ELEMENTS_XPATH + " was found") {
            @Nonnull
            @Override
            public CheckResult check(Driver driver,
                                     WebElement element) {
                if (getSizeOfElementsWithInvalidAttribute(element) > 0) {
                    return new CheckResult(CheckResult.Verdict.ACCEPT, currentInvalidElements);
                } else {
                    return new CheckResult(CheckResult.Verdict.REJECT, currentInvalidElements);
                }
            }
        };
    }

    public static Condition marked() {
        //noinspection NullableProblems
        return new Condition("Invalid " + DIV_INVALID_XPATH + " was found") {
            @Nonnull
            @Override
            public CheckResult check(Driver driver,
                                     WebElement element) {
                if (getSizeOfElementsWithHaveErrorMarked(element) > 0) {
                    return new CheckResult(CheckResult.Verdict.ACCEPT, currentInvalidElements);
                } else {
                    return new CheckResult(CheckResult.Verdict.REJECT, currentInvalidElements);
                }
            }
        };
    }

    // Methods for check to contain attribute of errors
    public static int getSizeOfElementsWithInvalidAttribute(WebElement webElement) {
        currentInvalidElements = webElement.findElements(By.xpath(QUANTITY_INVALID_ELEMENTS_XPATH)).size();
        return currentInvalidElements;
    }

    public static int getSizeOfElementsWithHaveErrorMarked(WebElement webElement) {
        currentInvalidElements = webElement.findElements(By.xpath(DIV_INVALID_XPATH)).size();
        return currentInvalidElements;
    }
}