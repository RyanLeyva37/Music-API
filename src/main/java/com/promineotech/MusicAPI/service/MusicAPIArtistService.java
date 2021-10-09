package com.promineotech.MusicAPI.service;

import java.util.List;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

public interface MusicAPIArtistService {

	/**
	 *
	 * @param place_of_origin
	 * @return
	 */
	List<Artists> fetchArtists(Locations place_of_origin);

}
