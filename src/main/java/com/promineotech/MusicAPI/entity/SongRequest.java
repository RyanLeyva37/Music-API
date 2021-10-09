package com.promineotech.MusicAPI.entity;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;


@Data
public class SongRequest {
	
	@NotNull
	private int albumId;
	
	@Length(max = 100)
	@Pattern(regexp = "[\\w\\s]*")
	private String songName;
	
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
	private String funFact;
	
	
	
	@Length(max = 10)
	private String dateReleased;
	
	private List<@NotNull @Length(max=3) @Pattern(regexp = "[A-Z0-9]*") String> artists;

}
