package com.promineotech.MusicAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;

@RequestMapping("/Music_Artists")
@OpenAPIDefinition(info = @Info(title = "Artist Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local Server")})

public interface MusicAPIArtistController {
	
	
	// @formatter:off
	@Operation(
			summary = "Returns a list of Artists",
			description = "Returns a list of Artists given an optional place of origin",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of Artists is returned", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Artists.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No Artists were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error ocurred.", 
							content = @Content(mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "place_of_origin", 
							allowEmptyValue = false, 
							required = false, 
							description = "Where the Artist is from (i.e. 'Los Angeles, CA')"),
			}
	)
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Artists> fetchArtists(
			@RequestParam(required = false) 
			Locations place_of_origin);
	// @formatter:on
}
