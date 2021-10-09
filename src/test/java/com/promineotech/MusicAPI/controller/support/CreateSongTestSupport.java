package com.promineotech.MusicAPI.controller.support;



public class CreateSongTestSupport extends BaseTest{

	protected String createOrderBody() {
		return "{\n"
			+ "  \"songName\":\"3302\",\n"				
			+ "  \"albumId\":\"1\",\n"
			+ "  \"funFact\":\"Drake gets deep in his feelings on this one.\",\n"
			+ "  \"dateReleased\":\"01-02-2003\",\n"
			+ "  \"artists\":[\n"
			+ "    \"1\",\n"
			+ "    \"2\"\n"
			+ "  ]\n"
			+ "}";
	}

	  
	  
	  
}
