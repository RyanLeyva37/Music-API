package com.promineotech.MusicAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.MusicAPI.entity.Artists;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/Music_Artists")
@OpenAPIDefinition(info = @Info(title = "Delete Artist Service"), servers = {
@Server(url = "http://localhost:8080", description = "Local Server")})

public interface MusicAPIDeleteArtistController {
	// @formatter:off
			@Operation(
					summary = "Delete an Artist",
					description = "Deletes an Artist from the Database",
					responses = {
							@ApiResponse(
									responseCode = "201", 
									description = "The deleted Artist is returned", 
									content = @Content(mediaType = "application/json", 
									schema = @Schema(implementation = Artists.class))),
							@ApiResponse(
									responseCode = "400", 
									description = "The request parameters are invalid", 
									content = @Content(mediaType = "application/json")),
							@ApiResponse(
									responseCode = "404", 
									description = "An artist detail was not found with the input criteria", 
									content = @Content(mediaType = "application/json")),
							@ApiResponse(
									responseCode = "500", 
									description = "An unplanned error ocurred.", 
									content = @Content(mediaType = "application/json"))
					},
					parameters = {
							@Parameter(
									name = "Artist_name", 
									allowEmptyValue = false, 
									required = false, 
									description = "The Artist's name (i.e., 'Led Zeppelin')"),
							
					}
			)
			
			@DeleteMapping
			@ResponseStatus(code = HttpStatus.ACCEPTED)
			Artists deleteArtist(@RequestBody Artists artist);
			// @formatter:on
}
