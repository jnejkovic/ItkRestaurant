package webPageTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webPage.Page;
import webPage.Menu;

public class MenuTest {
	public static String MENU_URL = "http://10.15.1.204:3000/menu";

	@Test
	public void menuTest() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ReservationTest.driver;
		Page.navigateToPage(ReservationTest.driver, MENU_URL);

		Thread.sleep(5000);

		int sum = 0;
		js.executeScript("window.scrollBy(0,500)");

		Menu.selectProduc(ReservationTest.driver, 3);
		sum += Menu.getPrice(ReservationTest.driver, 3);
		Thread.sleep(3000);

		Menu.selectProduc(ReservationTest.driver, 4);
		Thread.sleep(3000);
		Menu.selectProduc(ReservationTest.driver, 4);
		sum += Menu.getPrice(ReservationTest.driver, 4) * 2;
		Thread.sleep(3000);

		Menu.selectProduc(ReservationTest.driver, 5);
		sum += Menu.getPrice(ReservationTest.driver, 5);
		Thread.sleep(3000);

		Menu.selectProduc(ReservationTest.driver, 10);
		sum += Menu.getPrice(ReservationTest.driver, 10);
		Thread.sleep(3000);

		Menu.selectProduc(ReservationTest.driver, 12);
		sum += Menu.getPrice(ReservationTest.driver, 12);
		Thread.sleep(3000);

		Assert.assertEquals(Menu.getTotalPrice(ReservationTest.driver), sum);
	}

}
