package com.zf.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zf.cs.db.model.Location;
import com.zf.cs.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository repos;
	
	@Override
	public Location saveLocation(Location location) {
		
		return repos.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		
		return repos.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		
		repos.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
	
		Location location = new Location();
		location = repos.findById(id).get();
		return location;
	}

	@Override
	public List<Location> getAllLocations() {
		List<Location> allLocations = repos.findAll();
		return allLocations;
	}

}
