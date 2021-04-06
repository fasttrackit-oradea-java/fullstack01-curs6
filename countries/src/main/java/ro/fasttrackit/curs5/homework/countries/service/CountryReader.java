package ro.fasttrackit.curs5.homework.countries.service;

import ro.fasttrackit.curs5.homework.countries.domain.Country;

import java.util.List;

public interface CountryReader {
    List<Country> readCountries();
}
