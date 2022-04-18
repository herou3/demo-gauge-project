package uitests.pages.sign_in_page;

import com.thoughtworks.gauge.Step;
import uitests.pages.BasePage;
import uitests.pages.sign_in_page.components.LoginForm;

public class SignInPage extends BasePage {

    private final LoginForm loginForm = new LoginForm();

    @Override
    public void shouldBeShown() {
        loginForm.shouldBeShown();
    }

    @Step("Ввод логина <login>")
    public void enterLogin(String login) {
        loginForm.getLoginInput().enterText(login);
    }

    @Step("Ввод пароля <login>")
    public void enterPassword(String password) {
        loginForm.getPasswordInput().enterText(password);
    }

    @Step("Выполнение клика по кнопки авторизации")
    public void signIn() {
        loginForm.getLoginButton().click();
    }
}
