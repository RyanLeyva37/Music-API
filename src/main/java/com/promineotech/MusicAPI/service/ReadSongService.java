package com.promineotech.MusicAPI.service;

import com.promineotech.MusicAPI.entity.Song;

public interface ReadSongService {
	
	Song fetchSong(long id);

}
