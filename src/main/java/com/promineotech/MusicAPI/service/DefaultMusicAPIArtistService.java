package com.promineotech.MusicAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.MusicAPI.dao.MusicAPIArtistDao;
import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultMusicAPIArtistService implements MusicAPIArtistService {
	
	@Autowired
	private MusicAPIArtistDao musicAPIArtistDao;
	
	@Override
	public List<Artists> fetchArtists(Locations place_of_origin) {
		log.info("The fetchArtists method was called with place_of_origin={}, place_of_origin");
		
		return musicAPIArtistDao.fetchArtists(place_of_origin);
	}
}
