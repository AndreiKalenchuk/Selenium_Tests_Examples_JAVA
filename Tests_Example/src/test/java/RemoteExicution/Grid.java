package RemoteExicution;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

class Grid {
	private WebDriver driver;

	@BeforeEach
	void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
//		capabilities.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL("http://10.0.0.109:4444/wd/hub"), capabilities);
		driver.manage().window().maximize();
	}

	@AfterEach
	void close() {
		driver.quit();
	}

	@Test
	void testInChromeGrid() {
		driver.get("https://www.selenium.dev/downloads/");
		assertEquals("Downloads", driver.getTitle());
	}
}
