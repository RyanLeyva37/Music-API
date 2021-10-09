package com.promineotech.MusicAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.service.MusicAPIDeleteArtistService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultMusicAPIDeleteArtistController implements MusicAPIDeleteArtistController {
	
	@Autowired
	private MusicAPIDeleteArtistService musicAPIDeleteArtistService;
	
	@Override
	public Artists deleteArtist(Artists artist) {
		log.debug("DefaultUserController -> createArtist() method called");
		
		return musicAPIDeleteArtistService.deleteArtist(artist);
	}
	
}
