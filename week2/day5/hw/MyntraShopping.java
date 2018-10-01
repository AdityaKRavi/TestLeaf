package week2.day5.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyntraShopping {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		WebElement searchBox = driver.findElementByTagName("input");
		Actions builder = new Actions(driver);
		builder.click(searchBox).sendKeys("Sunglasses").sendKeys(Keys.ENTER).perform();
		List<WebElement> allSunglasses = driver.findElementsByXPath("//li[@class='product-base']");
		List<WebElement> unisexSunglasses = driver.findElementsByXPath("//h4[@class ='product-product']");
		List<WebElement> discount40 = driver.findElementsByXPath("//span[@class ='product-discountPercentage']");
		List<String> brandName = new ArrayList<String>();
		List<String> discountedPrice = new ArrayList<String>();
		String eachUnisexGlass =null;
		String eachDiscount=null;
		for(int i =0; i<allSunglasses.size();i++) {
			eachUnisexGlass = unisexSunglasses.get(i).getText();
			eachDiscount = discount40.get(i).getText();
			if(eachUnisexGlass.contains("Unisex") && eachDiscount.equals("(40% OFF)")) {
				brandName.add(driver.findElementByXPath("(//div[@class ='product-brand'])["+i+"]").getText());
				discountedPrice.add(driver.findElementByXPath("(//span[@class ='product-discountedPrice'])["+i+"]").getText());
			}	
		}
		for(String value: brandName) {
			System.out.println("Brand Name:"+value+"  ");
		}
		for(String value2: discountedPrice) {
			System.out.println("Discounted Price:"+value2+"  ");
		}

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement faceShapeRadio = driver.findElementByXPath("//h4[@class='atsa-title' and text()='Face Shape']");
		faceShapeRadio.click();
		List<WebElement> listOfCheckBox = driver.findElementsByXPath("//ul[@class='atsa-values']/*");
		listOfCheckBox.get(4).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='filter-summary-filterList']")));
		driver.findElementByXPath("//h4[@class='atsa-title' and text()='Type']").click();
		List<WebElement>listOfCheckBox2 = driver.findElementsByXPath("//ul[@class='atsa-values']/*");
		listOfCheckBox2.get(5).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='filter-summary-filterList']")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//li[@class='product-base']//img").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>();
		window.addAll(windowHandles);
		driver.switchTo().window(window.get(1));
		String productTitle = driver.findElementByXPath("//h1[@class='pdp-name']").getText();
		System.out.println(productTitle);
		driver.findElementByXPath("//div[text()='ADD TO BAG']").click();
		driver.findElementByXPath("//a[@class='desktop-cart']").click();
		Thread.sleep(3000);
		String productName = driver.findElementByXPath("//div[@class='prod-name']").getText();
		if(productName.contains(productTitle)) {
			System.out.println("The product name matches");
		}
		else {
			System.out.println("The product name doesn't match");
		}
		driver.quit();
	}
}

