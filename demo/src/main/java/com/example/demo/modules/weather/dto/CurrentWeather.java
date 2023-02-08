package com.example.demo.modules.weather.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CurrentWeather {

	@JsonAlias("temperature")
	private float temperature;
	@JsonAlias("windspeed")
	private float windSpeed;
	@JsonAlias("winddirection")
	private float windDirection;
	@JsonAlias("weathercode")
	private int weatherCode;
	@JsonAlias("time")
	private LocalDateTime time;

	public CurrentWeather(float temperature, float windspeed, float winddirection, int weathercode, LocalDateTime time) {
		super();
		this.temperature = temperature;
		this.windSpeed = windspeed;
		this.windDirection = winddirection;
		this.weatherCode = weathercode;
		this.time = time;
	}

	public CurrentWeather() {
		super();
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getWindspeed() {
		return windSpeed;
	}

	public void setWindspeed(float windspeed) {
		this.windSpeed = windspeed;
	}

	public float getWinddirection() {
		return windDirection;
	}

	public void setWinddirection(float winddirection) {
		this.windDirection = winddirection;
	}

	public int getWeathercode() {
		return weatherCode;
	}

	public void setWeathercode(int weathercode) {
		this.weatherCode = weathercode;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CurrentWeather [temperature=" + temperature + ", windspeed=" + windSpeed + ", winddirection="
				+ windDirection + ", weathercode=" + weatherCode + ", time=" + time + "]";
	}
}
