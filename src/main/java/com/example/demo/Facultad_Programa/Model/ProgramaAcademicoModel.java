package com.example.demo.Facultad_Programa.Model;

public class ProgramaAcademicoModel {

    private long id;
    private String nombre;
    private Long idFacultad;

    public ProgramaAcademicoModel(){}
    
    public ProgramaAcademicoModel(long id, String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Long getIdFacultad() {
        return idFacultad;
    }
    public void setIdFacultad(Long idFacultad) {
        this.idFacultad = idFacultad;
    }
}
