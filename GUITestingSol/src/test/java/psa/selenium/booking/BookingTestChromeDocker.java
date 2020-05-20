package psa.selenium.booking;

import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class BookingTestChromeDocker {

	private RemoteWebDriver driver;
	
	public BookingTestChromeDocker(@DockerBrowser(type = CHROME) RemoteWebDriver driver) {
		this.driver = driver;
	}
	
    @BeforeAll
    static void setup() {
    	System.setProperty("sel.jup.recording", "true");
    	System.setProperty("sel.jup.output.folder", ".\\output\\videos\\");
    }
    
    @Test
    public void testBooking() throws Exception {
      driver.get("https://www.booking.com/index.en-gb.html?label=gen173nr-1DCAEoggI46AdIM1gEaEaIAQGYAQm4ARfIAQzYAQPoAQGIAgGoAgO4ApHG0uQFwAIB;sid=81331a4f35819299c39c79ab0b0a6931;keep_landing=1&sb_price_type=total&");
      driver.findElement(By.id("ss")).click();
      driver.findElement(By.id("ss")).clear();
      driver.findElement(By.id("ss")).sendKeys("Cádiz");
     // driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='From cosy country homes to funky city flats'])[1]/following::li[1]")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='+'])[5]/following::span[1]")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in day'])[1]/following::i[3]")).click();
      assertTrue(isElementPresent(By.xpath("//div[@id='filter_popular_activities']/div/p")));
      assertEquals("2", driver.findElement(By.id("group_adults")).getAttribute("value"));
    }

    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }
}