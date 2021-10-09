package com.promineotech.MusicAPI.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.promineotech.MusicAPI.entity.Song;
import com.promineotech.MusicAPI.entity.SongRequest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/createsong")
@OpenAPIDefinition(info = @Info(title = "Song Creation Service"), servers = {
		 @Server(url = "http://localhost:3306", description = "Local server.")
})
public interface SongCreateController {
	
	
	  @Operation(summary = "Create a song record",
		      description = "Returns the created Jeep",
		      responses = {
		          @ApiResponse(responseCode = "201",
		              description = "The created Jeep is returned",
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Song.class))),
		          
		          @ApiResponse(responseCode = "400", 
		              description =  "The request parameters are invalid",
		              content = @Content(mediaType = "application/json")),
		          
		          @ApiResponse(responseCode = "404", 
		              description =  "A Jeep component was not found with the input criteria",
		          content = @Content(mediaType = "application/json")),
		          
		          @ApiResponse(responseCode = "500", 
		              description =  "An unplanned error occured.",
		              content = @Content(mediaType = "application/json"))
		          

		      },
		      parameters = {
		          @Parameter(name = "orderRequest", 
		        		  required = true, 
		        		  description = "The order as JSON"),
		      })
		  
		  @PostMapping
		  @ResponseStatus(code = HttpStatus.CREATED)
		  Song createSong(@Valid @RequestBody SongRequest orderRequest);	

}
