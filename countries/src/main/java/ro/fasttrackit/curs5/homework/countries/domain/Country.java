package ro.fasttrackit.curs5.homework.countries.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder
@RequiredArgsConstructor
public class Country {
    String name;
    String capital;
    long population;
    long area;
    String continent;
    List<String> neighbours;
}
