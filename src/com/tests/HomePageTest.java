package com.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.HomePage;
import com.utilities.Config;

public class HomePageTest {
	WebDriver driver;
	HomePage hp;
	Config c; 
	@Before
	public void setUp() throws Exception {
		c=new Config();
		System.setProperty("webdriver.chrome.driver", c.driverPath);
		driver = new ChromeDriver();
		driver.get(c.openUrl);
		driver.manage().window().maximize();
		hp= new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

	//@Test
	/*public void testHotelBooking() {
		hp.enterCityToFindHotel("London");
		hp.enterCheckinDate("12/04/2019");
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		hp.enterCheckoutDate("16/04/2019");
		hp.enterNoOfTravellers(2, 1);
		hp.clickOnSearchBtn();
	}*/
	
	@Test
	public void testOneWayFlightBooking() {
		hp.getFlightsTab().click();
		hp.enterSourceAirport("London","LCY");
		//hp.enterDestinationAirport("New York", "ROC");
	}

}
