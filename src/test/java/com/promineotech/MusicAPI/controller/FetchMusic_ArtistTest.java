package com.promineotech.MusicAPI.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

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
	
	
	@Test
	void testthatartistsarereturnedwhenvalidplaceoforiginissupplied() {
		Locations place_of_origin = Locations.Bergen_Norway;
		String uri = String.format("http://localhost:%d/Music_Artists?place_of_origin=%s", serverPort, place_of_origin);
		
		ResponseEntity<List<Artists>> response = restTemplate.exchange(uri, 
				HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		List<Artists> expected = buildExpected();
		assertThat(response.getBody()).isEqualTo(expected);
	}


}
