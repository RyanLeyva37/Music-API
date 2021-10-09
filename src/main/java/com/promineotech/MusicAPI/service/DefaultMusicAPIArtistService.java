package com.promineotech.MusicAPI.service;


import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.MusicAPI.dao.MusicAPIArtistDao;
import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultMusicAPIArtistService implements MusicAPIArtistService {
	
	@Autowired
	private MusicAPIArtistDao musicAPIArtistDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Artists> fetchArtists(Locations place_of_origin) {
		log.info("The fetchArtists method was called with place_of_origin={}, place_of_origin");
		
		List<Artists> artists = musicAPIArtistDao.fetchArtists(place_of_origin);
		
		if(artists.isEmpty()) {
			String msg = String.format("No Artists found with place_of_origin=%s", place_of_origin);
			throw new NoSuchElementException(msg);
		}
		
		Collections.sort(artists);
		return artists;
		
	}
	
	
}
