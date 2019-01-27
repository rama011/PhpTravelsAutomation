package com.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.HomePage;

public class HomePageUtilities {
	WebDriver d;
	WebDriverWait w;
	public HomePageUtilities(WebDriver d) {
		this.d  =d;
		// TODO Auto-generated constructor stub
		w= new WebDriverWait(d,3000);
	}

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
}
