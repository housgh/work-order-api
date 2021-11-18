package com.example.workorderapi.controllers;

import com.example.workorderapi.configuration.IMapper;
import com.example.workorderapi.models.Country;
import com.example.workorderapi.repositories.CountryRepository;
import com.example.workorderapi.viewmodels.CountryVM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/country")
public class CountryController {
    private CountryRepository countryRepository;
    private IMapper mapper;

    public CountryController(CountryRepository countryRepository, IMapper mapper){
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<Iterable<CountryVM>> GetAll(){
        var countries = countryRepository.findAll();
        var countriesVM = new ArrayList<CountryVM>();
        for (var country: countries) {
            countriesVM.add(mapper.countryToCountryVM(country));
        }
        return new ResponseEntity<>(countriesVM, HttpStatus.OK);
    }
}
