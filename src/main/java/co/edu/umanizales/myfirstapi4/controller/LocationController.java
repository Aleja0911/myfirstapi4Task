package co.edu.umanizales.myfirstapi4.controller;

import co.edu.umanizales.myfirstapi4.model.Location;
import co.edu.umanizales.myfirstapi4.service.LocationService;
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

    @GetMapping(path = "/initialLetters/{InitialLetters}")
    public List<Location> getLocationByInitial(@PathVariable String initial) {
        return locationService.getLocationsByInitialLetter(initial);
    }

    @GetMapping(path = "/{InitialLetters}")
    public List<Location> getLocationByLetters(@PathVariable String InitialLetters) {
        return locationService.getLocationByLetter(InitialLetters);
    }


    @GetMapping("/StateCode/{statecode}")
    public List<Location> getLocationByStateCode(@PathVariable String stateCode) {
        return locationService.getLocationByStateCode(stateCode);

    }

    @GetMapping("/capitals")
    public List<Location> getCapitals() {
        return locationService.getCapitals();
    }

    @GetMapping(path = "/StateByCode/{statecode}")
    public Location getStateByCode(@PathVariable String stateCode) {
        return locationService.getStateByCode(stateCode);
    }
}