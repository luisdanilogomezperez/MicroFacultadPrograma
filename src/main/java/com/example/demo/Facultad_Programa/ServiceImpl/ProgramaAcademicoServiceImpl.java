package com.example.demo.Facultad_Programa.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Facultad_Programa.Converter.ProgramaAcademicoConverter;
import com.example.demo.Facultad_Programa.Entity.ProgramaAcademico;
import com.example.demo.Facultad_Programa.Model.ProgramaAcademicoModel;
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

            ProgramaAcademico residuo = programaAcademicoRepository.save(programaAcademicoConverter.modelToEntity(programaModel));
           
            prog = programaAcademicoConverter.entityToModel(residuo);
        } catch (SQLGrammarException e) {
            System.out.println(e);
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
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
    public List<ProgramaAcademicoModel> getPrograma(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
