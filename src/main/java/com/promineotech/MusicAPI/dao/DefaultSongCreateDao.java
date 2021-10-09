package com.promineotech.MusicAPI.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.MusicAPI.entity.Song;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSongCreateDao implements SongCreateDao{
	
//	private int albumPrimaryKey;
//	private String songName;
//	private String funFact;
//	private String dateReleased;
//	List<String> artists;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Song saveSong(Song song) {
		
		SqlParams params = generateInsertSql(song);
		List<SqlParams> artistSql = new ArrayList<SqlParams>(); 
		KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, key);
		Long songPK = key.getKey().longValue();
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public Song readSong(int id) {
		
		String sql = 		"SELECT * " + 
				"FROM Songs "
				+ "WHERE Song_id = :id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
 		
		return (Song)jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Song.builder().dateReleased("Date_released").funFact("Fun_fact")
						.songName(rs.getString("Song_name"))
						.albumPrimaryKey(rs.getLong("Album_id"))
						.build();
			}});
	}
	
	
	
	
	
	
	  private SqlParams generateReadSql(int id) {
		  SqlParams params = new SqlParams();
		  params.sql = "SELECT * FROM Songs WHERE Song_id = :id";
		  params.source.addValue("id", id);
		// TODO Auto-generated method stub
		return params;
	}


	private SqlParams generateInsertSql(Song s) {
		  SqlParams params = new SqlParams();
		  long albumId = s.getAlbumPrimaryKey();
		  String songName = s.getSongName();
		  String funFact = s.getFunFact();
		  String dateReleased = s.getDateReleased();
		  // @formatter:off
		  params.sql = " INSERT INTO Songs (Album_id, Song_name, Fun_fact, Date_released)"
		      + " VALUES (:albumId, :songName, :funFact, :releaseDate)";
		    params.source.addValue("albumId", albumId);
		    params.source.addValue("songName", songName);
		    params.source.addValue("funFact", funFact);
		    params.source.addValue("releaseDate", dateReleased);
		    return params;
	  }
	  
	  private void saveSongArtistRelationship(List<String> artistIds, Long songId) {
		  for(String id : artistIds) {
			  try {
				  long parse = Long.parseLong(id);
				  SqlParams params =generateInsertSql(songId, parse);
			  }catch(Exception e) {
				  
			  }
			  
		  }
	  }
	  
	
	
	
	
	  private SqlParams generateInsertSql(long songId, long albumId) {
		  SqlParams params = new SqlParams();
		    
		  // @formatter:off
		  params.sql = ""
		      + "INSERT INTO Song_Artist(Artist_id, Song_id)"
		      + "VALUES"
		      + "(:songId, :albumId)";
		    params.source.addValue("songId", songId);
		    params.source.addValue("albumId", albumId);
		    
		    return params;
	  }
	  
	  
	  
	  
	  class SqlParams {
		    String sql;
		    MapSqlParameterSource source = new MapSqlParameterSource();
		  }






}
