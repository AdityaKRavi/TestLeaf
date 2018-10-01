package week1.day2;

//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
//		drive.get("http://www.google.com");
//		System.out.println(drive.manage().window().getSize());
//		Dimension d=new Dimension(50, 50);
//		drive.manage().window().setSize(d);
//		System.out.println(d.getHeight());
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("DemoSalesManager");

		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		
		Select opt = new Select(driver.findElementById("createLeadForm_dataSourceId"));
		opt.selectByVisibleText("Employee");
	}

}
