package pageclass;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
WebDriver driver;
public CartPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id="checkout")
WebElement clickCheckoutBtn;
@FindBy(id="remove-sauce-labs-backpack")
WebElement removeItem;

//actions
public void clickCheckout() {
	clickCheckoutBtn.click();
}
public void removeProduct() {
	removeItem.click();
}
}
