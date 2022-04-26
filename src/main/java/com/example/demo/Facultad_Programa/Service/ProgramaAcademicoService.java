package com.example.demo.Facultad_Programa.Service;

import java.util.List;

import com.example.demo.Facultad_Programa.Model.ProgramaAcademicoModel;

import org.springframework.stereotype.Service;

@Service
public interface ProgramaAcademicoService {
    
    public abstract List<ProgramaAcademicoModel> getAllProgramasAcademicos();

    public abstract ProgramaAcademicoModel getProgramaWithId(Long id);

    public abstract ProgramaAcademicoModel crearPrograma(ProgramaAcademicoModel programa);

    public abstract boolean deletePrograma(Long id);

    public abstract ProgramaAcademicoModel buscarPorNombre(String nombre);

    public abstract Boolean agregaMasiva(List<ProgramaAcademicoModel> programa);
}
