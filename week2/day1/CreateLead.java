package week2.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public void main() throws InterruptedException, IOException  {

		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		//Browser Module
		ChromeDriver driver = new ChromeDriver();	//open browser which is empty
		driver.manage().window().maximize(); 		//maximize the browser
		driver.get("http://leaftaps.com/opentaps");	//get the url and enter

		//Login Module
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();


		driver.findElementByLinkText("CRM/SFA").click();

		//Create Lead Module
		driver.findElementByLinkText("Create Lead").click();
		//driver.manage().wait(1000);
		driver.findElementById("createLeadForm_companyName").sendKeys("HCL Tech");
		driver.findElementById("createLeadForm_firstName").sendKeys("Aditya");
		driver.findElementById("createLeadForm_lastName").sendKeys("Ravi");
		
		Select dataSource = new Select(driver.findElementById("createLeadForm_dataSourceId"));
		dataSource.selectByVisibleText("Employee");

		//driver.findElementById("createLeadForm_dataSourceId").sendKeys("Employee");
		driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Aditya");
		driver.findElementById("createLeadForm_personalTitle").sendKeys("Mister");
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("QA");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("9 Billion USD");
		Select industry = new Select(driver.findElementById("createLeadForm_industryEnumId"));
		
		List <WebElement> allOptions =  industry.getOptions();
		int allOptionsSize = allOptions.size();
		for(int i=0; i<allOptionsSize; i++) {
			if(i == allOptionsSize - 1) {
				//System.out.println(allOptions.get(i).getText());
				industry.selectByIndex(i);
				break;
			}
		}

		//driver.findElementById("createLeadForm_industryEnumId").sendKeys("Computer Software");
		Select ownerShip = new Select(driver.findElementById("createLeadForm_ownershipEnumId"));
		ownerShip.selectByVisibleText("Partnership");

		//	driver.findElementById("createLeadForm_ownershipEnumId").sendKeys("Partnership");
		driver.findElementById("createLeadForm_sicCode").sendKeys("561421");

		Select marketingCampaign = new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
		marketingCampaign.selectByValue("DEMO_MKTG_CAMP");

		//	driver.findElementById("createLeadForm_marketingCampaignId").sendKeys("Demo Marketing Campaign");
		driver.findElementById("createLeadForm_lastNameLocal").sendKeys("Ravi");
		driver.findElementById("createLeadForm_departmentName").sendKeys("Testing");
		driver.findElementById("createLeadForm_numberEmployees").sendKeys("10000");
		Select currency = new Select(driver.findElementById("createLeadForm_currencyUomId"));
		currency.selectByVisibleText("USD - American Dollar");
		//driver.findElementById("createLeadForm_currencyUomId").sendKeys("USD - American Dollar");

		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("NSE: HCLTECH");
		driver.findElementById("createLeadForm_description").sendKeys("XYZ");
		driver.findElementById("createLeadForm_importantNote").sendKeys("Hello");
		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("+91");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9003746012");
		driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("#333");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("ravi981957632@gmail.com");
		driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("www.hcltech.com");
		driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("Aditya");
		driver.findElementById("createLeadForm_generalToName").sendKeys("Aditya K Ravi");
		driver.findElementById("createLeadForm_generalAttnName").sendKeys("Aditya");
		driver.findElementById("createLeadForm_generalAddress1").sendKeys("E3/10, 6th Main Road");
		driver.findElementById("createLeadForm_generalAddress2").sendKeys("Mogappair East");
		driver.findElementById("createLeadForm_generalCity").sendKeys("Chennai");

		Select country = new Select(driver.findElementById("createLeadForm_generalCountryGeoId"));
		country.selectByVisibleText("India");
		Thread.sleep(3000);
		//driver.findElementById("createLeadForm_generalCountryGeoId").sendKeys("India");
		Select state = new Select(driver.findElementById("createLeadForm_generalStateProvinceGeoId"));
		state.selectByVisibleText("TAMILNADU");
		Thread.sleep(3000);
		//driver.findElementById("createLeadForm_generalStateProvinceGeoId").sendKeys("TAMILNADU");
		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("600037");
		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("1234");
		driver.findElementByClassName("smallSubmit").click();

		//Take Snapshot
//		File screenShot = driver.getScreenshotAs(OutputType.FILE); 
		//the above code takes the screenshot and saves it into a temporary variable
		//it will be deleted once the JVM exits so we need to copy it to permanent location
//		FileUtils.copyFile(screenShot, new File("./snaps/img.jpeg"));
		driver.close();
		
	}

}
