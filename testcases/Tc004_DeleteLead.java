package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class Tc004_DeleteLead extends Tc001_LoginAndLogout{

	public void deleteLead() throws InterruptedException {

		WebElement crmsfaLink = locateElement("linktext","CRM/SFA");
		click(crmsfaLink);
		WebElement leadsLink = locateElement("linktext", "Leads");
		click(leadsLink);
		WebElement findLeads = locateElement("linktext", "Find Leads");
		click(findLeads);
		
		WebElement phoneNumberTab = locateElement("xpath", "//span[text( )='Phone']");
		click(phoneNumberTab);
		WebElement phoneNumber = locateElement("name", "phoneNumber");
		type(phoneNumber, "9003746012");
		WebElement buttonFindLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(buttonFindLead);
		Thread.sleep(3000);

		WebElement firstResult = locateElement("xpath", "//table[@class='x-grid3-row-table']/tbody/tr/td[1]");
		String storeResultLink = getText(firstResult);
		WebElement firstResultLink = locateElement("linktext", storeResultLink);
		click(firstResultLink);
		Thread.sleep(3000);
		WebElement deleteButton = locateElement("linktext", "Delete");
		click(deleteButton);
		Thread.sleep(3000);

		//click(findLeads);
		click(locateElement("linktext", "Find Leads"));
		WebElement leadId = locateElement("name", "id");
		type(leadId, storeResultLink);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(3000);
		WebElement noRecords = locateElement("class", "x-paging-info");
		verifyExactText(noRecords, "No records to display");
		closeBrowser();
	}
}
