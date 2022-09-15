package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class WikiPage  {

	//local class variable
		WebDriver driver;
		
	     public WikiPage(WebDriver driver) {
			
			//initialization 
			this.driver= driver;
			PageFactory.initElements(driver, this);
		 }
	     
		// Pagefactory design
	     
		@FindBy(xpath="/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")
		WebElement Releasedate;
		
		@FindBy(xpath="/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[14]/td")
	    WebElement country;
	
		@FindBy(xpath="/html/body/div[3]/form/fieldset/div/input")
	    WebElement searchbtn;
		
		@FindBy(xpath="/html/body/div[3]/form/fieldset/div/div[2]/div/a[1]/div[1]")
	    WebElement dropdown;
		
		// go on Wikipage
			public void goTo() {
				driver.get("https://www.wikipedia.org/");	
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
			
		public void entermoviename() {
			searchbtn.sendKeys("Pushpa: The Rise");
			dropdown.click();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
			
		// get Releasedate value from Wiki page
		public String getReleasedate() {
			
			return Releasedate.getText();
					
		}
		// get country value from Wiki page
		public String getcountry() {
				
			return country.getText();
			
		}
		
	
}
