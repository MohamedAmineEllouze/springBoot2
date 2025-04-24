package com.learninsb.activitie2.Repo;

import com.learninsb.activitie2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    ClassValue<Object> findByNom(String nom);

    List<Patient> findByNomContaining(String taher);


    @Query("SELECT p FROM Patient p WHERE p.nom LIKE :x")
    List<Patient> search(@Param("x") String s);

    @Query("SELECT p FROM Patient p WHERE p.score = :y")
    List<Patient> search2(@Param("y") String s);

    @Query("SELECT p FROM Patient p WHERE p.score BETWEEN :min AND :max")
    List<Patient> searchByScoreRange(@Param("min") int min, @Param("max") int max);

    List<Patient> findByScoreGreaterThanEqual(int scoreIsGreaterThan);

    List<Patient> id(Long id);
}
