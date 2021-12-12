package com.example.soapclient.controller;

import com.example.soapclient.Country;
import com.example.soapclient.GetCountryResponse;
import com.example.soapclient.client.CountryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClientController {

    private final CountryClient client;

    @GetMapping("/get")
    public String getInfo(@RequestParam String name) {
        final GetCountryResponse response = client.getCountry(name);
        final Country country = response.getCountry();
        if (country == null) {
            return "Not Found!";
        }
        return String.format("Name: %s, Capital: %s, Population: %d, Currency: %s", country.getName(), country.getCapital(), country.getPopulation(), country.getCurrency());
    }
}
