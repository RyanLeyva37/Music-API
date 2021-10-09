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

public class DefaultMusicAPIDeleteArtistDao implements MusicAPIDeleteArtistDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Artists deleteArtist(Artists artist) {
		log.debug("DefaultMusicAPIDeleteArtistDao -> deleteArtist() method called");
	
		// @formatter:off
				final String sql = ""
						+ "DELETE "
						+ "FROM Artists "
						+ "WHERE artist_name = :artist_name";
				
				SqlParameterSource sqlParams = new 
						MapSqlParameterSource("artist_name", artist.getArtist_name());
				// @formatter:on

				jdbcTemplate.update(sql, sqlParams);


				// @formatter:off
				return Artists.builder()
						.artist_name(artist.getArtist_name())
						.year_started(artist.getYear_started())
						.year_ended(artist.getYear_ended())
						.place_of_origin(artist.getPlace_of_origin())
						.instagram_handle(artist.getInstagram_handle())
						.build();
				// @formatter:on
			}
}
