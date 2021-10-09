package com.promineotech.MusicAPI.controller.support;

public class CreateArtistTestSupport extends BaseTest {
	/**
	 * 
	 * @return
	 */
	protected String createArtistBody() {
		// @formatter:off
		return "{\n"
				+ "	\"artist_name\":\"Tycho\",\n"
			    + "	\"year_started\":\"2002\",\n"
			    + "	\"year_ended\":\"9999\",\n"
			    + "	\"place_of_origin\":\"Sacramento\",\n"
			    + " \"instagram_handle\":\"tychomusic\",\n"
				+ "}";
		// @formatter:on
	}
}
