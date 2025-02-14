package app.service;

import app.entity.Professor;
import app.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public String save(Professor professor) {
        this.professorRepository.save(professor);
        return "Professor salvo com sucesso!";
    }

    public Professor findById(Long id) {
        Professor professor = this.professorRepository.findById(id).get();
        return professor;
    }

    public List<Professor> findAll() {
        List<Professor> professorList = this.professorRepository.findAll();
        return professorList;
    }

    public String update(Professor professor,Long id) {

        this.professorRepository.save(professor);
        return "O Pluno" + professor.getNome() +  " foi atualizado com sucesso!";
    }

    public String delete(Long id) {
        this.professorRepository.deleteById(id);
        return "O professor " + id + " foi excluído com sucesso!";
    }
}
