package com.example.demo.modules.weather.service;

import com.example.demo.modules.weather.dto.ResponseDTO;

public interface IWeatherService {

	public ResponseDTO getWeather(float lat, float longi, boolean currentWeather) throws Exception;

}
