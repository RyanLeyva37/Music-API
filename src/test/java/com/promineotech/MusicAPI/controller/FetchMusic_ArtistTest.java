package com.promineotech.MusicAPI.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.promineotech.MusicAPI.controller.support.FetchMusic_ArtistTestSupport;
import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;
import com.promineotech.MusicAPI.controller.support.BaseTest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

@Sql(scripts = {
	    "classpath:flyaway/migrations/Music_Artist_API_Database.sql",
	    "classpath:flyaway/migrations/Music_Artist_API_Database_Data.sql"}, 
	    config = @SqlConfig(encoding = "utf-8"))

class FetchMusic_ArtistTest extends FetchMusic_ArtistTestSupport{

	@Autowired
	 private TestRestTemplate restTemplate;
	  
	 @LocalServerPort
	 private int serverPort;
	
	/**
	 *  
	 */
	@Test
	void testthatartistsarereturnedwhenvalidplaceoforiginissupplied() {
		Locations place_of_origin = Locations.Bergen_Norway;
		String uri = String.format("%s?place_of_origin=%s", getBaseUriForReadArtist(), place_of_origin);
		
		// When: a connection is made to the URI
		ResponseEntity<List<Artists>> response = restTemplate.exchange(uri, 
				HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		// Then: a success (OK - 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// And: the actual list returned is the same as the expected list
		List<Artists> expected = buildExpected();
		assertThat(response.getBody()).isEqualTo(expected);
	}
	
	/**
	 *  
	 */
	@Test
	void testThatAnErrorMessageIsReturnedWhenAnInvalidplaceoforiginIsSupplied() {
		Locations place_of_origin = Locations.Bergen_Norway;
		String uri = String.format("%s?place_of_origin=%s", getBaseUriForReadArtist(), place_of_origin);
		
		// When: a connection is made to the URI
		ResponseEntity<?> response = restTemplate.exchange(uri, 
				HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		// Then: a not found (404) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		
		// And: an error message is returned
		
	}



}
