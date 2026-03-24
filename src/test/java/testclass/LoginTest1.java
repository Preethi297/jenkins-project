package testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageclass.LoginPage1;

public class LoginTest1 {
	WebDriver driver;
	LoginPage1 loginpg; 
	@BeforeMethod
	void setup() {
		driver=new ChromeDriver();
		loginpg=new LoginPage1(driver);//create obj of page class
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		
	}
	@Test
	void validLogin() {
		loginpg.enterUserName("standard_user");
		loginpg.enterPassword("secret_sauce");
		loginpg.clickLoginButton();
	}
	@Test
	void invalidLogin() {
		loginpg.enterUserName("ammu");
		loginpg.enterPassword("secret_sauce");
		loginpg.clickLoginButton();
	}
	@Test
	void problemUser() {
		loginpg.enterUserName("problem_user");
		loginpg.enterPassword("secret_sauce");
		loginpg.clickLoginButton();
	}
	@Test
	void errorUSer() {
		loginpg.enterUserName("error_user");
		loginpg.enterPassword("secret_sauce");
		loginpg.clickLoginButton();	
	}
	@Test
	void performanceUser() {
		loginpg.enterUserName("performance_glitch_user");
		loginpg.enterPassword("secret_sauce");
		loginpg.clickLoginButton();		
	}
	@Test
	void visualUser() {
		loginpg.enterUserName("visual_user");
		loginpg.enterPassword("secret_sauce");
		loginpg.clickLoginButton();	
	}
	@Test
	void emptyUSer() {
		loginpg.enterUserName(" ");
		loginpg.enterPassword("secret_sauce");
		loginpg.clickLoginButton();		
	}
	@Test
	void emptyPwd() {
		loginpg.enterUserName("visual_user");
		loginpg.enterPassword("");
		loginpg.clickLoginButton();	
	}
	@Test
	void clickLoginBtn() {
		loginpg.clickLoginButton();	
	}
	@AfterMethod
	void tearDown() {
		if(driver!=null) {
		driver.quit();
		}
	}
}
