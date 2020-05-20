package psa.selenium.us;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumExtension;
import static io.github.bonigarcia.seljup.BrowserType.*;

@ExtendWith(SeleniumExtension.class)
public class USTestDocker {

    @BeforeAll
    static void setup() {
    	System.setProperty("sel.jup.recording", "true");
    	System.setProperty("sel.jup.output.folder", ".\\output\\videos\\");
    }
	
	@Test
	@DisplayName("Display correct title in Chrome (Docker)")
	public void titleTestChromeDocker(@DockerBrowser(type = CHROME) RemoteWebDriver driver) {
		driver.get("http://www.us.es/");
		assertThat(driver.getTitle(), containsString("Universidad de Sevilla"));
	}
	
	@Test
	@DisplayName("Display correct title in Firefox (Docker)")
	public void titleTestFirefoxDocker(@DockerBrowser(type = FIREFOX) RemoteWebDriver driver) {
		driver.get("http://www.us.es/");
		assertThat(driver.getTitle(), containsString("Universidad de Sevilla"));
	}

	/*
	@Test
	public void testOpera(@DockerBrowser(type = OPERA) RemoteWebDriver driver) {
		driver.get("http://www.us.es/");
		assertThat(driver.getTitle(), containsString("Universidad de Sevilla"));
	}
	*/
}