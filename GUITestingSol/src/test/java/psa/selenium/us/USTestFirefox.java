package psa.selenium.us;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import io.github.bonigarcia.seljup.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class USTestFirefox {

	FirefoxDriver driver;

	public USTestFirefox(FirefoxDriver driver) {
		this.driver = driver;
	}
	
	@Test
	@DisplayName("Display correct title in Firefox")
	public void titleTest() {
		driver.get("http://www.us.es/");
		assertThat(driver.getTitle(), containsString("Universidad de Sevilla"));
	}
}