package Defs;

import Common.BaseTest;
import Page.RegisterPage;
import Steps.RegisterSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class RegisterDefs extends BaseTest {

    public RegisterDefs(WebDriver driver) {
        super(driver);
    }
    RegisterSteps registerSteps = new RegisterSteps(driver);

    WebElement lblRegister = driver.findElement(By.xpath("//h1[text()='Register']"));
    WebElement rdoGenderMale = driver.findElement(By.id("gender-female"));

    WebElement btnRegister = driver.findElement(By.id("register-button"));
//    @Steps
//    RegisterSteps registerSteps = new RegisterSteps(driver);

    @Given("I open the browser")
    public void iOpenTheBrowser() {
        openBrowser();
    }
    @When("I click register button")
    public void iClickRegisterButton() {
//        registerSteps.clickRegisterBtn();
        btnRegister.click();

    }
    @When("I select gender")
    public void iSelectGender(){
        rdoGenderMale.click();
    }


    @When("I am on the Register screen")
    public void iAmOnTheRegisterScreen(){
        String registerTitle = "Register";
        registerTitle.equals(lblRegister.getText());
    }

    @When("I input register information")
    public void iInputRegisterInformation(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        for(Map<String, String>row:data){
            String firstname = row.get("firstname");
            String lastname = row.get("lastname");
            String email = row.get("email");
            String password = row.get("password");
            String confirmpassword = row.get("confirmpassword");
            registerSteps.inputRegisterInfors(firstname, lastname, email, password, confirmpassword);
        }
    }
    @Then("I am on the Dashboard screen")
    public void iAmOnTheDashboardScreen() {

    }

}
