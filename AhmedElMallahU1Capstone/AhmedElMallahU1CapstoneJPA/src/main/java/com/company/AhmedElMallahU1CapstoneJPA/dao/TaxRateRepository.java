package com.company.AhmedElMallahU1CapstoneJPA.dao;

import com.company.AhmedElMallahU1CapstoneJPA.dto.TShirt;
import com.company.AhmedElMallahU1CapstoneJPA.dto.TaxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxRateRepository extends JpaRepository<TaxRate,String> {
    TaxRate findByState(String state);
}
