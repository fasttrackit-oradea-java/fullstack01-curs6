package ro.fasttrackit.curs5.homework.countries.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs5.homework.countries.domain.Country;

import java.util.List;

@Component
@Profile({"memory", "!file"})
public class InMemoryCountryReader implements CountryReader {

    @Override
    public List<Country> readCountries() {
        System.out.println("Reading from memory");
        return List.of(
                Country.builder()
                        .name("Romania")
                        .capital("Bucharest")
                        .area(217000)
                        .population(20_000_000)
                        .continent("Europe")
                        .neighbours(List.of("HU"))
                        .build()
        );
    }
}
