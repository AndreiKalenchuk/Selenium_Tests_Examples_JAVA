package _page;

import org.openqa.selenium.WebDriver;

public class Base {
	protected WebDriver driver;
	
	protected void open(String url) {
		driver.get(url);
	};
	
}
