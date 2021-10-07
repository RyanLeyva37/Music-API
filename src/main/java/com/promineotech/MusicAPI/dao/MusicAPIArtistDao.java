package com.promineotech.MusicAPI.dao;

import java.util.List;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

public interface MusicAPIArtistDao {

	List<Artists> fetchArtists(Locations place_of_origin);

}
