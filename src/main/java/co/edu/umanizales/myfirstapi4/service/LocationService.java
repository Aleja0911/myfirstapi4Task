package co.edu.umanizales.myfirstapi4.service;
import co.edu.umanizales.myfirstapi4.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class LocationService {

    private List<Location> locations;

    @Value("DIVIPOLA-_C_digos_municipios_20250326.csv")
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();

        Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                locations.add(new Location(line[2], line[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getStates() {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().length() == 2) {
                states.add(location);
            }
        }
        return states;
    }
    public Location getLocationByName(String name) {
        for (Location location : locations) {
            if (location.getCode().equals(name)) {
                return location;
            }
        }
        return null;
    }
    public List<Location> getLocationByLetter(String letter) {
        List<Location> matchedLocations = new ArrayList<>();

        for (Location location : locations) {
            if (location.getCode().equals(letter)) {
                matchedLocations.add(location);
            }
        }

        return matchedLocations;
    }
    public List<Location> getLocationByStateCode(String stateCode) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().equals(stateCode)) {
                result.add(location);
            }
        }
        return result;
    }

}


