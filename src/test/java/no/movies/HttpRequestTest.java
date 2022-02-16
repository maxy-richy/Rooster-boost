package no.movies;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	@LocalServerPort
	private int port;

	private static final String base = "http://localhost:";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void loginTest() throws Exception {
		String url = base + port + "/login";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
		map.add("username", "admin");
		map.add("password", "admin");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
		String cookie = response.getHeaders().get("Set-Cookie").get(0);
		assertTrue(cookie.contains("JSESSIONID"));
		assertFalse(cookie.isEmpty());
	}
}