package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class Tc005_DuplicateLead extends Tc001_LoginAndLogout {

	public void duplicateLead() throws InterruptedException {
		WebElement crmsfaLink = locateElement("linktext","CRM/SFA");
		click(crmsfaLink);
		WebElement leadsLink = locateElement("linktext", "Leads");
		click(leadsLink);
		WebElement findLeads = locateElement("linktext", "Find Leads");
		click(findLeads);
		
		WebElement locateEmailTab = locateElement("xpath", "//span[text( )='Email']");
		click(locateEmailTab);
		WebElement emailTextBox = locateElement("name", "emailAddress");
		type(emailTextBox, "ravi981957632@gmail.com");
		WebElement buttonFindLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(buttonFindLead);
		Thread.sleep(3000);
		
		WebElement firstNameLink = locateElement("xpath", "//table[@class='x-grid3-row-table']/tbody/tr/td[3]");
		String firstName = getText(firstNameLink);
		WebElement firstResultLink = locateElement("linktext", firstName);
		click(firstResultLink);
		Thread.sleep(3000);
		WebElement duplicateLead = locateElement("linktext", "Duplicate Lead");
		click(duplicateLead);
		verifyTitle("Duplicate Lead | opentaps CRM");
		WebElement submitClick = locateElement("class", "smallSubmit");
		click(submitClick);
		WebElement duplicateName = locateElement("viewLead_firstName_sp");
		verifyExactText(duplicateName, firstName);
		closeBrowser();
	}
}
