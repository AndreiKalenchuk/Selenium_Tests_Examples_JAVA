package operations;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class SelectRadioBtn {
	private static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
	@Test
	void test() {
		driver.get("https://www.amazon.com/b/ref=CyElectricBikes/ref=s9_acss_bw_cg_sphapnav_2c1_w?ie=UTF8&node=3405141&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-leftnav&pf_rd_r=BZEBR54G840JDVTWE1WY&pf_rd_r=BZEBR54G840JDVTWE1WY&pf_rd_t=101&pf_rd_p=4d94ac5d-1262-461e-acca-3beb84bb2508&pf_rd_p=4d94ac5d-1262-461e-acca-3beb84bb2508&pf_rd_i=3403201&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-3&pf_rd_r=KG3TYP9RYKR0HNDZ22P2&pf_rd_t=101&pf_rd_p=3462651f-de22-469c-b176-69248e3ce264&pf_rd_i=3403201");
		assertTrue(driver.getTitle().contains("Adult Electric Bicycles"));
	}
	
	@Test
	void checkBox() {
		selectCheckBox("Bosh");
		selectCheckBox("Americus");
		selectCheckBox("Caf");
	}
	
	@Test
	void deselectCheckBox() {
		deselectCheckBox("Bosh");
		
	}
	
	
// methods	
	public static void selectCheckBox(String name) {
		String xPath = "//span[text()='%s']/preceding-sibling";
		if(!driver.findElement(By.xpath(String.format(xPath, name) + "/input")).isSelected())
			driver.findElement(By.xpath(String.format(xPath, name))).click();		
	}
	
	public static void deselectCheckBox(String name) {
		String xPath = "//span[text()='%s']/preceding-sibling";
		if(driver.findElement(By.xpath(String.format(xPath, name) + "/input")).isSelected())
			driver.findElement(By.xpath(String.format(xPath, name))).click();		
	}
}
