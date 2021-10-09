package com.promineotech.MusicAPI.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.MusicAPI.entity.Song;

public interface SongCreateDao {
	
//	private int albumPrimaryKey;
//	private String songName;
//	private String funFact;
//	private String dateReleased;
//	List<String> artists;
		
	Song saveSong(Song song);
	
	Song readSong(int id);
	
}
