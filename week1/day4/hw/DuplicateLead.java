package week1.day4.hw;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("http://leaftaps.com/opentaps");
		
		chromeDriver.findElementById("username").sendKeys("DemoSalesManager");
		chromeDriver.findElementById("password").sendKeys("crmsfa");
		chromeDriver.findElementByClassName("decorativeSubmit").click();

		chromeDriver.findElementByLinkText("CRM/SFA").click();
		chromeDriver.findElementByLinkText("Leads").click();
		chromeDriver.findElementByLinkText("Find Leads").click();
		
		chromeDriver.findElementByXPath("//span[text( )='Email']").click();
		chromeDriver.findElementByName("emailAddress").sendKeys("ravi981957632@gmail.com");
		chromeDriver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		try {
		String firstName =chromeDriver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody/tr/td[3]").getText();
		
		chromeDriver.findElementByLinkText(firstName).click();
		chromeDriver.findElementByLinkText("Duplicate Lead").click();
		if((chromeDriver.getTitle()).equals("Duplicate Lead | opentaps CRM"))
				System.out.println("Duplicate Lead Page");
		else
			System.out.println("Not a Duplicate Lead page");
		
		chromeDriver.findElementByClassName("smallSubmit").click();
		
		String duplicateName = chromeDriver.findElementById("viewLead_firstName_sp").getText();
		if(firstName.equals(duplicateName))
			System.out.println("The names are same");
		else
			System.out.println("The names are different");
		}catch(Exception e) {
			System.out.println("No records available");
		}
		chromeDriver.close();
	}
}
