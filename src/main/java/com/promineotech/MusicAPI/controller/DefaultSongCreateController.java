package com.promineotech.MusicAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.promineotech.MusicAPI.entity.Song;
import com.promineotech.MusicAPI.entity.SongRequest;
import com.promineotech.MusicAPI.service.SongCreateService;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class DefaultSongCreateController implements SongCreateController{
	
	@Autowired
	private SongCreateService songCreateService;

	@Transactional
	@Override
	public Song createSong(@Valid SongRequest orderRequest) {
		log.debug("Order={}", orderRequest);
		return songCreateService.createSong(orderRequest);
	}

}
