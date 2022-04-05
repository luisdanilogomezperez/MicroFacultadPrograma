package com.example.demo.Facultad_Programa.Service;

import java.util.List;

import com.example.demo.Facultad_Programa.Model.ProgramaAcademicoModel;

public interface ProgramaAcademicoService {
    
    public abstract List<ProgramaAcademicoModel> getAllProgramasAcademicos();

    public abstract List<ProgramaAcademicoModel> getPrograma(Long id);

    public abstract ProgramaAcademicoModel crearPrograma(ProgramaAcademicoModel programa);

    public abstract boolean deletePrograma(Long id);
}
