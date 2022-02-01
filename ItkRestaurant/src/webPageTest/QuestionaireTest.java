package webPageTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import webPage.Page;
import webPage.Questionaire;

public class QuestionaireTest {
	public static String QUESTION_URL = "http://10.15.1.204:3000/questionaire";

	@Test
	public void questionaireTest() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) ReservationTest.driver;
		Page.navigateToPage(ReservationTest.driver, QUESTION_URL);

		Questionaire.selectReason(ReservationTest.driver, 2);
		String expectedReason = Questionaire.getReason(ReservationTest.driver, 2);

		js.executeScript("window.scrollBy(0,500)");
		ReservationTest.driver.switchTo().frame(Questionaire.iframe1(ReservationTest.driver));

		Questionaire.selectTryOption(ReservationTest.driver, 1);
		Questionaire.selectTryOption(ReservationTest.driver, 2);
		String expectedTryText1 = Questionaire.getTryText(ReservationTest.driver, 1);
		String expectedTryText2 = Questionaire.getTryText(ReservationTest.driver, 2);

		ReservationTest.driver.switchTo().defaultContent();
		Questionaire.clickLikeFoodButton(ReservationTest.driver);
		Questionaire.selectRating(ReservationTest.driver, 1);
		String expectedRating = Questionaire.getRating(ReservationTest.driver, 1);

		Questionaire.inputFeedback(ReservationTest.driver, "Lazanje");
		String expectedFeedback = Questionaire.getFeedback(ReservationTest.driver);
		Thread.sleep(2000);

		Questionaire.clickSubmitModal(ReservationTest.driver);
		ReservationTest.driver.switchTo().frame(Questionaire.iframe3(ReservationTest.driver));
		js.executeScript("javascript:document.getElementById(\"rng\").value=5;");
		String sliderValue = Questionaire.slider(ReservationTest.driver).getAttribute("value");

		ReservationTest.driver.switchTo().defaultContent();
		Questionaire.selectRateStaff(ReservationTest.driver, 0);
		String expectedRate = Questionaire.getRate(ReservationTest.driver, 0);

		ReservationTest.driver.switchTo().frame(Questionaire.iframe2(ReservationTest.driver));
		Questionaire.inputYourFeedback(ReservationTest.driver, "bla bla bla");
		String expectedYourFeedback = Questionaire.getYourFeedback(ReservationTest.driver);

		ReservationTest.driver.switchTo().defaultContent();
		Questionaire.submitForm(ReservationTest.driver);

		String cookies = ReservationTest.driver.manage().getCookieNamed("").getValue();
		String[] values = cookies.split(",");
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(values[0], expectedReason);
		sa.assertEquals(values[1], expectedRating);
		sa.assertEquals(values[2], expectedFeedback);
		sa.assertEquals(values[3], expectedTryText1);
		sa.assertEquals(values[4], expectedTryText2);
		sa.assertEquals(values[5], expectedYourFeedback);
		sa.assertEquals(values[6], sliderValue);
		sa.assertEquals(values[7], expectedRate);
		sa.assertAll();
	}
}
