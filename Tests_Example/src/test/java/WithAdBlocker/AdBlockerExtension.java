package WithAdBlocker;

import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class AdBlockerExtension {
	private static WebDriver driver;
// Download extension as a “CRX file” adBlock.crx 
//	Save the file onto the local machine
//	add path in test

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/chromedriver79/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\driversSelenium\\extensionAdBlocker_4_10_0_0.crx"));
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	}

	@AfterEach
	void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	void test() {
		driver.get("https://www.target.com/c/adult-bikes-sports-outdoors/-/N-5ul7z");
	}
}
