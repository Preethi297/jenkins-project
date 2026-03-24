package hybridframework;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hybridframe.LoginPage2;


public class LoginTest2 {
WebDriver driver;
LoginPage2 loginpg;
String testresult;
String validate() {
	try {
		driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']"));
		testresult = "success";
	} catch (Exception e) {
		// TODO: handle exception
		testresult = "failed";
	}
	return testresult;
}
@DataProvider(name="credentials")
public Object[][] data() throws IOException {
try(FileInputStream fs=new FileInputStream("C:/Users/ammu9/Downloads/data.xlsx");//"data.xlsx" is file name with extension
 XSSFWorkbook book = new XSSFWorkbook(fs)){//apache poi workbook class to access excel
 XSSFSheet sheet= book.getSheet("Sheet2");
int totalrows = sheet.getPhysicalNumberOfRows();//total rows
int totalcolumns = sheet.getRow(0).getPhysicalNumberOfCells();//total columns
   //2D object array
Object[][]obj=new Object[totalrows-1][totalcolumns]; // totalrows-1 is in excel sheet first row is heading to remove this we use -1
//storing values inside 2D array
for(int i=1;i<totalrows;i++) {
	XSSFRow row=sheet.getRow(i);
	for(int j=0;j<totalcolumns;j++) {
		obj[i-1][j]=row.getCell(j).toString();
	}
}
return obj;
}
}

@BeforeMethod
void setup() {
	driver=new ChromeDriver();
	loginpg=new LoginPage2(driver);//create obj of page class
	driver.get("https://www.saucedemo.com");
	driver.manage().window().maximize();
	
}
@Test(dataProvider =" credentials")
void validLogin(String username, String password) {
	loginpg.enterUserName(username);
	loginpg.enterPassword(password);
	loginpg.clickLoginButton();
	String result="success";
	Assert.assertEquals(validate(), result);

}
@AfterMethod
void tearDown() {
	if(driver!=null) {
		driver.quit();
	}
}
}
