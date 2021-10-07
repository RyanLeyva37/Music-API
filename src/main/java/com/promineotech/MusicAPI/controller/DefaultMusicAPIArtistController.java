package com.promineotech.MusicAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;
import com.promineotech.MusicAPI.service.MusicAPIArtistService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultMusicAPIArtistController implements MusicAPIArtistController {

	@Autowired
	private MusicAPIArtistService musicAPIArtistService;
	
	@Override
	public List<Artists> fetchArtists(Locations place_of_origin) {
		log.debug("place_of_origin={}", place_of_origin);
		return musicAPIArtistService.fetchArtists(place_of_origin); 
	}
		
}
