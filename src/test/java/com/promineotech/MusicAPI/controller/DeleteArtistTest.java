package com.promineotech.MusicAPI.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.MusicAPI.controller.support.DeleteArtistTestSupport;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

@Sql(scripts = {
	    "classpath:flyaway/migrations/Music_Artist_API_Database.sql",
	    "classpath:flyaway/migrations/Music_Artist_API_Database_Data.sql"}, 
	    config = @SqlConfig(encoding = "utf-8"))

class DeleteArtistTest extends DeleteArtistTestSupport {

	/**
	 * 
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	void testDeleteArtistReturnsSuccess201() {
		
		final String body = deleteArtistBody();
	}

}
