package com.example.demo.modules.weather.database.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.modules.weather.dto.WeatherDTO;

@Entity(name = "WeatherEntity")
@Table(name = "weather")
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint")
	private BigInteger id;
	@Column(name = "temperature", precision = 2, scale = 3)
	private float temperature;
	@Column(name = "wind_speed", precision = 2, scale = 3)
	private float windspeed;
	@Column(name = "wind_direction", precision = 2, scale = 3)
	private float winddirection;
	@Column(name = "time")
	private LocalDateTime time;
	@Column(name = "utc_time")
	private LocalDateTime utctime;
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public Weather(BigInteger id, float temperature, float windspeed, float winddirection, LocalDateTime time,
			LocalDateTime utctime, Location location) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.windspeed = windspeed;
		this.winddirection = winddirection;
		this.time = time;
		this.utctime = utctime;
		this.location = location;
	}

	public Weather(float temperature, float windspeed, float winddirection, LocalDateTime time, LocalDateTime utctime,
			Location location) {
		super();
		this.temperature = temperature;
		this.windspeed = windspeed;
		this.winddirection = winddirection;
		this.time = time;
		this.utctime = utctime;
		this.location = location;
	}

	public Weather() {
		super();
	}

	public Weather(WeatherDTO weatherDTO, Location location) {
		this.temperature = weatherDTO.getCurrentWeather().getTemperature();
		this.windspeed = weatherDTO.getCurrentWeather().getWindspeed();
		this.winddirection = weatherDTO.getCurrentWeather().getWinddirection();
		this.time = weatherDTO.getCurrentWeather().getTime();
		this.utctime = weatherDTO.getCurrentWeather().getTime();
		this.location = location;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getWindspeed() {
		return windspeed;
	}

	public void setWindspeed(float windspeed) {
		this.windspeed = windspeed;
	}

	public float getWinddirection() {
		return winddirection;
	}

	public void setWinddirection(float winddirection) {
		this.winddirection = winddirection;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public LocalDateTime getUtctime() {
		return utctime;
	}

	public void setUtctime(LocalDateTime utctime) {
		this.utctime = utctime;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
