package com.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.HomePage;

public class HotelBookingTests {
	WebDriver driver;
	HomePage hp;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D://Work//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");
		driver.manage().window().maximize();
		hp= new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

	@Test
	public void test() {
		hp.enterCityToFindHotel("London");
		hp.enterCheckinDate("12/04/2019");
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		hp.enterCheckoutDate("16/04/2019");
		hp.enterNoOfTravellers(1, 1);
	}

}
