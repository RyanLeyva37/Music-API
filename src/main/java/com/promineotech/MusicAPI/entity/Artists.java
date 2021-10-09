package com.promineotech.MusicAPI.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Artists implements Comparable<Artists> {
	private int artist_id;
	private String artist_name;
	private int year_started;
	private int year_ended;
	private Locations place_of_origin;
	private String instagram_handle;
	
	
	@Override
	public int compareTo(Artists that) {
		// @formatter:off
		return Comparator
				.comparing(Artists::getArtist_id)
				.compare(this, that);
		// @formatter:on
	}
}
