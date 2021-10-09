package com.promineotech.MusicAPI.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component

public class DefaultMusicAPIArtistDao implements MusicAPIArtistDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Artists> fetchArtists(Locations place_of_origin) {
		log.debug("DAO: place_of_origin={}, place_of_origin");
	
	// @formatter:off
	String sql = ""
			+ "SELECT * "
			+ "FROM Artists "
			+ "WHERE place_of_origin = :place_of_origin";
	// @formatter:on
	
	Map<String, Object> params = new HashMap<>();
	params.put("place_of_origin", place_of_origin.toString());
	
	return jdbcTemplate.query(sql, params, new RowMapper<>() {
		
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
		}});
	}
}
