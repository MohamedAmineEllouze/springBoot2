package com.learninsb.activitie2;

import com.learninsb.activitie2.Repo.PatientRepository;
import com.learninsb.activitie2.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class Activitie2Application implements CommandLineRunner {

    @Autowired // pour dire a spring de faire injecter des objet(type patient) dans l'objet(l'interface) productRepository
    PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Activitie2Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception { //il methode he4i automatiquement exécutée au démarrage de l'application Spring Boot.
        // insertion avec succée ,on doit les mettre en commentaire pour ne pas avoir une deuxieme insertion au deuxieme demarage
        patientRepository.save(new Patient(null,"Ali",new SimpleDateFormat("yyyy-MM-dd").parse("1998-02-15"),true,75));
        patientRepository.save(new Patient(null,"taher",new SimpleDateFormat("yyyy-MM-dd").parse("2011-12-21"),false,35));
        patientRepository.save(new Patient(null,"abdoullah",new SimpleDateFormat("yyyy-MM-dd").parse("1995-01-30"),true,100));
        patientRepository.save(new Patient(null,"abd_il_jabbar",new SimpleDateFormat("yyyy-MM-dd").parse("1970-05-31"),true,65));


    System.out.println("Tous les patients :");
    List<Patient> patients = patientRepository.findAll();
    patients.forEach(pa -> System.out.println(pa.toString()));
    System.out.println("+++++++++++++++++++++++++++++++++++++++");
    System.out.println("patient(taher):");
    List<Patient> taherS = patientRepository.findByNomContaining("taher");
    System.out.println("Patient(taher) :");
    taherS.forEach(System.out::println);
    System.out.println("+++++++++++++++++++++++++++++++++++++++");
    List<Patient> abdoullahS = patientRepository.search("%abdoullah%");
    System.out.println("patient(abdoullah):");
    abdoullahS.forEach(System.out::println);
    System.out.println("+++++++++++++++++++++++++++++++++++++++");
    List<Patient> lesSujetsMalades = patientRepository.findByScoreGreaterThanEqual(50);
    System.out.println("patients mlades:");
    lesSujetsMalades.forEach(System.out::println);


}}
