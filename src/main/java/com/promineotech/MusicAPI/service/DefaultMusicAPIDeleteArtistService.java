package com.promineotech.MusicAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.MusicAPI.dao.MusicAPICreateArtistDao;
import com.promineotech.MusicAPI.dao.MusicAPIDeleteArtistDao;
import com.promineotech.MusicAPI.entity.Artists;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DefaultMusicAPIDeleteArtistService implements MusicAPIDeleteArtistService {
	
		@Autowired
		MusicAPIDeleteArtistDao musicAPIDeleteArtistDao;
		
		@Override
		public Artists deleteArtist(Artists artist) {
			log.debug("DefaultMusicAPIArtistService -> createArtist() method called");
			
			return musicAPIDeleteArtistDao.deleteArtist(artist);
		
		}
}
