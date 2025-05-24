package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Store;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    private final List<Store> stores = new ArrayList<>();

    @PostConstruct
    public void loadStoresFromCSV() {
        try {
            URL resource = getClass().getClassLoader().getResource("stores.csv");
            if (resource == null) {
                System.err.println("⚠️ Archivo stores.csv no encontrado en resources.");
                return;
            }

            try (CSVReader csvReader = new CSVReader(new FileReader(Paths.get(resource.toURI()).toFile()))) {
                csvReader.skip(1); // saltar encabezado
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    // Asegúrate que el constructor de Store coincida con el número de columnas
                    stores.add(new Store(line[0], line[1], line[2], line[3]));
                }
                System.out.println("✅ Tiendas cargadas exitosamente: " + stores.size());
            }
        } catch (IOException | CsvValidationException | URISyntaxException e) {
            System.err.println("❌ Error al leer el archivo stores.csv: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Store> getAllStores() {
        return new ArrayList<>(stores);
    }
}
