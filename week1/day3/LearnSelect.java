package week1.day3;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnSelect {

	public static void main(String[] args) throws IOException {
		//set driver path
		System.setProperty("Webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//launch browser
		ChromeDriver driver = new ChromeDriver();
		//load URL
		driver.get("http://leaftaps.com/opentaps");
		//maximize
		driver.manage().window().maximize();
		//Enter username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter password
		driver.findElementById("password").sendKeys("crmsfa");
		//click login
		driver.findElementByClassName("decorativeSubmit").click();

		//click logout
		//driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		WebElement eleSource = driver.findElementById("createLeadForm_dataSourceId");

		Select sc = new Select(eleSource); 
		//sc.selectByVisibleText("Employee");
		//sc.selectByValue("LEAD_EMPLOYEE");
		//sc.selectByIndex(1);
		List<WebElement> allOptions = sc.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		//syntax foreach
		for(WebElement eachOption: allOptions) {
			System.out.println(eachOption.getText());
		}
	}	
}
