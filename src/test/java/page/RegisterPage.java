package page;

import common.BaseTest;
import org.openqa.selenium.*;

public class RegisterPage  {
    WebDriver driver;

   public void setWebDriver (WebDriver driver) {
       this.driver = driver;
   }
    public String getTextLblRegister(){
         WebElement lblRegister = driver.findElement(By.xpath("//h1[text()='Register']"));
        return lblRegister.getText();
        // Add test git 1
    }
    public void selectGender(){
        WebElement rdoGenderMale = driver.findElement(By.id("gender-female"));
        rdoGenderMale.click();
    }
    public void clickRegisterBtn(){
        WebElement btnRegister = driver.findElement(By.id("register-button"));
        btnRegister.click();
    }

    public void inputRegisterInfors(String firstName, String lastName, String email,String password, String confirmPassword){
        WebElement txtFirstName = driver.findElement(By.id("FirstName"));
        txtFirstName.click();
        txtFirstName.sendKeys(firstName);
        WebElement txtLastName = driver.findElement(By.id("LastName"));
        txtLastName.click();
        txtLastName.sendKeys(lastName);
        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.click();
        txtEmail.sendKeys(email);
        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.click();
        txtPassword.sendKeys(password);
        WebElement txtConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        txtConfirmPassword.click();
        txtConfirmPassword.sendKeys(confirmPassword);

    }



}

