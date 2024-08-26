package Page;

import Common.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class RegisterPage extends BaseTest {
    WebElement lblRegister = driver.findElement(By.xpath("//h1[text()='Register']"));
    WebElement rdoGenderMale = driver.findElement(By.id("gender-female"));
    WebElement txtFirstName = driver.findElement(By.id("FirstName"));
    WebElement txtLastName = driver.findElement(By.id("LastName"));
    WebElement txtEmail = driver.findElement(By.id("Email"));
    WebElement txtPassword = driver.findElement(By.id("Password"));
    WebElement txtConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
    WebElement btnRegister = driver.findElement(By.id("register-button"));

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String getTextLblRegister(){
        return lblRegister.getText();
    }
    public void selectGender(){
        rdoGenderMale.click();
    }
    public void clickRegisterBtn(){
        btnRegister.click();
    }

    public void inputRegisterInfors(String firstName, String lastName, String email,String password, String confirmPassword){
        txtFirstName.click();
        txtFirstName.sendKeys(firstName);
        txtLastName.click();
        txtLastName.sendKeys(lastName);
        txtEmail.click();
        txtEmail.sendKeys(email);
        txtPassword.click();
        txtPassword.sendKeys(password);
        txtConfirmPassword.click();
        txtConfirmPassword.sendKeys(confirmPassword);

    }



}

