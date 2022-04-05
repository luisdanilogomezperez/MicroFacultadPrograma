package com.example.demo.Facultad_Programa.Repository;

import com.example.demo.Facultad_Programa.Entity.Facultad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("facultadRepository")
public interface FacultadRepository extends JpaRepository<Facultad, Long> {
    
    
}
