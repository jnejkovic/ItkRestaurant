package webPageTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Reserve;
import webPage.Page;
import webPage.Reservation;

public class ReservationTest {

	public static String RESERVE_URL = "http://10.15.1.204:3000/reserve";
	public static WebDriver driver;

	@BeforeSuite
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void reserveTest() throws ParseException {
		Page.openHomePage(driver, RESERVE_URL);
		Reserve reserve1 = new Reserve("Jelena", "jnejkovic@itekako.com", "12/01/2023", "123456", "on", 1, "05:10AM");
		Reservation.inputName(driver, reserve1.getName());
		Reservation.inputEmail(driver, reserve1.getEmail());
		Reservation.inputPhone(driver, reserve1.getPhone());
		Reservation.inputDate(driver, reserve1.getDate());
		Reservation.inputTime(driver, reserve1.getTime());
		Reservation.chooseOption(driver, reserve1.getPerson());
		Reservation.turnOnParking(driver);
		Reservation.submitForm(driver);

		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
		// using local storage
		LocalStorage localStorage = webStorage.getLocalStorage();
		DateFormat userDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-MM-dd");
		Date date = userDateFormat.parse(reserve1.getDate());
		String convertedDate = dateFormatNeeded.format(date);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Integer.parseInt(localStorage.getItem("person")), reserve1.getPerson());
		sa.assertEquals(localStorage.getItem("email"), reserve1.getEmail());
		sa.assertEquals(localStorage.getItem("name"), reserve1.getName());
		sa.assertEquals(localStorage.getItem("phone"), reserve1.getPhone());
		sa.assertEquals(localStorage.getItem("date"), convertedDate);
		sa.assertEquals(localStorage.getItem("time"), reserve1.getTime().substring(0, 5));
		sa.assertEquals(localStorage.getItem("parking"), reserve1.getParking());
		sa.assertAll();

	}

	@AfterSuite
	public void TestQuit() {
		driver.close();
	}
}
