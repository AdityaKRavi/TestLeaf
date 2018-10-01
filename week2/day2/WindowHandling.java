package week2.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElementByLinkText("Contact Us").click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> window = new ArrayList<String>();
		window.addAll(allWindows);
		
		driver.switchTo().window(window.get(1));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.switchTo().window(window.get(0)).close();
		
	}
}
