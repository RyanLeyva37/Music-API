package com.promineotech.MusicAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.MusicAPI.entity.Song;
import com.promineotech.MusicAPI.service.DefaultReadSongService;
import com.promineotech.MusicAPI.service.ReadSongService;
@RestController
public class DefaultReadSongController implements ReadSongController{
	
	@Autowired
	private DefaultReadSongService readSongService;

	@Override
	public Song fetchsong(long id) {
		return readSongService.fetchSong(id);
	}

}
