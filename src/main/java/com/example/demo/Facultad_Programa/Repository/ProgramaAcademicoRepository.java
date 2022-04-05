package com.example.demo.Facultad_Programa.Repository;

import com.example.demo.Facultad_Programa.Entity.ProgramaAcademico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("programaAcademicoRepository")
public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, Long> {
    
}
