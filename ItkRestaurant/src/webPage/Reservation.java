package webPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Reservation extends Page {

	public static void inputName(WebDriver driver, String data) {
		findByXpath(driver, "Name").sendKeys(data);
	}

	public static void inputEmail(WebDriver driver, String data) {
		findByXpath(driver, "Email").sendKeys(data);
	}

	public static void inputPhone(WebDriver driver, String data) {
		findByXpath(driver, "Phone").sendKeys(data);
	}

	public static void inputDate(WebDriver driver, String data) {
		findByXpath(driver, "Date").sendKeys(data);
	}

	public static void inputTime(WebDriver driver, String data) {
		findByXpath(driver, "Time").sendKeys(data);
	}

	public static Select person(WebDriver driver) {
		return new Select(findByXpath(driver, "Person"));
	}

	public static void chooseOption(WebDriver driver, int i) {
		person(driver).selectByIndex(i);

	}

	public static WebElement parking(WebDriver driver) {
		return findByXpath(driver, "Parking");
	}

	public static void turnOnParking(WebDriver driver) {
		findByXpath(driver, "Parking").click();
	}

	public static void submitForm(WebDriver driver) {
		findByXpath(driver, "Submit").click();
	}
}
