package ro.fasttrackit.curs5.homework.countries.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs5.homework.countries.domain.Country;
import ro.fasttrackit.curs5.homework.countries.exceptions.ResourceNotFoundException;
import ro.fasttrackit.curs5.homework.countries.service.CountriesService;

import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountriesController {
    private final CountriesService service;

    @GetMapping
    List<Country> allCountries() {
        String a = null;
        System.out.println(a.toString());
        return service.getAll();
    }

    @GetMapping("mine")
    Country myCountry(@RequestHeader("X-Country") String myCountryName) {
        return service.getByName(myCountryName)
                .orElseThrow(() -> new ResourceNotFoundException("Country " + myCountryName + " doesn't exist"));
    }

    @GetMapping("mine-scoped")
    Country myCountryProfile() {
        return service.getMyCountry()
                .orElseThrow(() -> new ResourceNotFoundException("My country doesn't exist"));
    }
}
