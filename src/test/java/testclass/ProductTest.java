package testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageclass.LoginPage1;
import pageclass.ProductPage;

public class ProductTest {
WebDriver driver;
LoginPage1 loginpg;
ProductPage productpg;

@BeforeMethod
void setup() {
	driver=new ChromeDriver();
	loginpg=new LoginPage1(driver);
	productpg=new ProductPage(driver);
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	// login
	loginpg.enterUserName("standard_user");
	loginpg.enterPassword("secret_sauce");
	loginpg.clickLoginButton();
	
}
@Test
void clickOnMenu() {
	productpg.clickMenu();
}
@Test
void selectProduct() {
	productpg.selectBackPackProduct();
	
}
@Test
void addItemToCart() {
	productpg.addItemt();
}
@Test
void openCartICon() {
	productpg.openCart();
}
@AfterMethod
void tearDown() {
	driver.quit();
}
}
