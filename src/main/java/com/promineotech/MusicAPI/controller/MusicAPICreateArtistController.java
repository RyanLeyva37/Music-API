package com.promineotech.MusicAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.MusicAPI.entity.Artists;
import com.promineotech.MusicAPI.entity.Locations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;



@RequestMapping("/Create_Artist")
@OpenAPIDefinition(info = @Info(title = "Create Artist Service"), 
servers = {@Server(url = "http://localhost:8080", description = "Local Server") })

public interface MusicAPICreateArtistController {
	// @formatter:off
		@Operation(
				summary = "Create a new Artist",
				description = "Returns the created Artist",
				responses = {
						@ApiResponse(
								responseCode = "201", 
								description = "The created Artist is returned", 
								content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, 
								schema = @Schema(implementation = Artists.class))),
						@ApiResponse(
								responseCode = "400", 
								description = "The request parameters are invalid", 
								content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
						@ApiResponse(
								responseCode = "404", 
								description = "An artist detail was not found with the input criteria", 
								content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
						@ApiResponse(
								responseCode = "500", 
								description = "An unplanned error ocurred.", 
								content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
				})
		
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		Artists createArtist(@RequestBody Artists artist);
		// @formatter:on
}

