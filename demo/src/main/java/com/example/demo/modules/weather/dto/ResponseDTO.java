package com.example.demo.modules.weather.dto;

import com.example.demo.modules.weather.database.entities.Weather;

public class ResponseDTO {
	private Weather weather;

	public ResponseDTO(Weather weather) {
		this.weather = weather;
	}

	public ResponseDTO() {
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
}
