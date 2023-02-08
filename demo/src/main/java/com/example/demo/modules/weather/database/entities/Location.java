package com.example.demo.modules.weather.database.entities;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "LocationEntity")
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint")
	private BigInteger id;
	@Column(name = "longitude", scale = 3, precision = 2)
	private float longitude;
	@Column(name = "latitude", scale = 3, precision = 2)
	private float latitude;
	@Column(name = "current_weather")
	private boolean currentWeather;

	@OneToMany(mappedBy = "location")
	private List<Weather> weathers;

	public Location(BigInteger id, float longitude, float latitude, boolean currentWeather, List<Weather> weathers) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.currentWeather = currentWeather;
		this.weathers = weathers;
	}

	public Location(float longitude, float latitude, boolean currentWeather, List<Weather> weathers) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.currentWeather = currentWeather;
		this.weathers = weathers;
	}

	public Location() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public boolean isCurrentWeather() {
		return currentWeather;
	}

	public void setCurrentWeather(boolean currentWeather) {
		this.currentWeather = currentWeather;
	}

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

}
