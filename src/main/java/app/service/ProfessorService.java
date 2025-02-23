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

        // Regra 1: Verificar se o email já está cadastrado
        if (professorRepository.findByEmail(professor.getEmail()) != null) {
            throw new RuntimeException("Email já cadastrado!");
        }

        // Regra 2: Verificar se o email contém "@outlook.com"
        if (professor.getEmail().toLowerCase().contains("@outlook.com")) {
            throw new RuntimeException("Domínio de e-mail não permitido!");
        }

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

    public List<Professor> findProfessorsByComecoNomeOrEspecialidade(String nome, String especialidade) {
        return this.professorRepository.findByComecoNomeOuEspecialidade(nome, especialidade);
    }

    public List<Professor> findByWithoutGmail() {
        return this.professorRepository.findByEmailNotContaining("@gmail.com");
    }

    public Professor findByEmail(String email) {
        return this.professorRepository.findByEmail(email);
    }
}
