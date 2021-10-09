package com.promineotech.MusicAPI.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.promineotech.MusicAPI.entity.Song;
@Component
public class DefaultReadSongDao implements ReadSongDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Song fetchSong(long Id) {
		
		String sql =
		"SELECT * " + 
		"FROM songs "
		+ "WHERE Song_id = :id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("id", Id);
		
		List<Song> list = jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Song.builder().dateReleased("Date_released").funFact("Fun_fact")
				.songName(rs.getString("Song_name"))
				.albumPrimaryKey(rs.getLong("Album_id"))
				.build();
			}});
		
		
		return list.get(0);
	}

}
