package app.service;

import app.entity.Aluno;
import app.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public String save(Aluno aluno){
        this.alunoRepository.save(aluno);
        return "Aluno salvo com sucesso!";
    }

    public Aluno findById(Long id){

        Aluno aluno = this.alunoRepository.findById(id).get();
        return aluno;
    }

    public List<Aluno> findAll(){

        List<Aluno> alunoList = this.alunoRepository.findAll();
        return alunoList;
    }

    public String update(Aluno aluno, Long id){

        aluno.setId(id);
        this.alunoRepository.save(aluno);
        return "O Aluno" + aluno.getNome() +  " foi atualizado com sucesso!";
    }

    public String delete(Long id){

        this.alunoRepository.deleteById(id);
        return "O Aluno " + id + " foi excluído com sucesso!";
    }

    public List<Aluno> findStudentsStartingWith (String nome) {
        return this.alunoRepository.findByNomeStartingWith(nome);
    }

    public List<Aluno> findStudentsByTelefoneContaining(String telefone) {
        return this.alunoRepository.findByTelefoneContaining(telefone);
    }

    public List<Aluno> findStudentsByTurma(String turma) {
        return this.alunoRepository.findByTurmaNome(turma);
    }
}
