package com.promineotech.MusicAPI.controller.support;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

public class FetchMusic_ArtistTestSupport extends BaseTest{
	
	protected List<Artists> buildExpected() {
		List<Artists> list = new LinkedList<>();
		
		// @formatter:off
		list.add(Artists.builder()
				.artist_name("Kygo")
				.year_started(2010)
				.year_ended(9999)
				.place_of_origin(Locations.Bergen_Norway)
				.instagram_handle("kygomusic")
				.build());
		
		list.add(Artists.builder()
				.artist_name("Tame Impala")
				.year_started(2007)
				.year_ended(9999)
				.place_of_origin(Locations.Perth_Western_Australia)
				.instagram_handle("tameimpala")
				.build());
		// @formatter:on
		
		Collections.sort(list);
		return list;
	}
}
