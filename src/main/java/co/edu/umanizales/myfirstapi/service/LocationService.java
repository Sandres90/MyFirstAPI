package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class LocationService {

    private List<Location> locations;

    @Value("${locations.filename:DIVIPOLA-_C_digos_municipios_20250326.csv}")
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException {
        locations = new ArrayList<>();

        // Departamentos base
        locations.add(new Location("05", "ANTIOQUIA"));
        locations.add(new Location("06", "ANTIOQUIA"));
        locations.add(new Location("07", "ANTIOQUIA"));
        locations.add(new Location("91", "AMAZONAS"));
        locations.add(new Location("08", "ATLANTICO"));
        locations.add(new Location("11", "BOGOTA"));
        locations.add(new Location("13", "BOLIVAR"));
        locations.add(new Location("15", "BOYACA"));
        locations.add(new Location("18", "CAQUETA"));
        locations.add(new Location("19", "CAUCA"));
        locations.add(new Location("85", "CASANARE"));
        locations.add(new Location("20", "CESAR"));
        locations.add(new Location("27", "CHOCO"));
        locations.add(new Location("25", "CUNDINAMARCA"));
        locations.add(new Location("23", "CORDOBA"));
        locations.add(new Location("94", "GUANIA"));
        locations.add(new Location("95", "GUAVIARE"));
        locations.add(new Location("41", "HUILA"));
        locations.add(new Location("44", "LA GUAJIRA"));
        locations.add(new Location("47", "MAGDALENA"));
        locations.add(new Location("50", "META"));
        locations.add(new Location("52", "NARIÑO"));
        locations.add(new Location("54", "NORTE DE SANTANDER"));
        locations.add(new Location("86", "PUTUMAYO"));
        locations.add(new Location("63", "QUINDIO"));
        locations.add(new Location("88", "SAN ANDRES y PROVIDENCIA"));
        locations.add(new Location("68", "SANTANDER"));
        locations.add(new Location("70", "SUCRE"));
        locations.add(new Location("73", "TOLIMA"));
        locations.add(new Location("76", "VALLE DEL CAUCA"));
        locations.add(new Location("99", "VICHADA"));
        locations.add(new Location("97", "VAUPES"));
        locations.add(new Location("81", "ARAUCA"));

        try (
                InputStream is = getClass().getClassLoader().getResourceAsStream(locationsFilename);
                CSVReader csvReader = new CSVReader(new InputStreamReader(is))
        ) {
            if (is == null) {
                throw new IOException("Archivo CSV no encontrado: " + locationsFilename);
            }

            String[] line;
            csvReader.skip(1); // Saltar encabezado
            while ((line = csvReader.readNext()) != null) {
                if (line.length >= 4) {
                    locations.add(new Location(line[2], line[3]));
                }
            }

            System.out.println("Total de ubicaciones cargadas: " + locations.size());
        } catch (CsvValidationException e) {
            throw new RuntimeException("Error al leer el archivo CSV", e);
        }
    }

    public Location getLocationByCode(String code) {
        return locations.stream()
                .filter(location -> location.getCode().equals(code))
                .findFirst()
                .orElse(null);
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
            if (location.getDescription().equalsIgnoreCase(name)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocationsByInitialLetter(String letter) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getDescription().startsWith(letter)) {
                result.add(location);
            }
        }
        return result;
    }

    public List<Location> getLocationByLetter(String letter) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().equals(letter)) {
                result.add(location);
            }
        }
        return result;
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

    public List<Location> getCapitals() {
        List<Location> capitals = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().endsWith("01") && location.getCode().length() == 5) {
                capitals.add(location);
            }
        }
        return capitals;
    }

    public Location getStateByCode(String stateCode) {
        for (Location location : locations) {
            if (location.getCode().equals(stateCode)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getStartEnd(String initial, String end) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getDescription().startsWith(initial) &&
                    location.getDescription().endsWith(end)) {
                result.add(location);
            }
        }
        return result;
    }
}
