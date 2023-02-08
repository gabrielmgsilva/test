package com.example.demo.modules.weather.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modules.weather.database.entities.Location;
import com.example.demo.modules.weather.database.entities.Weather;
import com.example.demo.modules.weather.database.repository.ILocationRepository;
import com.example.demo.modules.weather.database.repository.IWeatherRepository;
import com.example.demo.modules.weather.dto.ResponseDTO;
import com.example.demo.modules.weather.dto.WeatherDTO;

@Service
public class WeatherService implements IWeatherService {
	
	private final String api = "https://api.open-meteo.com/v1/forecast?";
	
	private final IWeatherRepository weatherRepository;
	private final ILocationRepository locationRepository;
	private final IGenerateCsvService csvService;
	
	public WeatherService(IWeatherRepository weatherRepository, ILocationRepository locationRepository, IGenerateCsvService csvService) {
		this.locationRepository = locationRepository;
		this.weatherRepository = weatherRepository;
		this.csvService = csvService;
	}

	@Override
	public ResponseDTO getWeather(float lat, float longi, boolean currentWeather) throws Exception {
		
		Location location = this.saveRequest(lat, longi, currentWeather);
		
		RestTemplate http = new RestTemplate();
		
		String stringlat = String.valueOf(lat);
		String stringlongi = String.valueOf(longi);
		String currentWeatherString = String.valueOf(currentWeather);
		
		String fullUri = String.format(api + "latitude=%s&longitude=%s&current_weather=%s"
				, stringlat, stringlongi, currentWeatherString);
		
		ResponseEntity<WeatherDTO> response = http.getForEntity(fullUri, WeatherDTO.class);
		
		WeatherDTO weatherDTO= response.getBody();
		
		Weather weather = new Weather(weatherDTO, location);
		
		this.weatherRepository.save(weather);
		
		this.csvService.generateCsv();
		
		return new ResponseDTO(weather);
	}
	
	private Location saveRequest(float lat, float longi, boolean currentWeather) throws Exception {
		Location location = new Location();
		location.setLatitude(lat);
		location.setLongitude(longi);
		location.setCurrentWeather(currentWeather);
		
		this.locationRepository.save(location);
		
		return location;
	}

}
