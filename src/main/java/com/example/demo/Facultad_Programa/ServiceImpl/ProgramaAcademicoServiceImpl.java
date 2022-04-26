package com.example.demo.Facultad_Programa.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Facultad_Programa.Converter.ProgramaAcademicoConverter;
import com.example.demo.Facultad_Programa.Entity.ProgramaAcademico;
import com.example.demo.Facultad_Programa.Model.ProgramaAcademicoModel;
import com.example.demo.Facultad_Programa.Repository.FacultadRepository;
import com.example.demo.Facultad_Programa.Repository.ProgramaAcademicoRepository;
import com.example.demo.Facultad_Programa.Service.ProgramaAcademicoService;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service("programaAcademicoServiceImpl")
public class ProgramaAcademicoServiceImpl implements ProgramaAcademicoService{

    @Autowired
    @Qualifier("programaAcademicoRepository")
    private ProgramaAcademicoRepository programaAcademicoRepository;

    @Autowired
    @Qualifier("programaAcademicoConverter")
    private ProgramaAcademicoConverter programaAcademicoConverter;

    @Autowired
    @Qualifier("facultadRepository")
    private FacultadRepository facultadRepository;

    @Override
    public List<ProgramaAcademicoModel> getAllProgramasAcademicos() {
        List<ProgramaAcademico> listadoProg = programaAcademicoRepository.findAll();
        List<ProgramaAcademicoModel> lista = new ArrayList<>();

        for (ProgramaAcademico p : listadoProg) {
            lista.add(programaAcademicoConverter.entityToModel(p));

        }
        return lista;
    }

    @Override
    public ProgramaAcademicoModel crearPrograma(ProgramaAcademicoModel programaModel) {
        ProgramaAcademicoModel prog = null;
        
        try {
            programaModel.setIdFacultad(facultadRepository.getById(programaModel.getFacultad()));
            ProgramaAcademico residuo = programaAcademicoRepository.save(programaAcademicoConverter.modelToEntity(programaModel));
            prog = programaAcademicoConverter.entityToModel(residuo);
        }  catch (NullPointerException e) {
            System.out.println(e);
        } 
        return prog;
    }

    @Override
    public boolean deletePrograma(Long id) {
        boolean resultado =false;
        try {
            programaAcademicoRepository.deleteById(id);  
                 resultado=true;
        } catch (Exception e) {
            //TODO: handle exception
        }
         return resultado;
    }

    @Override
    public ProgramaAcademicoModel getProgramaWithId(Long id) {
        ProgramaAcademicoModel programa = new ProgramaAcademicoModel();
        List<ProgramaAcademicoModel> listado = getAllProgramasAcademicos();

        for(ProgramaAcademicoModel l : listado){

            if(l.getId() == id){
                programa=l;
            }
        }
        return programa;
    }

    @Override
    public ProgramaAcademicoModel buscarPorNombre(String nombre) {
        ProgramaAcademicoModel programa = new ProgramaAcademicoModel();
        List<ProgramaAcademicoModel> listado = getAllProgramasAcademicos();

        for(ProgramaAcademicoModel l : listado){

            if(l.getNombre().equalsIgnoreCase(nombre)){
                programa=l;
            }
        }
        return programa;
    }

    @Override
    public Boolean agregaMasiva(List<ProgramaAcademicoModel> programa) {
        
        Boolean exito = false;

        for(ProgramaAcademicoModel l : programa){
            try{
                l.setIdFacultad(facultadRepository.getById(l.getFacultad()));
                ProgramaAcademico residuo = programaAcademicoRepository.save(programaAcademicoConverter.modelToEntity(l));
                
                if(residuo!=null){
                    exito=true;
                }else{
                    exito=false;
                }
            }catch (Exception e) {
                //TODO: handle exception
            }
        }
        return exito;
    }
    
}
