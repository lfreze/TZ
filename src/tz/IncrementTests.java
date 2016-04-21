/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tz;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 *
 * @author лена
 */
public class IncrementTests extends TestCase{
    public FirefoxDriver driver;
    String basePage = "https://buggy.auroraplatform.com/";

    IncrementTests(String testName) {
        super(testName);
    }
      
	@BeforeClass
	public void setUp() throws MalformedURLException{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(basePage);
                driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
		
	}
    
    @Test
	public void testIncrementClick() throws InterruptedException{
		HomePage homePage = new HomePage(driver);
		LogInPage loginPage = homePage.logInClick();
                MainPage mainPage = loginPage.login("lfreze@gmail.com", "131313");
                int val = mainPage.getValue();
                mainPage.clickIncrement();
                int currentVal = mainPage.getValue();
                if(currentVal!=(val+1)) 
                    System.out.println("Error in incrementation");
                driver.navigate().refresh();
                int valAfter = mainPage.getValue();
                if(currentVal!=valAfter)
                    System.out.println("Error in incrementation after refreshing");
                else
                    System.out.println("testIncrementClick passed");
	}
}
