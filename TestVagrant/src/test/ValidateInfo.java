package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ImdbPage;
import pages.WikiPage;


public class ValidateInfo {

    @Test
	public void run() {
    	
		WebDriverManager.chromedriver().setup();
		
	    WebDriver driver = new ChromeDriver();
			
		//a.waitForElementToAppear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// create obj for imdb class and pass driver value to imdb class
		ImdbPage i= new ImdbPage(driver);
		
		// open IMDB home page and enter movie value
		i.goTo();
		i.entermoviename();
		
		// extract value of ReleaseDate element from Imdb page
	    String Releasedate1= i.getReleasedate();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    	    
		// extract value of country element from Imdb page
		String CountryOfOrigin1= i.getcountry();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// create obj for wiki class and pass driver value to wiki class
		WikiPage w= new WikiPage(driver);
		
		// open Wiki page and enter movie value/
	    w.goTo();
		w.entermoviename();
			
	    // extract value of Release Date element on Wiki page
	 	String Releasedate2= w.getReleasedate();
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 	
	 	// extract value of Country of Origin on wikipedia page
	 	String CountryOfOrigin2=w.getcountry();
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 	
	 // validate if release date is equal on both pages	
	 	try {
	 		Assert.assertEquals(Releasedate1, Releasedate2);
	 		System.out.println("Dates are same");
		   }
		   catch(AssertionError e)
		   {
			   System.out.println("Dates dont match");
		   }
	 	
	    // validate if country value is equal on both pages
	 	try {
	 		Assert.assertEquals(CountryOfOrigin1,CountryOfOrigin2);
	 		System.out.println("Countries are same");
		   }
		   catch(AssertionError e)
		   {
			   System.out.println("countries dont match");
		   }
	 	
		}
	    
	}


