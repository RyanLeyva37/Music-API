package com.promineotech.MusicAPI.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.catalina.loader.ResourceEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.promineotech.MusicAPI.controller.support.CreateArtistTestSupport;
import com.promineotech.MusicAPI.entity.Artists;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

@Sql(scripts = {
	    "classpath:flyaway/migrations/Music_Artist_API_Database.sql",
	    "classpath:flyaway/migrations/Music_Artist_API_Database_Data.sql"}, 
	    config = @SqlConfig(encoding = "utf-8"))

class CreateArtistTest extends CreateArtistTestSupport {
	/**
	 * 
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	void testCreateAtistReturnSuccess201() {
		// Given: an order as JSON
		final String body = createArtistBody();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String uri = getBaseUriForCreateArtist();
		
		HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
		
		int rowsInUserTable = JdbcTestUtils.countRowsInTable(jdbcTemplate, "Artists");
		
		// When: the order is sent
		ResponseEntity<Artists> response = getRestTemplate().exchange(uri, HttpMethod.POST, 
				bodyEntity, Artists.class);
		
		Artists artist = response.getBody();
		
		// Then: a 201 status is returned
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(artist);
		assertEquals("Tame Impala", artist.getArtist_name());
		assertEquals("2007", artist.getYear_started());
		assertEquals("9999", artist.getYear_ended());
		assertEquals("Perth, Western Australia", artist.getPlace_of_origin());
		assertEquals("tameimpala", artist.getInstagram_handle());
		assertEquals(rowsInUserTable + 1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "Artists"));
		// And: the returned order is correct
	}

}
