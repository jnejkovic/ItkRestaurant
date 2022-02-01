package webPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ObjectsMap;

public class Questionaire extends Page {

	public static List<WebElement> radioReason(WebDriver driver) {
		return driver.findElements(By.name(ObjectsMap.getObjects("Reason")));
	}

	public static WebElement oneReason(WebDriver driver, int i) {
		return radioReason(driver).get(i);
	}

	public static void selectReason(WebDriver driver, int i) {
		oneReason(driver, i).click();
	}

	public static String getReason(WebDriver driver, int i) {
		return oneReason(driver, i).getAttribute("value");
	}

	public static List<WebElement> tryOption(WebDriver driver) {
		return driver.findElements(By.xpath(ObjectsMap.getObjects("TryOptions")));
	}

	public static WebElement oneTryOption(WebDriver driver, int i) {
		return tryOption(driver).get(i);
	}

	public static void selectTryOption(WebDriver driver, int i) {
		oneTryOption(driver, i).click();
	}

	public static String getTryText(WebDriver driver, int i) {
		return oneTryOption(driver, i).getAttribute("value");
	}

	public static void clickLikeFoodButton(WebDriver driver) {
		findByXpath(driver, "LikeFoodButton").click();
		;
	}

	public static List<WebElement> rating(WebDriver driver) {
		return driver.findElements(By.name(ObjectsMap.getObjects("Rating")));
	}

	public static WebElement oneRating(WebDriver driver, int i) {
		return rating(driver).get(i);
	}

	public static String getRating(WebDriver driver, int i) {
		return oneRating(driver, i).getAttribute("value");
	}

	public static void selectRating(WebDriver driver, int i) {
		oneRating(driver, i).click();
	}

	public static WebElement feedback(WebDriver driver) {
		return findByXpath(driver, "Feedback");
	}

	public static void inputFeedback(WebDriver driver, String text) {
		feedback(driver).sendKeys(text);
	}

	public static String getFeedback(WebDriver driver) {
		return feedback(driver).getAttribute("value");
	}

	public static void clickSubmitModal(WebDriver driver) {
		findByXpath(driver, "SubmitModal").click();
	}

	public static List<WebElement> rateStaff(WebDriver driver) {
		return driver.findElements(By.cssSelector(ObjectsMap.getObjects("RateStaff")));
	}

	public static WebElement chooseRateStaff(WebDriver driver, int i) {
		return rateStaff(driver).get(i);
	}

	public static String getRate(WebDriver driver, int i) {
		return rateStaff(driver).get(i).getText();
	}

	public static void selectRateStaff(WebDriver driver, int i) {
		chooseRateStaff(driver, i).click();
	}

	public static WebElement yourFeedback(WebDriver driver) {
		return findById(driver, "YourFeedback");
	}

	public static void inputYourFeedback(WebDriver driver, String text) {
		yourFeedback(driver).sendKeys(text);
	}

	public static String getYourFeedback(WebDriver driver) {
		return yourFeedback(driver).getAttribute("value");
	}

	public static void submitForm(WebDriver driver) {
		findById(driver, "SubmitQuestionaire").click();
	}

	public static WebElement iframe1(WebDriver driver) {
		return findById(driver, "Iframe1");
	}

	public static WebElement iframe2(WebDriver driver) {
		return findById(driver, "Iframe2");
	}

	public static WebElement iframe3(WebDriver driver) {
		return findById(driver, "Iframe3");
	}

	public static WebElement slider(WebDriver driver) {
		return findById(driver, "Slider");
	}
}
