package RestApi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class TestGet {
	private RestTemplate restTemplate;
	private String URL = "http://worldtimeapi.org/api/timezone/America/Los_Angeles";
	
	@BeforeEach
	void setUp() {
		restTemplate = new RestTemplate();
	}
	
	@Test
	void GETasString() {
		String response = restTemplate.getForObject(URL, String.class);
		System.out.println(response);
		assertTrue(response.contains("timezone: America/Los_Angeles"));
	}
	
	@Test
	void GETasPOJO() {
		TimeZonePAge response = restTemplate.getForObject(URL, TimeZonePAge.class);
		System.out.println();
		assertEquals(1, response.getDay_of_week());
		assertEquals("PDT", response.getAbbreviation());
		
	}
}
