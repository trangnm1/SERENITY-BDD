package Steps;

import Common.BaseTest;
import Page.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

public class RegisterSteps extends BaseTest {

    RegisterPage registerPage = new RegisterPage(driver);

    public RegisterSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public void checkLblRegister(){
        String registerTitle = "Register";
        registerTitle.equals(registerPage.getTextLblRegister());
    }
    @Step
    public void selectGender(){
        registerPage.selectGender();
    }
    @Step
    public void clickRegisterBtn(){
        registerPage.clickRegisterBtn();
    }
    @Step
    public void inputRegisterInfors(String firstName, String lastName, String email,String password, String confirmPassword) {
        registerPage.inputRegisterInfors(firstName, lastName, email, password, confirmPassword);
    }

    @Step
    public void setRegisterPage(RegisterPage registerPage) {
        this.registerPage = registerPage;
    }
}
