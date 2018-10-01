package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class Tc006_MergeLead extends Tc001_LoginAndLogout{
	public void mergeLead() throws InterruptedException {

		WebElement crmsfaLink = locateElement("linktext","CRM/SFA");
		click(crmsfaLink);
		WebElement leadsLink = locateElement("linktext", "Leads");
		click(leadsLink);
		WebElement mergeLeadLink = locateElement("linktext", "Merge Leads");
		click(mergeLeadLink);

		WebElement fromLeadIcon = locateElement("xpath", "//table[@class='twoColumnForm']//img");
		click(fromLeadIcon);
		switchToWindow(1);
		WebElement firstNameBox = locateElement("xpath", "//input[@name='firstName']");
		type(firstNameBox, "Aditya");
		WebElement buttonFindLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(buttonFindLead);
		Thread.sleep(3000);
		WebElement leadId = locateElement("xpath", "(//div[@class='x-grid3-scroller']//a)[1]");
		String fromLeadId = getText(leadId);
		click(leadId);
		switchToWindow(0);

		WebElement toLeadIcon = locateElement("xpath", "(//table[@class='twoColumnForm']//img)[2]");
		click(toLeadIcon);
		switchToWindow(1);
		firstNameBox = locateElement("xpath", "//input[@name='firstName']");
		type(firstNameBox, "Aditya");
		buttonFindLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(buttonFindLead);
		Thread.sleep(3000);
		leadId = locateElement("xpath", "(//div[@class='x-grid3-scroller']//table)[2]//a");
		click(leadId);
		switchToWindow(0);
		WebElement mergeLink = locateElement("linktext", "Merge");
		click(mergeLink);
		acceptAlert();
		WebElement findLeads = locateElement("linktext", "Find Leads");
		click(findLeads);
		WebElement leadIdBox = locateElement("name", "id");
		type(leadIdBox, fromLeadId);
		buttonFindLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(buttonFindLead);
		Thread.sleep(3000);
		WebElement noRecords = locateElement("class", "x-paging-info");
		verifyExactText(noRecords, "No records to display");
		closeBrowser();
	}
}
