package com.example.demo.Facultad_Programa.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Facultad_Programa.Converter.FacultadConverter;
import com.example.demo.Facultad_Programa.Entity.Facultad;
import com.example.demo.Facultad_Programa.Model.FacultadModel;
import com.example.demo.Facultad_Programa.Repository.FacultadRepository;
import com.example.demo.Facultad_Programa.Service.FacultadService;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service("facultadServiceImpl")
public class FacultadServiceImpl implements FacultadService{

    @Autowired
    @Qualifier("facultadRepository")
    private FacultadRepository facultadRepository;

    @Autowired
    @Qualifier("facultadConverter")
    private FacultadConverter facultadConverter;

    @Override
    public List<FacultadModel> getAllFacultades() {

        List<Facultad> listadoFac = facultadRepository.findAll();
        List<FacultadModel> lista = new ArrayList<>();

        for (Facultad f : listadoFac) {
            lista.add(facultadConverter.entityToModel(f));

        }
        return lista;
    }


    @Override
    public FacultadModel crearFacultad(FacultadModel facultadModel) {

        FacultadModel fac = null;
        try {

            Facultad residuo = facultadRepository.save(facultadConverter.modelToEntity(facultadModel));
           
            fac = facultadConverter.entityToModel(residuo);
        } catch (SQLGrammarException e) {
            System.out.println(e);
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return fac;
    }

    @Override
    public boolean deleteFacultad(Long id) {
        boolean resultado =false;
        try {
            facultadRepository.deleteById(id);  
                 resultado=true;
        } catch (Exception e) {
            //TODO: handle exception
        }
         return resultado;
    }


    @Override
    public FacultadModel getFacultadWithId(Long id) {
        FacultadModel facultad = new FacultadModel();
        List<FacultadModel> listado = getAllFacultades();

        for(FacultadModel l : listado){

            if(l.getId() == id){
                facultad=l;
            }
        }

        return facultad;
    }


    @Override
    public FacultadModel buscarPorNombre(String nombre) {
        FacultadModel facultad = new FacultadModel();
        List<FacultadModel> listado = getAllFacultades();

        for(FacultadModel l : listado){
            if(l.getNombre().equalsIgnoreCase(nombre)){
                facultad = l;
            }
        }
        return facultad;
    }

}
