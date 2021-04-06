package ro.fasttrackit.curs5.homework.countries.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs5.homework.countries.domain.Country;

import java.util.List;

@Profile("file")
@Component
public class FileCountryReader implements CountryReader {
    @Override
    public List<Country> readCountries() {
        System.out.println("Reading from file");
        return List.of(
                Country.builder()
                        .name("Romania")
                        .capital("Bucharest")
                        .area(217000)
                        .population(20_000_000)
                        .continent("Europe")
                        .neighbours(List.of("HU"))
                        .build(),
                Country.builder()
                        .name("Moldova")
                        .capital("Chisinau")
                        .area(21700)
                        .population(3_000_000)
                        .continent("Europe")
                        .neighbours(List.of("RO"))
                        .build(),
                Country.builder()
                        .name("Bulgaria2")
                        .capital("Sofia")
                        .area(21700)
                        .population(3_000_000)
                        .continent("Europe")
                        .neighbours(List.of("RO"))
                        .build()
        );
    }
}
