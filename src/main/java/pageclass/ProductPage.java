package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
WebDriver driver;
public ProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id="react-burger-menu-btn")
WebElement menu;
//@FindBy(css=".app_logo")
//WebElement pageTitle;
@FindBy(xpath="//div[.='Sauce Labs Backpack']")
WebElement selectProduct;
@FindBy(id="add-to-cart-sauce-labs-backpack")
WebElement addToCart;
@FindBy(className ="shopping_cart_link")
WebElement clickCartIcon;
//actions
public void clickMenu() {
	menu.click();
}
//public void verifyTitle() {
//	pageTitle.isDisplayed();
//}
public void selectBackPackProduct() {
	selectProduct.click();
}
public void addItemt() {
	addToCart.click();
}
public void openCart() {
	clickCartIcon.click();
}
}
