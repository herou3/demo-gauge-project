package uitests.pages.sign_in_page.components;

import lombok.Getter;
import org.openqa.selenium.By;

import uitests.models.controls.Input;
import uitests.pages.BasePage;

@Getter
public class LoginForm extends BasePage {

    private final String loginBoxXpath = ("//div[@class='login-box']");

    private final Input loginInput = new Input(By.xpath(loginBoxXpath + "//input[@id='user-name']"));
    private final Input passwordInput = new Input(By.xpath(loginBoxXpath + "//input[@id='password']"));
    private final Input loginButton = new Input(By.xpath(loginBoxXpath + "//input[@id='login-button']"));

    @Override
    public void shouldBeShown() {
        loginInput.shouldBeValid();
        passwordInput.shouldBeValid();
        loginButton.shouldBeValid();
    }


}