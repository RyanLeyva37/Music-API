package com.promineotech.MusicAPI.service;

import com.promineotech.MusicAPI.entity.Song;
import com.promineotech.MusicAPI.entity.SongRequest;

public interface SongCreateService {
	
	Song createSong(SongRequest request);

}
