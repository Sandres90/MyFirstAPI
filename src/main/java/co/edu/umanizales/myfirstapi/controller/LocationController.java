package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
@RequestMapping(path = "/location")
public class LocationController {


    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping(path = "/byCode/{code}")
    public Location getLocationByCode(@PathVariable String code) {
        return locationService.getLocationByCode(code);

    }

    @GetMapping(path = "/states")
    public List<Location> getLocationByStates() {
        return locationService.getStates();
    }

    @GetMapping(path = "/name/{name}")
    public Location getLocationByName(@PathVariable String name) {
        return locationService.getLocationByName(name);

    }

    @GetMapping(path = "/initialLetters/{initial}")
    public List<Location> getLocationByInitial(@PathVariable String initial) {
        return locationService.getLocationsByInitialLetter(initial);
    }

    @GetMapping(path = "/StartLetter/{Letters}")
    public List<Location> getLocationByLetters(@PathVariable String Letters) {
        return locationService.getLocationByLetter(Letters);
    }


    @GetMapping("/statecode/{stateCode}")
    public List<Location> getLocationByStateCode(@PathVariable String stateCode) {
        return locationService.getLocationByStateCode(stateCode);

    }

    @GetMapping("/capitals")
    public List<Location> getCapitals() {
        return locationService.getCapitals();
    }


    @GetMapping(path = "/StateByCode/{stateByCode}")
    public Location getStateByCode(@PathVariable String stateByCode) {
        return locationService.getStateByCode(stateByCode);
    }
    @GetMapping(path = "/StartEnd/{initial}/{end}")
    public List<Location> getStartEnd(@PathVariable String initial, @PathVariable String end) {
        return locationService.getStartEnd(initial,end);
    }
}