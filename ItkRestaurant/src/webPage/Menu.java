package webPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ObjectsMap;

public class Menu extends Page {
	
	public static List<WebElement> listOfItems(WebDriver driver) {
		return driver.findElements(By.cssSelector(ObjectsMap.getObjects("AddButtons")));
	}

	public static WebElement chooseProduct(WebDriver driver, int i) {
		return listOfItems(driver).get(i);
	}

	public static void selectProduc(WebDriver driver, int i) {
		chooseProduct(driver,  i).click();
	}
	
	public static List<WebElement> listOfPrices(WebDriver driver) {
		return driver.findElements(By.className(ObjectsMap.getObjects("Prices")));
	}
	
	public static int getPrice(WebDriver driver, int i) {
		return Integer.parseInt(listOfPrices(driver).get(i).getText().substring(1));
	}
	
	public static int getTotalPrice(WebDriver driver) {
		return Integer.parseInt(findByXpath(driver, "TotalPrice").getText());
	}
	
	public static List<WebElement> listOfItemsInChart(WebDriver driver) {
		return driver.findElements(By.xpath(ObjectsMap.getObjects("ListItems")));
	}
}
