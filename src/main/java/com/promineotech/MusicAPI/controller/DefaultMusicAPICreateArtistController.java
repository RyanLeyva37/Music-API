package com.promineotech.MusicAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.service.MusicAPIArtistService;
import com.promineotech.MusicAPI.service.MusicAPICreateArtistService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultMusicAPICreateArtistController implements MusicAPICreateArtistController {
	
	@Autowired
	private MusicAPICreateArtistService musicAPICreateArtistService;
	
	@Override
	public Artists createArtist(Artists artist) {
		log.debug("DefaultUserController -> createArtist() method called");
		
		return musicAPICreateArtistService.createArtist(artist);
	}
}
