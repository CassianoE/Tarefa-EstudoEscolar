package app.repository;

import app.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

    List<Turma> findByAnoBetween(int anoInicio, int anoFim);

    List<Turma> findBySemestreAndAno(int semestre, int ano);

    List<Turma> findByNomeAndTurno(String nome, String turno);

    List<Turma> findByCursoNome(String nomeCurso);
}
