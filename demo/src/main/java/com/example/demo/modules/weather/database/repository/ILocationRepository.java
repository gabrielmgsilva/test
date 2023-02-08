package com.example.demo.modules.weather.database.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modules.weather.database.entities.Location;

public interface ILocationRepository extends JpaRepository<Location, UUID>{

}
