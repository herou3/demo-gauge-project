package uitests.utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import lombok.val;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class SelectorsUtils {

    public static void clearInputElement(SelenideElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public static void clearAllTextInInputableElement(SelenideElement element) {
        while (!Objects.requireNonNull(element.getValue()).equals("")) {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    public static String getElementXpath(WebElement element) {
        val driver = WebDriverRunner.getWebDriver();
        String result = (String) ((JavascriptExecutor) driver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
        result = result.replaceAll("id\\(\"app\"\\)\\/", "");
        return "//*/" + result;
    }
}