package psa.selenium.amazon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.seljup.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class AmazonChrome {

	static ChromeDriver driver;

	public AmazonChrome(ChromeDriver d) {
		driver = d;
	}

	@BeforeAll
	static void setup() {
		// Screenshots
		System.setProperty("sel.jup.screenshot.at.the.end.of.tests", "true");
		System.setProperty("sel.jup.screenshot.format", "png");
		System.setProperty("sel.jup.output.folder", ".\\output\\media\\amazon\\");
	}

	@AfterAll
	static void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	@DisplayName("Display correct title")
	public void titleTest() {
		driver.get("https://www.amazon.com");
		assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
				driver.getTitle());
	}

	@Test
	@DisplayName("Display 'Today's Deals' text anywhere in the main page")
	public void todaysDealsTest() {
		driver.get("https://www.amazon.com");
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("Today's Deals"));
	}

	@Test
	@DisplayName("Display menu header 'Make Money with Us'")
	public void testMakeMoneyWithUs() throws Exception {
		driver.get("https://www.amazon.com");
		assertEquals("Make Money with Us",
				driver.findElement(By.xpath("//div[@id='navFooter']/div/div/div[3]/div")).getText());
	}

	@Test
	@DisplayName("Select Euro currency")
	public void testCurrency() throws Exception {
		driver.get("https://www.amazon.com");
		driver.findElement(By.xpath("//a[@id='icp-touch-link-cop']/span[2]")).click();
		driver.findElement(By.id("a-autoid-0-announce")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("icp-sc-dropdown_2")).click();
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		assertEquals("EUR - Euro", driver.findElement(By.xpath("//a[@id='icp-touch-link-cop']/span[2]")).getText());
	}

	@Test
	@DisplayName("Default ordering (Featured)")
	public void testDefaultOrdering() throws Exception {
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tablet");
		driver.findElement(By.name("site-search")).submit();
		assertEquals("relevanceblender", driver.findElement(By.id("s-result-sort-select")).getAttribute("value"));
	}

	@Test
	@DisplayName("Search title")
	public void testSearchTitle() throws Exception {
		String keyword = "tablet";
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
		driver.findElement(By.name("site-search")).submit();
		//System.out.println(driver.getTitle());
		assertEquals("Amazon.com: " + keyword, driver.getTitle());
	}

}