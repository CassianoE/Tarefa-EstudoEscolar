package app.repository;

import app.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    // Query Methods
    List<Aluno> findByNomeStartingWith(String nome);

    List<Aluno> findByTelefoneContaining(String telefone);

    List<Aluno> findByTurmaNome(String turma);
}
