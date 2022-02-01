package webPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ObjectsMap;

public class Page {
	WebDriver driver;

	public static void openHomePage(WebDriver driver, String url) {
		driver.get(url);

	}

	public static void navigateToPage(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	// Methods to finding objects (by xpath and id)
	public static WebElement findByXpath(WebDriver driver, String objects) {
		return driver.findElement(By.xpath(ObjectsMap.getObjects(objects)));
	}

	public static WebElement findById(WebDriver driver, String objects) {
		return driver.findElement(By.id(ObjectsMap.getObjects(objects)));
	}

}
