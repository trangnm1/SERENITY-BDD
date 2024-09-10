package defs;

import common.BaseTest;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import page.RegisterPage;
import steps.RegisterSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;

public class RegisterDefs extends BaseTest{
    BaseTest baseTest = new BaseTest();
    RegisterSteps registerSteps = new RegisterSteps();
//    WebElement virtualGiftItem = baseTest.getDriver().findElement(By.cssSelector("div.picture>a[href='/25-virtual-gift-card']"));
//    WebElement laptopItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/141-inch-laptop']"));
//    WebElement cheapComputerItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/build-your-cheap-own-computer']"));
//    WebElement ownComputerItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/build-your-own-computer']"));
//    WebElement expensiveComputerItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/build-your-own-expensive-computer-2']"));
//    WebElement simpleComputerItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/simple-computer']"));
//    WebElement titleDetailProductActual = baseTest.getDriver().findElement(By.className("product-name"));
//    WebElement computerMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/computers'"));
//    WebElement bookMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/books'"));
//    WebElement electronicMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/electronics'"));
//    WebElement shoeMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/apparel-shoes'"));
//    WebElement digitalMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/digital-downloads'"));
//    WebElement jewelryMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/jewelry'"));
//    WebElement giftMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/gift-cards'"));


    @Given("I open the browser")
    public void iOpenTheBrowser() {
        baseTest.openBrowser();
    }
    @When("I click register button")
    public void iClickRegisterButton() {
//        registerSteps.clickRegisterBtn();

        WebElement btnRegister = baseTest.getDriver().findElement(By.id("register-button"));
        btnRegister.click();
    }
    @When("I select gender")
    public void iSelectGender(){
        WebElement rdoGenderMale = baseTest.getDriver().findElement(By.id("gender-female"));
        rdoGenderMale.click();
    }


    @When("I am on the Register screen")
    public void iAmOnTheRegisterScreen(){
     String registerTitle = "Register";
     WebElement lblRegister = baseTest.getDriver().findElement(By.xpath("//h1[text()='Register']"));
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

            RegisterPage registerPage = new RegisterPage();
            registerPage.setWebDriver(baseTest.getDriver());
            registerSteps.setRegisterPage(registerPage);
            registerSteps.inputRegisterInfors(firstname, lastname, email, password, confirmpassword);
        }
    }
    @Then("I am on the Dashboard screen")
    public void iAmOnTheDashboardScreen() {
        baseTest.closeBrowser();
    }

    @When("I scroll to the Featured products")
    public void iScrollToTheFeaturedProducts() {
        WebElement toElement = baseTest.getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[1]/strong"));
        baseTest.scrollToElement(toElement);

    }

    @When("Feature products is displaying correctly")
    public void featureProductsIsDisplayingCorrectly() {
        WebElement virtualGiftItem = baseTest.getDriver().findElement(By.cssSelector("div.picture>a[href='/25-virtual-gift-card']"));
        WebElement laptopItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/141-inch-laptop']"));
        WebElement cheapComputerItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/build-your-cheap-own-computer']"));
        WebElement ownComputerItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/build-your-own-computer']"));
        WebElement expensiveComputerItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/build-your-own-expensive-computer-2']"));
        WebElement simpleComputerItem = baseTest.getDriver().findElement(By.cssSelector("h2.product-title>a[href='/simple-computer']"));

        List<String> productListActual = new ArrayList<>();
        productListActual.add(String.valueOf(virtualGiftItem));
        productListActual.add(String.valueOf(laptopItem));
        productListActual.add(String.valueOf(cheapComputerItem));
        productListActual.add(String.valueOf(ownComputerItem));
        productListActual.add(String.valueOf(expensiveComputerItem));
        productListActual.add(String.valueOf(simpleComputerItem));

        List<String> productListExpect = new ArrayList<>();
        productListExpect.add("$25 Virtual Gift Card");
        productListExpect.add("14.1-inch Laptop");
        productListExpect.add("Build your own cheap computer");
        productListExpect.add("Build your own computer");
        productListExpect.add("Build your own expensive computer");
        productListExpect.add("Simple Computer");

       productListActual.equals(productListExpect);
    }

    @When("I click on the a product")
    public void iClickOnTheAProduct() {
        WebElement virtualGiftItem = baseTest.getDriver().findElement(By.cssSelector("div.picture>a[href='/25-virtual-gift-card']"));
        virtualGiftItem.click();
    }

    @Then("I go to the product detail screen")
    public void iGoToTheProductDetailScreen() {
        WebElement titleDetailProductActual = baseTest.getDriver().findElement(By.className("product-name"));
        WebElement virtualGiftItem = baseTest.getDriver().findElement(By.cssSelector("div.picture>a[href='/25-virtual-gift-card']"));
        titleDetailProductActual.equals(virtualGiftItem.getText());

    }

    @When("Menu categories is displaying correctly")
    public void menuCategoriesIsDisplayingCorrectly() {
            WebElement computerMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/computers'"));
    WebElement bookMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/books'"));
    WebElement electronicMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/electronics'"));
    WebElement shoeMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/apparel-shoes'"));
    WebElement digitalMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/digital-downloads'"));
    WebElement jewelryMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/jewelry'"));
    WebElement giftMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/gift-cards'"));

        List<String> menuCategoriesActual = new ArrayList<>();
        menuCategoriesActual.add(String.valueOf(bookMenu));
        menuCategoriesActual.add(String.valueOf(computerMenu));
        menuCategoriesActual.add(String.valueOf(shoeMenu));
        menuCategoriesActual.add(String.valueOf(giftMenu));
        menuCategoriesActual.add(String.valueOf(digitalMenu));
        menuCategoriesActual.add(String.valueOf(electronicMenu));
        menuCategoriesActual.add(String.valueOf(jewelryMenu));

        List<String> menuCategoriesExpect = new ArrayList<>();
        menuCategoriesExpect.add("Books");
        menuCategoriesExpect.add("Computers");
        menuCategoriesExpect.add("Electronics");
        menuCategoriesExpect.add("Apparel & Shoes");
        menuCategoriesExpect.add("Digital downloads");
        menuCategoriesExpect.add("Jewelry");
        menuCategoriesExpect.add("Gift Cards");

        menuCategoriesActual.equals(menuCategoriesExpect);
    }

    @And("I click on the a menu")
    public void iClickOnTheAMenu() {
        WebElement computerMenu = baseTest.getDriver().findElement(By.cssSelector("ul.mob-top-menu li>a[href = '/computers'"));
        computerMenu.click();

    }
//
//    @Then("Menu items displaying correctly")
//    public void menuItemsDisplayingCorrectly() {
//    }
}
