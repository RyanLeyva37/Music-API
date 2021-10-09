package com.promineotech.MusicAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.MusicAPI.dao.ReadSongDao;
import com.promineotech.MusicAPI.entity.Song;
@Service
public class DefaultReadSongService implements ReadSongService{
	
	@Autowired
	private ReadSongDao dao;

	@Override
	public Song fetchSong(long id) {
		// TODO Auto-generated method stub
		return dao.fetchSong(id);
	}



}
