package com.promineotech.MusicAPI.controller;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.MusicAPI.entity.Song;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
@Validated
@RequestMapping("/readSong")
@OpenAPIDefinition(info = @Info(title = "Song reading service"), servers = {
    @Server(url = "http://localhost:3306", description = "Local server.")})
public interface ReadSongController {
	
  
  
  @Operation(summary = "Returns a song by Id",
      description = "Returns a song based on the Id",
      responses = {
          @ApiResponse(responseCode = "200",
              description = "A song is retuned",
              content = @Content(mediaType = "application/json", schema = @Schema(implementation = Song.class))),
          
          @ApiResponse(responseCode = "400", 
              description =  "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(responseCode = "404", 
              description =  "No Jeeps were found with the input criteria",
          content = @Content(mediaType = "application/json")),
          
          @ApiResponse(responseCode = "500", 
              description =  "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
          

      },
      parameters = {
          @Parameter(name = "id", allowEmptyValue = false, required = true, description = "The ID of a song"),
      })
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  Song fetchsong(
		  @RequestParam(required = false)
		  	long id);

}
