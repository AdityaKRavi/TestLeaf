package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class Tc003_EditLead extends Tc001_LoginAndLogout {

	public void editLead() throws InterruptedException {
		/*
		 * Navigate to FindLeads
		 */
		WebElement crmsfaLink = locateElement("linktext","CRM/SFA");
		click(crmsfaLink);
		WebElement leadsLink = locateElement("linktext", "Leads");
		click(leadsLink);
		WebElement findLeads = locateElement("linktext", "Find Leads");
		click(findLeads);
		/*
		 * Find lead based on first Name 
		 */
		WebElement firstName = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(firstName, "Aditya");
		WebElement buttonFindLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(buttonFindLead);
		Thread.sleep(3000);
		/*
		 * Click the first Result and verify the title
		 */
		WebElement firstResult = locateElement("xpath", "//table[@class='x-grid3-row-table']/tbody/tr/td[1]");
		String storeResultLink = getText(firstResult);
		WebElement firstResultLink = locateElement("linktext", storeResultLink);
		click(firstResultLink);
		verifyTitle("View Lead | opentaps CRM");
		/*
		 * Edit the company Name and verify the changed company name
		 */
		WebElement editLead = locateElement("linktext", "Edit");
		click(editLead);
		WebElement editCompanyName = locateElement("updateLeadForm_companyName");
		editCompanyName.clear();
		type(editCompanyName, "Testleaf");
		WebElement submitButton = locateElement("xpath", "//input[@type='submit']");
		click(submitButton);
		WebElement viewNewCompanyName = locateElement("viewLead_companyName_sp");
		verifyPartialText(viewNewCompanyName, "TestLeaf");
		closeBrowser();
	}
}
