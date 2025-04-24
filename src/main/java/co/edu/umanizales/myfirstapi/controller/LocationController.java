package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Location;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final List<Location> locations = new ArrayList<>();

    public LocationController() {
        locations.add(new Location("001", "Ukraina", "UA", true));
        locations.add(new Location("002", "Bogotá", "CO", true));
        locations.add(new Location("003", "Medellín", "CO", false));
        locations.add(new Location("004", "Kharkiv", "UA", false));
        locations.add(new Location("005", "Cali", "CO", false));
    }

    @GetMapping("/by-code/{code}")
    public Location getLocationByCode(@PathVariable String code) {
        return locations.stream()
                .filter(loc -> loc.getCode().equalsIgnoreCase(code))
                .findFirst().orElse(null);
    }

    @GetMapping("/by-name/{name}")
    public Location getLocationByName(@PathVariable String name) {
        return locations.stream()
                .filter(loc -> loc.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    @GetMapping("/by-initials/{letters}")
    public List<Location> getLocationByInitialLetters(@PathVariable String letters) {
        return locations.stream()
                .filter(loc -> loc.getName().toLowerCase().startsWith(letters.toLowerCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/by-state-code/{stateCode}")
    public List<Location> getLocationByStateCode(@PathVariable String stateCode) {
        return locations.stream()
                .filter(loc -> loc.getStateCode().equalsIgnoreCase(stateCode))
                .collect(Collectors.toList());
    }

    @GetMapping("/states")
    public List<String> getStates() {
        return locations.stream()
                .map(Location::getStateCode)
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping("/states/{code}")
    public String getStateByCode(@PathVariable String code) {
        boolean exists = locations.stream()
                .anyMatch(loc -> loc.getStateCode().equalsIgnoreCase(code));
        return exists ? "State found: " + code : "State not found";
    }

    @GetMapping("/capitals")
    public List<Location> getCapitals() {
        return locations.stream()
                .filter(Location::isCapital)
                .collect(Collectors.toList());
    }
}
