package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdmethods.SeMethods;

public class Tc001_LoginAndLogout extends SeMethods{

	@Test
	public void login() {
	startApp("chrome", "http://leaftaps.com/opentaps");
	WebElement eleUsername = locateElement("id", "username");
	type(eleUsername, "DemoSalesManager");
	WebElement elePassword = locateElement("id", "password");
	type(elePassword, "crmsfa");
	WebElement eleLogin = locateElement("class", "decorativeSubmit");
	click(eleLogin);
	}	
}







