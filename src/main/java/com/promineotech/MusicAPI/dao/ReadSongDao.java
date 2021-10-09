package com.promineotech.MusicAPI.dao;

import com.promineotech.MusicAPI.entity.Song;

public interface ReadSongDao {
	
	Song fetchSong(long Id);

}
