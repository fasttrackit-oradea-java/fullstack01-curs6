package ro.fasttrackit.curs5.homework.countries.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs5.homework.countries.domain.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountriesService {
    private final List<Country> countries = new ArrayList<>();
    private final CountryContext context;

    public CountriesService(CountryReader reader, CountryContext context) {
        countries.addAll(reader.readCountries());
        this.context = context;
    }

    public List<Country> getAll() {
        System.out.println("-------get all");
        return new ArrayList<>(countries);
    }

    public Optional<Country> getByName(String myCountryName) {
        return countries.stream()
                .filter(c -> c.getName().equalsIgnoreCase(myCountryName))
                .findFirst();
    }

    public Optional<Country> getMyCountry() {
        System.out.println("-------get with scoped");
        System.out.println(context.getClass());
        String myCountryName = context.getMyCountryName();
        return getByName(myCountryName);
    }
}
