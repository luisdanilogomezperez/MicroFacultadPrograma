package com.example.demo.Facultad_Programa.Service;

import java.util.List;

import com.example.demo.Facultad_Programa.Model.FacultadModel;

public interface FacultadService {
    
    public abstract List<FacultadModel> getAllFacultades();

    public abstract FacultadModel getFacultad(Long id);

    public abstract FacultadModel crearFacultad(FacultadModel facultad);

    public abstract boolean deleteFacultad(Long id);

    public abstract FacultadModel buscarPorNombre(String nombre);

}
