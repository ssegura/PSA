package psa.selenium.us;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class USTestChrome {

    @BeforeAll
    static void setup() {
    	System.setProperty("sel.jup.screenshot.at.the.end.of.tests", "true");
    	System.setProperty("sel.jup.screenshot.format", "png");
    	System.setProperty("sel.jup.output.folder", ".\\output\\screenshots\\");
    }
    
	@Test
	@DisplayName("Display correct title in Chrome")
	public void titleTest(ChromeDriver driver) {
		driver.get("http://www.us.es/");
		assertThat(driver.getTitle(), containsString("Universidad de Sevilla"));
	}
	
	@Test
	@DisplayName("Display correct title in Chrome (headless)")
	public void titleTestHeadlessChrome(@Arguments("--headless") ChromeDriver driver) {
		driver.get("http://www.us.es/");
		assertThat(driver.getTitle(), containsString("Universidad de Sevilla"));
	}

}