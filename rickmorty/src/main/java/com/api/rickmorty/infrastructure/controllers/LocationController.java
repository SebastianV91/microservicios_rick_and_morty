package com.api.rickmorty.infrastructure.controllers;

import com.api.rickmorty.application.services.LocationService;
import com.api.rickmorty.domain.model.Location;
import com.api.rickmorty.infrastructure.dto.LocationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
        Location createdLocation = locationService.createLocation(location);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Integer id){
        return locationService.getLocationById(id)
                .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocation(){
        List<Location> location = locationService.getAllLocations();
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Integer id, @RequestBody Location updatedLocation){
        return locationService.updateLocation(id, updatedLocation)
                .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Void> deleteLocationById(@PathVariable Integer id){
        if(locationService.deleteLocation(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/additional-info-location")
    public ResponseEntity<LocationDTO> getAdditionalInfoLocation(){
        LocationDTO locationDTO = locationService.getAdditionalLocationInfo();
        return new ResponseEntity<>(locationDTO, HttpStatus.OK);
    }

}
