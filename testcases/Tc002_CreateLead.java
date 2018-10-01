package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class Tc002_CreateLead extends Tc001_LoginAndLogout {
	
	public void createLead() throws InterruptedException {
//		login();
		WebElement crmsfaLink = locateElement("linktext","CRM/SFA");
		click(crmsfaLink);
		WebElement createLeadLink = locateElement("linktext","Create Lead");
		click(createLeadLink);
		WebElement companyName = locateElement("id","createLeadForm_companyName");
		type(companyName, "TCS");
		WebElement firstName = locateElement("id", "createLeadForm_firstName");
		type(firstName, "Aditya");
		WebElement lastName = locateElement("id", "createLeadForm_lastName");
		type(lastName, "Ravi");
		WebElement dataSource = locateElement("id", "createLeadForm_dataSourceId");
		selectDropDownUsingText(dataSource, "Employee");
		WebElement firstLocalName = locateElement("id", "createLeadForm_firstNameLocal");
		type(firstLocalName, "Aditya");
		WebElement personalTitle = locateElement("id", "createLeadForm_personalTitle");
		type(personalTitle, "Mister");
		WebElement profileTitle = locateElement("id", "createLeadForm_generalProfTitle");
		type(profileTitle, "QA");
		WebElement annualRevenue = locateElement("id", "createLeadForm_annualRevenue");
		type(annualRevenue, "10 billion USD");
		WebElement industryId = locateElement("id", "createLeadForm_industryEnumId");
		selectDropDownUsingIndex(industryId, 5);
		WebElement ownershipId = locateElement("id", "createLeadForm_ownershipEnumId");
		selectDropDownUsingText(ownershipId, "Partnership");
		WebElement sicCode = locateElement("id", "createLeadForm_sicCode");
		type(sicCode, "12345");
		WebElement marketingCampaignId = locateElement("id", "createLeadForm_marketingCampaignId");
		selectDropDownUsingText(marketingCampaignId, "eCommerce Site Internal Campaign");
		WebElement lastLocalName = locateElement("id", "createLeadForm_lastNameLocal");
		type(lastLocalName, "Ravi");
		WebElement departmentName = locateElement("id", "createLeadForm_departmentName");
		type(departmentName, "Testing");
		WebElement numberOfEmployees = locateElement("id", "createLeadForm_numberEmployees");
		type(numberOfEmployees, "2000");
		WebElement selectCurrency = locateElement("id", "createLeadForm_currencyUomId");
		selectDropDownUsingText(selectCurrency, "USD - American Dollar");
		WebElement tickerSymbol = locateElement("id", "createLeadForm_tickerSymbol");
		type(tickerSymbol, "NSE:TCS");
		WebElement description = locateElement("id", "createLeadForm_description");
		type(description, "xyz");
		WebElement importantNote = locateElement("id", "createLeadForm_importantNote");
		type(importantNote, "Hello");
		WebElement phoneAreaCode = locateElement("id", "createLeadForm_primaryPhoneAreaCode");
		type(phoneAreaCode, "+91");
		WebElement phoneNumber = locateElement("id", "createLeadForm_primaryPhoneNumber");
		type(phoneNumber, "9003746012");
		WebElement phoneExtension = locateElement("id", "createLeadForm_primaryPhoneExtension");
		type(phoneExtension, "#333");
		WebElement primaryEmail = locateElement("id", "createLeadForm_primaryEmail");
		type(primaryEmail, "ravi981957632@gmail.com");
		WebElement webMail = locateElement("id", "createLeadForm_primaryWebUrl");
		type(webMail, "www.tcsion.com");
		WebElement phoneAskForName = locateElement("id", "createLeadForm_primaryPhoneAskForName");
		type(phoneAskForName, "Aditya");
		WebElement toName = locateElement("id", "createLeadForm_generalToName");
		type(toName, "Aditya K Ravi");
		WebElement attentionName = locateElement("id", "createLeadForm_generalAttnName");
		type(attentionName, "Aditya");
		WebElement generalAddress1 = locateElement("id", "createLeadForm_generalAddress1");
		type(generalAddress1, "E3/10, 6th Main Road");
		WebElement generalAddress2 = locateElement("id", "createLeadForm_generalAddress2");
		type(generalAddress2, "Mogappair East");
		WebElement generalCity = locateElement("id", "createLeadForm_generalCity");
		type(generalCity, "Chennai");
		WebElement selectCountry = locateElement("id", "createLeadForm_generalCountryGeoId");
		selectDropDownUsingText(selectCountry, "India");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement selectState = locateElement("id", "createLeadForm_generalStateProvinceGeoId");
		selectDropDownUsingText(selectState, "TAMILNADU");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement postalCode = locateElement("id", "createLeadForm_generalPostalCode");
		type(postalCode, "600037");
		WebElement extPostalCode = locateElement("id", "createLeadForm_generalPostalCodeExt");
		type(extPostalCode, "1234");
		WebElement submit = locateElement("class", "smallSubmit");
		click(submit);
		closeBrowser();
	}
}
