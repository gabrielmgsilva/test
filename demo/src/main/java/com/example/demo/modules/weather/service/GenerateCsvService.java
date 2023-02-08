package com.example.demo.modules.weather.service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modules.weather.database.entities.Weather;
import com.example.demo.modules.weather.database.repository.IWeatherRepository;

@Service
public class GenerateCsvService implements IGenerateCsvService {

	private final IWeatherRepository weatherRepository;

	public GenerateCsvService(IWeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}

	@Override
	public void generateCsv() {
		
		List<Weather> weathers = this.weatherRepository.findAll();
		
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("weather-table-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS"))+".csv"), "UTF-8")))
		{
			StringBuffer header = new StringBuffer();
			header.append("id,temperature,wind_direction,wind_speed,time,utc_time,location_id");
			bw.write(header.toString());
			bw.newLine();
			for(Weather w : weathers) {
				StringBuffer line = new StringBuffer();
				line.append(w.getId());
				line.append(",");
				line.append(w.getTemperature());
				line.append(",");
				line.append(w.getWinddirection());
				line.append(",");
				line.append(w.getWindspeed());
				line.append(",");
				line.append(w.getTime());
				line.append(",");
				line.append(w.getUtctime());
				line.append(",");
				line.append(w.getLocation().getId());
				
				bw.write(line.toString());
				bw.newLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
