package wdmethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods implements WdMethods {

	public RemoteWebDriver driver = null;
	int i=1;
	@Override
	public void startApp(String browser, String url) {
	
	if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
	} else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.get(url);
	driver.manage().window().maximize();
	System.out.println("The browser "+browser+" launched successfully");
	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		switch (locator) {
		case "id": return driver.findElementById(locValue); 
		case "class": return  driver.findElementByClassName(locValue);
		case "linktext" :return driver.findElementByLinkText(locValue);
		case "xpath": return driver.findElementByXPath(locValue);
		case "name": return driver.findElementByName(locValue);
		case "tagname": return driver.findElementByTagName(locValue);
		case "partiallinktext": return driver.findElementByPartialLinkText(locValue);
		case "css": return driver.findElementByCssSelector(locValue);
		}
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return driver.findElementById(locValue);
	}

	@Override
	public void type(WebElement ele, String data) {
       ele.sendKeys(data);	
       System.out.println("The data "+data+" entered successfully");
	}

	@Override
	public void click(WebElement ele) {
		ele.click();
		System.out.println("The element "+ele+ "click successfully");
	}

	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return ele.getText();
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
	Select sel = new Select(ele);
	sel.selectByVisibleText(value);
	System.out.println("The value "+value+" entered successfully");
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		Select sel = new Select(ele);
		try {
		sel.selectByIndex(index);
		System.out.println("The value entered successfully");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Sorry!! no such value found at the mentioned index");
		}		
	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
			return true;
		else
			return false;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		String actualText = ele.getText();
		if(actualText.equals(expectedText))
			System.out.println("Text Verified");
		else
			System.out.println("Texts do not match");
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		String actualText = ele.getText();
		if(actualText.contains(expectedText))
			System.out.println("Partial Text verified");
		else
			System.out.println("Texts do not match");
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		String actualAttributeValue = ele.getAttribute(attribute);
		if(actualAttributeValue.equals(value))
			System.out.println("The attribute value matches");
		else
			System.out.println("The attribute value doesn't match");
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		String actualAttributeValue=ele.getAttribute(attribute);
				if(actualAttributeValue.contains(value))
					System.out.println("The attribute value matches");
				else
					System.out.println("The attribute value doesn't match");
	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		if(ele.isSelected())
			System.out.println("The element is selected");
		else
			System.out.println("The element is not selected");
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		if(ele.isDisplayed())
			System.out.println("The element is selected");
		else
			System.out.println("The element is not selected");
	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		Set<String> allWindows = driver.getWindowHandles();
		List<String> window = new ArrayList<String>();
		window.addAll(allWindows);
		driver.switchTo().window(window.get(index));
		window.clear();
	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(ele);
	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();
	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return driver.switchTo().alert().getText();
	}

	@Override
	public void takeSnap(){
		// TODO Auto-generated method stub		
		try {
			File screenShot = driver.getScreenshotAs(OutputType.FILE); 
			File destination=  new File("./snaps/img"+i+".jpeg");
			FileUtils.copyFile(screenShot, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();
	}

}
