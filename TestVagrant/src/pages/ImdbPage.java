package pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class ImdbPage  {
	
 //local class variable
	WebDriver driver;
	
     public ImdbPage(WebDriver driver) {	
		//initialization 
		this.driver= driver;
		PageFactory.initElements(driver, this);
	 }
     
	// Pagefactory design
     
	@FindBy(xpath="/html/body/div[2]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[1]/div/ul/li/a")
	WebElement Releasedate;
	
	@FindBy(xpath="/html/body/div[2]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[2]/div/ul/li/a")
	WebElement country;
	
	@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/form/div[2]/div/input")
	WebElement searchbtn;
	
	@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/form/div[2]/div/div/div/ul/li[1]/a/div[2]")
	WebElement dropdown;

	// go on IMDB page
		public void goTo() {
			driver.get("https://www.imdb.com/");				
		}
		
		public void entermoviename() {
			searchbtn.sendKeys("Pushpa: The Rise - Part 1");
			dropdown.click();		
		}
		
	// get Releasedate value from IMDB page
	public String getReleasedate() {		
		return Releasedate.getText();
	
	    }
	// get country value from IMDB page
		public String getcountry() {
			return country.getText();
		
		}
}
