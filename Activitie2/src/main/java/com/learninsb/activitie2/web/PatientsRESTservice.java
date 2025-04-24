package com.learninsb.activitie2.web;


import com.learninsb.activitie2.Repo.PatientRepository;
import com.learninsb.activitie2.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientsRESTservice {
    @Autowired // Spring will inject the ProductRepository instance here
    PatientRepository patientRepository;

    @GetMapping("/ListePatients")
    public List<Patient> patients() {
        // Use the injected productRepository instance to call the findAll() method
        List<Patient> all = patientRepository.findAll();
        return all;
    }

    @GetMapping("/ListePatients/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientRepository.findById(id).get();
    }
}

