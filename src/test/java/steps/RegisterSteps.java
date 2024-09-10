package steps;

import common.BaseTest;
import page.RegisterPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class RegisterSteps  {
    RegisterPage registerPage;

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
