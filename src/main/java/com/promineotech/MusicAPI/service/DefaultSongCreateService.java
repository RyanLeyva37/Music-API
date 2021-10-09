package com.promineotech.MusicAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.MusicAPI.dao.SongCreateDao;
import com.promineotech.MusicAPI.entity.Song;
import com.promineotech.MusicAPI.entity.SongRequest;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DefaultSongCreateService implements SongCreateService{
	
	@Autowired
	private SongCreateDao songCreateDao;

	
	@Transactional
	@Override
	public Song createSong(SongRequest request) {
		
		int albumId = request.getAlbumId();
		String songName = request.getSongName();
		String funFact = request.getFunFact();
		String dateReleased = request.getDateReleased();
		List<String> artists = request.getArtists();
		Song song = new Song(albumId, songName, funFact, dateReleased, artists);
		return songCreateDao.saveSong(song);
	}

}
