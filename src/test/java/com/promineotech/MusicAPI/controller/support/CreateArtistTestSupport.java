package com.promineotech.MusicAPI.controller.support;

public class CreateArtistTestSupport extends BaseTest {
	/**
	 * 
	 * @return
	 */
	protected String createArtistBody() {
		// @formatter:off
		return "{\n"
				+ "	\"artist_name\":\"Tame Impala\",\n"
			    + "	\"year_started\":\"2007\",\n"
			    + "	\"year_ended\":\"9999\",\n"
			    + "	\"place_of_origin\":\"Perth, Western Australia\",\n"
			    + " \"instagram_handle\":\"tameimpala\",\n"
				+ "}";
		// @formatter:on
	}
}
