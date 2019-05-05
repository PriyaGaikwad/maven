package Tmavenlog4j.Log4maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mercurylog4 {
	
	public WebDriver driver;
	static Logger logger=Logger.getLogger(Mercurylog4.class);
	
	
  @Test(priority=1)
  public void loginwithvalidds() {
	  
	  PropertyConfigurator.configure("E:\\priyag java\\Log4maven\\src\\test\\resources\\log4j.properties");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys( "Suvidyap1");
	           
	       
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
	            

	        driver.findElement(By.xpath("//input[@name='login']")).click();
	        driver.findElement(By.linkText("SIGN-OFF")).click();
	        logger.info("user has successfully login into application");
	        logger.debug("user  has successfully");
	        
	        
	  
	  
  }
  @BeforeMethod
  public void getallcookies() {
	  Set<Cookie>cookies=driver.manage().getCookies();
	  for(Cookie cookies1:cookies)
	  {
		  System.out.println(cookies1.getName());
	  }
	  
  }

  @AfterMethod
  public void capturescreenshot() {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try
      {
          FileUtils.copyFileToDirectory(src, new File("E:\\priyag java\\Log4maven\\Screenshot\\"));


      }
      catch(IOException e)
      {
          e.printStackTrace();
          logger.fatal("Catch block is executed successfully");
      }
  }

  @BeforeClass
  public void maximizeBrowser()
  {
      driver.manage().window().maximize();
      logger.info("Maximize browser");
  }

  @AfterClass
  public void deleteAllCookies()
  {
      driver.manage().deleteAllCookies();
      logger.warn("warning message");
  }

  @BeforeTest
  public void enterApplicationURL()
  {
      driver.get("http://newtours.demoaut.com/mercurywelcome.php");
      logger.info("URL is entered successfully");
  }

  @AfterTest
  public void dbConnectionClosed()
  {
      logger.info("dbConnection is closed");
  }

  @BeforeSuite
  public void openBrowser()
  {
      System.setProperty("webdriver.chrome.driver", "E:\\Selenium Setup\\chromedriver.exe");
      driver = new ChromeDriver();
      logger.info("Chrome browser is opened successfully");
  }
@AfterSuite
  public void closeBrowser()
  {
      driver.close();
  }



}