package com.example.demo.modules.weather.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class WeatherDTO {

	private float latitude;
	private float longitude;
	@JsonAlias("generationtime_ms")
	private float generationtimems;
	@JsonAlias("generationtime_ms")
	private int utcoffsetseconds;
	private String timezone;
	@JsonAlias("timezone_abbreviation")
	private String timezoneabbreviation;
	private float elevation;
	@JsonAlias("current_weather")
	private CurrentWeather currentWeather;

	public WeatherDTO(float latitude, float longitude, float generationtimems, int utcoffsetseconds, String timezone,
			String timezoneabbreviation, float elevation, CurrentWeather currentWeather) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.generationtimems = generationtimems;
		this.utcoffsetseconds = utcoffsetseconds;
		this.timezone = timezone;
		this.timezoneabbreviation = timezoneabbreviation;
		this.elevation = elevation;
		this.currentWeather = currentWeather;
	}

	public WeatherDTO() {
		super();
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getGenerationtimems() {
		return generationtimems;
	}

	public void setGenerationtimems(float generationtimems) {
		this.generationtimems = generationtimems;
	}

	public int getUtcoffsetseconds() {
		return utcoffsetseconds;
	}

	public void setUtcoffsetseconds(int utcoffsetseconds) {
		this.utcoffsetseconds = utcoffsetseconds;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTimezoneabbreviation() {
		return timezoneabbreviation;
	}

	public void setTimezoneabbreviation(String timezoneabbreviation) {
		this.timezoneabbreviation = timezoneabbreviation;
	}

	public float getElevation() {
		return elevation;
	}

	public void setElevation(float elevation) {
		this.elevation = elevation;
	}

	public CurrentWeather getCurrentWeather() {
		return currentWeather;
	}

	public void setCurrentWeather(CurrentWeather currentWeather) {
		this.currentWeather = currentWeather;
	}

	
}
