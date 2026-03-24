package testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageclass.CartPage;
import pageclass.LoginPage1;
import pageclass.ProductPage;

public class CartTest {
WebDriver driver;
LoginPage1 loginpg;
ProductPage productpg;
CartPage cartpg;

@BeforeMethod
void setup() {
	driver=new ChromeDriver();
	loginpg=new LoginPage1(driver);
	productpg=new ProductPage(driver);
	cartpg=new CartPage(driver);
	
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	// login
		loginpg.enterUserName("standard_user");
		loginpg.enterPassword("secret_sauce");
		loginpg.clickLoginButton();
		productpg.addItemt();
		productpg.openCart();
		
		}
@Test
void cartPage() {
	cartpg.clickCheckout();
}
@Test
void removeItem() {
	cartpg.removeProduct();
}
@Test
void clickCheckout() {
	cartpg.clickCheckout();
}
@Test
void verifyRemoveBtn() {
	cartpg.removeProduct();
}
@Test
void verifyCheckout() {
	cartpg.clickCheckout();
}
@AfterMethod
void tearDown() {
	driver.quit();
}
}
