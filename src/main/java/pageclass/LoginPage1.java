package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	WebDriver driver;
	public LoginPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

//locate the elements
	@FindBy(id = "user-name")
	WebElement username; 
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login-button")
	WebElement loginButton;

//  actions
	public void enterUserName(String un) {
		username.sendKeys(un);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);

	}

	public void clickLoginButton() {
		loginButton.click();

	}
}
