package week2.day5;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdmethods.SeMethods;

public class ZoomCar extends SeMethods{

	@Test
	public void zoom() {
		startApp("chrome","https://www.zoomcar.com/chennai");
		WebElement locateElement = locateElement("linktext", "Start your wonderful journey");
		click(locateElement);
	}
	String a="? 552";
	String b= a.replaceAll("\\D","");
}
