package app.service;

import app.entity.Curso;
import app.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public String save(Curso curso){
        this.cursoRepository.save(curso);
        return "Curso salvo com sucesso!";
    }

    public Curso findById(Long id){
        Curso curso = this.cursoRepository.findById(id).get();
        return curso;
    }

    public List<Curso> findAll(){
        List<Curso> cursoList = this.cursoRepository.findAll();
        return cursoList;
    }

    public String update(Curso curso, Long id){

        curso.setId(id);
        this.cursoRepository.save(curso);
        return "O Curso" + curso.getNome() + " foi atualizado com sucesso!";
    }

    public String delete(Long id){
        this.cursoRepository.deleteById(id);
        return "O Curso" + id + " foi excluído com sucesso!";
    }


}
