package psa.selenium.uni.lu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class UniLuChrome {

	static ChromeDriver driver;

	public UniLuChrome(ChromeDriver d) {
		driver = d;
	}

	@BeforeAll
	static void setup() {
		// Screenshots
		System.setProperty("sel.jup.screenshot.at.the.end.of.tests", "true");
		System.setProperty("sel.jup.screenshot.format", "png");
		System.setProperty("sel.jup.output.folder", ".\\output\\media\\uni\\");
	}

	@AfterAll
	static void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	@DisplayName("Display correct title in Chrome")
	public void titleTest() {
		driver.get("https://wwwen.uni.lu/");
		assertEquals("Home", driver.getTitle());
	}

	@Test
	@DisplayName("Display correct title in Firefox")
	public void titleTest(FirefoxDriver driver) {
		driver.get("https://wwwen.uni.lu/");
		assertEquals("Home", driver.getTitle());
	}

	@Test
	@DisplayName("Display correct title in Chrome (headless)")
	public void titleTestHeadlessChrome(@Arguments("--headless") ChromeDriver driver) {
		driver.get("https://wwwen.uni.lu/");
		assertEquals("Home", driver.getTitle());
	}

	@Test
	@DisplayName("Display correct campus info for Bachelor in AIT")
	public void testBachelorCampus() throws Exception {
		driver.get("https://wwwen.uni.lu/");

		// Accept cookie consent
		driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
				
		// Mouseover on Studies dropdown menu
		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[6]"));
		action.moveToElement(btn).perform();

		// Thread.sleep just for user to notice the event
		Thread.sleep(3000);

		// Click on Bachelors
		driver.findElement(By.linkText("Bachelors")).click();

		// Click on Bachelor in Applied Information Technology
		driver.findElement(By.xpath("//*[@id=\"module_result\"]/table[2]/tbody/tr[8]/td[3]/p/a")).click();

		// Assert campus is "Belval"
		assertEquals("Campus: Belval",
				driver.findElement(By.xpath("//div[@id='main']/table/tbody/tr/td[3]/div/div[6]/ul/li[4]")).getText());
	}

	@Test
	@DisplayName("Search feature")
	public void testSearch() throws Exception {
		driver.get("https://wwwen.uni.lu/");
		driver.findElement(By.name("SearchText")).click();
		driver.findElement(By.name("SearchText")).clear();
		driver.findElement(By.name("SearchText")).sendKeys("erasmus");
		driver.findElement(By.name("f1")).submit();
		assertTrue(driver.findElement(By.xpath("//div[@id='module_result']/div[2]/form/div/div")).getText()
				.matches("^Search for \"erasmus\" returned [\\s\\S]*$"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "erasmus", " bachelor", "informatics", "" })
	@DisplayName("Parameterized test on search feature")
	public void testParameterizedSearch(String keyword) throws Exception {
		driver.get("https://wwwen.uni.lu/");
		driver.findElement(By.name("SearchText")).click();
		driver.findElement(By.name("SearchText")).clear();
		driver.findElement(By.name("SearchText")).sendKeys(keyword);
		driver.findElement(By.name("f1")).submit();
		assertTrue(driver.findElement(By.xpath("//div[@id='module_result']/div[2]/form/div/div")).getText()
				.matches("^Search for \"" + keyword + "\" returned [\\s\\S]*$"));
	}

}