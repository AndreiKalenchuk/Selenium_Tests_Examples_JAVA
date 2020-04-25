package _page;

import org.openqa.selenium.WebDriver;

public class HomePage extends Base {
	
	private String url = "https://asana.com/";
	private String title = "Manage your team’s work, projects, & tasks online · Asana";
	private String homeURL = "https://asana.com/";
	private String header = "Keep your team organized and connected";
	private String[] menuLinksTextArr = {"Why Asana?", "Solutions", "Resources"};
	
// elements
 public void homePageOpen(WebDriver driver) {
	 super.open(this.url);
 }
	
// constructor 

}
