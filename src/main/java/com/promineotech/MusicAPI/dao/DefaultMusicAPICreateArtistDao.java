package com.promineotech.MusicAPI.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.MusicAPI.entity.Artists;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DefaultMusicAPICreateArtistDao implements MusicAPICreateArtistDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Artists createArtist(Artists artist) {
		log.debug("DefaultMusicAPICreateArtistDao -> createArtist() method called");
		

		// @formatter:off
		final String sql = ""
				+ "INSERT INTO artists "
				+ "(artist_name, year_started, year_ended, place_of_origin, instagram_handle) VALUES "
				+ "(:artist_name, :year_started, :year_ended, :place_of_origin, :instagram_handle)";
		
		SqlParameterSource sqlParams = new 
				MapSqlParameterSource("artist_name", artist.getArtist_name())
								.addValue("year_started", artist.getYear_started())
								.addValue("year_ended", artist.getYear_ended())
								.addValue("place_of_origin", artist.getPlace_of_origin())
								.addValue("instagram_handle", artist.getInstagram_handle());
		// @formatter:on
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(sql, sqlParams, keyHolder);

		int artist_id = keyHolder.getKey().intValue();

		// @formatter:off
		return Artists.builder()
				.artist_id(artist_id)
				.artist_name(artist.getArtist_name())
				.year_started(artist.getYear_started())
				.year_ended(artist.getYear_ended())
				.place_of_origin(artist.getPlace_of_origin())
				.instagram_handle(artist.getInstagram_handle())
				.build();
		// @formatter:on
	}
}
