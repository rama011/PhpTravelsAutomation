package com.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.HomePage;

public class HomePageUtility {
	WebDriver d;
	WebDriverWait w;
	public HomePageUtility(WebDriver d) {
		this.d  =d;
		// TODO Auto-generated constructor stub
		w= new WebDriverWait(d,3000);
	}
	
//Method to handle autocomplete on hotel booking tab
	public void handleAutocomplete(WebDriver d, String cityName){
		WebElement inputCityName = d.findElement(By.cssSelector("div#select2-drop>div:nth-child(1)>input.select2-input"));
		inputCityName.sendKeys(cityName);
		//System.out.println(city.getAttribute("innerHTML"));
		//d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 List<WebElement> l = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='select2-drop']//div[@class='select2-result-label']")));
		 System.out.println(l.get(0).getAttribute("innerHTML"));
		List<WebElement> cityOptions = d.findElements(By.xpath("//div[@id='select2-drop']//ul[@class='select2-result-sub']/li[contains(@class,'select2-result')]"));
		cityOptions.get(0).click();	
	}

//Method to handle calender on hotel booking tab
	public void handleCalender(String checkin){
		String dd= checkin.split("/")[0];
		String mm= checkin.split("/")[1];
		String yy= checkin.split("/")[2];
		
		System.out.println(dd+" "+mm+" "+yy);
		
		switch(mm){
		case("01"): mm="January"; break;
		case("02"): mm="February"; break;
		case("03"): mm="March"; break;
		case("04"): mm="April"; break;
		case("05"): mm="May"; break;
		case("06"): mm="June"; break;
		case("07"): mm="July"; break;
		case("08"): mm="August"; break;
		case("09"): mm="September"; break;
		case("10"): mm="October"; break;
		case("11"): mm="November"; break;
		case("12"): mm="December"; break;
		}
		
		System.out.println(dd+" "+mm+" "+yy);
		
		WebElement monthHeader = d.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='switch']"));
		System.out.println(monthHeader.getAttribute("innerHTML"));
		
		WebElement nextBtn = d.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']"));
		
		while(!monthHeader.getAttribute("innerHTML").equals(mm+" "+yy)){
			nextBtn.click();
		}
		
		List<WebElement> day = d.findElements(By.xpath("//div[@class='datepicker-days']//td[contains(@class,'day')][contains(text(),"+dd+")]"));
		try{
			day.get(0).click();
		}
		catch(ElementNotVisibleException e){
			day.get(1).click();
		}
	
	}
	
//method to handle number of travellers elment on hotel booking tab
	public void handleTravelersTab(int adults,int children) {
		//System.out.println(adults);
		WebElement adultsDiv = d.findElement(By.cssSelector("div#options>div.row>div:nth-child(1)"));
		//System.out.println(adultsDiv.getAttribute("innerHTML"));
		WebElement adultsValue = adultsDiv.findElement(By.id("adultInput"));
		//System.out.println(adultsValue.getAttribute("value"));
		while(Integer.valueOf(adultsValue.getAttribute("value"))!=adults){
			//System.out.println(Integer.valueOf(adultsValue.getAttribute("value"))<2);
			if(Integer.valueOf(adultsValue.getAttribute("value"))>adults) {
				d.findElement(By.id("adultMinusBtn")).click();
			}else {
				d.findElement(By.id("adultPlusBtn")).click();
			}
			
		}
		
		WebElement childsDiv = d.findElement(By.cssSelector("div#options>div.row>div:nth-child(2)"));
		//System.out.println(childsDiv.getAttribute("innerHTML"));

		WebElement childsValue = childsDiv.findElement(By.id("childInput"));
		//System.out.println(childsValue.getAttribute("value"));
		while(Integer.valueOf(childsValue.getAttribute("value"))!=children){
			//System.out.println(Integer.valueOf(adultsValue.getAttribute("value"))<2);
			if(Integer.valueOf(childsValue.getAttribute("value"))>children) {
				d.findElement(By.id("childMinusBtn")).click();
			}else {
				d.findElement(By.id("childPlusBtn")).click();
			}
			
		}
		
	

	}
	
	public void handleAutocompleteSourceAirport(String city,String airport) {
		WebElement inputCityName = d.findElement(By.cssSelector("div#select2-drop>div:nth-child(1)>input.select2-input"));
		inputCityName.sendKeys(city);
		//System.out.println(city.getAttribute("innerHTML"));
		//d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 WebElement e = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']/li[contains(@class,'select2-result')]/div[@class='select2-result-label'][contains(text(),'"+airport+"')]")));
		 //e.click();
		 System.out.println(e.getAttribute("innerHTML"));
		 e.click();
		
		
	}
	
	public void handleAutocompleteDestinationAirport(String city,String airport) {
		WebElement inputCityName = d.findElement(By.cssSelector("div#select2-drop>div:nth-child(1)>input.select2-input"));
		inputCityName.sendKeys(city);
		 WebElement e = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']/li[contains(@class,'select2-result')]/div[@class='select2-result-label'][contains(text(),'"+airport+"')]")));
		 e.click();		
		 d.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	}
}
