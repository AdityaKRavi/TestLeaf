package week2.day5;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCarTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zoomcar.com/chennai");
		driver.findElementByLinkText("Start your wonderful journey").click();
		List<WebElement> popularLocations = driver.findElementsByClassName("items");
		popularLocations.get(1).click();
		driver.findElementByClassName("proceed").click();
//		Date date=new Date();
//		DateFormat sdf = new SimpleDateFormat("dd");
//		String today = sdf.format(date);
//		int tomorrow = Integer.parseInt(today)+1;
//		Date date=new Date();
		Calendar today = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("dd");
        today.add(Calendar.DAY_OF_YEAR, 1);
        String tomorrow = format.format(today.getTime());
		WebElement tomorrowDate = driver.findElementByXPath("//div[contains(text(),'"+tomorrow+"')]");
		tomorrowDate.click();
		driver.findElementByClassName("proceed").click();
		driver.findElementByClassName("proceed").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> listOfCars = driver.findElementsByXPath("//div[@class='car-listing']");
		List<Integer> listOfPrice = new ArrayList<Integer>();
		List<String> carBran = new ArrayList<String>();
		for (WebElement eachCar : listOfCars) {
			String priceOfEachCar = eachCar.findElement(By.className("price")).getText();			
			listOfPrice.add(Integer.parseInt(priceOfEachCar.replaceAll("\\D","")));
			carBran.add(eachCar.findElement(By.tagName("h3")).getText());
		}
		int maxPrice = Collections.max(listOfPrice);
//		DecimalFormat df = new DecimalFormat("##,###");
//		String maximumPriceElement = df.format(maxPrice);
		for(int i=0; i<listOfCars.size();i++) {
			if(maxPrice == (listOfPrice.get(i))) {
				System.out.println(carBran.get(i));
				driver.findElementByXPath("(//button[text()='BOOK NOW'])["+i+"]").click();
				break;
			}
		}
		driver.close();
//		String carName = driver.findElementByXPath("//div[contains(text(),'"+maximumPriceElement+"')]/preceding::h3").getText();
//		System.out.println(carName);
	}
}
