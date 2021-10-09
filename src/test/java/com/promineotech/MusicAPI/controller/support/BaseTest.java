package com.promineotech.MusicAPI.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

public class BaseTest {
	
	  @LocalServerPort
	  private int serverPort;

	  
	  protected String getBaseUriForCreateSongController() {
		    return String.format("http://localhost:%d/createsong", serverPort);
		  }
	  
	  @Autowired
	  private TestRestTemplate restTemplate;
	  
	  public TestRestTemplate getRestTemplate() {
		return restTemplate;
	}
	  
}
