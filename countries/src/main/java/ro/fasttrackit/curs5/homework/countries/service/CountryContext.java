package ro.fasttrackit.curs5.homework.countries.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import ro.fasttrackit.curs5.homework.countries.exceptions.HeaderNotFoundException;

import javax.servlet.http.HttpServletRequest;

import static java.util.Optional.ofNullable;

@Component
@RequestScope
public class CountryContext {
    private final String myCountryName;

    public CountryContext(HttpServletRequest request) {
        System.out.println("------------ instantiate CountryContext");
        this.myCountryName = ofNullable(request.getHeader("X-Country"))
                .orElseThrow(() -> new HeaderNotFoundException(""));
    }

    public String getMyCountryName() {
        return myCountryName;
    }
}
