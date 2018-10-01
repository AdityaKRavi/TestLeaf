package week1.day4.hw;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver chrome =new ChromeDriver();
		chrome.manage().window().maximize();
		
		chrome.get("http://leaftaps.com/opentaps");
		chrome.findElementById("username").sendKeys("DemoSalesManager");
		chrome.findElementById("password").sendKeys("crmsfa");
		chrome.findElementByClassName("decorativeSubmit").click();
		
		chrome.findElementByLinkText("CRM/SFA").click();
		chrome.findElementByLinkText("Leads").click();
		chrome.findElementByLinkText("Find Leads").click();
		
		chrome.findElementByXPath("//span[text( )='Phone']").click();
		chrome.findElementByName("phoneNumber").sendKeys("9003746012");
		chrome.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		try {
		String myId = (chrome.findElementByXPath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]").getText());
//		String myId = chrome.findElementByLinkText("10035").getText();
		chrome.findElementByLinkText(myId).click();
		Thread.sleep(3000);
		chrome.findElementByLinkText("Delete").click();
		Thread.sleep(3000);
		chrome.findElementByLinkText("Find Leads").click();
		chrome.findElementByName("id").sendKeys(myId);
		chrome.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		String text = chrome.findElementByClassName("x-paging-info").getText();
		if(text.equals("No records to display")) 
			System.out.println("No records found");
		else
			System.out.println("Records not deleted");
		}
		catch(NoSuchElementException e) {
			System.out.println("Records already deleted");
		}
		chrome.close();	
	}
}