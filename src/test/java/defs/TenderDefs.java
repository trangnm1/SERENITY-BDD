package defs;

import common.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TenderDefs extends BaseTest {
    BaseTest baseTest = new BaseTest();

    WebElement btnSignIn = baseTest.getDriver().findElement(By.xpath("//h6[text()='Sign in'])"));
    WebElement loginLbl = baseTest.getDriver().findElement(By.xpath("//h3[text() = 'Welcome back!']"));
    WebElement emailTxt = baseTest.getDriver().findElement(By.xpath("div>input[placeholder='Email Address']"));
    WebElement passwordTxt = baseTest.getDriver().findElement(By.xpath("span>input[type='password']"));
    WebElement submitBtn = baseTest.getDriver().findElement(By.xpath("div>button[type='submit']"));

    @When("I click on Signin button")
    public void iClickOnSigninButton() {
        btnSignIn.click();
    }

    @When("The login screen is displaying")
    public void theLoginScreenIsDisplaying() {
        loginLbl.getText().equals("Welcome back!");
    }

    @And("I input <{string}> and <{string}>")
    public void iInputAnd(String email, String password) {
        emailTxt.click();
        emailTxt.sendKeys(email);
        passwordTxt.click();
        passwordTxt.sendKeys(password);
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        submitBtn.click();
    }

}
