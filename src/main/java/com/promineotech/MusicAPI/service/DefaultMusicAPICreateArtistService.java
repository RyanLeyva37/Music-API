package com.promineotech.MusicAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.MusicAPI.dao.MusicAPICreateArtistDao;
import com.promineotech.MusicAPI.entity.Artists;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultMusicAPICreateArtistService implements MusicAPICreateArtistService {
	
	@Autowired
	MusicAPICreateArtistDao musicAPICreateArtistDao;
	
	@Override
	public Artists createArtist(Artists artist) {
		log.debug("DefaultMusicAPIArtistService -> createArtist() method called");
		
		return musicAPICreateArtistDao.createArtist(artist);
	}
}
