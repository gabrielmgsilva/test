package com.example.demo.modules.weather.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.modules.weather.database.repository.ILocationRepository;
import com.example.demo.modules.weather.database.repository.IWeatherRepository;
import com.example.demo.modules.weather.dto.ResponseDTO;


class WeatherServiceTest {
	
	private IWeatherService service;
	
	@Mock private IGenerateCsvService csvService;
	@Mock private IWeatherRepository weatherRepository;
	@Mock private ILocationRepository locationRepository;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.service = new WeatherService(weatherRepository, locationRepository, csvService);
	}

	@Test
	void mustReturnWeatherForecast() throws Exception {
		float lat = -23.31F;
		float longi = -48.97F;
		
		ResponseDTO response = this.service.getWeather(lat, longi, true);
		
		Assert.assertNotNull(response);
	}
	
	@Test
	void mustThrowErrorWhenSearchForTheWeatger() {
		String wrongformat = "-23.31";
		float longi = -48.97F;
		
		try {
			service.getWeather(Float.parseFloat(wrongformat), longi, true);
			Assert.fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Failed to convert value of type 'java.lang.String' to required type 'float'; nested exception is java.lang.NumberFormatException: For input string: \"-23,45\""));
		}
	}

	
}
