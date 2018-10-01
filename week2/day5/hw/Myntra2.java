package week2.day5.hw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myntra2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		WebElement searchBox = driver.findElementByTagName("input");
		Actions builder = new Actions(driver);
		builder.click(searchBox).sendKeys("Sunglasses").sendKeys(Keys.ENTER).perform();
		List<WebElement> ListOfBrandName = driver.findElementsByXPath("(//div[@class='product-productMetaInfo'][.//h4[contains(text(), 'Unisex')] and .//span[contains(text(), '40% OFF')]])/div[1]");
		List<WebElement> ListOfPrices = driver.findElementsByXPath("(//div[@class='product-productMetaInfo'][.//h4[contains(text(), 'Unisex')] and .//span[contains(text(), '40% OFF')]])/div[2]/span/span[@class='product-discountedPrice']");
		for (WebElement eachBrandName : ListOfBrandName) 
		{String brandName = eachBrandName.getText();
			System.out.println("iteme Brand Name is:  "+ brandName);
		}
		for (WebElement eachprice: ListOfPrices)
		{
			String price = eachprice.getText();
			System.out.println("discounted Price is :" + price );
		}
		
		WebElement faceShapeRadio = driver.findElementByXPath("//h4[@class='atsa-title' and text()='Face Shape']");
		builder.click(faceShapeRadio).pause(3000).perform();
		List<WebElement> listOfCheckBox = driver.findElementsByXPath("//ul[@class='atsa-values']/*");
		WebElement roundSelect = listOfCheckBox.get(4);
		builder.click(roundSelect).perform();
		WebElement typeRadio = driver.findElementByXPath("//h4[@class='atsa-title' and text()='Type']");
		builder.click(typeRadio).pause(3000).perform();
		List<WebElement>listOfCheckBox2 = driver.findElementsByXPath("//ul[@class='atsa-values']/*");
		WebElement ovalSelect = listOfCheckBox2.get(5);
		builder.click(ovalSelect).pause(3000).perform();
		
		
	}
}
