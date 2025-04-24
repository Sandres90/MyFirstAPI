package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private final List<Location> locations = new ArrayList<>();

    public LocationService() {
        locations.add(new Location("001", "Ukraina", "UA", true));
        locations.add(new Location("002", "Bogotá", "CO", true));
        locations.add(new Location("003", "Medellín", "CO", false));
        locations.add(new Location("004", "Kharkiv", "UA", false));
        locations.add(new Location("005", "Cali", "CO", false));
    }

    public Location getLocationByCode(String code) {
        return locations.stream()
                .filter(loc -> loc.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public Location getLocationByName(String name) {
        return locations.stream()
                .filter(loc -> loc.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Location> getLocationsByInitialLetters(String letters) {
        return locations.stream()
                .filter(loc -> loc.getName().toLowerCase().startsWith(letters.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Location> getLocationsByStateCode(String stateCode) {
        return locations.stream()
                .filter(loc -> loc.getStateCode().equalsIgnoreCase(stateCode))
                .collect(Collectors.toList());
    }

    public List<String> getStates() {
        return locations.stream()
                .map(Location::getStateCode)
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean stateExistsByCode(String code) {
        return locations.stream()
                .anyMatch(loc -> loc.getStateCode().equalsIgnoreCase(code));
    }

    public List<Location> getCapitals() {
        return locations.stream()
                .filter(Location::isCapital)
                .collect(Collectors.toList());
    }
}
