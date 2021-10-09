package com.promineotech.MusicAPI.controller;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.promineotech.MusicAPI.MusicApiApplication;
import com.promineotech.MusicAPI.controller.support.CreateSongTestSupport;
import com.promineotech.MusicAPI.entity.Song;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"classpath:flyway/migrations/Music_Artist_API_Database.sql",
		"classpath:flyway/migrations/Music_Artist_API_Database_Data.sql"},
		config = @SqlConfig(encoding = "utf-8"))

class CreateSongTest extends CreateSongTestSupport{
	

	
	@MockBean
	MusicApiApplication applicationService;
	
	@Test
	void testCreateOderReturnsSucesss201() {
		
		String body = createOrderBody();
		String uri = getBaseUriForCreateSongController();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
		
		ResponseEntity<?> response = getRestTemplate().exchange(uri,
				 HttpMethod.POST, bodyEntity, Song.class);
		
		
	
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		
		Song song = (Song) response.getBody();
		assertThat(song.getAlbumPrimaryKey()).isEqualTo(1);
		assertThat(song.getSongName()).isEqualTo("The Motion");
		assertThat(song.getFunFact()).isEqualTo("Drake gets deep in his feelings on this one.");
		assertThat(song.getDateReleased()).isEqualTo("01-02-2003");
		assertThat(song.getArtists().get(0)).isEqualTo("1");
	}
	
	
	
	  @Bean 
	  ServletWebServerFactory servletWebServerFactory(){
	  return new TomcatServletWebServerFactory();
	  }
	

}

