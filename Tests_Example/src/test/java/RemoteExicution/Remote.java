package RemoteExicution;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

class Remote {
	private RemoteWebDriver driver;

	@BeforeEach
	void setUp() throws MalformedURLException {
		DesiredCapabilities capabilitis = new DesiredCapabilities();
		capabilitis.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilitis);
		driver.manage().window().maximize();
	}

	@AfterEach
	void close() {
		driver.quit();
	}

	@Test
	void testINChromeGrid() {
		driver.get("https://www.selenium.dev/downloads/");
		assertEquals("Downloads", driver.getTitle());
	}
}
