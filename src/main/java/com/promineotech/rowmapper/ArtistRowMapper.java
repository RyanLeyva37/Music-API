package com.promineotech.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

public class ArtistRowMapper implements RowMapper<Artists> {

	@Override
	public Artists mapRow(ResultSet rs, int rowNum) throws SQLException {
		// @formatter:off
		return Artists.builder()
				.artist_id(rs.getInt("artist_id"))
				.artist_name(rs.getString("artist_name"))
				.year_started(rs.getInt("year_started"))
				.year_ended(rs.getInt("year_ended"))
				.place_of_origin(Locations.valueOf(rs.getString("place_of_origin")))
				.instagram_handle(rs.getString("instagram_handle"))
				.build();
		// @formatter:on		
	};
}
