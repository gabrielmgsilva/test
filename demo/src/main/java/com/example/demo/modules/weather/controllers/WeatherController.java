package com.example.demo.modules.weather.controllers;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modules.weather.dto.ResponseDTO;
import com.example.demo.modules.weather.service.IWeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	private final IWeatherService weatherService;
	
	public WeatherController(IWeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GetMapping()
	public ResponseEntity<ResponseDTO> getForecast(@PathParam(value = "latitude") float latitude
									   , @PathParam(value = "longitude") float longitude) throws Exception{

		return new ResponseEntity<ResponseDTO>(weatherService.getWeather(latitude, longitude, true), HttpStatus.OK);
	}
}
