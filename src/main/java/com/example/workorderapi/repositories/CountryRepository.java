package com.example.workorderapi.repositories;

import com.example.workorderapi.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
