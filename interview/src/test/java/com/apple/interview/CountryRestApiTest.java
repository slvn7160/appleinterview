package com.apple.interview;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.apple.iterview.Country;

public class CountryRestApiTest {

	private URI uri;

	@Before
	public void init() {
		try {
			uri = new URI("https://istheapplestoredown.com/api/v1/status/worldwide");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getCountryStatusTest() {

		RequestEntity<?> request = RequestEntity.get(this.uri).accept(MediaType.APPLICATION_JSON).build();
		RestTemplate template = new RestTemplate();
		ParameterizedTypeReference<HashMap<String, Country>> responseType = new ParameterizedTypeReference<HashMap<String, Country>>() {};
		ResponseEntity<HashMap<String, Country>> jsonResponse = template.exchange(request, responseType);
		jsonResponse.getBody().entrySet().forEach(x -> {
			try {
				assertTrue(x.getValue().getStatus().equalsIgnoreCase("n"));
			} catch (AssertionError e) {
				System.out.println(x.getValue().getName());
				throw new AssertionError();
			}
		});
	}

}
