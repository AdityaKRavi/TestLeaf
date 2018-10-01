package week2.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {
	public static void main(String[] args) throws InterruptedException {
		//login
	ChromeDriver chrome = new ChromeDriver();
	chrome.get("http://leaftaps.com/opentaps");
	chrome.manage().window().maximize();
	chrome.findElementById("username").sendKeys("DemoSalesManager");
	chrome.findElementById("password").sendKeys("crmsfa");
	chrome.findElementByClassName("decorativeSubmit").click();

	chrome.findElementByLinkText("CRM/SFA").click();
	chrome.findElementByLinkText("Leads").click();
	chrome.findElementByLinkText("Merge Leads").click();
	chrome.findElementByXPath("//table[@class='twoColumnForm']//img").click();
	Set<String> windowHandle = chrome.getWindowHandles();
	List<String> allWindows = new ArrayList<String>();
	allWindows.addAll(windowHandle);
	
	chrome.switchTo().window(allWindows.get(1));
	chrome.findElementByXPath("//input[@name='firstName']").sendKeys("Aditya");
	chrome.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(3000);
	WebElement LeadId = chrome.findElementByXPath("(//div[@class='x-grid3-scroller']//a)[1]");
	String fromLeadId = LeadId.getText();
	LeadId.click();
	
	chrome.switchTo().window(allWindows.get(0));
	chrome.findElementByXPath("(//table[@class='twoColumnForm']//img)[2]").click();
	windowHandle=chrome.getWindowHandles();
	allWindows.clear();
	allWindows.addAll(windowHandle);
//	System.out.println(windowHandle.size());
	chrome.switchTo().window(allWindows.get(1));
	chrome.findElementByXPath("//input[@name='firstName']").sendKeys("Aditya");
	chrome.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(3000);
	LeadId=chrome.findElementByXPath("(//div[@class='x-grid3-scroller']//table)[2]//a");
	LeadId.click();
	chrome.switchTo().window(allWindows.get(0));
	chrome.findElementByLinkText("Merge").click();
	chrome.switchTo().alert().accept();
	chrome.findElementByLinkText("Find Leads").click();
	chrome.findElementByName("id").sendKeys(fromLeadId);
	chrome.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(3000);
	String text = chrome.findElementByClassName("x-paging-info").getText();
	if(text.equals("No records to display")) 
		System.out.println("No records found");
	else
		System.out.println("Records not deleted");
	}
}
