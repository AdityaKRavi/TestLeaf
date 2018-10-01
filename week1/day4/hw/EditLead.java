package week1.day4.hw;

//import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Login Steps
		ChromeDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get("http://leaftaps.com/opentaps");
		webDriver.findElementById("username").sendKeys("DemoSalesManager");
		webDriver.findElementById("password").sendKeys("crmsfa");
		webDriver.findElementByClassName("decorativeSubmit").click();

		//Click crm/sfa link
		webDriver.findElementByLinkText("CRM/SFA").click();
		//Click Leads link
		webDriver.findElementByLinkText("Leads").click();
		//Click Find leads
		webDriver.findElementByLinkText("Find Leads").click();
		//Enter first name
		webDriver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Aditya");
		//webDriver.findElementByLinkText("Find Leads").click();

		// Here the FindLeads is button
		webDriver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);

		try {
			
			String row1Col1=(webDriver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]").getText());
			webDriver.findElementByLinkText(row1Col1).click();
			String title = webDriver.getTitle();
			String actualTitle = "View Lead | opentaps CRM";
			if(title.equals(actualTitle))
				System.out.println("Title verified");
			else
				System.out.println("Title not verified");

			webDriver.findElementByLinkText("Edit").click();
			webDriver.findElementById("updateLeadForm_companyName").clear();
			webDriver.findElementById("updateLeadForm_companyName").sendKeys("TestLeaf");
			webDriver.findElementByXPath("//input[@type='submit']").click();

			//		webDriver.findElementByLinkText("Find Lead").click();
			//		webDriver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Aditya");
			//		webDriver.findElementByXPath("//button[text()='Find Leads']").click();
			//		Thread.sleep(3000);
			//		String text = webDriver.findElementByLinkText("LeafTest").getText();
			//		if(text.equals("TestLeaf"))
			//			System.out.println("New Company Name verified");
			//		else
			//			System.out.println("Name not updated");

			String text = webDriver.findElementById("viewLead_companyName_sp").getText();
			System.out.println(text);

			if(text.contains("TestLeaf"))
				System.out.println("New Company Name verified");
			else
				System.out.println("Name not updated");		
		}catch(Exception e) {
			System.out.println("No records to edit...");
		}
		webDriver.close();
	}
}
