package com.promineotech.MusicAPI.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Song {


	  private Long SongPK;
	private long albumPrimaryKey;

	private String songName;
	private String funFact;
	private String dateReleased;
	List<String> artists;
	
	
}
