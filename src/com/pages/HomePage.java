package com.pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.HomePageUtility;

public class HomePage {
	private WebDriver d;
	public WebDriverWait w;
	private HomePageUtility hpu;
	public HomePage(WebDriver d){
		this.d = d;
		PageFactory.initElements(d, this);
		hpu = new HomePageUtility(d);
	}
	
	
	@FindBy(xpath="//a[@title='Hotels']")
	private WebElement hotelTab;
	
	@FindBy(xpath="//a[@class='select2-choice']")
	private WebElement city;
	public void enterCityToFindHotel(String cityName){
		hotelTab.click();
		city.click();
		hpu.handleAutocomplete(d, cityName);
	}
	
	@FindBy(name="checkin")
	private WebElement checkinDate;
	public void enterCheckinDate(String checkin){
		checkinDate.click();
		hpu.handleCalender(checkin);	
	}
	
	@FindBy(name="checkout")
	private WebElement checkoutDate;
	public void enterCheckoutDate(String checkout){
		System.out.println(checkoutDate.isDisplayed());
		//checkoutDate.click();
		hpu.handleCalender(checkout);	
	}
	
	@FindBy(id="travellersInput")
	private WebElement noOfTravellers;
	public void enterNoOfTravellers(int adults,int children){
		noOfTravellers.click();
		hpu.handleTravelersTab(adults, children);		
	}
	
	@FindBy(xpath="//div[contains(@class,'search-button')]/button[contains(text(),'Search')]")
	private WebElement searchBtn;
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	
	@FindBy(xpath="//a[@title='Flights']")
	private WebElement flightsTab;
	public WebElement getFlightsTab() {
		return flightsTab;
	}
		
	@FindBy(css="div#s2id_location_from>a.select2-choice")
	private WebElement sourceInput;
	public void enterSourceAirport(String srcCity,String srcCityAirport) {
		//flightsTab.click();
		sourceInput.click();
		hpu.handleAutocompleteSourceAirport(srcCity,srcCityAirport);
	}
	
	@FindBy(css="div#s2id_location_to>a.select2-choice")
	private WebElement destinationInput;
	public void enterDestinationAirport(String destCity,String destCityAirport) {
		destinationInput.click();
		hpu.handleAutocompleteDestinationAirport(destCity,destCityAirport);
	}
	
	
	

}
