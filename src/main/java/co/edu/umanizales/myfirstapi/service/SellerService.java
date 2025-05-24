package co.edu.umanizales.myfirstapi.service;
import co.edu.umanizales.myfirstapi.model.Seller;
import co.edu.umanizales.myfirstapi.model.TypeDoc;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class SellerService {

    @Autowired
    private LocationService locationService;

    private List<Seller> seller = new ArrayList<>();

    @Value("${seller_filename}")
    private String sellerFilename;

    public SellerService(LocationService locationService) { this.locationService = locationService; }

    @PostConstruct
    public void readSellerFromCSV() throws IOException, URISyntaxException {
        seller = new ArrayList<>();
        Path pathFile = Paths.get(getClass().getClassLoader().getResource(sellerFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toFile()))) {
            csvReader.skip(1);
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                seller.add(new Seller(line[0], line[1], line[2], locationService.getLocationByCode(line[3]), Byte.parseByte(line[4]), new TypeDoc(line[5], line[0])));
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);

        }

    }
    public List<Seller> getAllSeller() {
        return seller;
    }
}